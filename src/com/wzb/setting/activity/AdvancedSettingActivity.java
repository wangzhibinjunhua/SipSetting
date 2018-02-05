package com.wzb.setting.activity;

import com.wzb.setting.R;
import com.wzb.setting.util.Constant;
import com.wzb.setting.util.DialogUtil;
import com.wzb.setting.util.SystemShare;
import com.wzb.setting.util.ToastUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class AdvancedSettingActivity extends BaseActivity implements OnClickListener, OnCheckedChangeListener {

	private Context mContext;
	private TextView titleView;
	private ImageView backView;
	private Switch switch_preview;
	private LinearLayout ll_proxy_server_address, ll_proxy_server_port, ll_proxy_server_name, ll_proxy_server_password,
			ll_backup_proxy_server_address, ll_backup_proxy_server_port, ll_server_name, ll_server_register_time,
			ll_DTMF_type, ll_BLFList_number, ll_session_timeout, ll_specification_version,
			ll_anonymity_call_specification, ll_transport_protocols, ll_caller_identification, ll_preview_pattern;

	private TextView tv_proxy_server_address, tv_proxy_server_port, tv_proxy_server_name, tv_proxy_server_password,
			tv_backup_proxy_server_address, tv_backup_proxy_server_port, tv_server_name, tv_server_register_time,
			tv_DTMF_type, tv_BLFList_number, tv_session_timeout, tv_specification_version,
			tv_anonymity_call_specification, tv_transport_protocols, tv_caller_identification, tv_preview_pattern;

	private CheckBox cb_use_STUN, cb_forbid_server_call, cb_open_BLFList, cb_open_session_timer, cb_open_Rport,
			cb_open_PRACK, cb_start_Tel_type_call, cb_compatible_special_server, cb_allow_URI_transition,
			cb_show_name_quotationmark, cb_start_voice_message, cb_open_DNS_SRV;
	
	private int route; // 线路
	private String sp_name; // 存储文件名称
	private Boolean isregister = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advancedsetting);
		mContext = AdvancedSettingActivity.this;
		Intent intent = getIntent();
		route = intent.getIntExtra("SIPROUTE", 1);
		setview();
		setvalues(); // 初始值设置
	}

	private void setview() {
		// TODO Auto-generated method stub
		titleView = (TextView) findViewById(R.id.title_text);
		titleView.setText(R.string.advanced_setting);
		backView = (ImageView) findViewById(R.id.title_back);
		backView.setOnClickListener(this);

		switch_preview = (Switch) findViewById(R.id.switch_preview);
		switch_preview.setOnCheckedChangeListener(this);

		cb_use_STUN = (CheckBox) findViewById(R.id.cb_use_STUN);
		cb_forbid_server_call = (CheckBox) findViewById(R.id.cb_forbid_server_call);
		cb_open_BLFList = (CheckBox) findViewById(R.id.cb_open_BLFList);
		cb_open_session_timer = (CheckBox) findViewById(R.id.cb_open_session_timer);
		cb_open_Rport = (CheckBox) findViewById(R.id.cb_open_Rport);
		cb_open_PRACK = (CheckBox) findViewById(R.id.cb_open_PRACK);
		cb_start_Tel_type_call = (CheckBox) findViewById(R.id.cb_start_Tel_type_call);
		cb_compatible_special_server = (CheckBox) findViewById(R.id.cb_compatible_special_server);
		cb_allow_URI_transition = (CheckBox) findViewById(R.id.cb_allow_URI_transition);
		cb_show_name_quotationmark = (CheckBox) findViewById(R.id.cb_show_name_quotationmark);
		cb_start_voice_message = (CheckBox) findViewById(R.id.cb_start_voice_message);
		cb_open_DNS_SRV = (CheckBox) findViewById(R.id.cb_open_DNS_SRV);

		cb_use_STUN.setOnCheckedChangeListener(this);
		cb_forbid_server_call.setOnCheckedChangeListener(this);
		cb_open_BLFList.setOnCheckedChangeListener(this);
		cb_open_session_timer.setOnCheckedChangeListener(this);
		cb_open_Rport.setOnCheckedChangeListener(this);
		cb_open_PRACK.setOnCheckedChangeListener(this);
		cb_start_Tel_type_call.setOnCheckedChangeListener(this);
		cb_compatible_special_server.setOnCheckedChangeListener(this);
		cb_allow_URI_transition.setOnCheckedChangeListener(this);
		cb_show_name_quotationmark.setOnCheckedChangeListener(this);
		cb_start_voice_message.setOnCheckedChangeListener(this);
		cb_open_DNS_SRV.setOnCheckedChangeListener(this);

		ll_proxy_server_address = (LinearLayout) findViewById(R.id.ll_proxy_server_address);
		ll_proxy_server_port = (LinearLayout) findViewById(R.id.ll_proxy_server_port);
		ll_proxy_server_name = (LinearLayout) findViewById(R.id.ll_proxy_server_name);
		ll_proxy_server_password = (LinearLayout) findViewById(R.id.ll_proxy_server_password);
		ll_backup_proxy_server_address = (LinearLayout) findViewById(R.id.ll_backup_proxy_server_address);
		ll_backup_proxy_server_port = (LinearLayout) findViewById(R.id.ll_backup_proxy_server_port);
		ll_server_name = (LinearLayout) findViewById(R.id.ll_server_name);
		ll_server_register_time = (LinearLayout) findViewById(R.id.ll_server_register_time);
		ll_DTMF_type = (LinearLayout) findViewById(R.id.ll_DTMF_type);
		ll_BLFList_number = (LinearLayout) findViewById(R.id.ll_BLFList_number);
		ll_session_timeout = (LinearLayout) findViewById(R.id.ll_session_timeout);
		ll_specification_version = (LinearLayout) findViewById(R.id.ll_specification_version);
		ll_anonymity_call_specification = (LinearLayout) findViewById(R.id.ll_anonymity_call_specification);
		ll_transport_protocols = (LinearLayout) findViewById(R.id.ll_transport_protocols);
		ll_caller_identification = (LinearLayout) findViewById(R.id.ll_caller_identification);
		ll_preview_pattern = (LinearLayout) findViewById(R.id.ll_preview_pattern);

		tv_proxy_server_address = (TextView) findViewById(R.id.tv_proxy_server_address);
		tv_proxy_server_port = (TextView) findViewById(R.id.tv_proxy_server_port);
		tv_proxy_server_name = (TextView) findViewById(R.id.tv_proxy_server_name);
		tv_proxy_server_password = (TextView) findViewById(R.id.tv_proxy_server_password);
		tv_backup_proxy_server_address = (TextView) findViewById(R.id.tv_backup_proxy_server_address);
		tv_backup_proxy_server_port = (TextView) findViewById(R.id.tv_backup_proxy_server_port);
		tv_server_name = (TextView) findViewById(R.id.tv_server_name);
		tv_server_register_time = (TextView) findViewById(R.id.tv_server_register_time);
		tv_DTMF_type = (TextView) findViewById(R.id.tv_DTMF_type);
		tv_BLFList_number = (TextView) findViewById(R.id.tv_BLFList_number);
		tv_session_timeout = (TextView) findViewById(R.id.tv_session_timeout);
		tv_specification_version = (TextView) findViewById(R.id.tv_specification_version);
		tv_anonymity_call_specification = (TextView) findViewById(R.id.tv_anonymity_call_specification);
		tv_transport_protocols = (TextView) findViewById(R.id.tv_transport_protocols);
		tv_caller_identification = (TextView) findViewById(R.id.tv_caller_identification);
		tv_preview_pattern = (TextView) findViewById(R.id.tv_preview_pattern);

		ll_proxy_server_address.setOnClickListener(this);
		ll_proxy_server_port.setOnClickListener(this);
		ll_proxy_server_name.setOnClickListener(this);
		ll_proxy_server_password.setOnClickListener(this);
		ll_backup_proxy_server_address.setOnClickListener(this);
		ll_backup_proxy_server_port.setOnClickListener(this);
		ll_server_name.setOnClickListener(this);
		ll_server_register_time.setOnClickListener(this);
		ll_DTMF_type.setOnClickListener(this);
		ll_BLFList_number.setOnClickListener(this);
		ll_session_timeout.setOnClickListener(this);
		ll_specification_version.setOnClickListener(this);
		ll_anonymity_call_specification.setOnClickListener(this);
		ll_transport_protocols.setOnClickListener(this);
		ll_caller_identification.setOnClickListener(this);
		ll_preview_pattern.setOnClickListener(this);
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
		tv_proxy_server_address.setText(SystemShare.getSettingString(mContext, sp_name, Constant.proxyaddress));
		tv_proxy_server_port.setText(SystemShare.getSettingString(mContext, sp_name, Constant.proxyport));
		tv_proxy_server_name.setText(SystemShare.getSettingString(mContext, sp_name, Constant.proxyname));
		tv_proxy_server_password.setText(SystemShare.getSettingString(mContext, sp_name, Constant.proxypassword));
		tv_backup_proxy_server_address.setText(SystemShare.getSettingString(mContext, sp_name, Constant.backupproxyaddress));
		tv_backup_proxy_server_port.setText(SystemShare.getSettingString(mContext, sp_name, Constant.backupproxyport));
		tv_server_name.setText(SystemShare.getSettingString(mContext, sp_name, Constant.servername));
		tv_server_register_time.setText(SystemShare.getSettingString(mContext, sp_name, Constant.registertime));
		tv_DTMF_type.setText(SystemShare.getSettingString(mContext, sp_name, Constant.DTMFtype));
		tv_BLFList_number.setText(SystemShare.getSettingString(mContext, sp_name, Constant.BLFListnumber));
		tv_session_timeout.setText(SystemShare.getSettingString(mContext, sp_name, Constant.sessiontimeout));
		tv_specification_version.setText(SystemShare.getSettingString(mContext, sp_name, Constant.specificationversion));
		tv_anonymity_call_specification.setText(SystemShare.getSettingString(mContext, sp_name, Constant.anonymitspecification));
		tv_transport_protocols.setText(SystemShare.getSettingString(mContext, sp_name, Constant.transportprotocols));
		tv_caller_identification.setText(SystemShare.getSettingString(mContext, sp_name, Constant.calleridentification));
		tv_preview_pattern.setText(SystemShare.getSettingString(mContext, sp_name, Constant.previewpattern));
		
		cb_use_STUN.setChecked(SystemShare.getSettingBoolean(mContext, sp_name, Constant.useSTUN, false));
		cb_forbid_server_call.setChecked(SystemShare.getSettingBoolean(mContext, sp_name, Constant.forbidcall, false));
		cb_open_BLFList.setChecked(SystemShare.getSettingBoolean(mContext, sp_name, Constant.openBLFList, false));
		cb_open_session_timer.setChecked(SystemShare.getSettingBoolean(mContext, sp_name, Constant.opensessiontimer, false));
		cb_open_Rport.setChecked(SystemShare.getSettingBoolean(mContext, sp_name, Constant.openRport, false));
		cb_open_PRACK.setChecked(SystemShare.getSettingBoolean(mContext, sp_name, Constant.openPRACK, false));
		cb_start_Tel_type_call.setChecked(SystemShare.getSettingBoolean(mContext, sp_name, Constant.startTeltypecall, false));
		cb_compatible_special_server.setChecked(SystemShare.getSettingBoolean(mContext, sp_name, Constant.specialserver, false));
		cb_allow_URI_transition.setChecked(SystemShare.getSettingBoolean(mContext, sp_name, Constant.URItransition, false));
		cb_show_name_quotationmark.setChecked(SystemShare.getSettingBoolean(mContext, sp_name, Constant.namequotationmark, false));
		cb_start_voice_message.setChecked(SystemShare.getSettingBoolean(mContext, sp_name, Constant.voicemessage, false));
		cb_open_DNS_SRV.setChecked(SystemShare.getSettingBoolean(mContext, sp_name, Constant.openDNSSRV, false));
		
		switch_preview.setChecked(SystemShare.getSettingBoolean(mContext, sp_name, Constant.startpreview, false));
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.title_back: // 返回
			finish();
			break;
		case R.id.ll_proxy_server_address: // 代理服务器地址
			DialogUtil.showdialog(mContext, R.string.proxy_server_address, tv_proxy_server_address, sp_name, Constant.proxyaddress);
			break;
		case R.id.ll_proxy_server_port: // 代理服务器端口
			DialogUtil.showdialog(mContext, R.string.proxy_server_port, tv_proxy_server_port, sp_name, Constant.proxyport);
			break;
		case R.id.ll_proxy_server_name: // 代理服务器账号
			DialogUtil.showdialog(mContext, R.string.proxy_server_name, tv_proxy_server_name, sp_name, Constant.proxyname);
			break;
		case R.id.ll_proxy_server_password: // 代理服务器密码
			DialogUtil.showdialog(mContext, R.string.proxy_server_password, tv_proxy_server_password, sp_name, Constant.proxypassword);
			break;
		case R.id.ll_backup_proxy_server_address: // 备份代理服务器地址
			DialogUtil.showdialog(mContext, R.string.backup_proxy_server_address, tv_backup_proxy_server_address, sp_name, Constant.backupproxyaddress);
			break;
		case R.id.ll_backup_proxy_server_port: // 备份代理服务器端口
			DialogUtil.showdialog(mContext, R.string.backup_proxy_server_port, tv_backup_proxy_server_port, sp_name, Constant.backupproxyport);
			break;
		case R.id.ll_server_name: // 服务器名称
			DialogUtil.showdialog(mContext, R.string.server_name, tv_server_name, sp_name, Constant.servername);
			break;
		case R.id.ll_server_register_time: // 服务器注册时限
			DialogUtil.showdialog(mContext, R.string.server_register_time, tv_server_register_time, sp_name, Constant.registertime);
			break;
		case R.id.ll_DTMF_type: // DTMF类型
			DialogUtil.showdialog(mContext, R.string.DTMF_type, tv_DTMF_type, sp_name, Constant.DTMFtype);
			break;
		case R.id.ll_BLFList_number: // BLF List号码
			DialogUtil.showdialog(mContext, R.string.BLFList_number, tv_BLFList_number, sp_name, Constant.BLFListnumber);
			break;
		case R.id.ll_session_timeout: // 会话超时时间
			DialogUtil.showdialog(mContext, R.string.session_timeout, tv_session_timeout, sp_name, Constant.sessiontimeout);
			break;
		case R.id.ll_specification_version: // 规范版本
			DialogUtil.showdialog(mContext, R.string.specification_version, tv_specification_version, sp_name, Constant.specificationversion);
			break;
		case R.id.ll_anonymity_call_specification: // 匿名呼叫规范版本
			DialogUtil.showdialog(mContext, R.string.anonymity_call_specification, tv_anonymity_call_specification, sp_name, Constant.anonymitspecification);
			break;
		case R.id.ll_transport_protocols: // 传输协议
			DialogUtil.showdialog(mContext, R.string.transport_protocols, tv_transport_protocols, sp_name, Constant.transportprotocols);
			break;
		case R.id.ll_caller_identification: // 来的显示类型
			DialogUtil.showdialog(mContext, R.string.caller_identification, tv_caller_identification, sp_name, Constant.calleridentification);
			break;
		case R.id.ll_preview_pattern: // 预览模式
			DialogUtil.showdialog(mContext, R.string.preview_pattern, tv_preview_pattern, sp_name, Constant.previewpattern);
			break;

		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		switch (buttonView.getId()) {
		case R.id.switch_preview:
			isregister = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, sp_name, Constant.startpreview, isregister);
			break;
		case R.id.cb_use_STUN:
			isregister = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, sp_name, Constant.useSTUN, isregister);
			break;
		case R.id.cb_forbid_server_call:
			isregister = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, sp_name, Constant.forbidcall, isregister);
			break;
		case R.id.cb_open_BLFList:
			isregister = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, sp_name, Constant.openBLFList, isregister);
			break;
		case R.id.cb_open_session_timer:
			isregister = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, sp_name, Constant.opensessiontimer, isregister);
			break;
		case R.id.cb_open_Rport:
			isregister = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, sp_name, Constant.openRport, isregister);
			break;
		case R.id.cb_open_PRACK:
			isregister = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, sp_name, Constant.openPRACK, isregister);
			break;
		case R.id.cb_start_Tel_type_call:
			isregister = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, sp_name, Constant.startTeltypecall, isregister);
			break;
		case R.id.cb_compatible_special_server:
			isregister = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, sp_name, Constant.specialserver, isregister);
			break;
		case R.id.cb_allow_URI_transition:
			isregister = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, sp_name, Constant.URItransition, isregister);
			break;
		case R.id.cb_show_name_quotationmark:
			isregister = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, sp_name, Constant.namequotationmark, isregister);
			break;
		case R.id.cb_start_voice_message:
			isregister = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, sp_name, Constant.voicemessage, isregister);
			break;
		case R.id.cb_open_DNS_SRV:
			isregister = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, sp_name, Constant.openDNSSRV, isregister);
			break;

		default:
			break;
		}
	}

}
