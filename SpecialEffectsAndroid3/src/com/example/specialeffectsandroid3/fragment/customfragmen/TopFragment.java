package com.example.specialeffectsandroid3.fragment.customfragmen;

import com.example.specialeffectsandroid3.Diary;
import com.example.specialeffectsandroid3.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class TopFragment extends Fragment {

	private TextView tv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.topfragment_main, container,
				false);
		tv = (TextView) view.findViewById(R.id.toptv);
		tv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				CustomDialogFragment dialog = new CustomDialogFragment();
				dialog.show(getFragmentManager(), "loginDialog");
			}
		});
		return view;
	}

}
