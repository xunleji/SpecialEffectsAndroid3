package com.example.specialeffectsandroid3.whorlview;

import com.example.specialeffectsandroid3.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 漩涡风格加载
 * 
 * @author xujuan
 * 
 */
public class WhorlActivity extends Activity {

	private boolean mIsRunning;
	private WhorlView mWhorlView1;
	private WhorlView mWhorlView2;
	private WhorlView mWhorlView3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.whorl_main);
		final Button btn = (Button) this.findViewById(R.id.button);
		btn.setText("start");
		mWhorlView1 = (WhorlView) this.findViewById(R.id.whorl);
		mWhorlView2 = (WhorlView) this.findViewById(R.id.whorl2);
		mWhorlView3 = (WhorlView) this.findViewById(R.id.whorl3);

		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mIsRunning) {
					mWhorlView1.stop();
					mWhorlView2.stop();
					mWhorlView3.stop();
				} else {
					mWhorlView1.start();
					mWhorlView2.start();
					mWhorlView3.start();
				}
				mIsRunning = !mIsRunning;
				btn.setText(mIsRunning ? "stop" : "start");
			}
		});
	}

}
