package com.example.specialeffectsandroid3.flowingdrawer;

import com.example.specialeffectsandroid3.Diary;
import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.drawerlayout.DrawerArrowDrawable;
import com.example.specialeffectsandroid3.flowingdrawer.LeftDrawerLayout.OnPositionChange;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

/**
 * 具有弹性的侧滑菜单
 * 
 * @author xujuan
 * 
 */
public class FlowingDrawerActivity extends FragmentActivity {

	private LeftDrawerLayout drawerLayout;
	private DrawerArrowDrawable drawerArrowDrawable;
	private ImageView imageView;
	private float offset;
	private boolean flipped;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flowingdrawerarrow_main);
		imageView = (ImageView) findViewById(R.id.drawer_indicator);
		drawerArrowDrawable = new DrawerArrowDrawable(getResources());
		drawerArrowDrawable.setStrokeColor(getResources().getColor(
				R.color.light_gray));
		imageView.setImageDrawable(drawerArrowDrawable);

		drawerLayout = (LeftDrawerLayout) findViewById(R.id.drawer_layout);
		FlowingView mFlowingView = (FlowingView) findViewById(R.id.sv);
		drawerLayout.setFluidView(mFlowingView);
		MyMenuFragment mMenuFragment = (MyMenuFragment) getSupportFragmentManager()
				.findFragmentById(R.id.id_container_menu);
		if (mMenuFragment == null) {
			getSupportFragmentManager()
					.beginTransaction()
					.add(R.id.id_container_menu,
							mMenuFragment = new MyMenuFragment()).commit();
		}
		drawerLayout.setMenuFragment(mMenuFragment);
		drawerLayout.setPosChange(new OnPositionChange() {

			@Override
			public void onPoschange(float pos) {
				// 监听移动的距离
				offset = pos;
				// Sometimes slideOffset ends up so close to but not quite 1 or
				// 0.
				if (pos >= .995) {
					flipped = true;
					drawerArrowDrawable.setFlip(flipped);
				} else if (pos <= .005) {
					flipped = false;
					drawerArrowDrawable.setFlip(flipped);
				}

				drawerArrowDrawable.setParameter(offset);
			}
		});
		imageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (drawerLayout.isShownMenu()) {
					drawerLayout.closeDrawer();
		        } else {
		        	drawerLayout.openDrawer();
		        }
			}
		});
	}

}
