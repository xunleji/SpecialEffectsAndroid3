package com.example.specialeffectsandroid3.swichlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.swichlayout.library.BaseEffects;
import com.example.specialeffectsandroid3.swichlayout.library.SwitchLayout;

public class SwichLayoutActivity extends Activity implements OnClickListener {

	private Button btn_ok, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7,
			btn_8, btn_9, btn_10, btn_11, btn_12, btn_13, btn_14;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.swichlayout_main);
		btn_ok = (Button) this.findViewById(R.id.btn_ok);
		btn_1 = (Button) this.findViewById(R.id.btn_1);
		btn_2 = (Button) this.findViewById(R.id.btn_2);
		btn_3 = (Button) this.findViewById(R.id.btn_3);
		btn_4 = (Button) this.findViewById(R.id.btn_4);
		btn_5 = (Button) this.findViewById(R.id.btn_5);
		btn_6 = (Button) this.findViewById(R.id.btn_6);
		btn_7 = (Button) this.findViewById(R.id.btn_7);
		btn_8 = (Button) this.findViewById(R.id.btn_8);
		btn_9 = (Button) this.findViewById(R.id.btn_9);
		btn_10 = (Button) this.findViewById(R.id.btn_10);
		btn_11 = (Button) this.findViewById(R.id.btn_11);
		btn_12 = (Button) this.findViewById(R.id.btn_12);
		btn_13 = (Button) this.findViewById(R.id.btn_13);
		btn_14 = (Button) this.findViewById(R.id.btn_14);
		btn_ok.setOnClickListener(this);
		btn_1.setOnClickListener(this);
		btn_2.setOnClickListener(this);
		btn_3.setOnClickListener(this);
		btn_4.setOnClickListener(this);
		btn_5.setOnClickListener(this);
		btn_6.setOnClickListener(this);
		btn_7.setOnClickListener(this);
		btn_8.setOnClickListener(this);
		btn_9.setOnClickListener(this);
		btn_10.setOnClickListener(this);
		btn_11.setOnClickListener(this);
		btn_12.setOnClickListener(this);
		btn_13.setOnClickListener(this);
		btn_14.setOnClickListener(this);

		// 设置进入Activity的Activity特效动画，同理可拓展为布局动画
		SwitchLayout.getSlideFromBottom(this, false,
				BaseEffects.getQuickToSlowEffect());
		// 三个参数分别为（Activity/View，是否关闭Activity，特效（可为空））
	}

	@Override
	public void onClick(View v) {
		if (v == btn_ok) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 0);
			SwichLayoutActivity.this.startActivity(in);
		} else if (v == btn_1) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 1);
			SwichLayoutActivity.this.startActivity(in);
		} else if (v == btn_2) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 2);
			SwichLayoutActivity.this.startActivity(in);
		} else if (v == btn_3) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 3);
			SwichLayoutActivity.this.startActivity(in);
		} else if (v == btn_4) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 4);
			SwichLayoutActivity.this.startActivity(in);
		} else if (v == btn_5) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 5);
			SwichLayoutActivity.this.startActivity(in);
		} else if (v == btn_6) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 6);
			SwichLayoutActivity.this.startActivity(in);
		} else if (v == btn_7) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 7);
			SwichLayoutActivity.this.startActivity(in);
		} else if (v == btn_8) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 8);
			SwichLayoutActivity.this.startActivity(in);
		} else if (v == btn_9) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 9);
			SwichLayoutActivity.this.startActivity(in);
		} else if (v == btn_10) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 10);
			SwichLayoutActivity.this.startActivity(in);
		} else if (v == btn_11) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 11);
			SwichLayoutActivity.this.startActivity(in);
		} else if (v == btn_12) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 12);
			SwichLayoutActivity.this.startActivity(in);
		} else if (v == btn_13) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 13);
			SwichLayoutActivity.this.startActivity(in);
		} else if (v == btn_14) {
			Intent in = new Intent(SwichLayoutActivity.this, SecondActivity.class);
			in.putExtra("key", 14);
			SwichLayoutActivity.this.startActivity(in);
		}
	}

}
