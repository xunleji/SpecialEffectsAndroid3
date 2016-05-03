package com.example.specialeffectsandroid3.springindicator;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.specialeffectsandroid3.R;

public class IndicatorPager extends PagerAdapter {

	private ArrayList<View> list = new ArrayList<View>();
	private String[] str = { "1", "2", "3" };

	public IndicatorPager(Context context) {
		super();
		list.add(LayoutInflater.from(context).inflate(R.layout.scroll1, null));
		list.add(LayoutInflater.from(context).inflate(R.layout.scroll2, null));
		list.add(LayoutInflater.from(context).inflate(R.layout.scroll3, null));
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView(list.get(position));
	}

	// 每次滑动的时候生成的组件
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		((ViewPager) container).addView(list.get(position));
		return list.get(position);
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public int getItemPosition(Object object) {
		return super.getItemPosition(object);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return str[position];
	}

}
