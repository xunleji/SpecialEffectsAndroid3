package com.example.specialeffectsandroid3.scrolllayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.scrolllayout.ScrollLayout.OnViewChangeListener;

public class ScrollLayoutActivity extends Activity {

	private ScrollLayout scrollLayout;
	private int mViewCount;
	private RadioButton[] mButtons;
	private int mCurrent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scrolllayout);
		scrollLayout = (ScrollLayout) findViewById(R.id.main_scrolllayout);
		// 设置是否可以左右滑动
		scrollLayout.setIsScroll(true);
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.main_linearlayout_footer);
		mViewCount = scrollLayout.getChildCount();
		mButtons = new RadioButton[mViewCount];
		for (int i = 0; i < mViewCount; i++) {
			mButtons[i] = (RadioButton) linearLayout.getChildAt(i * 2);
			mButtons[i].setTag(i);
			mButtons[i].setChecked(false);
			mButtons[i].setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					int pos = (Integer) (v.getTag());
					scrollLayout.snapToScreen(pos);
				}
			});
		}
		mCurrent = 0;
		mButtons[mCurrent].setChecked(true);
		scrollLayout.SetOnViewChangeListener(new OnViewChangeListener() {

			@Override
			public void OnViewChange(int view) {
				setCurPoint(view);
			}
		});
	}

	private void setCurPoint(int index) {
		if (index < 0 || index > mViewCount - 1 || mCurrent == index)
			return;
		mButtons[mCurrent].setChecked(false);
		mButtons[index].setChecked(true);
		mCurrent = index;
	}

}
