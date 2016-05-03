package com.example.specialeffectsandroid3.bitmapmerger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.specialeffectsandroid3.R;

/**
 * 图片合成
 * 
 * @author xujuan
 * 
 */
public class BitmapMergerActivity extends FragmentActivity {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bitmapmerger_main);
		showFragment(BitmapMergerTask.BitmapMergeOptions.MERGE_AT_CENTER);
	}

	private void showFragment(BitmapMergerTask.BitmapMergeOptions mergeOptions) {

		Fragment fragment;

		switch (mergeOptions) {
		case MERGE_AT_ANGLE_OFF:
			fragment = new BitmapAngleFragment();
			break;
		case MERGE_FROM_TOP_LEFT:
			fragment = new BitmapOffsetFragment();
			break;
		default:
			fragment = new BitmapCenterFragment();
		}

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, fragment).commit();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bitmapmerger_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		switch (id) {
		case R.id.action_angle:
			showFragment(BitmapMergerTask.BitmapMergeOptions.MERGE_AT_ANGLE_OFF);
			break;
		case R.id.action_offset:
			showFragment(BitmapMergerTask.BitmapMergeOptions.MERGE_FROM_TOP_LEFT);
			break;
		case R.id.action_center:
			showFragment(BitmapMergerTask.BitmapMergeOptions.MERGE_AT_CENTER);
		}

		return super.onOptionsItemSelected(item);
	}

}
