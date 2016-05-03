package com.example.specialeffectsandroid3.springmenu;

import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.Until;
import com.example.specialeffectsandroid3.springmenu.animation.EnlargeAnimationOut;
import com.example.specialeffectsandroid3.springmenu.animation.ShrinkAnimationOut;
import com.example.specialeffectsandroid3.springmenu.animation.SpringAnimation;
import com.example.specialeffectsandroid3.springmenu.animation.ZoomAnimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.widget.RelativeLayout;

/**
 * 菜单向四边扩散效果
 * 
 * @author xujuan
 * 
 */
public class SpringMenuActivity extends Activity {

	private boolean areMenusShowing;// 判断展开还是关闭的标识
	private View imageViewPlus;
	private ViewGroup menusWrapper;
	private View shrinkRelativeLayout;
	private RelativeLayout layoutMain;
	// 顺时针旋转动画
	private Animation animRotateClockwise;
	// 你试着旋转动画
	private Animation animRotateAntiClockwise;
	private int[] mainResources = { R.drawable.bg_main_1, R.drawable.bg_main_2,
			R.drawable.bg_main_3, R.drawable.bg_main_4, R.drawable.bg_main_1,
			R.drawable.bg_main_4 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.springmenu_main);
		imageViewPlus = findViewById(R.id.imageview_plus);
		menusWrapper = (ViewGroup) findViewById(R.id.menus_wrapper);
		shrinkRelativeLayout = findViewById(R.id.relativelayout_shrink);
		layoutMain = (RelativeLayout) findViewById(R.id.layout_content);
		animRotateClockwise = AnimationUtils.loadAnimation(this,
				R.anim.rotate_clockwise);
		animRotateAntiClockwise = AnimationUtils.loadAnimation(this,
				R.anim.rotate_anticlockwise);
		shrinkRelativeLayout.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// 展开关闭按钮
				showLinearMenus();
			}
		});
		// 展开后单个menu点击效果
		for (int i = 0; i < menusWrapper.getChildCount(); i++) {
			menusWrapper.getChildAt(i).setOnClickListener(
					new SpringMenuLauncher(null, mainResources[i]));
		}
	}

	protected void showLinearMenus() {
		int[] size = Until.getScreenSize(this);
		if (!areMenusShowing) {
			SpringAnimation.startAnimations(this.menusWrapper,
					ZoomAnimation.Direction.SHOW, size);
			this.imageViewPlus.startAnimation(this.animRotateClockwise);
		} else {
			SpringAnimation.startAnimations(this.menusWrapper,
					ZoomAnimation.Direction.HIDE, size);
			this.imageViewPlus.startAnimation(this.animRotateAntiClockwise);
		}

		areMenusShowing = !areMenusShowing;
	}

	// 分布菜单事件监听器
	private class SpringMenuLauncher implements OnClickListener {
		private final Class<?> cls;
		private int resource;

		private SpringMenuLauncher(Class<?> c, int resource) {
			this.cls = c;
			this.resource = resource;
		}

		public void onClick(View v) {
			startSpringMenuAnimations(v);
			layoutMain.setBackgroundResource(resource);
		}
	}

	/**
	 * 展现菜单动画效果
	 * 
	 * @param view
	 * @param runnable
	 */
	private void startSpringMenuAnimations(View view) {
		areMenusShowing = true;
		Animation shrinkOut1 = new ShrinkAnimationOut(300);
		Animation growOut = new EnlargeAnimationOut(300);
		shrinkOut1.setInterpolator(new AnticipateInterpolator(2.0F));
		shrinkOut1.setAnimationListener(new Animation.AnimationListener() {

			public void onAnimationEnd(Animation animation) {
				imageViewPlus.clearAnimation();
			}

			public void onAnimationRepeat(Animation animation) {
			}

			public void onAnimationStart(Animation animation) {
			}
		});
		view.startAnimation(growOut);
	}

}
