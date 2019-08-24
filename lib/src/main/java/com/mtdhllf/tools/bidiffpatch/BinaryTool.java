package com.mtdhllf.tools.bidiffpatch;

/**
 * author: mtdhllf
 * time  : 2019/08/24 10:57
 * desc  :
 */
public class BinaryTool {

    static {
        System.loadLibrary("bsdiff-lib");
    }

    /**
     * 生成差分包
     * @param oldPath   旧包路径
     * @param newPath   新包路径
     * @param patchPath 生成差分包路径
     */
    public static native int diff(String oldPath,String newPath,String patchPath);

    /**
     * 合并新包
     * @param oldPath   旧包路径
     * @param newPath   生成新包路径
     * @param patchPath 差分包路径
     */
    public static native int patch(String oldPath,String newPath,String patchPath);

}
