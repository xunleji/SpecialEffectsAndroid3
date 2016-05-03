package com.example.specialeffectsandroid3.recycler.recycleranimator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.specialeffectsandroid3.Diary;
import com.example.specialeffectsandroid3.R;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleAdapter extends Adapter<SimpleAdapter.SimpleViewHolder> {

	public static final int LAST_POSITION = -1;
	private final Context mContext;
	private List<String> mData;

	public SimpleAdapter(Context context, String[] data) {
		super();
		this.mContext = context;
		if (data != null)
			mData = new ArrayList<String>(Arrays.asList(data));
		else
			mData = new ArrayList<String>();
	}

	public static class SimpleViewHolder extends RecyclerView.ViewHolder {
		public final TextView title;

		public SimpleViewHolder(View view) {
			super(view);
			title = (TextView) view.findViewById(R.id.simple_text);
		}
	}

	@Override
	public int getItemCount() {
		return mData.size();
	}

	@Override
	public void onBindViewHolder(SimpleViewHolder holder, final int position) {
		holder.title.setText(mData.get(position));
		holder.title.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(mContext, "Position =" + position,
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int arg1) {
		final View view = LayoutInflater.from(mContext).inflate(
				R.layout.simple_item, parent, false);
		return new SimpleViewHolder(view);
	}

	public void add(String s, int position) {
		Diary.print("add position=" + position);
		position = position == LAST_POSITION ? getItemCount() : position;
		mData.add(position, s);
		notifyItemInserted(position);
	}

	public void remove(int position) {
		Diary.print("remove position=" + position);
		if (position == LAST_POSITION && getItemCount() > 0)
			position = getItemCount() - 1;
		if (position > LAST_POSITION && position < getItemCount()) {
			mData.remove(position);
			notifyItemRemoved(position);
		}
	}

}
