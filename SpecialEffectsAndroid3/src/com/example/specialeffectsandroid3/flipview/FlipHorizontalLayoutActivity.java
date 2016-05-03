package com.example.specialeffectsandroid3.flipview;

import android.app.Activity;
import android.os.Bundle;

import com.example.specialeffectsandroid3.flipview.library.FlipViewController;

public class FlipHorizontalLayoutActivity extends Activity {
	
	private FlipViewController flipView;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);

		flipView.setAdapter(new TravelAdapter(this));

		setContentView(flipView);
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
