package com.example.specialeffectsandroid3.screenscroll.line;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.screenscroll.BaseSampleActivity;
import com.example.specialeffectsandroid3.screenscroll.TestFragmentAdapter;
import com.example.specialeffectsandroid3.screenscroll.viewpagerindicator.LinePageIndicator;

public class SampleLinesStyledTheme extends BaseSampleActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// The look of this sample is set via a style in the manifest
		setContentView(R.layout.simple_lines);

		mAdapter = new TestFragmentAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);

		mIndicator = (LinePageIndicator) findViewById(R.id.indicator);
		mIndicator.setViewPager(mPager);
	}
}
