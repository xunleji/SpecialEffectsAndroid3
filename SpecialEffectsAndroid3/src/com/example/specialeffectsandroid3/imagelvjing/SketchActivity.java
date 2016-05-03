package com.example.specialeffectsandroid3.imagelvjing;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

import com.example.specialeffectsandroid3.R;

public class SketchActivity extends Activity {

	private ImageView mImageView;
	private Bitmap mBitmap;
	private final int PROGRESS_WAIT_VISIBLE = 1;
	private final int PROGRESS_WAIT_GONE = 2;
	private final int IMAGEVIEW_INVALIDATE = 3;
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case PROGRESS_WAIT_VISIBLE:
				setProgressBarIndeterminateVisibility(true);
				break;
			case PROGRESS_WAIT_GONE:
				setProgressBarIndeterminateVisibility(false);
				break;
			case IMAGEVIEW_INVALIDATE:
				mImageView.setImageBitmap(mBitmap);
				mImageView.invalidate();
				break;
			default:
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.sketch);
		mImageView = (ImageView) findViewById(R.id.sketch_image);
		cancelSketch();
		doSketch();
	}

	private void cancelSketch() {
		Bitmap bmp = BitmapFactory.decodeStream(getResources().openRawResource(
				R.drawable.image));
		int width = bmp.getWidth();
		int height = bmp.getHeight();
		int[] pixel = new int[width * height];

		bmp.getPixels(pixel, 0, width, 0, 0, width, height);
		mBitmap = Bitmap.createBitmap(width, height, bmp.getConfig());
		mBitmap.setPixels(pixel, 0, width, 0, 0, width, height);
		mImageView.setImageBitmap(mBitmap);
		bmp.recycle();
	}

	private void doSketch() {
		new Thread(new Runnable() {
			public void run() {
				try {
					mHandler.sendEmptyMessage(PROGRESS_WAIT_VISIBLE);
					mBitmap = ImageUntil.sketch(mBitmap);
					mHandler.sendEmptyMessage(IMAGEVIEW_INVALIDATE);
				} catch (Exception e) {
					Log.e("sketch", e.getMessage());
				} finally {
					mHandler.sendEmptyMessage(PROGRESS_WAIT_GONE);
				}
			}
		}).start();
	}

}
