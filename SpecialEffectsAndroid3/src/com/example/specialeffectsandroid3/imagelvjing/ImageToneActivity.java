package com.example.specialeffectsandroid3.imagelvjing;

import java.util.ArrayList;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.example.specialeffectsandroid3.R;

public class ImageToneActivity extends Activity {

	private ToneLayer mToneLayer;
	private ImageView mImageView;
	private Bitmap mBitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handle_image);
		mToneLayer = new ToneLayer(this);
		mBitmap = ImageUntil.readBitMap(this, R.drawable.image);
		mImageView = (ImageView) findViewById(R.id.img_view);
		mImageView.setImageBitmap(mBitmap);
		((LinearLayout) findViewById(R.id.tone_view)).addView(mToneLayer
				.getParentView());
		ArrayList<SeekBar> seekBars = mToneLayer.getSeekBars();
		for (int i = 0, size = seekBars.size(); i < size; i++) {
			seekBars.get(i).setOnSeekBarChangeListener(onSeekbar);
		}
	}

	private OnSeekBarChangeListener onSeekbar = new OnSeekBarChangeListener() {

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// TODO Auto-generated method stub
			int flag = (Integer) seekBar.getTag();
			switch (flag) {
			case ToneLayer.FLAG_SATURATION:
				mToneLayer.setSaturation(progress);
				break;
			case ToneLayer.FLAG_LUM:
				mToneLayer.setLum(progress);
				break;
			case ToneLayer.FLAG_HUE:
				mToneLayer.setHue(progress);
				break;
			}

			mImageView.setImageBitmap(mToneLayer.handleImage(mBitmap, flag));
		}
	};

}
