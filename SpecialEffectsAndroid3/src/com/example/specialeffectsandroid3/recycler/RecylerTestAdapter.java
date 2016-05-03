package com.example.specialeffectsandroid3.recycler;

import java.util.ArrayList;
import java.util.List;

import com.example.specialeffectsandroid3.Diary;
import com.example.specialeffectsandroid3.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.NoCopySpan.Concrete;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecylerTestAdapter extends
		RecyclerView.Adapter<RecylerTestAdapter.ViewHolder> {

	// 数据集
	private List<String> mDataset;
	private Context context;
	private OnItemClick onitem;

	public RecylerTestAdapter(List<String> dataset, Context context) {
		super();
		this.context = context;
		mDataset = new ArrayList<String>();
		mDataset.addAll(dataset);
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		// 创建一个View，简单起见直接使用系统提供的布局，就是一个TextView
		View view = LayoutInflater.from(context).inflate(R.layout.recyler_item,
				null);
		// 创建一个ViewHolder
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, final int i) {
		// 绑定数据到ViewHolder上
		viewHolder.mTextView.setText(mDataset.get(i));
		viewHolder.itemView.setTag(mDataset.get(i));
		if (onitem != null) {
			viewHolder.itemView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					onitem.itemClick(v, i);
				}
			});
			viewHolder.itemView
					.setOnLongClickListener(new OnLongClickListener() {

						@Override
						public boolean onLongClick(View v) {
							onitem.itemlongClick(v, i);
							return false;
						}
					});
		}
	}

	@Override
	public int getItemCount() {
		if (mDataset == null)
			return 0;
		else
			return mDataset.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		public TextView mTextView;

		public ViewHolder(View itemViews) {
			super(itemViews);
			// if (itemViews != null)
			// itemViews.setOnClickListener(new OnClickListener() {
			//
			// @Override
			// public void onClick(View v) {
			// onitem.itemClick(v, getPosition());
			// }
			// });
			mTextView = (TextView) itemViews.findViewById(R.id.textview);
		}
	}

	public void addItem(String content, int position) {
		mDataset.add(content);
		notifyItemInserted(mDataset.size());
	}

	public void removeItem(int position) {
		mDataset.remove(position);
		notifyItemRemoved(position);// Attention!
	}

	public interface OnItemClick {
		public void itemClick(View view, int pos);

		public void itemlongClick(View view, int pos);
	}

	public void setOnitemClick(OnItemClick onitem) {
		this.onitem = onitem;
	}

}
