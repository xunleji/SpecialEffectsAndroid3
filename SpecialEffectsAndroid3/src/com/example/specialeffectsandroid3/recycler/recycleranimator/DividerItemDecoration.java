package com.example.specialeffectsandroid3.recycler.recycleranimator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.TypedValue;
import android.view.View;

public class DividerItemDecoration extends ItemDecoration {

	private static final int[] ATTRS = new int[] { android.R.attr.listDivider };
	public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
	public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
	private Drawable mDivider;
	private int mOrientation;
	/**
	 * item之间分割线的size，默认为1
	 */
	private int mItemSize = 3;

	/**
	 * 绘制item分割线的画笔，和设置其属性 来绘制个性分割线
	 */
	private Paint mPaint;

	public DividerItemDecoration(Context context, int orientation) {
		super();
		final TypedArray a = context.obtainStyledAttributes(ATTRS);
		mDivider = a.getDrawable(0);
		a.recycle();
		if (orientation != LinearLayoutManager.VERTICAL
				&& orientation != LinearLayoutManager.HORIZONTAL) {
			throw new IllegalArgumentException("请传入正确的参数");
		}
		setOrientation(orientation);
		mItemSize = (int) TypedValue.applyDimension(mItemSize,
				TypedValue.COMPLEX_UNIT_DIP, context.getResources()
						.getDisplayMetrics());
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setColor(Color.BLUE);
		/* 设置填充 */
		mPaint.setStyle(Paint.Style.FILL);
	}

	public void setOrientation(int orientation) {
		if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
			throw new IllegalArgumentException("invalid orientation");
		}
		mOrientation = orientation;
	}

	@Override
	public void getItemOffsets(Rect outRect, int itemPosition,
			RecyclerView parent) {
		if (mOrientation == VERTICAL_LIST) {
			outRect.set(0, 0, 0, mItemSize);
		} else {
			outRect.set(0, 0, mItemSize, 0);
		}
	}

	@Override
	public void onDraw(Canvas c, RecyclerView parent) {
		// TODO Auto-generated method stub
		if (mOrientation == VERTICAL_LIST) {
			drawVertical(c, parent);
		} else {
			drawHorizontal(c, parent);
		}
	}

	private void drawHorizontal(Canvas c, RecyclerView parent) {
		int childcount = parent.getChildCount();
		for (int i = 0; i < childcount; i++) {
			View child = parent.getChildAt(i);
			LayoutParams params = (LayoutParams) child.getLayoutParams();
			int left = child.getRight() + params.rightMargin;
			int right = left + mDivider.getIntrinsicHeight();
			final int top = parent.getPaddingTop();
			final int bottom = parent.getHeight() - parent.getPaddingBottom();
			c.drawRect(left, top, right, bottom, mPaint);
		}

	}

	private void drawVertical(Canvas c, RecyclerView parent) {
		int childcount = parent.getChildCount();
		for (int i = 0; i < childcount; i++) {
			View child = parent.getChildAt(i);
			LayoutParams params = (LayoutParams) child.getLayoutParams();
			final int top = child.getBottom() + params.bottomMargin;
			final int bottom = top + mItemSize;
			final int left = parent.getPaddingLeft();
			final int right = parent.getMeasuredWidth()
					- parent.getPaddingRight();
			c.drawRect(left, top, right, bottom, mPaint);
		}
	}

}
