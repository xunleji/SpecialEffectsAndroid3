package com.example.specialeffectsandroid3.listitemdel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.listitemdel.view.BaseSwipeListViewListener;
import com.example.specialeffectsandroid3.listitemdel.view.SwipeListView;

public class ItemDelActivity extends Activity {

	private SwipeListView mSwipeListView;
	private SwipeAdapter mAdapter;
	public static int deviceWidth;
	private List<String> testData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itemdel_main);
		mSwipeListView = (SwipeListView) findViewById(R.id.example_lv_list);
		testData = getTestData();
		mAdapter = new SwipeAdapter(this, R.layout.package_row, testData,
				mSwipeListView);
		deviceWidth = getResources().getDisplayMetrics().widthPixels;
		mSwipeListView.setAdapter(mAdapter);
		mSwipeListView
				.setSwipeListViewListener(new TestBaseSwipeListViewListener());
		mSwipeListView.setSwipeMode(SwipeListView.SWIPE_MODE_LEFT);
		mSwipeListView.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL);
		// mSwipeListView.setSwipeActionRight(settings.getSwipeActionRight());
		mSwipeListView.setOffsetLeft(deviceWidth * 1 / 3);
		// mSwipeListView.setOffsetRight(convertDpToPixel(settings.getSwipeOffsetRight()));
		mSwipeListView.setAnimationTime(0);
		mSwipeListView.setSwipeOpenOnLongPress(false);
	}

	private List<String> getTestData() {
		String[] obj = new String[] { "背对背拥抱", "第几个一百天", "江南", "那些你很冒险的梦",
				"醉赤壁", "西界", "爱与希望", "你要的不是我", "不潮不用花钱", "只对你有感觉", "简简单单" };
		List<String> list = new ArrayList<String>(Arrays.asList(obj));
		return list;
	}

	class TestBaseSwipeListViewListener extends BaseSwipeListViewListener {

		@Override
		public void onClickFrontView(int position) {
			super.onClickFrontView(position);
			Toast.makeText(getApplicationContext(), testData.get(position),
					Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onDismiss(int[] reverseSortedPositions) {
			for (int position : reverseSortedPositions) {
				testData.remove(position);
			}
			mAdapter.notifyDataSetChanged();
		}
	}

}
