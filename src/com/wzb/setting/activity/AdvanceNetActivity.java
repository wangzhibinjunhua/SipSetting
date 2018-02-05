package com.wzb.setting.activity;

import com.wzb.setting.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class AdvanceNetActivity extends BaseActivity implements OnClickListener{
	
	private ImageView backView;
	private TextView titleView;
	private Context mContext;
	
	private TextView tv_vlan,tv_tr069,tv_tcpdump;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advancenet);
		mContext=AdvanceNetActivity.this;
		initTitleView();
		initView();
	}
	
	private void initTitleView() {
		backView = (ImageView) findViewById(R.id.title_back);
		titleView = (TextView) findViewById(R.id.title_text);
		titleView.setText("高级网络设置");
		backView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

	}
	

	private void initView() {
		tv_vlan=(TextView)findViewById(R.id.tv_vlan);
		tv_vlan.setClickable(true);
		tv_vlan.setOnClickListener(this);
			
		tv_tr069=(TextView)findViewById(R.id.tv_tr069);
		tv_tr069.setClickable(true);
		tv_tr069.setOnClickListener(this);
			
		tv_tcpdump=(TextView)findViewById(R.id.tv_tcpdump);
		tv_tcpdump.setClickable(true);
		tv_tcpdump.setOnClickListener(this);
			
			
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.tv_vlan:
			show_vlan();
			break;
		case R.id.tv_tr069:
			show_tr069();
			break;
		case R.id.tv_tcpdump:
			show_tcpdump();
			break;
		default:
			break;
		}
	}
	
	private void show_tcpdump(){
		mContext.startActivity(new Intent("com.android.settings.TCPDUMP"));
	}
	
	private void show_tr069(){
		mContext.startActivity(new Intent("com.android.settings.TR069_SETTING"));
	}
	
	private void show_vlan(){
		mContext.startActivity(new Intent("com.android.settings.VLAN_SETTING"));
	}


}
