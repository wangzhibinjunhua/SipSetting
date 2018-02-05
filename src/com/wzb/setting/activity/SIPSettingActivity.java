package com.wzb.setting.activity;

import com.wzb.setting.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class SIPSettingActivity extends BaseActivity implements OnClickListener {

	private TextView titleView;
	private ImageView backView;
	private TextView sip1, sip2, sip3, sip4;
	private Context mContext;
	
	String siproute = "SIPROUTE";
	
	int SIP1 = 1;
	int SIP2 = 2;
	int SIP3 = 3;
	int SIP4 = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sipsetting);
		mContext = SIPSettingActivity.this;
		setview();

	}

	private void setview() {
		// TODO Auto-generated method stub
		titleView = (TextView) findViewById(R.id.title_text);
		titleView.setText(R.string.siproute_title);
		backView = (ImageView) findViewById(R.id.title_back);
		backView.setOnClickListener(this);

		sip1 = (TextView) findViewById(R.id.siproute1);
		sip2 = (TextView) findViewById(R.id.siproute2);
		sip3 = (TextView) findViewById(R.id.siproute3);
		sip4 = (TextView) findViewById(R.id.siproute4);

		sip1.setOnClickListener(this);
		sip2.setOnClickListener(this);
		sip3.setOnClickListener(this);
		sip4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.title_back:
			finish();
			break;
		case R.id.siproute1:
			into_siproute1();
			break;
		case R.id.siproute2:
			into_siproute2();
			break;
		case R.id.siproute3:
			into_siproute3();
			break;
		case R.id.siproute4:
			into_siproute4();
			break;

		default:
			break;
		}
	}

	private void into_siproute1() {
		Intent intent=new Intent(this, SIPRouteActivity.class);
		intent.putExtra(siproute, SIP1);
		mContext.startActivity(intent);
	}
	
	private void into_siproute2() {
		Intent intent=new Intent(this, SIPRouteActivity.class);
		intent.putExtra(siproute, SIP2);
		mContext.startActivity(intent);
	}
	
	private void into_siproute3() {
		Intent intent=new Intent(this, SIPRouteActivity.class);
		intent.putExtra(siproute, SIP3);
		mContext.startActivity(intent);
	}
	
	private void into_siproute4() {
		Intent intent=new Intent(this, SIPRouteActivity.class);
		intent.putExtra(siproute, SIP4);
		mContext.startActivity(intent);
	}
}
