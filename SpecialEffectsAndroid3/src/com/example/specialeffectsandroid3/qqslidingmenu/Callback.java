package com.example.specialeffectsandroid3.qqslidingmenu;

public interface Callback {
	void onBefore();

	boolean onRun();

	void onAfter(boolean b);
}
