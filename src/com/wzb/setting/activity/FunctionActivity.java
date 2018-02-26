package com.wzb.setting.activity;

import com.wzb.setting.R;
import com.wzb.setting.util.Constant;
import com.wzb.setting.util.DialogUtil;
import com.wzb.setting.util.SystemShare;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FunctionActivity extends BaseActivity implements OnClickListener, OnCheckedChangeListener {

	private Context mContext;

	private TextView titleView;
	private ImageView backView;

	private CheckBox cb_callwait, cb_calldivert, cb_halfattend_turn, cb_auto_hangup, cb_open_threeparty, cb_headsetring,
			cb_auto_Earphone, cb_forbid_callout, cb_call_history, cb_IPcall, cb_open_MultiLine, cb_callwait_voice,
			cb_callDTMF_voice, cb_dialDTMF_voice, cb_passwordcall, cb_finishcall, cb_auto_redial, cb_talkbackmode,
			cb_talkbackmode_mute, cb_talkbackmode_ring, cb_secondtalkback_answer, cb_hide_localcode, cb_SIP_number,
			cb_update_callnumber, cb_three_callprocedure, cb_three_callsoftware;

	private LinearLayout ll_auto_hanguptime, ll_hideDTMF, ll_calloutside, ll_callmode, ll_answermode, ll_urgent_number,
			ll_limit_ActiveURI, ll_passwordcall_prefix, ll_passwordlong, ll_auto_redial_interval, ll_auto_redial_count,
			ll_busy_responsecode, ll_country_code, ll_region_code, ll_onekey_transfer, ll_videomode;

	private TextView tv_auto_hanguptime, tv_hideDTMF, tv_calloutside, tv_callmode, tv_answermode, tv_urgent_number,
			tv_limit_ActiveURI, tv_passwordcall_prefix, tv_passwordlong, tv_auto_redial_interval, tv_auto_redial_count,
			tv_busy_responsecode, tv_country_code, tv_region_code, tv_onekey_transfer, tv_videomode;

	private String function_name; // 存储文件名称
	private Boolean istrue = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_function);
		mContext = FunctionActivity.this;
		setview();
		setvalues(); // 初始值设置
	}

	private void setview() {
		titleView = (TextView) findViewById(R.id.title_text);
		titleView.setText(R.string.service_title);
		backView = (ImageView) findViewById(R.id.title_back);
		backView.setOnClickListener(this);

		cb_callwait = (CheckBox) findViewById(R.id.cb_callwait);
		cb_calldivert = (CheckBox) findViewById(R.id.cb_calldivert);
		cb_halfattend_turn = (CheckBox) findViewById(R.id.cb_halfattend_turn);
		cb_auto_hangup = (CheckBox) findViewById(R.id.cb_auto_hangup);
		cb_open_threeparty = (CheckBox) findViewById(R.id.cb_open_threeparty);
		cb_headsetring = (CheckBox) findViewById(R.id.cb_headsetring);
		cb_auto_Earphone = (CheckBox) findViewById(R.id.cb_auto_Earphone);
		cb_forbid_callout = (CheckBox) findViewById(R.id.cb_forbid_callout);
		cb_call_history = (CheckBox) findViewById(R.id.cb_call_history);
		cb_IPcall = (CheckBox) findViewById(R.id.cb_IPcall);

		cb_open_MultiLine = (CheckBox) findViewById(R.id.cb_open_MultiLine);
		cb_callwait_voice = (CheckBox) findViewById(R.id.cb_callwait_voice);
		cb_callDTMF_voice = (CheckBox) findViewById(R.id.cb_callDTMF_voice);
		cb_dialDTMF_voice = (CheckBox) findViewById(R.id.cb_dialDTMF_voice);
		cb_passwordcall = (CheckBox) findViewById(R.id.cb_passwordcall);
		cb_finishcall = (CheckBox) findViewById(R.id.cb_finishcall);
		cb_auto_redial = (CheckBox) findViewById(R.id.cb_auto_redial);
		cb_talkbackmode = (CheckBox) findViewById(R.id.cb_talkbackmode);
		cb_talkbackmode_mute = (CheckBox) findViewById(R.id.cb_talkbackmode_mute);
		cb_talkbackmode_ring = (CheckBox) findViewById(R.id.cb_talkbackmode_ring);

		cb_secondtalkback_answer = (CheckBox) findViewById(R.id.cb_secondtalkback_answer);
		cb_hide_localcode = (CheckBox) findViewById(R.id.cb_hide_localcode);
		cb_SIP_number = (CheckBox) findViewById(R.id.cb_SIP_number);
		cb_update_callnumber = (CheckBox) findViewById(R.id.cb_update_callnumber);
		cb_three_callprocedure = (CheckBox) findViewById(R.id.cb_three_callprocedure);
		cb_three_callsoftware = (CheckBox) findViewById(R.id.cb_three_callsoftware);

		cb_callwait.setOnCheckedChangeListener(this);
		cb_calldivert.setOnCheckedChangeListener(this);
		cb_halfattend_turn.setOnCheckedChangeListener(this);
		cb_auto_hangup.setOnCheckedChangeListener(this);
		cb_open_threeparty.setOnCheckedChangeListener(this);
		cb_headsetring.setOnCheckedChangeListener(this);
		cb_auto_Earphone.setOnCheckedChangeListener(this);
		cb_forbid_callout.setOnCheckedChangeListener(this);
		cb_call_history.setOnCheckedChangeListener(this);
		cb_IPcall.setOnCheckedChangeListener(this);

		cb_open_MultiLine.setOnCheckedChangeListener(this);
		cb_callwait_voice.setOnCheckedChangeListener(this);
		cb_callDTMF_voice.setOnCheckedChangeListener(this);
		cb_dialDTMF_voice.setOnCheckedChangeListener(this);
		cb_passwordcall.setOnCheckedChangeListener(this);
		cb_finishcall.setOnCheckedChangeListener(this);
		cb_auto_redial.setOnCheckedChangeListener(this);
		cb_talkbackmode.setOnCheckedChangeListener(this);
		cb_talkbackmode_mute.setOnCheckedChangeListener(this);
		cb_talkbackmode_ring.setOnCheckedChangeListener(this);

		cb_secondtalkback_answer.setOnCheckedChangeListener(this);
		cb_hide_localcode.setOnCheckedChangeListener(this);
		cb_SIP_number.setOnCheckedChangeListener(this);
		cb_update_callnumber.setOnCheckedChangeListener(this);
		cb_three_callprocedure.setOnCheckedChangeListener(this);
		cb_three_callsoftware.setOnCheckedChangeListener(this);

		ll_auto_hanguptime = (LinearLayout) findViewById(R.id.ll_auto_hanguptime);
		ll_hideDTMF = (LinearLayout) findViewById(R.id.ll_hideDTMF);
		ll_calloutside = (LinearLayout) findViewById(R.id.ll_calloutside);
		ll_callmode = (LinearLayout) findViewById(R.id.ll_callmode);
		ll_answermode = (LinearLayout) findViewById(R.id.ll_answermode);
		ll_urgent_number = (LinearLayout) findViewById(R.id.ll_urgent_number);
		ll_limit_ActiveURI = (LinearLayout) findViewById(R.id.ll_limit_ActiveURI);
		ll_passwordcall_prefix = (LinearLayout) findViewById(R.id.ll_passwordcall_prefix);
		ll_passwordlong = (LinearLayout) findViewById(R.id.ll_passwordlong);
		ll_auto_redial_interval = (LinearLayout) findViewById(R.id.ll_auto_redial_interval);
		ll_auto_redial_count = (LinearLayout) findViewById(R.id.ll_auto_redial_count);
		ll_busy_responsecode = (LinearLayout) findViewById(R.id.ll_busy_responsecode);
		ll_country_code = (LinearLayout) findViewById(R.id.ll_country_code);
		ll_region_code = (LinearLayout) findViewById(R.id.ll_region_code);
		ll_onekey_transfer = (LinearLayout) findViewById(R.id.ll_onekey_transfer);
		ll_videomode = (LinearLayout) findViewById(R.id.ll_videomode);

		ll_auto_hanguptime.setOnClickListener(this);
		ll_hideDTMF.setOnClickListener(this);
		ll_calloutside.setOnClickListener(this);
		ll_callmode.setOnClickListener(this);
		ll_answermode.setOnClickListener(this);
		ll_urgent_number.setOnClickListener(this);
		ll_limit_ActiveURI.setOnClickListener(this);
		ll_passwordcall_prefix.setOnClickListener(this);
		ll_passwordlong.setOnClickListener(this);
		ll_auto_redial_interval.setOnClickListener(this);
		ll_auto_redial_count.setOnClickListener(this);
		ll_busy_responsecode.setOnClickListener(this);
		ll_country_code.setOnClickListener(this);
		ll_region_code.setOnClickListener(this);
		ll_onekey_transfer.setOnClickListener(this);
		ll_videomode.setOnClickListener(this);

		tv_auto_hanguptime = (TextView) findViewById(R.id.tv_auto_hanguptime);
		tv_hideDTMF = (TextView) findViewById(R.id.tv_hideDTMF);
		tv_calloutside = (TextView) findViewById(R.id.tv_calloutside);
		tv_callmode = (TextView) findViewById(R.id.tv_callmode);
		tv_answermode = (TextView) findViewById(R.id.tv_answermode);
		tv_urgent_number = (TextView) findViewById(R.id.tv_urgent_number);
		tv_limit_ActiveURI = (TextView) findViewById(R.id.tv_limit_ActiveURI);
		tv_passwordcall_prefix = (TextView) findViewById(R.id.tv_passwordcall_prefix);
		tv_passwordlong = (TextView) findViewById(R.id.tv_passwordlong);
		tv_auto_redial_interval = (TextView) findViewById(R.id.tv_auto_redial_interval);
		tv_auto_redial_count = (TextView) findViewById(R.id.tv_auto_redial_count);
		tv_busy_responsecode = (TextView) findViewById(R.id.tv_busy_responsecode);
		tv_country_code = (TextView) findViewById(R.id.tv_country_code);
		tv_region_code = (TextView) findViewById(R.id.tv_region_code);
		tv_onekey_transfer = (TextView) findViewById(R.id.tv_onekey_transfer);
		tv_videomode = (TextView) findViewById(R.id.tv_videomode);
	}

	private void setvalues() {
		function_name = Constant.function;
		
		tv_auto_hanguptime.setText(SystemShare.getSettingString(mContext, function_name, Constant.autohanguptime));
		tv_hideDTMF.setText(SystemShare.getSettingString(mContext, function_name, Constant.hideDTMF));
		tv_calloutside.setText(SystemShare.getSettingString(mContext, function_name, Constant.calloutside));
		tv_callmode.setText(SystemShare.getSettingString(mContext, function_name, Constant.callmode));
		tv_answermode.setText(SystemShare.getSettingString(mContext, function_name, Constant.answermode));
		tv_urgent_number.setText(SystemShare.getSettingString(mContext, function_name, Constant.urgentnumber));
		tv_limit_ActiveURI.setText(SystemShare.getSettingString(mContext, function_name, Constant.limitActiveURI));
		tv_passwordcall_prefix.setText(SystemShare.getSettingString(mContext, function_name, Constant.passwordcallprefix));
		tv_passwordlong.setText(SystemShare.getSettingString(mContext, function_name, Constant.passwordlong));
		tv_auto_redial_interval.setText(SystemShare.getSettingString(mContext, function_name, Constant.autoredialinterval));
		
		tv_auto_redial_count.setText(SystemShare.getSettingString(mContext, function_name, Constant.autoredialcount));
		tv_busy_responsecode.setText(SystemShare.getSettingString(mContext, function_name, Constant.busyresponsecode));
		tv_country_code.setText(SystemShare.getSettingString(mContext, function_name, Constant.countrycode));
		tv_region_code.setText(SystemShare.getSettingString(mContext, function_name, Constant.regioncode));
		tv_onekey_transfer.setText(SystemShare.getSettingString(mContext, function_name, Constant.onekeytransfer));
		tv_videomode.setText(SystemShare.getSettingString(mContext, function_name, Constant.videomode));
		
		cb_callwait.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.callwait, false));
		cb_calldivert.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.calldivert, false));
		cb_halfattend_turn.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.halfattendturn, false));
		cb_auto_hangup.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.autohangup, false));
		cb_open_threeparty.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.openthreeparty, false));
		cb_headsetring.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.headsetring, false));
		cb_auto_Earphone.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.autoEarphone, false));
		cb_forbid_callout.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.forbidcallout, false));
		cb_call_history.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.callhistory, false));
		cb_IPcall.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.IPcall, false));
		
		cb_open_MultiLine.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.openMultiLine, false));
		cb_callwait_voice.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.callwaitvoice, false));
		cb_callDTMF_voice.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.callDTMFvoice, false));
		cb_dialDTMF_voice.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.dialDTMFvoice, false));
		cb_passwordcall.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.passwordcall, false));
		cb_finishcall.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.finishcall, false));
		cb_auto_redial.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.autoredial, false));
		cb_talkbackmode.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.talkbackmode, false));
		cb_talkbackmode_mute.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.talkbackmodemute, false));
		cb_talkbackmode_ring.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.talkbackmodering, false));
		
		cb_secondtalkback_answer.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.secondtalkbackanswer, false));
		cb_hide_localcode.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.hidelocalcode, false));
		cb_SIP_number.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.SIPnumber, false));
		cb_update_callnumber.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.updatecallnumber, false));
		cb_three_callprocedure.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.threecallprocedure, false));
		cb_three_callsoftware.setChecked(SystemShare.getSettingBoolean(mContext, function_name, Constant.threecallsoftware, false));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_back: // 返回
			finish();
			break;
		case R.id.ll_auto_hanguptime: // 
			DialogUtil.showdialog(mContext, R.string.auto_hanguptime, tv_auto_hanguptime, function_name, Constant.autohanguptime);
			break;
		case R.id.ll_hideDTMF: // 
			DialogUtil.showdialog(mContext, R.string.hideDTMF, tv_hideDTMF, function_name, Constant.hideDTMF);
			break;
		case R.id.ll_calloutside: // 
			DialogUtil.showdialog(mContext, R.string.calloutside, tv_calloutside, function_name, Constant.calloutside);
			break;
		case R.id.ll_callmode: // 
			DialogUtil.showdialog(mContext, R.string.callmode, tv_callmode, function_name, Constant.callmode);
			break;
		case R.id.ll_answermode: // 
			DialogUtil.showdialog(mContext, R.string.answermode, tv_answermode, function_name, Constant.answermode);
			break;
		case R.id.ll_urgent_number: // 
			DialogUtil.showdialog(mContext, R.string.urgent_number, tv_urgent_number, function_name, Constant.urgentnumber);
			break;
		case R.id.ll_limit_ActiveURI: // 
			DialogUtil.showdialog(mContext, R.string.limit_ActiveURI, tv_limit_ActiveURI, function_name, Constant.limitActiveURI);
			break;
		case R.id.ll_passwordcall_prefix: // 
			DialogUtil.showdialog(mContext, R.string.passwordcall_prefix, tv_passwordcall_prefix, function_name, Constant.passwordcallprefix);
			break;
		case R.id.ll_passwordlong: // 
			DialogUtil.showdialog(mContext, R.string.passwordlong, tv_passwordlong, function_name, Constant.passwordlong);
			break;
		case R.id.ll_auto_redial_interval: // 
			DialogUtil.showdialog(mContext, R.string.auto_redial_interval, tv_auto_redial_interval, function_name, Constant.autoredialinterval);
			break;
		case R.id.ll_auto_redial_count: // 
			DialogUtil.showdialog(mContext, R.string.auto_redial_count, tv_auto_redial_count, function_name, Constant.autoredialcount);
			break;
		case R.id.ll_busy_responsecode: // 
			DialogUtil.showdialog(mContext, R.string.busy_responsecode, tv_busy_responsecode, function_name, Constant.busyresponsecode);
			break;
		case R.id.ll_country_code: // 
			DialogUtil.showdialog(mContext, R.string.country_code, tv_country_code, function_name, Constant.countrycode);
			break;
		case R.id.ll_region_code: // 
			DialogUtil.showdialog(mContext, R.string.region_code, tv_region_code, function_name, Constant.regioncode);
			break;
		case R.id.ll_onekey_transfer: // 
			DialogUtil.showdialog(mContext, R.string.onekey_transfer, tv_onekey_transfer, function_name, Constant.onekeytransfer);
			break;
		case R.id.ll_videomode: // 
			DialogUtil.showdialog(mContext, R.string.videomode, tv_videomode, function_name, Constant.videomode);
			break;

		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		switch (buttonView.getId()) {
		case R.id.cb_callwait:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.callwait, istrue);
			break;
		case R.id.cb_calldivert:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.calldivert, istrue);
			break;
		case R.id.cb_halfattend_turn:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.halfattendturn, istrue);
			break;
		case R.id.cb_auto_hangup:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.autohangup, istrue);
			break;
		case R.id.cb_open_threeparty:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.openthreeparty, istrue);
			break;
		case R.id.cb_headsetring:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.headsetring, istrue);
			break;
		case R.id.cb_auto_Earphone:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.autoEarphone, istrue);
			break;
		case R.id.cb_forbid_callout:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.forbidcallout, istrue);
			break;
		case R.id.cb_call_history:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.callhistory, istrue);
			break;
		case R.id.cb_IPcall:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.IPcall, istrue);
			break;
		case R.id.cb_open_MultiLine:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.openMultiLine, istrue);
			break;
		case R.id.cb_callwait_voice:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.callwaitvoice, istrue);
			break;
		case R.id.cb_callDTMF_voice:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.callDTMFvoice, istrue);
			break;
		case R.id.cb_dialDTMF_voice:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.dialDTMFvoice, istrue);
			break;
		case R.id.cb_passwordcall:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.passwordcall, istrue);
			break;
		case R.id.cb_finishcall:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.finishcall, istrue);
			break;
		case R.id.cb_auto_redial:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.autoredial, istrue);
			break;
		case R.id.cb_talkbackmode:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.talkbackmode, istrue);
			break;
		case R.id.cb_talkbackmode_mute:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.talkbackmodemute, istrue);
			break;
		case R.id.cb_talkbackmode_ring:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.talkbackmodering, istrue);
			break;
		case R.id.cb_secondtalkback_answer:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.secondtalkbackanswer, istrue);
			break;
		case R.id.cb_hide_localcode:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.hidelocalcode, istrue);
			break;
		case R.id.cb_SIP_number:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.SIPnumber, istrue);
			break;
		case R.id.cb_update_callnumber:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.updatecallnumber, istrue);
			break;
		case R.id.cb_three_callprocedure:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.threecallprocedure, istrue);
			break;
		case R.id.cb_three_callsoftware:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, function_name, Constant.threecallsoftware, istrue);
			break;
		default:
			break;
		}
	}

}
