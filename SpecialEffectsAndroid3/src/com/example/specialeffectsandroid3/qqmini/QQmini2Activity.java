package com.example.specialeffectsandroid3.qqmini;

import com.example.specialeffectsandroid3.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class QQmini2Activity extends Activity {
	
	private HomeCenterLayout centerLayout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.qqmini_main);

		LinearLayout leftLayout = (LinearLayout) findViewById(R.id.homeLeft);
		MyLinearLayout rightLayout = (MyLinearLayout) findViewById(R.id.homeRight);
		centerLayout = (HomeCenterLayout) findViewById(R.id.homeCenter);

		leftLayout.setVisibility(View.GONE);
		rightLayout.setVisibility(View.GONE);
		centerLayout.setBrotherLayout(leftLayout, rightLayout);
		ImageButton leftBtn = (ImageButton) findViewById(R.id.ivTitleBtnLeft);
		ImageButton rightBtn = (ImageButton) findViewById(R.id.ivTitleBtnRigh);
		leftBtn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (centerLayout.getPage() == HomeCenterLayout.MIDDLE)
					centerLayout.setPage(HomeCenterLayout.LEFT);
				else
					centerLayout.setPage(HomeCenterLayout.MIDDLE);
			}
		});

		rightBtn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (centerLayout.getPage() == HomeCenterLayout.MIDDLE)
					centerLayout.setPage(HomeCenterLayout.RIGHT);
				else
					centerLayout.setPage(HomeCenterLayout.MIDDLE);
			}
		});
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (centerLayout.getPage() != HomeCenterLayout.MIDDLE)
			centerLayout.setPage(HomeCenterLayout.MIDDLE);
		else
			super.onBackPressed();
	}
}