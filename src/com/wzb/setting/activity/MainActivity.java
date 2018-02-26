package com.wzb.setting.activity;

import org.json.JSONException;

import com.wzb.setting.R;
import com.wzb.setting.interf.WApplication;
import com.wzb.setting.util.JsonUtil;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import junit.framework.Test;


public class MainActivity extends BaseActivity implements OnClickListener {

	private ImageView backView;
	private TextView titleView;
	private Context mContext;
	
	private TextView tv_wlan,tv_eth,tv_sip,tv_more_setting,tv_advancenet, tv_call;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = MainActivity.this;

		initTitleView();
		initView();
		
		
	}
	
	private void test(){
		String string="";
	
		string=JsonUtil.httpApiRes("1001", "1", "ok");

		
		Log.d("wzb", "string="+string);
	}

	private void initTitleView() {
		backView = (ImageView) findViewById(R.id.title_back);
		titleView = (TextView) findViewById(R.id.title_text);
		titleView.setText("设置");
		backView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

	}

	private void initView() {
			tv_wlan=(TextView)findViewById(R.id.tv_wlan);
			tv_wlan.setClickable(true);
			tv_wlan.setOnClickListener(this);
			
			tv_eth=(TextView)findViewById(R.id.tv_eth);
			tv_eth.setClickable(true);
			tv_eth.setOnClickListener(this);
			
			tv_sip=(TextView)findViewById(R.id.tv_sip);
			tv_sip.setClickable(true);
			tv_sip.setOnClickListener(this);
			
			tv_call = (TextView) findViewById(R.id.tv_call);
			tv_call.setClickable(true);
			tv_call.setOnClickListener(this);
			
			tv_more_setting=(TextView)findViewById(R.id.tv_more_setting);
			tv_more_setting.setClickable(true);
			tv_more_setting.setOnClickListener(this);
			
			tv_advancenet=(TextView)findViewById(R.id.tv_advancenet);
			tv_advancenet.setClickable(true);
			tv_advancenet.setOnClickListener(this);
			
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			
		case R.id.tv_wlan:
			show_wlan();
			break;
		case R.id.tv_more_setting:
			show_more_settings();
			break;
		case R.id.tv_eth:
			show_eth();
			break;
		case R.id.tv_sip:
			show_sip_setting();
			break;
		case R.id.tv_call:
			show_call_setting();
			break;
		case R.id.tv_advancenet:
			show_advancenet();
			break;
		default:
			break;
		
		}
	}
	
	private void show_advancenet(){
		Intent intent=new Intent();
		intent.setClass(MainActivity.this, AdvanceNetActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		mContext.startActivity(intent);
	}
	
	private void show_sip_setting()
	{
		Intent intent = new Intent(MainActivity.this, SIPSettingActivity.class);
//        ComponentName cn=new ComponentName("com.dodoo_tech.voip",
//                "com.dodoo_tech.sdk.juphoon.ui.LoginActivity");
//        intent.setComponent(cn);
        mContext.startActivity(intent);

	}
	
	private void show_call_setting() {
		Intent intent = new Intent(MainActivity.this, CallSettingActivity.class);
		mContext.startActivity(intent);
	}
	
	private void show_eth(){
		mContext.startActivity(new Intent("com.android.settings.ETHERNET_SETTINGS"));
	}
	
	private void show_more_settings(){
		mContext.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
	}
	
	private void show_wlan(){
		mContext.startActivity(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS));
	}

}
