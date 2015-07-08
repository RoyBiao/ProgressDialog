/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#ifndef _YIIM_THREADS_H
#define _YIIM_THREADS_H

#include <stdint.h>
#include <sys/time.h>
#include <time.h>
#include <pthread.h>
#include "YiLog.h"

/*****************************************************************************/

/*
 * Simple mutex class.  The implementation is system-dependent.
 *
 * The mutex must be unlocked by the thread that locked it.  They are not
 * recursive, i.e. the same thread can't lock it multiple times.
 */
namespace yiim {

class Condition;

class Mutex {
public:
	enum {
		PRIVATE = 0, SHARED = 1
	};

	Mutex();
	Mutex(const char* name);
	Mutex(int type, const char* name = NULL);
	~Mutex();

	// lock or unlock the mutex
	int lock();
	void unlock();

	// lock if possible; returns 0 on success, error otherwise
	int tryLock();

	// Manages the mutex automatically. It'll be locked when Autolock is
	// constructed and released when Autolock goes out of scope.
	class Autolock {
	public:
		inline Autolock(Mutex& mutex) :
				mLock(mutex) {
			mLock.lock();
		}
		inline Autolock(Mutex* mutex) :
				mLock(*mutex) {
			mLock.lock();
		}
		inline ~Autolock() {
			mLock.unlock();
		}
	private:
		Mutex& mLock;
	};

private:
	friend class Condition;

	// A mutex cannot be copied
	Mutex(const Mutex&);
	Mutex& operator =(const Mutex&);

	pthread_mutex_t mMutex;
};

inline Mutex::Mutex() {
	pthread_mutex_init(&mMutex, NULL);
}
inline Mutex::Mutex(const char* name) {
	pthread_mutex_init(&mMutex, NULL);
}
inline Mutex::Mutex(int type, const char* name) {
	if (type == SHARED) {
		pthread_mutexattr_t attr;
		pthread_mutexattr_init(&attr);
		pthread_mutexattr_setpshared(&attr, PTHREAD_PROCESS_SHARED);
		pthread_mutex_init(&mMutex, &attr);
		pthread_mutexattr_destroy(&attr);
	} else {
		pthread_mutex_init(&mMutex, NULL);
	}
}
inline Mutex::~Mutex() {
	pthread_mutex_destroy(&mMutex);
}
inline int Mutex::lock() {
	YiLog::getInstance().i("%p lock", this);
	return pthread_mutex_lock(&mMutex);
}
inline void Mutex::unlock() {
	YiLog::getInstance().i("%p unlock", this);
	pthread_mutex_unlock(&mMutex);
}
inline int Mutex::tryLock() {
	return pthread_mutex_trylock(&mMutex);
}

/*
 * Automatic mutex.  Declare one of these at the top of a function.
 * When the function returns, it will go out of scope, and release the
 * mutex.
 */

typedef Mutex::Autolock AutoMutex;

/*****************************************************************************/

/*
 * Condition variable class.  The implementation is system-dependent.
 *
 * Condition variables are paired up with mutexes.  Lock the mutex,
 * call wait(), then either re-wait() if things aren't quite what you want,
 * or unlock the mutex and continue.  All threads calling wait() must
 * use the same mutex for a given Condition.
 */
class Condition {
public:
	enum {
		PRIVATE = 0, SHARED = 1
	};

