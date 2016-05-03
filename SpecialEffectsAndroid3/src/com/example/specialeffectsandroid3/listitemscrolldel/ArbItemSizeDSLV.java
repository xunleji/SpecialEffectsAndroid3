package com.example.specialeffectsandroid3.listitemscrolldel;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.listitemscrolldel.view.DragSortListView;

public class ArbItemSizeDSLV extends ListActivity {

	private String[] mArtistNames;
	private String[] mArtistAlbums;
	private ArrayList<JazzArtist> mArtists;
	private JazzAdapter adapter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hetero_main);

		DragSortListView lv = (DragSortListView) getListView();

		lv.setDropListener(onDrop);
		lv.setRemoveListener(onRemove);

		mArtistNames = getResources().getStringArray(R.array.jazz_artist_names);
		mArtistAlbums = getResources().getStringArray(
				R.array.jazz_artist_albums);

		mArtists = new ArrayList<JazzArtist>();
		JazzArtist ja;
		for (int i = 0; i < mArtistNames.length; ++i) {
			ja = new JazzArtist();
			ja.name = mArtistNames[i];
			if (i < mArtistAlbums.length) {
				ja.albums = mArtistAlbums[i];
			} else {
				ja.albums = "No albums listed";
			}
			mArtists.add(ja);
		}

		adapter = new JazzAdapter(mArtists);

		setListAdapter(adapter);
	}

	private DragSortListView.DropListener onDrop = new DragSortListView.DropListener() {
		@Override
		public void drop(int from, int to) {
			JazzArtist item = adapter.getItem(from);
			adapter.remove(item);
			adapter.insert(item, to);
		}
	};

	private DragSortListView.RemoveListener onRemove = new DragSortListView.RemoveListener() {
		@Override
		public void remove(int which) {
			adapter.remove(adapter.getItem(which));
		}
	};

	private class JazzArtist {
		public String name;
		public String albums;

		@Override
		public String toString() {
			return name;
		}
	}

	private class ViewHolder {
		public TextView albumsView;
	}

	private class JazzAdapter extends ArrayAdapter<JazzArtist> {

		public JazzAdapter(List<JazzArtist> artists) {
			super(ArbItemSizeDSLV.this, R.layout.jazz_artist_list_item,
					R.id.artist_name_textview, artists);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			View v = super.getView(position, convertView, parent);

			if (v != convertView && v != null) {
				ViewHolder holder = new ViewHolder();

				TextView tv = (TextView) v
						.findViewById(R.id.artist_albums_textview);
				holder.albumsView = tv;

				v.setTag(holder);
			}

			ViewHolder holder = (ViewHolder) v.getTag();
			String albums = getItem(position).albums;

			holder.albumsView.setText(albums);

			return v;
		}
	}

}
