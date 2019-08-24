//
// Created by Lebron Sn on 2017/2/6.
//
#include "bs.h"
JNIEXPORT jint JNICALL
Java_com_mtdhllf_tools_bidiffpatch_BinaryTool_patch
        (JNIEnv *env, jobject instance, jstring oldPath_, jstring newPath_,jstring patchPath_) {
    const char* argv[4];
    argv[0] = "bspatch";
    argv[1] = (*env)->GetStringUTFChars(env,oldPath_, 0);
    argv[2] = (*env)->GetStringUTFChars(env,newPath_, 0);
    argv[3] = (*env)->GetStringUTFChars(env, patchPath_, 0);
    mypatch(4,argv);
    (*env)->ReleaseStringUTFChars(env,oldPath_, argv[1]);
    (*env)->ReleaseStringUTFChars(env,newPath_, argv[2]);
    (*env)->ReleaseStringUTFChars(env,patchPath_,argv[3]);
//    free(argv);
    return 0;
}

JNIEXPORT jint JNICALL
Java_com_mtdhllf_tools_bidiffpatch_BinaryTool_diff
        (JNIEnv *env, jobject instance, jstring oldPath_, jstring newPath_, jstring patchPath_) {
    const char* argv[4];
    argv[0] = "bsdiff";
    argv[1] = (*env)->GetStringUTFChars(env,oldPath_, 0);
    argv[2] = (*env)->GetStringUTFChars(env,newPath_, 0);
    argv[3] = (*env)->GetStringUTFChars(env, patchPath_, 0);
    mydiff(4,argv);
    (*env)->ReleaseStringUTFChars(env,oldPath_, argv[1]);
    (*env)->ReleaseStringUTFChars(env,newPath_, argv[2]);
    (*env)->ReleaseStringUTFChars(env,patchPath_,argv[3]);
//    free(argv[0]);
//    free(argv);
    return 0;
}