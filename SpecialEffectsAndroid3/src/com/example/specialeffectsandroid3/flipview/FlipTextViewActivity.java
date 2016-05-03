package com.example.specialeffectsandroid3.flipview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.specialeffectsandroid3.Diary;
import com.example.specialeffectsandroid3.flipview.library.FlipViewController;

public class FlipTextViewActivity extends Activity {

	protected FlipViewController flipView;
	private TestAdapter testAdapter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		flipView = new FlipViewController(this);
		testAdapter = new TestAdapter();
		flipView.setAdapter(testAdapter);

		setContentView(flipView);
		flipView.setOnViewFlipListener(new FlipViewController.ViewFlipListener() {

			@Override
			public void onViewFlipped(View view, int position) {
				Toast.makeText(view.getContext(),
						"Flipped to page " + position, 1000).show();
				if (position == testAdapter.getCount() - 1) {// expand the data
																// size
					// on the last page
					testAdapter.setRepeatCount(testAdapter.getRepeatCount() + 1);
					testAdapter.notifyDataSetChanged();
				}
			}
		});
	}

	class TestAdapter extends BaseAdapter {

		private int repeatCount = 1;

		@Override
		public int getCount() {
			return 10 * repeatCount;
		}

		public int getRepeatCount() {
			return repeatCount;
		}

		public void setRepeatCount(int repeatCount) {
			this.repeatCount = repeatCount;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView view;
			if (convertView == null) {
				view = new TextView(FlipTextViewActivity.this);
				view.setBackgroundColor(Color.WHITE);
				view.setTextColor(Color.BLACK);
				view.setTextSize(50);
				view.setGravity(Gravity.CENTER);
			} else {
				view = (TextView) convertView;
			}
			view.setText("" + position);
			return view;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		flipView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		flipView.onPause();
	}

}
