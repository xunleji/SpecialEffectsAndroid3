package com.example.specialeffectsandroid3.recycler.recycleranimator.animator;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public class ScaleInOutItemAnimator extends BaseItemAnimator {

	private float DEFAULT_SCALE_INITIAL = 0.6f;

	private float mInitialScaleX = DEFAULT_SCALE_INITIAL;
	private float mInitialScaleY = DEFAULT_SCALE_INITIAL;

	private float mEndScaleX = DEFAULT_SCALE_INITIAL;
	private float mEndScaleY = DEFAULT_SCALE_INITIAL;

	private float mOriginalScaleX;
	private float mOriginalScaleY;

	public ScaleInOutItemAnimator(RecyclerView recyclerView) {
		super(recyclerView);
	}

	@Override
	protected void animateRemoveImpl(final ViewHolder holder) {
		final View view = holder.itemView;
		ViewCompat.animate(view).cancel();
		ViewCompat.animate(view).setDuration(getRemoveDuration())
				.scaleX(mEndScaleX).scaleY(mEndScaleY)
				.setListener(new VpaListenerAdapter() {
					@Override
					public void onAnimationEnd(View view) {
						ViewCompat.setScaleX(view, mEndScaleX);
						ViewCompat.setScaleY(view, mEndScaleY);
						dispatchRemoveFinished(holder);
						mRemoveAnimations.remove(holder);
						dispatchFinishedWhenDone();
					}
				}).start();
		mRemoveAnimations.add(holder);
	}

	@Override
	protected void animateAddImpl(final ViewHolder holder) {
		final View view = holder.itemView;
		ViewCompat.animate(view).cancel();
		ViewCompat.animate(view).scaleX(mOriginalScaleX)
				.scaleY(mOriginalScaleY).setDuration(getAddDuration())
				.setListener(new VpaListenerAdapter() {
					@Override
					public void onAnimationCancel(View view) {
						ViewCompat.setScaleX(view, mOriginalScaleX);
						ViewCompat.setScaleY(view, mOriginalScaleY);
					}

					@Override
					public void onAnimationEnd(View view) {
						dispatchAddFinished(holder);
						mAddAnimations.remove(holder);
						dispatchFinishedWhenDone();
					}
				}).start();
		mAddAnimations.add(holder);

	}

	@Override
	protected void prepareAnimateAdd(ViewHolder holder) {
		retrieveOriginalScale(holder);
		ViewCompat.setScaleX(holder.itemView, mInitialScaleX);
		ViewCompat.setScaleY(holder.itemView, mInitialScaleY);
	}

	@SuppressLint("NewApi")
	private void retrieveOriginalScale(RecyclerView.ViewHolder holder) {
		mOriginalScaleX = holder.itemView.getScaleX();
		mOriginalScaleY = holder.itemView.getScaleY();
	}

}
