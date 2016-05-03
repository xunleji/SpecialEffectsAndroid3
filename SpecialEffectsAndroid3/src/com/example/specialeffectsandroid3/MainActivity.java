package com.example.specialeffectsandroid3;

import com.example.specialeffectsandroid3.bitmapmerger.BitmapMergerActivity;
import com.example.specialeffectsandroid3.createexcel.OperateExcelActivity;
import com.example.specialeffectsandroid3.customcolor.CustomColorActivity;
import com.example.specialeffectsandroid3.drawchart.ChartDemo;
import com.example.specialeffectsandroid3.drawerlayout.DrawerArrowActivity;
import com.example.specialeffectsandroid3.fileexplore.MDfileexplorerActivity;
import com.example.specialeffectsandroid3.firework.FireWorkActivity;
import com.example.specialeffectsandroid3.flipview.FlipActivity;
import com.example.specialeffectsandroid3.flowingdrawer.FlowingDrawerActivity;
import com.example.specialeffectsandroid3.fragment.AddFragmentActivity;
import com.example.specialeffectsandroid3.iconred.IconRedActivity;
import com.example.specialeffectsandroid3.imageblurring.ImageBlurringActivity;
import com.example.specialeffectsandroid3.imagelvjing.ImageActivity;
import com.example.specialeffectsandroid3.listitemanimaiton.ListAnimation;
import com.example.specialeffectsandroid3.listitemdel.ItemDelActivity;
import com.example.specialeffectsandroid3.listitemscrolldel.Launcher;
import com.example.specialeffectsandroid3.lock.LockActivity;
import com.example.specialeffectsandroid3.metaball.MetaballActivity;
import com.example.specialeffectsandroid3.niftydialogeffects.NiftyDialogEffectsActivity;
import com.example.specialeffectsandroid3.qqmini.QQmini2Activity;
import com.example.specialeffectsandroid3.qqslidingmenu.QQslidingActivity;
import com.example.specialeffectsandroid3.radarscan.RadarScanActivity;
import com.example.specialeffectsandroid3.radarscan.library.RippleView;
import com.example.specialeffectsandroid3.recycler.RecyclerActivity;
import com.example.specialeffectsandroid3.recycler.recycleranimator.RecylerAnimatorActivity;
import com.example.specialeffectsandroid3.rippleview.RippleViewActivity;
import com.example.specialeffectsandroid3.screenscroll.ScreenMainActivity;
import com.example.specialeffectsandroid3.scrolllayout.ScrollLayoutActivity;
import com.example.specialeffectsandroid3.slidingcard.SlidingCardActivity;
import com.example.specialeffectsandroid3.springbackscrollview.BackScrollViewActivity;
import com.example.specialeffectsandroid3.springindicator.SpringIndicatorActivity;
import com.example.specialeffectsandroid3.springmenu.SpringMenuActivity;
import com.example.specialeffectsandroid3.swichlayout.SwichLayoutActivity;
import com.example.specialeffectsandroid3.verticalviewpager.VerticalPagerActivity;
import com.example.specialeffectsandroid3.waterwave.WaterWaveActivity;
import com.example.specialeffectsandroid3.whorlview.WhorlActivity;
import com.example.specialeffectsandroid3.zxing.CaptureActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lv;
	private ArrayAdapter<String> arrayAdapter;
	private String[] str = { "带有动画效果的抽屉式左右滑动", "在SD卡中创建excel表", "菜单向四边扩散效果",
			" 颜色选择器", "烟花效果", "二维码扫描", "绘制图表", "类似于QQmini的屏幕滑动", "屏幕左右滑动",
			"翻页效果", "listview中item以各种动画形式出现", "listview中item滑动删除",
			"listview中item拖动删除", "RecyclerView的使用1", "fragment的使用",
			"scrollLayout左右滑动", "图片效果", "仿360水波效果", "RecyclerView的使用2",
			"lock锁的使用", "桌面图标上显示红点", "水滴传递效果", "漩涡风格加载", "像水流动效果的viewpager指示器",
			"向上滑动viewpager效果", "下拉后可以自动回弹的Scrollview", "仿QQ侧滑", "具有弹性的侧滑菜单",
			"BitmapMerger图片合成", "ImageBlurring图像模糊", "SwitchLayout视图切换动画特效库",
			"NiftyDialogEffects 支持自定义飞入动画样式的 Dialog", "SlidingCard相册的效果",
			"雷达扫描的效果", "兼容低版本的水波纹控件", "MD风格的文件选择器" };
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.listView1);
		arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, str);
		lv.setAdapter(arrayAdapter);
		lv.setOnItemClickListener(onitem);
	}

	private OnItemClickListener onitem = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
				long arg3) {
			if (pos == 0) {
				intent = new Intent(MainActivity.this,
						DrawerArrowActivity.class);
			} else if (pos == 1) {
				intent = new Intent(MainActivity.this,
						OperateExcelActivity.class);
			} else if (pos == 2) {
				intent = new Intent(MainActivity.this, SpringMenuActivity.class);
			} else if (pos == 3) {
				intent = new Intent(MainActivity.this,
						CustomColorActivity.class);
			} else if (pos == 4) {
				intent = new Intent(MainActivity.this, FireWorkActivity.class);
			} else if (pos == 5) {
				intent = new Intent(MainActivity.this, CaptureActivity.class);
			} else if (pos == 6) {
				intent = new Intent(MainActivity.this, ChartDemo.class);
			} else if (pos == 7) {
				intent = new Intent(MainActivity.this, QQmini2Activity.class);
			} else if (pos == 8) {
				intent = new Intent(MainActivity.this, ScreenMainActivity.class);
			} else if (pos == 9) {
				intent = new Intent(MainActivity.this, FlipActivity.class);
			} else if (pos == 10) {
				intent = new Intent(MainActivity.this, ListAnimation.class);
			} else if (pos == 11) {
				intent = new Intent(MainActivity.this, ItemDelActivity.class);
			} else if (pos == 12) {
				intent = new Intent(MainActivity.this, Launcher.class);
			} else if (pos == 13) {
				intent = new Intent(MainActivity.this, RecyclerActivity.class);
			} else if (pos == 14) {
				intent = new Intent(MainActivity.this,
						AddFragmentActivity.class);
			} else if (pos == 15) {
				intent = new Intent(MainActivity.this,
						ScrollLayoutActivity.class);
			} else if (pos == 16) {
				intent = new Intent(MainActivity.this, ImageActivity.class);
			} else if (pos == 17) {
				intent = new Intent(MainActivity.this, WaterWaveActivity.class);
			} else if (pos == 18) {
				intent = new Intent(MainActivity.this,
						RecylerAnimatorActivity.class);
			} else if (pos == 19) {
				intent = new Intent(MainActivity.this, LockActivity.class);
			} else if (pos == 20) {
				intent = new Intent(MainActivity.this, IconRedActivity.class);
			} else if (pos == 21) {
				intent = new Intent(MainActivity.this, MetaballActivity.class);
			} else if (pos == 22) {
				intent = new Intent(MainActivity.this, WhorlActivity.class);
			} else if (pos == 23) {
				intent = new Intent(MainActivity.this,
						SpringIndicatorActivity.class);
			} else if (pos == 24) {
				intent = new Intent(MainActivity.this,
						VerticalPagerActivity.class);
			} else if (pos == 25) {
				intent = new Intent(MainActivity.this,
						BackScrollViewActivity.class);
			} else if (pos == 26) {
				intent = new Intent(MainActivity.this, QQslidingActivity.class);
			} else if (pos == 27) {
				intent = new Intent(MainActivity.this,
						FlowingDrawerActivity.class);
			} else if (pos == 28) {
				intent = new Intent(MainActivity.this,
						BitmapMergerActivity.class);
			} else if (pos == 29) {
				intent = new Intent(MainActivity.this,
						ImageBlurringActivity.class);
			} else if (pos == 30) {
				intent = new Intent(MainActivity.this,
						SwichLayoutActivity.class);
			} else if (pos == 31) {
				intent = new Intent(MainActivity.this,
						NiftyDialogEffectsActivity.class);
			} else if (pos == 32) {
				intent = new Intent(MainActivity.this,
						SlidingCardActivity.class);
			} else if (pos == 33) {
				intent = new Intent(MainActivity.this, RadarScanActivity.class);
			} else if (pos == 34) {
				intent = new Intent(MainActivity.this, RippleViewActivity.class);
			} else if (pos == 35) {
				intent = new Intent(MainActivity.this, MDfileexplorerActivity.class);
			}
			startActivity(intent);
		}
	};

}
