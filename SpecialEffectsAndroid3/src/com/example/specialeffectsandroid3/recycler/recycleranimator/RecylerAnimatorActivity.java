package com.example.specialeffectsandroid3.recycler.recycleranimator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.recycler.recycleranimator.animator.ScaleInOutItemAnimator;
import com.example.specialeffectsandroid3.recycler.recycleranimator.animator.SlideInOutBottomItemAnimator;
import com.example.specialeffectsandroid3.recycler.recycleranimator.animator.SlideInOutLeftItemAnimator;
import com.example.specialeffectsandroid3.recycler.recycleranimator.animator.SlideInOutRightItemAnimator;
import com.example.specialeffectsandroid3.recycler.recycleranimator.animator.SlideInOutTopItemAnimator;
import com.example.specialeffectsandroid3.recycler.recycleranimator.animator.SlideScaleInOutRightItemAnimator;

public class RecylerAnimatorActivity extends Activity {

	private RecyclerView mRecyclerView;
	private SimpleAdapter mAdapter;
	public static final String[] sCheeseStrings = { "aaaa", "bbb", };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycler);
		setupSpinner();
		mRecyclerView = (RecyclerView) findViewById(R.id.list);
		mRecyclerView.setHasFixedSize(true);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
				LinearLayoutManager.VERTICAL));
		mAdapter = new SimpleAdapter(this, sCheeseStrings);
		mRecyclerView.setAdapter(mAdapter);

	}

	private void setupSpinner() {
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.animators, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view,
					int position, long l) {
				switch (position) {
				case 0:
					mRecyclerView
							.setItemAnimator(new SlideInOutLeftItemAnimator(
									mRecyclerView));
					break;
				case 1:
					mRecyclerView
							.setItemAnimator(new SlideInOutRightItemAnimator(
									mRecyclerView));
					break;
				case 2:
					mRecyclerView
							.setItemAnimator(new SlideInOutTopItemAnimator(
									mRecyclerView));
					break;
				case 3:
					mRecyclerView
							.setItemAnimator(new SlideInOutBottomItemAnimator(
									mRecyclerView));
					break;
				case 4:
					mRecyclerView.setItemAnimator(new ScaleInOutItemAnimator(
							mRecyclerView));
					break;
				case 5:
					mRecyclerView
							.setItemAnimator(new SlideScaleInOutRightItemAnimator(
									mRecyclerView));
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.recycler, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_add) {
			mAdapter.add("New String", SimpleAdapter.LAST_POSITION);
			return true;
		}
		if (id == R.id.action_remove) {
			mAdapter.remove(SimpleAdapter.LAST_POSITION);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
