package com.example.specialeffectsandroid3.firework;

import com.example.specialeffectsandroid3.firework.fireview.MyView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class FireWorkActivity extends Activity {
	/** Called when the activity is first created. */

	// EventListener mListener = new EventListener();

	static final String LOG_TAG = FireWorkActivity.class.getSimpleName();

	MyView fireworkView;

	// get the current looper (from your Activity UI thread for instance

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// if (getRequestedOrientation() !=
		// ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		// }
		fireworkView = new MyView(this);
		setContentView(fireworkView);

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (fireworkView.isRunning()) {
			fireworkView.setRunning(false);
		}
	}
}