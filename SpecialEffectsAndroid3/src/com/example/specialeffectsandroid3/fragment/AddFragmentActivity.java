package com.example.specialeffectsandroid3.fragment;

import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.fragment.customfragmen.TopFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class AddFragmentActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.addfragment_main);
		// if (findViewById(R.id.frame_continer) != null) {
		// if (arg0 != null)
		// return;
		// TopFragment topFragment = new TopFragment();
		// getSupportFragmentManager().beginTransaction()
		// .add(R.id.frame_continer, topFragment).commit();
		// }

		TopFragment topFragment = new TopFragment();
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.frame_continer, topFragment);
		transaction.addToBackStack(null);// 添加之后用户点击返回会回退到用户替换之前的页面
		transaction.commit();
	}

}
