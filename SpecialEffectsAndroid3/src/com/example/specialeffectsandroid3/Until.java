package com.example.specialeffectsandroid3;

import java.io.File;

import android.content.Context;
import android.os.Environment;
import android.view.WindowManager;

public class Until {

	/**
	 * 获取sd路径
	 * 
	 * @return
	 */
	public static String getSDPath() {
		File sdDir = null;
		try {
			boolean sdCardExist = Environment.getExternalStorageState().equals(
					android.os.Environment.MEDIA_MOUNTED); // 判断sd卡是否存�?
			if (sdCardExist) {
				sdDir = Environment.getExternalStorageDirectory();// 获取存储卡根目录
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sdDir == null ? "null" : sdDir.toString();
	}

	/**
	 * 获取屏幕的尺寸
	 * 
	 * @param context
	 * @return
	 */
	public static int[] getScreenSize(Context context) {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		int width = wm.getDefaultDisplay().getWidth();// 屏幕宽度
		int height = wm.getDefaultDisplay().getHeight();// 屏幕高度
		int[] size = { width, height };

		return size;
	}
}
