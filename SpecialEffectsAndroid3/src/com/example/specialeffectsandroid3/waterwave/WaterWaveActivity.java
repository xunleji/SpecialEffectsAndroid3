package com.example.specialeffectsandroid3.waterwave;

import com.example.specialeffectsandroid3.R;

import android.app.Activity;
import android.os.Bundle;

public class WaterWaveActivity extends Activity {

	private WaterWaveView mWaterWaveView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.waterwave);
		mWaterWaveView = (WaterWaveView) findViewById(R.id.wave_view);
		mWaterWaveView.startWave();
	}

	
	@Override
	protected void onDestroy() {
		mWaterWaveView.stopWave();
		mWaterWaveView=null;
		super.onDestroy();
	}

}
