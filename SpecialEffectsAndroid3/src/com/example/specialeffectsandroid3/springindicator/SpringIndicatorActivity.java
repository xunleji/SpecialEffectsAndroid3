package com.example.specialeffectsandroid3.springindicator;

import com.example.specialeffectsandroid3.R;

import android.app.Activity;
import android.os.Bundle;

/**
 * 像水流动效果的viewpager指示器
 * 
 * @author xujuan
 * 
 */
public class SpringIndicatorActivity extends Activity {

	ScrollerViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.springindicator_main);
		viewPager = (ScrollerViewPager) findViewById(R.id.view_pager);
		SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);
		IndicatorPager adapter = new IndicatorPager(this);
		viewPager.setAdapter(adapter);
		springIndicator.setViewPager(viewPager);
	}

}
