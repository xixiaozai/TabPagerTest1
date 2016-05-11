package com.example.tabviewtest2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

//使用fragment方法实现
//但是不能左右移动
public class MainActivity extends FragmentActivity implements OnClickListener {
	private LinearLayout mlayout1;
	private LinearLayout mlayout2;
	private LinearLayout mlayout3;
	private LinearLayout mlayout4;

	private Fragment mTab01, mTab02, mTab03, mTab04;
	private ImageButton mbtn1, mbtn2, mbtn3, mbtn4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
		initEvent();
		// 默认显示第一个
		setSelect(0);
	}

	private void initEvent() {
		// TODO Auto-generated method stub
		mbtn1.setOnClickListener(this);
		mbtn2.setOnClickListener(this);
		mbtn3.setOnClickListener(this);
		mbtn4.setOnClickListener(this);
	}

	private void initView() {
		// TODO Auto-generated method stub
		mlayout1 = (LinearLayout) findViewById(R.id.layout_1);
		mlayout2 = (LinearLayout) findViewById(R.id.layout_2);
		mlayout3 = (LinearLayout) findViewById(R.id.layout_3);
		mlayout4 = (LinearLayout) findViewById(R.id.layout_4);
		
		mbtn1 = (ImageButton) findViewById(R.id.btn_1);
		mbtn2 = (ImageButton) findViewById(R.id.btn_2);
		mbtn3 = (ImageButton) findViewById(R.id.btn_3);
		mbtn4 = (ImageButton) findViewById(R.id.btn_4);

	}

	private void setSelect(int i) {
		// 图片设置为亮，设置内容区域
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		hideFragment(transaction);
		switch (i) {
		case 0:
			if (mTab01 == null) {
				mTab01 = new lauout1Fragment();
				transaction.add(R.id.id_content, mTab01);
			} else {
				transaction.show(mTab01);
			}
			mbtn1.setImageResource(R.drawable.tab_address_pressed);
			break;
		case 1:
			if (mTab02 == null) {
				mTab02 = new lauout2Fragment();
				transaction.add(R.id.id_content, mTab02);
			} else {
				transaction.show(mTab02);
			}
			mbtn2.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
		case 2:
			if (mTab03 == null) {
				mTab03 = new lauout3Fragment();
				transaction.add(R.id.id_content, mTab03);
			} else {
				transaction.show(mTab03);
			}
			mbtn3.setImageResource(R.drawable.tab_settings_pressed);
			break;
		case 3:
			if (mTab04 == null) {
				mTab04 = new lauout4Fragment();
				transaction.add(R.id.id_content, mTab04);
			} else {
				transaction.show(mTab04);
			}
			mbtn4.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		default:
			break;
		}
		transaction.commit();
	}

	private void hideFragment(FragmentTransaction transaction) {
		// TODO Auto-generated method stub
		if (mTab01 != null) {
			transaction.hide(mTab01);
		}
		if (mTab02 != null) {
			transaction.hide(mTab02);
		}
		if (mTab03 != null) {
			transaction.hide(mTab03);
		}
		if (mTab04 != null) {
			transaction.hide(mTab04);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		resetImg();
		switch (v.getId()) {
		case R.id.btn_1:
			setSelect(0);
			break;

		case R.id.btn_2:
			setSelect(1);
			break;
		case R.id.btn_3:
			setSelect(2);
			break;
		case R.id.btn_4:
			setSelect(3);
			break;
		default:
			break;
		}
	}

	private void resetImg() {
		// TODO Auto-generated method stub
		mbtn1.setImageResource(R.drawable.tab_address_normal);
		mbtn2.setImageResource(R.drawable.tab_find_frd_normal);
		mbtn3.setImageResource(R.drawable.tab_settings_normal);
		mbtn4.setImageResource(R.drawable.tab_weixin_normal);
	}

}
