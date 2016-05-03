package com.example.specialeffectsandroid3.imagelvjing;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ImageActivity extends ListActivity {

	private String[] mListStr = { "图片缩放", "图片圆角", "图片倒影", "旋转图片", "图片反转",
			"图片色调饱和度、色相、亮度处理", "涂鸦，水印", "图片上写文字", "怀旧效果", "模糊效果", "柔化效果(高斯模糊)",
			"浮雕效果", "锐化效果", "底片效果", "光照效果", "素描" };
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mListStr);
		// 设置该窗口显示列表
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		if (position == 0) {
			//图片缩放
			intent = new Intent(ImageActivity.this, Image.class);
			intent.putExtra("position", 0);
		} else if (position == 1) {
			//图片圆角
			intent = new Intent(ImageActivity.this, Image.class);
			intent.putExtra("position", 1);
		} else if (position == 2) {
			//图片倒影
			intent = new Intent(ImageActivity.this, Image.class);
			intent.putExtra("position", 2);
		} else if (position == 3) {
			//旋转图片
			intent = new Intent(ImageActivity.this, Image.class);
			intent.putExtra("position", 3);
		} else if (position == 4) {
			//图片反转
			intent = new Intent(ImageActivity.this, Image.class);
			intent.putExtra("position", 4);
		} else if (position == 5) {
			//图片色调饱和度、色相、亮度处理
			intent = new Intent(ImageActivity.this, ImageToneActivity.class);
		} else if (position == 6) {
			//涂鸦，水印
			intent = new Intent(ImageActivity.this, Image.class);
			intent.putExtra("position", 6);
		} else if (position == 7) {
			//图片上写文字
			intent = new Intent(ImageActivity.this, Image.class);
			intent.putExtra("position", 7);
		}else if (position == 8) {
			//怀旧效果
			intent = new Intent(ImageActivity.this, Image.class);
			intent.putExtra("position", 8);
		}else if (position == 9) {
			//模糊效果
			intent = new Intent(ImageActivity.this, Image.class);
			intent.putExtra("position", 9);
		}else if (position == 10) {
			//柔化效果(高斯模糊)
			intent = new Intent(ImageActivity.this, Image.class);
			intent.putExtra("position", 10);
		}else if (position == 11) {
			//浮雕效果
			intent = new Intent(ImageActivity.this, Image.class);
			intent.putExtra("position", 11);
		}else if (position == 12) {
			//锐化效果
			intent = new Intent(ImageActivity.this, Image.class);
			intent.putExtra("position", 12);
		}else if (position == 13) {
			//底片效果
			intent = new Intent(ImageActivity.this, Image.class);
			intent.putExtra("position", 13);
		}else if (position == 14) {
			//光照效果
			intent = new Intent(ImageActivity.this, Image.class);
			intent.putExtra("position", 14);
		}else if (position == 15) {
			//素描
			intent = new Intent(ImageActivity.this, SketchActivity.class);
		}
		startActivity(intent);
	}

}
