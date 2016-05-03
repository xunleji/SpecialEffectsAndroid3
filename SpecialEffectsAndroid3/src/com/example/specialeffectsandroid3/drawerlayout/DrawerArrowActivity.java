package com.example.specialeffectsandroid3.drawerlayout;

import com.example.specialeffectsandroid3.Diary;
import com.example.specialeffectsandroid3.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.DialerFilter;
import android.widget.ImageView;

/**
 * 带有动画效果的抽屉式左右滑动
 * @author xujuan
 * 
 */
public class DrawerArrowActivity extends Activity {

	private DrawerLayout drawerLayout;
	private DrawerArrowDrawable drawerArrowDrawable;
	private ImageView imageView;
	private float offset;
	private boolean flipped;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawerarrow_main);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		imageView = (ImageView) findViewById(R.id.drawer_indicator);
		drawerArrowDrawable = new DrawerArrowDrawable(getResources());
		drawerArrowDrawable.setStrokeColor(getResources().getColor(
				R.color.light_gray));
		imageView.setImageDrawable(drawerArrowDrawable);
		drawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				// 监听移动的距离
				Diary.print("onDrawerSlide=" + slideOffset + "drawerView="
						+ drawerView);
				offset = slideOffset;
				// Sometimes slideOffset ends up so close to but not quite 1 or
				// 0.
				if (slideOffset >= .995) {
					flipped = true;
					drawerArrowDrawable.setFlip(flipped);
				} else if (slideOffset <= .005) {
					flipped = false;
					drawerArrowDrawable.setFlip(flipped);
				}

				drawerArrowDrawable.setParameter(offset);
			}
		});
		imageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Diary.print("setOnClickListener");
				if (drawerLayout.isDrawerVisible(Gravity.LEFT)) {
					drawerLayout.closeDrawer(Gravity.LEFT);
				} else {
					drawerLayout.openDrawer(Gravity.LEFT);
				}
			}
		});

	}

}
