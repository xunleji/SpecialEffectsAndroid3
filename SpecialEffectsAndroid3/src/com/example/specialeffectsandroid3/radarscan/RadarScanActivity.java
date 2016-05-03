package com.example.specialeffectsandroid3.radarscan;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.example.specialeffectsandroid3.Diary;
import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.radarscan.library.RandomTextView;

public class RadarScanActivity extends Activity {

	private RandomTextView randomTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.raderscan_main);
		randomTextView = (RandomTextView) findViewById(R.id.random_textview);
		randomTextView
				.setOnRippleViewClickListener(new RandomTextView.OnRippleViewClickListener() {
					@Override
					public void onRippleViewClicked(View view) {
						Diary.print("onRippleViewClicked");
					}
				});
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				randomTextView.addKeyWord("彭丽媛");
				randomTextView.addKeyWord("习近平");
				randomTextView.show();
			}
		}, 2 * 1000);
	}

}
