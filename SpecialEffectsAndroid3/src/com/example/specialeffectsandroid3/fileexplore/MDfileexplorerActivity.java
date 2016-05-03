package com.example.specialeffectsandroid3.fileexplore;

import com.example.specialeffectsandroid3.fileexplore.library.FilePickerActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MDfileexplorerActivity extends Activity {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(new LinearLayout(this));
		Intent intent = new Intent(this, FilePickerActivity.class);
		startActivityForResult(intent, 1);
	}

}
