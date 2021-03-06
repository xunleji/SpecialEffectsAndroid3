package com.example.specialeffectsandroid3.flowingdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.specialeffectsandroid3.R;
import com.squareup.picasso.Picasso;

public class MyMenuFragment extends MenuFragment {

	private ImageView ivMenuUserProfilePhoto;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_menu, container, false);
		ivMenuUserProfilePhoto = (ImageView) view.findViewById(R.id.imageView1);
		return setupReveal(view);
	}

}
