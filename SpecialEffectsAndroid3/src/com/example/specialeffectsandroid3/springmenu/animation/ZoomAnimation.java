package com.example.specialeffectsandroid3.springmenu.animation;

import android.view.View;
import android.view.animation.AnimationSet;

/**

 * @File: ZoomAnimation.java

 * @Package com.spring.menu.animation

 * @Author Hanyonglu

 * @Version V1.0
 */
public abstract class ZoomAnimation extends AnimationSet {
	public Direction direction;

	public enum Direction {
		HIDE, SHOW;
	}

	public ZoomAnimation(Direction direction, long duration, View[] views) {
		super(true);
		this.direction = direction;
		
		switch (this.direction) {
		case HIDE:
			addShrinkAnimation(views);
			break;
		case SHOW:
			addEnlargeAnimation(views);
			break;
		}
		
		setDuration(duration);
	}

	protected abstract void addShrinkAnimation(View[] views);
	
	protected abstract void addEnlargeAnimation(View[] views);
}
