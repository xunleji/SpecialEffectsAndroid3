package com.example.specialeffectsandroid3.recycler.recycleranimator.animator;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;

public class SlideInOutTopItemAnimator extends BaseItemAnimator {

	float mOriginalY;

	public SlideInOutTopItemAnimator(RecyclerView recyclerView) {
		super(recyclerView);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void animateRemoveImpl(final ViewHolder holder) {
		// TODO Auto-generated method stub
		final View view = holder.itemView;
		ViewCompat.animate(view).cancel();
		ViewCompat.animate(view).setDuration(getRemoveDuration())
				.translationY(-mOriginalY)
				.setListener(new VpaListenerAdapter() {

					@Override
					public void onAnimationEnd(View view) {
						// TODO Auto-generated method stub
						super.onAnimationEnd(view);
						ViewCompat.setTranslationY(view, -mOriginalY);
						dispatchRemoveFinished(holder);
						mRemoveAnimations.remove(holder);
						dispatchFinishedWhenDone();
					}

				}).start();
		mMoveAnimations.add(holder);

	}

	@Override
	protected void animateAddImpl(final ViewHolder holder) {
		// TODO Auto-generated method stub
		final View view = holder.itemView;
		ViewCompat.animate(view).cancel();
		ViewCompat.animate(view).translationY(0).setDuration(getAddDuration())
				.setListener(new VpaListenerAdapter() {

					@Override
					public void onAnimationCancel(View view) {
						super.onAnimationCancel(view);
						ViewCompat.setTranslationY(view, 0);
					}

					@Override
					public void onAnimationEnd(View view) {
						super.onAnimationEnd(view);
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
		retrieveItemHeight(holder);
		ViewCompat.setTranslationY(holder.itemView, -mOriginalY);

	}

	private void retrieveItemHeight(ViewHolder holder) {
		mOriginalY = mRecyclerView.getLayoutManager().getDecoratedBottom(
				holder.itemView);
	}

}
