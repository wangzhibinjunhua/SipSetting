package com.wzb.setting.activity;

import com.wzb.setting.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class CallSettingActivity extends BaseActivity implements OnClickListener {

	private Context mContext;
	private TextView titleView;
	private ImageView backView;
	private TextView tv_service1, tv_service2, tv_service3, tv_service4, tv_function, tv_dnd, tv_collect;

	String callservice = "CALLSERVICE";

	int call1 = 1;
	int call2 = 2;
	int call3 = 3;
	int call4 = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_callsetting);
		mContext = CallSettingActivity.this;
		setview();
	}

	private void setview() {
		titleView = (TextView) findViewById(R.id.title_text);
		titleView.setText(R.string.callsetting_title);
		backView = (ImageView) findViewById(R.id.title_back);
		backView.setOnClickListener(this);

		tv_service1 = (TextView) findViewById(R.id.tv_service1);
		tv_service2 = (TextView) findViewById(R.id.tv_service2);
		tv_service3 = (TextView) findViewById(R.id.tv_service3);
		tv_service4 = (TextView) findViewById(R.id.tv_service4);
		tv_function = (TextView) findViewById(R.id.tv_function);
		tv_dnd = (TextView) findViewById(R.id.tv_dnd);
		tv_collect = (TextView) findViewById(R.id.tv_collect);

		tv_service1.setOnClickListener(this);
		tv_service2.setOnClickListener(this);
		tv_service3.setOnClickListener(this);
		tv_service4.setOnClickListener(this);
		tv_function.setOnClickListener(this);
		tv_dnd.setOnClickListener(this);
		tv_collect.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.title_back:
			finish();
			break;
		case R.id.tv_service1:
			into_service1();
			break;
		case R.id.tv_service2:
			into_service2();
			break;
		case R.id.tv_service3:
			into_service3();
			break;
		case R.id.tv_service4:
			into_service4();
			break;
		case R.id.tv_function:
			into_function();
			break;
		case R.id.tv_dnd:
			into_dnd();
			break;
		case R.id.tv_collect:
			into_collect();
			break;
		default:
			break;
		}
	}

	private void into_service1() {
		Intent intent = new Intent(this, CallServiceActivity.class);
		intent.putExtra(callservice, call1);
		mContext.startActivity(intent);
	}

	private void into_service2() {
		Intent intent = new Intent(this, CallServiceActivity.class);
		intent.putExtra(callservice, call2);
		mContext.startActivity(intent);
	}

	private void into_service3() {
		Intent intent = new Intent(this, CallServiceActivity.class);
		intent.putExtra(callservice, call3);
		mContext.startActivity(intent);
	}
	
	private void into_service4() {
		Intent intent = new Intent(this, CallServiceActivity.class);
		intent.putExtra(callservice, call4);
		mContext.startActivity(intent);
	}

	private void into_function() {
		Intent intent = new Intent(this, FunctionActivity.class);
		mContext.startActivity(intent);
	}

	private void into_dnd() {
		
	}

	private void into_collect() {
		Intent intent = new Intent(this, CollectRuleActivity.class);
		mContext.startActivity(intent);
	}

}
