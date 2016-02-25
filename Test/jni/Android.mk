LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := JNIThreads
LOCAL_SRC_FILES := com_example_test_thread_MyThread.c
LOCAL_LDLIBS    += -llog

include $(BUILD_SHARED_LIBRARY)
