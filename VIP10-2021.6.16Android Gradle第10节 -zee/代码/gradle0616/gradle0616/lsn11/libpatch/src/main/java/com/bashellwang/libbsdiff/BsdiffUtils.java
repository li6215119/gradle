package com.bashellwang.libbsdiff;

public class BsdiffUtils {
    static {
        System.loadLibrary("bsdiff"); // libbsdiff.so
    }

    // 生成差分包
    public static native int diff(String oldFile, String newFile, String patchFile);

    public static native int patch(String oldFile, String patchFile, String newFile);
}