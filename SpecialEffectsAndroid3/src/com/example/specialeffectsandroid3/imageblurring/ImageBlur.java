package com.example.specialeffectsandroid3.imageblurring;

import android.graphics.Bitmap;

/**
 * Created by QIUJUER on 2014/4/19.
 */
public class ImageBlur {
    public static native void blurIntArray(int[] pImg, int w, int h, int r);

    public static native void blurBitMap(Bitmap bitmap, int r);

    static {
        System.loadLibrary("JNI_ImageBlur");
    }
}