	Condition();
	Condition(int type);
	~Condition();
	// Wait on the condition variable.  Lock the mutex before calling.
	int wait(Mutex& mutex);
	// same with relative timeout
	int waitRelative(Mutex& mutex, int64_t reltime);
	int waitDefaultTimeout(Mutex& mutex);
	// Signal the condition variable, allowing one thread to continue.
	void signal();
	// Signal the condition variable, allowing all threads to continue.
	void broadcast();

private:
	pthread_cond_t mCond;
};

inline Condition::Condition() {
	pthread_cond_init(&mCond, NULL);
}
inline Condition::Condition(int type) {
	if (type == SHARED) {
		pthread_condattr_t attr;
		pthread_condattr_init(&attr);
		pthread_condattr_setpshared(&attr, PTHREAD_PROCESS_SHARED);
		pthread_cond_init(&mCond, &attr);
		pthread_condattr_destroy(&attr);
	} else {
		pthread_cond_init(&mCond, NULL);
	}
}
inline Condition::~Condition() {
	pthread_cond_destroy(&mCond);
}
inline int Condition::wait(Mutex& mutex) {
	return pthread_cond_wait(&mCond, &mutex.mMutex);
}

inline int Condition::waitDefaultTimeout(Mutex& mutex) {
	int64_t delay = 1;
	delay = delay * 6 * 1000000000;
	waitRelative(mutex, delay);
}

inline int Condition::waitRelative(Mutex& mutex, int64_t reltime) {
#if defined(HAVE_PTHREAD_COND_TIMEDWAIT_RELATIVE)
	struct timespec ts;
	ts.tv_sec = reltime / 1000000000;
	ts.tv_nsec = reltime%1000000000;
	return pthread_cond_timedwait_relative_np(&mCond, &mutex.mMutex, &ts);
#else // HAVE_PTHREAD_COND_TIMEDWAIT_RELATIVE
	struct timespec ts;
#if defined(HAVE_POSIX_CLOCKS)
	clock_gettime(CLOCK_REALTIME, &ts);
#else // HAVE_POSIX_CLOCKS
	// we don't support the clocks here.
	struct timeval t;
	gettimeofday(&t, NULL);
	ts.tv_sec = t.tv_sec;
	ts.tv_nsec = t.tv_usec * 1000;
#endif // HAVE_POSIX_CLOCKS
	ts.tv_sec += reltime / 1000000000;
	ts.tv_nsec += reltime % 1000000000;
	if (ts.tv_nsec >= 1000000000) {
		ts.tv_nsec -= 1000000000;
		ts.tv_sec += 1;
	}
	return pthread_cond_timedwait(&mCond, &mutex.mMutex, &ts);
#endif // HAVE_PTHREAD_COND_TIMEDWAIT_RELATIVE
}

inline void Condition::signal() {
	pthread_cond_signal(&mCond);
}
inline void Condition::broadcast() {
	pthread_cond_broadcast(&mCond);
}

class Thread {
public:
	Thread(std::string name) :
			pid(0), _name(name) {
	}
	virtual ~Thread() {
	}

	virtual int start();

	static int sleep(uint32_t msec);

	pthread_t getThreadId() const;

	std::string getThreadName() const;

	virtual void join();

	virtual void wait();

	virtual void wait(int64_t timeout);

	virtual void notify();

	virtual void notifyAll();
protected:
	virtual void run() = 0;
private:
	static void * thread_func(void *args);
	yiim::Mutex mutex;
	yiim::Condition cond;
	pthread_t pid;
	std::string _name;
};

inline int Thread::start() {
	int rc = pthread_create(&pid, NULL, thread_func, this);
	return rc;
}

inline pthread_t Thread::getThreadId() const {
	return pid;
}

inline std::string Thread::getThreadName() const {
	return _name;
}

inline int Thread::sleep(uint32_t msec) {
	struct timespec st;
	st.tv_sec = msec / 1000;
	st.tv_nsec = (msec % 1000) * 1000 * 1000;
	int ret = nanosleep(&st, NULL);
	return ret;
}

inline void * Thread::thread_func(void *args) {
	Thread *t = (Thread*) args;
	t->run();
	return NULL;
}

inline void Thread::join() {
	if (pid != 0) {
		pthread_join(pid, NULL);
		pid = 0;
	}
	YiLog::getInstance().i("Thread [%s] real exit", _name.c_str());
}

inline void Thread::wait() {
	yiim::AutoMutex _l(mutex);
	cond.wait(mutex);
}

inline void Thread::wait(int64_t timeout) {
	yiim::AutoMutex _l(mutex);
	cond.waitRelative(mutex, timeout);
}

inline void Thread::notify() {
	yiim::AutoMutex _l(mutex);
	cond.signal();
}

inline void Thread::notifyAll() {
	yiim::AutoMutex _l(mutex);
	cond.broadcast();
}

}
#endif // _YIIM_THREADS_H
