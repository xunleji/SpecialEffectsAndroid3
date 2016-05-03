package com.example.specialeffectsandroid3.springbackscrollview;

import com.example.specialeffectsandroid3.R;

import android.app.Activity;
import android.os.Bundle;

/**
 * 下拉后可以自动回弹的Scrollview
 * 
 * @author xujuan
 * 
 */
public class BackScrollViewActivity extends Activity {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_backscroll_main);
	}

}
