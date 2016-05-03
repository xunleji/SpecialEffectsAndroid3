package com.example.specialeffectsandroid3.listitemanimaiton.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.listitemanimaiton.haarman.ArrayAdapter;
import com.example.specialeffectsandroid3.listitemanimaiton.haarman.itemmanipulation.OnDismissCallback;
import com.example.specialeffectsandroid3.listitemanimaiton.haarman.itemmanipulation.SwipeDismissAdapter;
import com.example.specialeffectsandroid3.listitemanimaiton.haarman.swinginadapters.prepared.SwingBottomInAnimationAdapter;

public class CardItemActivity extends Activity implements OnDismissCallback {

	private GoogleCardsAdapter mGoogleCardsAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_googlecards);

		ListView listView = (ListView) findViewById(R.id.activity_googlecards_listview);

		mGoogleCardsAdapter = new GoogleCardsAdapter(this);
		mGoogleCardsAdapter.addAll(getItems());
		SwingBottomInAnimationAdapter swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(
				new SwipeDismissAdapter(mGoogleCardsAdapter, this));
		swingBottomInAnimationAdapter.setAbsListView(listView);
		listView.setAdapter(swingBottomInAnimationAdapter);

	}

	private ArrayList<Integer> getItems() {
		ArrayList<Integer> items = new ArrayList<Integer>();
		for (int i = 0; i < 50; i++) {
			items.add(i);
		}
		return items;
	}

	@Override
	public void onDismiss(AbsListView listView, int[] reverseSortedPositions) {
		for (int position : reverseSortedPositions) {
			mGoogleCardsAdapter.remove(position);
		}
	}

	private static class GoogleCardsAdapter extends ArrayAdapter<Integer> {

		private Context mContext;
		private LruCache<Integer, Bitmap> mMemoryCache;

		public GoogleCardsAdapter(Context context) {
			mContext = context;

			final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

			// Use 1/8th of the available memory for this memory cache.
			final int cacheSize = maxMemory / 8;
			mMemoryCache = new LruCache<Integer, Bitmap>(cacheSize) {
				@Override
				protected int sizeOf(Integer key, Bitmap bitmap) {
					// The cache size will be measured in kilobytes rather than
					// number of items.
					return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
				}
			};
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder viewHolder;
			View view = convertView;
			if (view == null) {
				view = LayoutInflater.from(mContext).inflate(
						R.layout.activity_googlecards_card, parent, false);

				viewHolder = new ViewHolder();
				viewHolder.textView = (TextView) view
						.findViewById(R.id.activity_googlecards_card_textview);
				view.setTag(viewHolder);

				viewHolder.imageView = (ImageView) view
						.findViewById(R.id.activity_googlecards_card_imageview);
			} else {
				viewHolder = (ViewHolder) view.getTag();
			}

			viewHolder.textView.setText("This is card "
					+ (getItem(position) + 1));
			setImageView(viewHolder, position);

			return view;
		}

		private void setImageView(ViewHolder viewHolder, int position) {
			int imageResId;
			switch (getItem(position) % 5) {
			case 0:
				imageResId = R.drawable.img_nature1;
				break;
			case 1:
				imageResId = R.drawable.img_nature2;
				break;
			case 2:
				imageResId = R.drawable.img_nature3;
				break;
			case 3:
				imageResId = R.drawable.img_nature4;
				break;
			default:
				imageResId = R.drawable.img_nature5;
			}

			Bitmap bitmap = getBitmapFromMemCache(imageResId);
			if (bitmap == null) {
				bitmap = BitmapFactory.decodeResource(mContext.getResources(),
						imageResId);
				addBitmapToMemoryCache(imageResId, bitmap);
			}
			viewHolder.imageView.setImageBitmap(bitmap);
		}

		private void addBitmapToMemoryCache(int key, Bitmap bitmap) {
			if (getBitmapFromMemCache(key) == null) {
				mMemoryCache.put(key, bitmap);
			}
		}

		private Bitmap getBitmapFromMemCache(int key) {
			return mMemoryCache.get(key);
		}

		private static class ViewHolder {
			TextView textView;
			ImageView imageView;
		}
	}

}
