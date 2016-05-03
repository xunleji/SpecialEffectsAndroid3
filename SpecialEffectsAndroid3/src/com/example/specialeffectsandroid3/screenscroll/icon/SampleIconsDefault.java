package com.example.specialeffectsandroid3.screenscroll.icon;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.screenscroll.BaseSampleActivity;
import com.example.specialeffectsandroid3.screenscroll.TestFragmentAdapter;
import com.example.specialeffectsandroid3.screenscroll.viewpagerindicator.IconPageIndicator;

public class SampleIconsDefault extends BaseSampleActivity {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.FragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.simple_icons);

		mAdapter = new TestFragmentAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);

		mIndicator = (IconPageIndicator) findViewById(R.id.indicator);
		mIndicator.setViewPager(mPager);
	}

}
