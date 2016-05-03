package com.example.specialeffectsandroid3.flipview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class FlipActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new SimpleAdapter(this, getData(),
				android.R.layout.simple_list_item_1, new String[] { "title" },
				new int[] { android.R.id.text1 }));
		getListView().setScrollbarFadingEnabled(false);
	}

	private List<? extends Map<String, ?>> getData() {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		addItem(data, "TextViews", FlipTextViewActivity.class);
		addItem(data, "Complex Layouts", FlipComplexLayoutActivity.class);
		addItem(data, "Horizontal", FlipHorizontalLayoutActivity.class);
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Map<String, Object> map = (Map<String, Object>) l
				.getItemAtPosition(position);
		Intent intent = new Intent(this,
				(Class<? extends Activity>) map.get("activity"));
		startActivity(intent);
	}

	private void addItem(List<Map<String, Object>> data, String title,
			Class<? extends Activity> activityClass) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", data.size() + ". " + title);
		map.put("activity", activityClass);
		data.add(map);
	}

}
