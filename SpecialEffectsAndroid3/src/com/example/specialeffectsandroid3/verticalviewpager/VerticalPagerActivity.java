package com.example.specialeffectsandroid3.verticalviewpager;

import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.springindicator.IndicatorPager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * 向上滑动viewpager效果
 * 
 * @author xujuan
 * 
 */
public class VerticalPagerActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.verticalpager_main);
		VerticalViewPager viewPager = (VerticalViewPager) findViewById(R.id.vertical_viewpager);
		IndicatorPager adapter = new IndicatorPager(this);
		viewPager.setAdapter(adapter);
		// 去掉蓝色阴影
		viewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
	}

}
