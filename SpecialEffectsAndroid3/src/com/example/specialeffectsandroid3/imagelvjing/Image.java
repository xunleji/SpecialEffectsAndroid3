package com.example.specialeffectsandroid3.imagelvjing;

import com.example.specialeffectsandroid3.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class Image extends Activity {

	private ImageView imageView2;
	private Bitmap bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		imageView2 = (ImageView) findViewById(R.id.imageView2);
		bmp = ImageUntil.readBitMap(this, R.drawable.image);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		int pos = bundle.getInt("position", 0);
		switch (pos) {
		case 0:
			imageView2.setImageBitmap(ImageUntil.zoomBitmap(bmp,
					bmp.getWidth() / 3, bmp.getHeight() / 3));
			break;
		case 1:
			imageView2.setImageBitmap(ImageUntil.getRoundedCornerBitmap(bmp,
					100f));
			break;
		case 2:
			imageView2.setImageBitmap(ImageUntil
					.createReflectionImageWithOrigin(bmp));
			break;
		case 3:
			imageView2.setImageBitmap(ImageUntil.postRotateBitamp(bmp, 90));
			break;
		case 4:
			imageView2.setImageBitmap(ImageUntil.reverseBitmap(bmp, 0));
			break;
		case 6:
			imageView2.setImageBitmap(ImageUntil.doodle(bmp,
					ImageUntil.readBitMap(this, R.drawable.ic_launcher),
					bmp.getWidth() / 2, bmp.getHeight() / 2));
			break;
		case 7:
			Bitmap tmpbmps = BitmapFactory.decodeResource(getResources(),
					R.drawable.image).copy(Config.ARGB_8888, true);
			imageView2.setImageBitmap(ImageUntil.drawText(tmpbmps, "test",
					bmp.getWidth() / 2, bmp.getHeight() / 2));
			break;
		case 8:
			imageView2.setImageBitmap(ImageUntil.oldRemeber(bmp));
			break;
		case 9:
			imageView2.setImageBitmap(ImageUntil.blurImage(bmp));
			break;
		case 10:
			imageView2.setImageBitmap(ImageUntil.blurImageAmeliorate(bmp));
			break;
		case 11:
			imageView2.setImageBitmap(ImageUntil.emboss(bmp));
			break;
		case 12:
			imageView2.setImageBitmap(ImageUntil.sharpenImageAmeliorate(bmp));
			break;
		case 13:
			Bitmap tmpbmp = ImageUntil.film(bmp);
			imageView2.setImageBitmap(tmpbmp);
			ImageUntil.SaveBitmap(tmpbmp, "test.jpg");
			ImageUntil.saveToLocal(tmpbmp);
			break;
		case 14:
			imageView2.setImageBitmap(ImageUntil.sunshine(bmp,
					bmp.getWidth() / 2, bmp.getHeight() / 2));
			break;
		default:
			break;
		}
	}

}
