package com.example.specialeffectsandroid3.recycler;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

public class DividerGridItemDecoration extends ItemDecoration {

	private static final int[] ATTRS = new int[] { android.R.attr.listDivider };
	private Drawable mDivider;

	public DividerGridItemDecoration(Context context) {
		super();
		// TODO Auto-generated constructor stub
		TypedArray a = context.obtainStyledAttributes(ATTRS);
		mDivider = a.getDrawable(0);
		a.recycle();
	}

	@Override
	public void onDraw(Canvas c, RecyclerView parent) {
		drawHorizontal(c, parent);
		drawVertical(c, parent);
	}

	private void drawVertical(Canvas c, RecyclerView parent) {
		int count = parent.getChildCount();
		for (int i = 0; i < count; i++) {
			final View child = parent.getChildAt(i);
			LayoutParams params = (LayoutParams) child.getLayoutParams();
			final int top = child.getTop() - params.topMargin;
			final int bottom = child.getBottom() + params.bottomMargin;
			final int left = child.getRight() + params.rightMargin;
			final int right = left + mDivider.getIntrinsicWidth();
			mDivider.setBounds(left, top, right, bottom);
			mDivider.draw(c);
		}
	}

	private void drawHorizontal(Canvas c, RecyclerView parent) {
		// TODO Auto-generated method stub
		int count = parent.getChildCount();
		for (int i = 0; i < count; i++) {
			final View child = parent.getChildAt(i);
			LayoutParams params = (LayoutParams) child.getLayoutParams();
			int left = child.getLeft() - params.leftMargin;
			int right = child.getRight() + params.rightMargin
					+ mDivider.getIntrinsicWidth();
			int top = child.getBottom() + params.bottomMargin;
			int bottom = top + mDivider.getIntrinsicHeight();
			mDivider.setBounds(left, top, right, bottom);
			mDivider.draw(c);
		}
	}

	@Override
	public void getItemOffsets(Rect outRect, int itemPosition,
			RecyclerView parent) {
		int spanCount = getSpanCount(parent);
		int childCount = parent.getAdapter().getItemCount();
		if (isLastRaw(parent, itemPosition, spanCount, childCount))// 如果是最后一行，则不需要绘制底部
		{
			outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);

		} else if (isLastColum(parent, itemPosition, spanCount, childCount))// 如果是最后一列，则不需要绘制右边
		{
			outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
		} else {
			outRect.set(0, 0, mDivider.getIntrinsicWidth(),
					mDivider.getIntrinsicHeight());
		}
	}

	private boolean isLastColum(RecyclerView parent, int pos, int spanCount,
			int childCount) {
		LayoutManager layoutManager = parent.getLayoutManager();
		if (layoutManager instanceof GridLayoutManager) {
			if ((pos + 1) % spanCount == 0)// 如果是最后一列，则不需要绘制右边
			{
				return true;
			}
		} else if (layoutManager instanceof StaggeredGridLayoutManager) {
			int orientation = ((StaggeredGridLayoutManager) layoutManager)
					.getOrientation();
			if (orientation == StaggeredGridLayoutManager.VERTICAL) {
				if ((pos + 1) % spanCount == 0)// 如果是最后一列，则不需要绘制右边
				{
					return true;
				}
			} else {
				childCount = childCount - childCount % spanCount;
				if (pos >= childCount)// 如果是最后一列，则不需要绘制右边
					return true;
			}
		}
		return false;
	}

	private boolean isLastRaw(RecyclerView parent, int itemPosition,
			int spanCount, int childCount) {
		// TODO Auto-generated method stub
		LayoutManager layoutManager = parent.getLayoutManager();
		if (layoutManager instanceof GridLayoutManager) {
			childCount = childCount - childCount % spanCount;
			if (itemPosition >= childCount) {
				return true;
			}
		} else if (layoutManager instanceof StaggeredGridLayoutManager) {
			int orientation = ((StaggeredGridLayoutManager) layoutManager)
					.getOrientation();
			if (orientation == StaggeredGridLayoutManager.VERTICAL) {
				childCount = childCount - childCount % spanCount;
				if (itemPosition >= childCount) {
					return true;
				}
			} else {
				// 如果是最后一行，则不需要绘制底部
				if ((itemPosition + 1) % spanCount == 0) {
					return true;
				}
			}
		}
		return false;
	}

	private int getSpanCount(RecyclerView parent) {
		int spanCount = -1;
		LayoutManager layoutManager = parent.getLayoutManager();
		if (layoutManager instanceof GridLayoutManager) {
			spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
		} else if (layoutManager instanceof StaggeredGridLayoutManager) {
			spanCount = ((StaggeredGridLayoutManager) layoutManager)
					.getSpanCount();
		}
		return spanCount;
	}

}
