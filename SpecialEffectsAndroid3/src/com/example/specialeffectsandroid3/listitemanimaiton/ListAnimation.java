package com.example.specialeffectsandroid3.listitemanimaiton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.listitemanimaiton.activity.AlphaInActivity;
import com.example.specialeffectsandroid3.listitemanimaiton.activity.CardItemActivity;
import com.example.specialeffectsandroid3.listitemanimaiton.activity.ScaleInActivity;
import com.example.specialeffectsandroid3.listitemanimaiton.activity.SwingBottomInActivity;
import com.example.specialeffectsandroid3.listitemanimaiton.activity.SwingBottomRightInActivity;
import com.example.specialeffectsandroid3.listitemanimaiton.activity.SwingLeftInActivity;
import com.example.specialeffectsandroid3.listitemanimaiton.activity.SwingRightInActivity;

public class ListAnimation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listanimation_main);
	}

	public void cardItem(View v) {
		startActivity(new Intent(this, CardItemActivity.class));
	}

	public void onBottomInClicked(View view) {
		Intent intent = new Intent(this, SwingBottomInActivity.class);
		startActivity(intent);
	}

	public void onRightInClicked(View view) {
		Intent intent = new Intent(this, SwingRightInActivity.class);
		startActivity(intent);
	}

	public void onLeftInClicked(View view) {
		Intent intent = new Intent(this, SwingLeftInActivity.class);
		startActivity(intent);
	}

	public void onBottomRightInClicked(View view) {
		Intent intent = new Intent(this, SwingBottomRightInActivity.class);
		startActivity(intent);
	}

	public void onScaleInClicked(View view) {
		Intent intent = new Intent(this, ScaleInActivity.class);
		startActivity(intent);
	}

	public void onAlphaInClicked(View view) {
		Intent intent = new Intent(this, AlphaInActivity.class);
		startActivity(intent);
	}

}
