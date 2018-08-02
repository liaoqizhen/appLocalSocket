LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES= $(call all-java-files-under, com)
LOCAL_MODULE = javaLocalServer

LOCAL_MODULE_PATH :=/home/liaoqizhen/nfs_root
include $(BUILD_JAVA_LIBRARY)

include $(CLEAR_VARS)

LOCAL_CFLAGS +=  -Wall -std=gnu99 -I inc -O3 -D__ANDROID_COMPILE__
#LOCAL_MODULE_TAGS := eng

LOCAL_SRC_FILES:= localSocketClient.c

LOCAL_MODULE:= localSocketClient
LOCAL_MODULE_PATH := /home/liaoqizhen/nfs_root/
LOCAL_SHARED_LIBRARIES := libcutils

include $(BUILD_EXECUTABLE)

