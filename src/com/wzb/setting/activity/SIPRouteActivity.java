package com.wzb.setting.activity;

import com.wzb.setting.R;
import com.wzb.setting.R.string;
import com.wzb.setting.util.Constant;
import com.wzb.setting.util.DialogUtil;
import com.wzb.setting.util.SystemShare;
import com.wzb.setting.util.ToastUtil;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SIPRouteActivity extends BaseActivity implements OnClickListener, OnCheckedChangeListener {

	private Context mContext;
	private TextView titleView;
	private ImageView backView;
	private RelativeLayout rl_advanced, rl_registerstart;
	private LinearLayout ll_registerstate, ll_server_address, ll_server_port, ll_user_name, ll_password, ll_phone,
			ll_show_name, ll_transport, ll_local_domainname;
	private TextView tv_registerstate, tv_serveraddress, tv_serverport, tv_username, tv_password, tv_phone, tv_showname,
			tv_transport, tv_localdomainname;
	private Switch switch_register;

	private Dialog dialog;
	private TextView dialogtitle;
	private EditText edit_text;
	private Button dialog_ok, dialog_cancel;

	private int route; // 线路
	private String sp_name; // 存储文件名称
	private Boolean isregister = false;

	String username;
	String password;
	String domain;
	String transport;
	String displayname;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_siproute);
		mContext = SIPRouteActivity.this;
		Intent intent = getIntent();
		route = intent.getIntExtra("SIPROUTE", 1);
		setview();
		setvalues(); // 初始值设置
	}

	private void setview() {
		// TODO Auto-generated method stub
		titleView = (TextView) findViewById(R.id.title_text);
		titleView.setText(R.string.siproute + route);
		backView = (ImageView) findViewById(R.id.title_back);
		backView.setOnClickListener(this);

		switch_register = (Switch) findViewById(R.id.switch_register);
		switch_register.setOnCheckedChangeListener(this);

		rl_advanced = (RelativeLayout) findViewById(R.id.rl_advanced_setting);
		rl_advanced.setOnClickListener(this);

		ll_registerstate = (LinearLayout) findViewById(R.id.ll_registerstate);
		ll_server_address = (LinearLayout) findViewById(R.id.ll_server_address);
		ll_server_port = (LinearLayout) findViewById(R.id.ll_server_port);
		ll_user_name = (LinearLayout) findViewById(R.id.ll_user_name);
		ll_password = (LinearLayout) findViewById(R.id.ll_password);
		ll_phone = (LinearLayout) findViewById(R.id.ll_phone);
		ll_show_name = (LinearLayout) findViewById(R.id.ll_show_name);
		ll_transport = (LinearLayout) findViewById(R.id.ll_transport);
		ll_local_domainname = (LinearLayout) findViewById(R.id.ll_local_domainname);

		tv_registerstate = (TextView) findViewById(R.id.tv_registerstate);
		tv_serveraddress = (TextView) findViewById(R.id.tv_serveraddress);
		tv_serverport = (TextView) findViewById(R.id.tv_serverport);
		tv_username = (TextView) findViewById(R.id.tv_username);
		tv_password = (TextView) findViewById(R.id.tv_password);
		tv_phone = (TextView) findViewById(R.id.tv_phone);
		tv_showname = (TextView) findViewById(R.id.tv_showname);
		tv_transport = (TextView) findViewById(R.id.tv_transport);
		tv_localdomainname = (TextView) findViewById(R.id.tv_localdomainname);

		// ll_registerstate.setOnClickListener(this);
		ll_server_address.setOnClickListener(this);
		ll_server_port.setOnClickListener(this);
		ll_user_name.setOnClickListener(this);
		ll_password.setOnClickListener(this);
		ll_phone.setOnClickListener(this);
		ll_show_name.setOnClickListener(this);
		ll_transport.setOnClickListener(this);
		ll_local_domainname.setOnClickListener(this);
	}

	private void setvalues() {
		if (route == 1) {
			sp_name = Constant.ROUTE1;
		} else if (route == 2) {
			sp_name = Constant.ROUTE2;
		} else if (route == 3) {
			sp_name = Constant.ROUTE3;
		} else if (route == 4) {
			sp_name = Constant.ROUTE4;
		}
		tv_registerstate.setText(SystemShare.getSettingString(mContext, sp_name, Constant.openregister, "未注册"));
		switch_register.setChecked(SystemShare.getSettingBoolean(mContext, sp_name, Constant.registerstart, false));
		tv_serveraddress.setText(SystemShare.getSettingString(mContext, sp_name, Constant.serveraddress));
		tv_serverport.setText(SystemShare.getSettingString(mContext, sp_name, Constant.serverport));
		tv_username.setText(SystemShare.getSettingString(mContext, sp_name, Constant.username));
		tv_password.setText(SystemShare.getSettingString(mContext, sp_name, Constant.password));
		tv_phone.setText(SystemShare.getSettingString(mContext, sp_name, Constant.phone));
		tv_showname.setText(SystemShare.getSettingString(mContext, sp_name, Constant.showname));
		tv_transport.setText(SystemShare.getSettingString(mContext, sp_name, Constant.transport));
		tv_localdomainname.setText(SystemShare.getSettingString(mContext, sp_name, Constant.localdomainname));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.title_back:
			finish();
			break;
		// case R.id.ll_registerstate: // 注册状态
		// DialogUtil.showdialog(mContext, R.string.register_state,
		// tv_registerstate, sp_name, Constant.openregister);
		// break;
		case R.id.ll_server_address: // 服务器地址
			DialogUtil.showdialog(mContext, R.string.server_address, tv_serveraddress, sp_name, Constant.serveraddress);
			break;
		case R.id.ll_server_port: // 服务器端口
			DialogUtil.showdialog(mContext, R.string.server_port, tv_serverport, sp_name, Constant.serverport);
			break;
		case R.id.ll_user_name: // 用户名
			DialogUtil.showdialog(mContext, R.string.user_name, tv_username, sp_name, Constant.username);
			break;
		case R.id.ll_password: // 密码
			DialogUtil.showdialog(mContext, R.string.password, tv_password, sp_name, Constant.password);
			break;
		case R.id.ll_phone: // 电话号码
			DialogUtil.showdialog(mContext, R.string.phone, tv_phone, sp_name, Constant.phone);
			break;
		case R.id.ll_show_name: // 显示名称
			DialogUtil.showdialog(mContext, R.string.show_name, tv_showname, sp_name, Constant.showname);
			break;
		case R.id.ll_local_domainname: // 本地域名
			DialogUtil.showdialog(mContext, R.string.local_domainname, tv_localdomainname, sp_name,
					Constant.localdomainname);
			break;
		case R.id.ll_transport: // 传输类型
			DialogUtil.showdialog(mContext, R.string.transport, tv_transport, sp_name, Constant.transport);
			break;
		case R.id.rl_advanced_setting: // 高级设置
			into_advanced();
			break;

		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		switch (buttonView.getId()) {
		case R.id.switch_register:
			if (isChecked) {
				username = tv_username.getText().toString();
				password = tv_password.getText().toString();
				domain = tv_serveraddress.getText().toString();
				transport = tv_transport.getText().toString();
				displayname = tv_showname.getText().toString();
				if (username.equals("") && password.equals("") && domain.equals("") && transport.equals("")
						&& displayname.equals("")) {
					ToastUtil.showToast(mContext, "数值不能为空！", 1);
					switch_register.setChecked(false);
				} else {
					Intent intent = new Intent();
					ComponentName comp = new ComponentName("com.android.dialer",
							"com.android.dialer.wzb.AccountRegistActivity");
					intent.setComponent(comp);
					intent.setAction("android.intent.action.MAIN");
					intent.putExtra("username", username); // 用户名
					intent.putExtra("password", password); // 密码
					intent.putExtra("domain", domain); // 域名
					intent.putExtra("transport", transport); // 传输类型
					intent.putExtra("displayname", displayname); // 显示名称
					startActivityForResult(intent, 1000);
				}
			}
			break;

		default:
			break;
		}
	}

	private void into_advanced() {
		Intent intent = new Intent(this, AdvancedSettingActivity.class);
		intent.putExtra("SIPROUTE", route);
		mContext.startActivity(intent);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Log.e("wzb", "testactivityonActivityResult requestCode=" + requestCode + "resultCode=" + resultCode);

		if (requestCode == 1000) {
			if (resultCode == 1823) {
				String result = data.getStringExtra("result");
				Log.e("wzb", "testactivityonActivityResult result=" + result);
				String log = "";
				String toast = "";
				if (result.equals("OK")) { // 注册成功
					isregister = true;
					log = "注册成功";
					toast = "注册成功";
					Log.e("onActivityResult", "注册成功");
				} else if (result.equals("FALL")) { // 失败
					isregister = false;
					log = "失败";
					toast = "注册失败";
					Log.e("onActivityResult", "失败");
				} else if (result.equals("EXP")) { // 异常
					isregister = false;
					log = "异常";
					toast = "注册失败";
					Log.e("onActivityResult", "异常");
				} else if (result.equals("EXSIT")) { // 帐号已存在
					isregister = true;
					log = "帐号已存在";
					toast = "帐号已存在";
					Log.e("onActivityResult", "帐号已存在");
				} else if (result.equals("TIMEOUT")) { // 超时
					isregister = false;
					log = "超时";
					toast = "注册失败";
					Log.e("onActivityResult", "超时");
				}
				Log.e("onActivityResult", log);
				ToastUtil.showShortToast(mContext, toast);
				switch_register.setChecked(isregister);
				// 保存数值
				SystemShare.setSettingBoolean(mContext, sp_name, Constant.registerstart, isregister);
				SystemShare.setSettingString(mContext, sp_name, Constant.openregister, "已注册");
				SystemShare.setSettingString(mContext, sp_name, Constant.username, username);
				SystemShare.setSettingString(mContext, sp_name, Constant.password, password);
				SystemShare.setSettingString(mContext, sp_name, Constant.serveraddress, domain);
				SystemShare.setSettingString(mContext, sp_name, Constant.transport, transport);
				SystemShare.setSettingString(mContext, sp_name, Constant.showname, displayname);
			}
		}
	}
}
