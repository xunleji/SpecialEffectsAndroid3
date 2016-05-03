package com.example.specialeffectsandroid3.recycler.recycleranimator.animator;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;

public class SlideInOutRightItemAnimator extends BaseItemAnimator {

	public SlideInOutRightItemAnimator(RecyclerView recyclerView) {
		super(recyclerView);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void animateRemoveImpl(final ViewHolder holder) {
		// TODO Auto-generated method stub
		final View view = holder.itemView;
		ViewCompat.animate(view).cancel();
		ViewCompat.animate(view).setDuration(getRemoveDuration())
				.translationX(+mRecyclerView.getWidth())
				.setListener(new VpaListenerAdapter() {

					@Override
					public void onAnimationEnd(View view) {
						super.onAnimationEnd(view);
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
		// TODO Auto-generated method stub
		final View view = holder.itemView;
		ViewCompat.animate(view).cancel();
		ViewCompat.animate(view).translationX(0).setDuration(getAddDuration())
				.setListener(new VpaListenerAdapter() {

					@Override
					public void onAnimationCancel(View view) {
						// TODO Auto-generated method stub
						super.onAnimationCancel(view);
						ViewCompat.setTranslationX(view, 0);
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
		ViewCompat.setTranslationX(holder.itemView, +mRecyclerView.getWidth());
	}

}
