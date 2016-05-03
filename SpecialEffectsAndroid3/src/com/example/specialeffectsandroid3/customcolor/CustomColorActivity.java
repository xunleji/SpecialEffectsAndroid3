package com.example.specialeffectsandroid3.customcolor;

import com.example.specialeffectsandroid3.Diary;
import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.customcolor.ColorPicker.OnColorChangedListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 颜色选择器
 * @author xujuan
 *
 */
public class CustomColorActivity extends Activity{
	
	
	private TextView tv;
	private ColorPicker picker;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.colorselect_main);
		tv = (TextView) findViewById(R.id.textView1);
		picker = (ColorPicker) findViewById(R.id.picker);
		SVBar svBar = (SVBar) findViewById(R.id.svbar);
		OpacityBar opacityBar = (OpacityBar) findViewById(R.id.opacitybar);
		SaturationBar saturationBar = (SaturationBar) findViewById(R.id.saturationbar);
		ValueBar valueBar = (ValueBar) findViewById(R.id.valuebar);
		picker.addSVBar(svBar);
		picker.addOpacityBar(opacityBar);
		picker.addSaturationBar(saturationBar);
		picker.addValueBar(valueBar);
		picker.setOnColorChangedListener(new OnColorChangedListener() {
			
			@Override
			public void onColorChanged(int color) {
				Diary.print("color=="+color);
				tv.setTextColor(color);
			}
		});
	}

}
