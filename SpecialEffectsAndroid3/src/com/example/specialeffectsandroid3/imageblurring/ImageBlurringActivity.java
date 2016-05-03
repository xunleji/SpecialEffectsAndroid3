package com.example.specialeffectsandroid3.imageblurring;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.specialeffectsandroid3.R;

/**
 * 图片模糊
 * 
 * @author xujuan
 * 
 */
@SuppressLint("NewApi")
public class ImageBlurringActivity extends FragmentActivity {

	private CustomPagerAdapter pagerAdapter;
	private ViewPager viewPager;
	TabLayout mTabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bitmapblurring_main);
		mTabLayout = (TabLayout) findViewById(R.id.tl);
		viewPager = (ViewPager) findViewById(R.id.pager);
		pagerAdapter = new CustomPagerAdapter(getSupportFragmentManager());
		mTabLayout.setTabsFromPagerAdapter(pagerAdapter);
		viewPager.setAdapter(pagerAdapter);
		mTabLayout.setupWithViewPager(viewPager);
		viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

	}

	public class CustomPagerAdapter extends FragmentStatePagerAdapter {

		private ArrayList<Fragment> fragments = new ArrayList<Fragment>();

		public CustomPagerAdapter(FragmentManager fm) {
			super(fm);
			// 使用这种方式我发现只能在Android 4.4 及其以后版本才能使用
//			fragments.add(Fragment.instantiate(ImageBlurringActivity.this,
//					RSBlurFragment.class.getName()));
			fragments.add(Fragment.instantiate(ImageBlurringActivity.this,
					FastBlurFragment.class.getName()));
			fragments.add(Fragment.instantiate(ImageBlurringActivity.this,
					JniBlurArrayFragment.class.getName()));
			fragments.add(Fragment.instantiate(ImageBlurringActivity.this,
					JniBlurBitMapFragment.class.getName()));
		}

		@Override
		public Fragment getItem(int i) {
			return fragments.get(i);
		}

		@Override
		public int getCount() {
			return fragments.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return fragments.get(position).toString();
		}
	}

}
