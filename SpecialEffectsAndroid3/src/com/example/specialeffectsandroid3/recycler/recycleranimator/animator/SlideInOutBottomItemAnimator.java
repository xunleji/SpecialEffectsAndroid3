package com.example.specialeffectsandroid3.recycler.recycleranimator.animator;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public class SlideInOutBottomItemAnimator extends BaseItemAnimator {

	private float mOriginalY;
	private float mDeltaY;

	public SlideInOutBottomItemAnimator(RecyclerView recyclerView) {
		super(recyclerView);
	}

	@Override
	protected void animateRemoveImpl(final ViewHolder holder) {
		final View view = holder.itemView;
		ViewCompat.animate(view).cancel();
		ViewCompat.animate(view).setDuration(getRemoveDuration())
				.translationY(+mDeltaY).setListener(new VpaListenerAdapter() {
					@Override
					public void onAnimationEnd(View view) {
						ViewCompat.setTranslationY(view, +mDeltaY);
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
		ViewCompat.animate(view).translationY(0).setDuration(getAddDuration())
				.setListener(new VpaListenerAdapter() {
					@Override
					public void onAnimationCancel(View view) {
						ViewCompat.setTranslationY(view, 0);
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
		retrieveItemPosition(holder);
		ViewCompat.setTranslationY(holder.itemView, +mDeltaY);
	}

	private void retrieveItemPosition(ViewHolder holder) {
		mOriginalY = mRecyclerView.getLayoutManager().getDecoratedTop(
				holder.itemView);
		mDeltaY = mRecyclerView.getHeight() - mOriginalY;
	}

}
