#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>
#include<jni.h>
#include<android/log.h>
#include<com_example_test_thread_MyThread.h>
#define LOG_TAG "System.out"
#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__))
#define LOGW(...) ((void)__android_log_print(ANDROID_LOG_WARN, LOG_TAG, __VA_ARGS__))
#define LOGE(...) ((void)__android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__))

JavaVM *g_jvm = NULL;
jobject g_obj = NULL;

void *thread_fun(void* arg){
	JNIEnv *env;
	jclass cls;
	jmethodID mid;
	if((*g_jvm)->AttachCurrentThread(g_jvm, &env, NULL) != JNI_OK){
		LOGE("%s: AttachCurrentThread() failed", __FUNCTION__);
		return NULL;
	}
	cls = (*env)->GetObjectClass(env,g_obj);
	if(cls == NULL){
		 LOGE("FindClass() Error.....");
		 goto error;
	}
	 mid = (*env)->GetStaticMethodID(env, cls, "fromJNI", "(I)V");
	 if (mid == NULL) {
		 LOGE("GetMethodID() Error.....");
		 goto error;
	 }
	 //最后调用java中的静态方法
	 (*env)->CallStaticVoidMethod(env, cls, mid ,(int)arg);
error:
	//Detach主线程
	if((*g_jvm)->DetachCurrentThread(g_jvm) != JNI_OK){
		 LOGE("%s: DetachCurrentThread() failed", __FUNCTION__);
	}
	 pthread_exit(0);
}


/*
 * Class:     com_example_test_thread_MyThread
 * Method:    mainThread
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_example_test_thread_MyThread_mainThread
  (JNIEnv * env, jobject jobj){
	int i;
	pthread_t pt[5];
	for (i = 0; i < 5; i++){
		 pthread_create(&pt[i], NULL, &thread_fun, (void *)i);
	}
}

/*
 * Class:     com_example_test_thread_MyThread
 * Method:    setJNIEnv
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_example_test_thread_MyThread_setJNIEnv
  (JNIEnv * env, jobject obj){
	//保存全局JVM以便在子线程中使用
	(*env)->GetJavaVM(env,&g_jvm);
	//不能直接赋值(g_obj = obj)
	//g_obj = (*env)->NewGlobalRef(env,obj);
	 g_obj=obj;
}

//当动态库被加载时这个函数被系统调用
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved){
	JNIEnv* env = NULL;
	jint result = -1;
	if ((*vm)->GetEnv(vm, (void**)&env, JNI_VERSION_1_4) != JNI_OK){
		LOGE("GetEnv failed!");
		 return result;
	}
	return JNI_VERSION_1_4;
}
