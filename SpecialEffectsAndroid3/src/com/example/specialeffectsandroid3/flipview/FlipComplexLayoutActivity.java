package com.example.specialeffectsandroid3.flipview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.example.specialeffectsandroid3.flipview.library.FlipViewController;

public class FlipComplexLayoutActivity extends Activity {

	private FlipViewController flipView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		flipView = new FlipViewController(this);
		// Use RGB_565 can reduce peak memory usage on large screen device, but
		// it's up to you to choose the best bitmap format
		flipView.setAnimationBitmapFormat(Bitmap.Config.RGB_565);
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
