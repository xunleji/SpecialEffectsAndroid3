package com.example.specialeffectsandroid3.iconred;

import com.example.specialeffectsandroid3.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 桌面图标上显示红点
 * 
 * @author xujuan
 * 
 */
public class IconRedActivity extends Activity {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		BadgeUtil.resetBadgeCount(this);

		Intent intent = new Intent(this, RedTestService.class);
		intent.putExtra("state", 1);
		startService(intent);
	}

}
