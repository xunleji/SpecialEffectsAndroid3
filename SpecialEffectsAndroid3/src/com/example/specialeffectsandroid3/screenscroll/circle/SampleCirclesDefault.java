package com.example.specialeffectsandroid3.screenscroll.circle;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.screenscroll.BaseSampleActivity;
import com.example.specialeffectsandroid3.screenscroll.TestFragmentAdapter;
import com.example.specialeffectsandroid3.screenscroll.viewpagerindicator.CirclePageIndicator;

public class SampleCirclesDefault extends BaseSampleActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.simple_circles);

		mAdapter = new TestFragmentAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);

		mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
		mIndicator.setViewPager(mPager);
	}

}
