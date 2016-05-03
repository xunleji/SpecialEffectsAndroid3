package com.example.specialeffectsandroid3.recycler.recycleranimator.animator;

import java.util.ArrayList;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public abstract class BaseItemAnimator extends ItemAnimator {

	protected RecyclerView mRecyclerView;
	private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList<RecyclerView.ViewHolder>();
	private ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList<RecyclerView.ViewHolder>();
	private ArrayList<MoveInfo> mPendingMoves = new ArrayList<MoveInfo>();

	private ArrayList<RecyclerView.ViewHolder> mAdditions = new ArrayList<RecyclerView.ViewHolder>();
	private ArrayList<MoveInfo> mMoves = new ArrayList<MoveInfo>();

	protected ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList<RecyclerView.ViewHolder>();
	protected ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList<RecyclerView.ViewHolder>();
	protected ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList<RecyclerView.ViewHolder>();

	public BaseItemAnimator(RecyclerView recyclerView) {
		super();
		mRecyclerView = recyclerView;
	}

	@Override
	public boolean animateAdd(ViewHolder holder) {
		prepareAnimateAdd(holder);
		mPendingAdditions.add(holder);
		return true;
	}

	@Override
	public boolean animateChange(ViewHolder arg0, ViewHolder arg1, int arg2,
			int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean animateMove(ViewHolder holder, int fromX, int fromY,
			int toX, int toY) {
		final View view = holder.itemView;
		int deltaX = toX - fromX;
		int deltaY = toY - fromY;
		if (deltaX == 0 && deltaY == 0) {
			dispatchMoveFinished(holder);
			return false;
		}
		if (deltaX != 0) {
			ViewCompat.setTranslationX(view, -deltaX);
		}
		if (deltaY != 0) {
			ViewCompat.setTranslationY(view, -deltaY);
		}
		mPendingMoves.add(new MoveInfo(holder, fromX, fromY, toX, toY));
		return true;
	}

	@Override
	public boolean animateRemove(ViewHolder holder) {
		mPendingRemovals.add(holder);
		return true;
	}

	@Override
	public void endAnimation(ViewHolder item) {
		final View view = item.itemView;
		ViewCompat.animate(view).cancel();
		if (mPendingMoves.contains(item)) {
			ViewCompat.setTranslationY(view, 0);
			ViewCompat.setTranslationX(view, 0);
			dispatchMoveFinished(item);
			mPendingMoves.remove(item);
		}
		if (mPendingRemovals.contains(item)) {
			dispatchRemoveFinished(item);
			mPendingRemovals.remove(item);
		}
		if (mPendingAdditions.contains(item)) {
			ViewCompat.setAlpha(view, 1);
			dispatchAddFinished(item);
			mPendingAdditions.remove(item);
		}
		if (mMoveAnimations.contains(item)) {
			ViewCompat.setTranslationY(view, 0);
			ViewCompat.setTranslationX(view, 0);
			dispatchMoveFinished(item);
			mMoveAnimations.remove(item);
		}
		if (mRemoveAnimations.contains(item)) {
			ViewCompat.setAlpha(view, 1);
			dispatchRemoveFinished(item);
			mRemoveAnimations.remove(item);
		}
		if (mAddAnimations.contains(item)) {
			ViewCompat.setAlpha(view, 1);
			dispatchAddFinished(item);
			mAddAnimations.remove(item);
		}
		dispatchFinishedWhenDone();

	}

	@Override
	public void endAnimations() {
		int count = mPendingMoves.size();
		for (int i = count - 1; i >= 0; i--) {
			MoveInfo item = mPendingMoves.get(i);
			View view = item.holder.itemView;
			ViewCompat.animate(view).cancel();
			ViewCompat.setTranslationY(view, 0);
			ViewCompat.setTranslationX(view, 0);
			dispatchMoveFinished(item.holder);
			mPendingMoves.remove(item);
		}
		count = mPendingRemovals.size();
		for (int i = count - 1; i >= 0; i--) {
			RecyclerView.ViewHolder item = mPendingRemovals.get(i);
			dispatchRemoveFinished(item);
			mPendingRemovals.remove(item);
		}
		count = mPendingAdditions.size();
		for (int i = count - 1; i >= 0; i--) {
			RecyclerView.ViewHolder item = mPendingAdditions.get(i);
			View view = item.itemView;
			ViewCompat.setAlpha(view, 1);
			dispatchAddFinished(item);
			mPendingAdditions.remove(item);
		}
		if (!isRunning()) {
			return;
		}
		count = mMoveAnimations.size();
		for (int i = count - 1; i >= 0; i--) {
			RecyclerView.ViewHolder item = mMoveAnimations.get(i);
			View view = item.itemView;
			ViewCompat.animate(view).cancel();
			ViewCompat.setTranslationY(view, 0);
			ViewCompat.setTranslationX(view, 0);
			dispatchMoveFinished(item);
			mMoveAnimations.remove(item);
		}
		count = mRemoveAnimations.size();
		for (int i = count - 1; i >= 0; i--) {
			RecyclerView.ViewHolder item = mRemoveAnimations.get(i);
			View view = item.itemView;
			ViewCompat.animate(view).cancel();
			ViewCompat.setAlpha(view, 1);
			dispatchRemoveFinished(item);
			mRemoveAnimations.remove(item);
		}
		count = mAddAnimations.size();
		for (int i = count - 1; i >= 0; i--) {
			RecyclerView.ViewHolder item = mAddAnimations.get(i);
			View view = item.itemView;
			ViewCompat.animate(view).cancel();
			ViewCompat.setAlpha(view, 1);
			dispatchAddFinished(item);
			mAddAnimations.remove(item);
		}
		mMoves.clear();
		mAdditions.clear();
		dispatchAnimationsFinished();
	}

	@Override
	public boolean isRunning() {
		return (!mMoveAnimations.isEmpty() || !mRemoveAnimations.isEmpty()
				|| !mAddAnimations.isEmpty() || !mMoves.isEmpty() || !mAdditions
					.isEmpty());
	}

	@Override
	public void runPendingAnimations() {
		// TODO Auto-generated method stub
		boolean removalsPending = !mPendingRemovals.isEmpty();
		boolean movesPending = !mPendingMoves.isEmpty();
		boolean additionsPending = !mPendingAdditions.isEmpty();
		if (!removalsPending && !movesPending && !additionsPending) {
			// nothing to animate
			return;
		}
		// First, remove stuff
		for (RecyclerView.ViewHolder holder : mPendingRemovals) {
			animateRemoveImpl(holder);
		}
		mPendingRemovals.clear();
		// Next, move stuff
		if (movesPending) {
			mMoves.addAll(mPendingMoves);
			mPendingMoves.clear();
			Runnable mover = new Runnable() {

				@Override
				public void run() {
					for (MoveInfo moveInfo : mMoves) {
						animateMoveImpl(moveInfo.holder, moveInfo.fromX,
								moveInfo.fromY, moveInfo.toX, moveInfo.toY);
					}
					mMoves.clear();
				}
			};
			if (removalsPending) {
				View view = mMoves.get(0).holder.itemView;
				ViewCompat.postOnAnimationDelayed(view, mover,
						getRemoveDuration());
			} else {
				mover.run();
			}
		}
		// Next, add stuff
		if (additionsPending) {
			mAdditions.addAll(mPendingAdditions);
			mPendingAdditions.clear();
			Runnable adder = new Runnable() {

				@Override
				public void run() {
					for (RecyclerView.ViewHolder holder : mAdditions) {
						animateAddImpl(holder);
					}
					mAdditions.clear();
				}
			};
			if (removalsPending || movesPending) {
				View view = mAdditions.get(0).itemView;
				ViewCompat.postOnAnimationDelayed(view, adder,
						(removalsPending ? getRemoveDuration() : 0)
								+ (movesPending ? getMoveDuration() : 0));
			} else {
				adder.run();
			}
		}

	}

	protected void animateMoveImpl(final ViewHolder holder, int fromX,
			int fromY, int toX, int toY) {
		final View view = holder.itemView;
		final int deltaX = toX - fromX;
		final int deltaY = toY - fromY;
		ViewCompat.animate(view).cancel();
		if (deltaX != 0) {
			ViewCompat.animate(view).translationX(0);
		}
		if (deltaY != 0) {
			ViewCompat.animate(view).translationY(0);
		}
		ViewCompat.animate(view).setDuration(getMoveDuration())
				.setListener(new VpaListenerAdapter() {
					@Override
					public void onAnimationCancel(View view) {
						if (deltaX != 0) {
							ViewCompat.setTranslationX(view, 0);
						}
						if (deltaY != 0) {
							ViewCompat.setTranslationY(view, 0);
						}
					}

					@Override
					public void onAnimationEnd(View view) {
						dispatchMoveFinished(holder);
						mMoveAnimations.remove(holder);
						dispatchFinishedWhenDone();
					}
				}).start();
		mMoveAnimations.add(holder);
	}

	protected void dispatchFinishedWhenDone() {
		if (!isRunning()) {
			dispatchAnimationsFinished();
		}
	}

	protected abstract void animateRemoveImpl(
			final RecyclerView.ViewHolder holder);

	protected abstract void animateAddImpl(final RecyclerView.ViewHolder holder);

	protected abstract void prepareAnimateAdd(
			final RecyclerView.ViewHolder holder);

	private static class MoveInfo {
		public RecyclerView.ViewHolder holder;
		public int fromX, fromY, toX, toY;

		private MoveInfo(RecyclerView.ViewHolder holder, int fromX, int fromY,
				int toX, int toY) {
			this.holder = holder;
			this.fromX = fromX;
			this.fromY = fromY;
			this.toX = toX;
			this.toY = toY;
		}
	}

	protected static class VpaListenerAdapter implements
			ViewPropertyAnimatorListener {
		@Override
		public void onAnimationStart(View view) {
		}

		@Override
		public void onAnimationEnd(View view) {
		}

		@Override
		public void onAnimationCancel(View view) {
		}
	};

}
