package com.example.specialeffectsandroid3.screenscroll;

import java.util.Random;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.screenscroll.viewpagerindicator.PageIndicator;

public abstract class BaseSampleActivity extends FragmentActivity {
	private static final Random RANDOM = new Random();
    protected TestFragmentAdapter mAdapter;
	public ViewPager mPager;
	public PageIndicator mIndicator;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.random:
			final int page = RANDOM.nextInt(mAdapter.getCount());
			Toast.makeText(this, "Changing to page " + page, Toast.LENGTH_SHORT);
			mPager.setCurrentItem(page);
			return true;
		case R.id.add_page:
			if (mAdapter.getCount() < 10) {
				mAdapter.setCount(mAdapter.getCount() + 1);
				mIndicator.notifyDataSetChanged();
			}
			return true;

		case R.id.remove_page:
			if (mAdapter.getCount() > 1) {
				mAdapter.setCount(mAdapter.getCount() - 1);
				mIndicator.notifyDataSetChanged();
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
