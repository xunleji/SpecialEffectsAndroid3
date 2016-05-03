package com.example.specialeffectsandroid3.recycler;

import java.util.ArrayList;
import java.util.List;

import com.example.specialeffectsandroid3.Diary;
import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.recycler.RecylerTestAdapter.OnItemClick;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;

public class RecyclerActivity extends Activity {

	private RecyclerView recylerView;
	private LinearLayoutManager manager;
	private RecylerTestAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recyler_main);
		recylerView = (RecyclerView) findViewById(R.id.recycler1);
		recylerView.setHasFixedSize(true);
		recylerView.setItemAnimator(new DefaultItemAnimator());
		manager = new LinearLayoutManager(this);
		manager.setOrientation(LinearLayoutManager.VERTICAL);
		// recylerView.setLayoutManager(manager);
		// recylerView.addItemDecoration(new DividerItemDecoration(this,
		// LinearLayoutManager.VERTICAL));
		recylerView.setLayoutManager(new GridLayoutManager(this, 4));
		recylerView.addItemDecoration(new DividerGridItemDecoration(this));
		// 创建数据集
		List<String> tmplist = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			tmplist.add("item" + i);
		}
		adapter = new RecylerTestAdapter(tmplist, this);
		recylerView.setAdapter(adapter);
		adapter.setOnitemClick(new OnItemClick() {

			@Override
			public void itemClick(View view, int pos) {
				Diary.print("pos===" + pos);
				adapter.removeItem(pos);
			}

			@Override
			public void itemlongClick(View view, int pos) {
				Diary.print("pos===" + pos);
				adapter.addItem("item" + pos, pos);
			}
		});
	}

}
