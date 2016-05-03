package com.example.specialeffectsandroid3.recycler.recycleranimator.animator;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public class SlideScaleInOutRightItemAnimator extends BaseItemAnimator {

	private float DEFAULT_SCALE_INITIAL = 0.6f;

	private float mInitialScaleX = DEFAULT_SCALE_INITIAL;
	private float mInitialScaleY = DEFAULT_SCALE_INITIAL;

	private float mEndScaleX = DEFAULT_SCALE_INITIAL;
	private float mEndScaleY = DEFAULT_SCALE_INITIAL;

	private float mOriginalScaleX;
	private float mOriginalScaleY;

	public SlideScaleInOutRightItemAnimator(RecyclerView recyclerView) {
		super(recyclerView);
	}

	@Override
	protected void animateRemoveImpl(final ViewHolder holder) {
		final View view = holder.itemView;
		ViewCompat.animate(view).cancel();
		ViewCompat.animate(view).setDuration(getRemoveDuration())
				.scaleX(mEndScaleX).scaleY(mEndScaleY)
				.translationX(+mRecyclerView.getWidth())
				.setListener(new VpaListenerAdapter() {
					@Override
					public void onAnimationEnd(View view) {
						ViewCompat.setScaleX(view, mEndScaleX);
						ViewCompat.setScaleY(view, mEndScaleY);
						ViewCompat.setTranslationX(view,
								+mRecyclerView.getWidth());
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
				.scaleY(mOriginalScaleY).translationX(0)
				.setDuration(getAddDuration())
				.setListener(new VpaListenerAdapter() {
					@Override
					public void onAnimationCancel(View view) {
						ViewCompat.setTranslationX(view, 0);
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
		// TODO Auto-generated method stub
		retrieveOriginalScale(holder);
		ViewCompat.setScaleX(holder.itemView, mInitialScaleX);
		ViewCompat.setScaleY(holder.itemView, mInitialScaleY);

		ViewCompat.setTranslationX(holder.itemView, +mRecyclerView.getWidth());
	}

	@SuppressLint("NewApi")
	private void retrieveOriginalScale(ViewHolder holder) {
		// TODO Auto-generated method stub
		mOriginalScaleX = holder.itemView.getScaleX();
		mOriginalScaleY = holder.itemView.getScaleY();
	}

}
