package com.example.specialeffectsandroid3.slidingcard;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.specialeffectsandroid3.R;

public class SlidingCardActivity extends Activity implements
		ContainerView.ContainerInterface {

	private ContainerView contentView;
	private List<PhotoContent> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slidingcard_main);
		contentView = (ContainerView) findViewById(R.id.contentview);
		try {
			initData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initData() throws Exception {
		dataList = new ArrayList<PhotoContent>();
		String[] titles = getResources().getStringArray(R.array.title);
		String[] imgs = getResources().getStringArray(R.array.imgs);
		for (int n = 0; n < titles.length; n++) {
			PhotoContent photoContent = new PhotoContent(String.valueOf(n),
					titles[n], imgs[n]);
			dataList.add(photoContent);
		}
		if (dataList == null || dataList.size() < 3)
			throw new Exception("list'size must be more than 3");

		contentView.initCardView(SlidingCardActivity.this,
				R.layout.sliding_card_item, R.id.sliding_card_content_view);
	}

	@Override
	public void initCard(SlidingCard card, int index) {
		ImageView mImageView = (ImageView) card
				.findViewById(R.id.user_imageview);
		TextView mTextView = (TextView) card.findViewById(R.id.user_text);
		if (dataList.get(index) != null) {
			mTextView.setText(dataList.get(index).getTitle());
			mImageView.setImageResource(getResourceByReflect(dataList
					.get(index).getUrl()));
			mImageView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// the first card index must be 0
					Toast.makeText(SlidingCardActivity.this,
							dataList.get(0).getTitle(), Toast.LENGTH_SHORT)
							.show();
				}
			});
		}
	}

	public int getResourceByReflect(String imageName) {
		Class drawable = R.drawable.class;
		Field field;
		int r_id;
		try {
			field = drawable.getField(imageName);
			r_id = field.getInt(field.getName());
		} catch (Exception e) {
			r_id = R.drawable.img1;
			Log.e("ERROR", String.valueOf(e.getMessage()));
		}
		return r_id;
	}

	@Override
	public void exChangeCard() {
		PhotoContent item = dataList.get(0);
		dataList.remove(0);
		dataList.add(item);
	}

}
