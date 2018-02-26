package com.wzb.setting.activity;

import com.wzb.setting.R;
import com.wzb.setting.util.Constant;
import com.wzb.setting.util.DialogUtil;
import com.wzb.setting.util.SystemShare;

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
import android.widget.TextView;

public class CallServiceActivity extends BaseActivity implements OnClickListener, OnCheckedChangeListener {

	private Context mContext;

	private TextView titleView;
	private ImageView backView;
	private CheckBox cb_auto_switchover, cb_open_unconditional, cb_open_busy, cb_open_noanswer, cb_open_hotline,
			cb_open_misscall, cb_notregister_call, cb_open_userphone;

	private LinearLayout ll_auto_answertime, ll_unconditional_turn, ll_busy_turn, ll_noanswer_turn,
			ll_noanswer_overtime, ll_hotline_number, ll_hotline_delaytime, ll_voicemail_number, ll_route_ring,
			ll_show_calltype;

	private TextView tv_auto_answertime, tv_unconditional_turn, tv_busy_turn, tv_noanswer_turn, tv_noanswer_overtime,
			tv_hotline_number, tv_hotline_delaytime, tv_voicemail_number, tv_route_ring, tv_show_calltype;

	String callservice = "CALLSERVICE";
	private int services; // 服务
	private String callset_name; // 存储文件名称
	private Boolean istrue = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_callservice);
		mContext = CallServiceActivity.this;
		Intent intent = getIntent();
		services = intent.getIntExtra(callservice, 1);
		setview();
		setvalues(); // 初始值设置
	}

	private void setview() {
		titleView = (TextView) findViewById(R.id.title_text);
		titleView.setText(R.string.service_title + services);
		backView = (ImageView) findViewById(R.id.title_back);
		backView.setOnClickListener(this);

		cb_auto_switchover = (CheckBox) findViewById(R.id.cb_auto_switchover);
		cb_open_unconditional = (CheckBox) findViewById(R.id.cb_open_unconditional);
		cb_open_busy = (CheckBox) findViewById(R.id.cb_open_busy);
		cb_open_noanswer = (CheckBox) findViewById(R.id.cb_open_noanswer);
		cb_open_hotline = (CheckBox) findViewById(R.id.cb_open_hotline);
		cb_open_misscall = (CheckBox) findViewById(R.id.cb_open_misscall);
		cb_notregister_call = (CheckBox) findViewById(R.id.cb_notregister_call);
		cb_open_userphone = (CheckBox) findViewById(R.id.cb_open_userphone);

		cb_auto_switchover.setOnCheckedChangeListener(this);
		cb_open_unconditional.setOnCheckedChangeListener(this);
		cb_open_busy.setOnCheckedChangeListener(this);
		cb_open_noanswer.setOnCheckedChangeListener(this);
		cb_open_hotline.setOnCheckedChangeListener(this);
		cb_open_misscall.setOnCheckedChangeListener(this);
		cb_notregister_call.setOnCheckedChangeListener(this);
		cb_open_userphone.setOnCheckedChangeListener(this);

		ll_auto_answertime = (LinearLayout) findViewById(R.id.ll_auto_answertime);
		ll_unconditional_turn = (LinearLayout) findViewById(R.id.ll_unconditional_turn);
		ll_busy_turn = (LinearLayout) findViewById(R.id.ll_busy_turn);
		ll_noanswer_turn = (LinearLayout) findViewById(R.id.ll_noanswer_turn);
		ll_noanswer_overtime = (LinearLayout) findViewById(R.id.ll_noanswer_overtime);
		ll_hotline_number = (LinearLayout) findViewById(R.id.ll_hotline_number);
		ll_hotline_delaytime = (LinearLayout) findViewById(R.id.ll_hotline_delaytime);
		ll_voicemail_number = (LinearLayout) findViewById(R.id.ll_voicemail_number);
		ll_route_ring = (LinearLayout) findViewById(R.id.ll_route_ring);
		ll_show_calltype = (LinearLayout) findViewById(R.id.ll_show_calltype);

		ll_auto_answertime.setOnClickListener(this);
		ll_unconditional_turn.setOnClickListener(this);
		ll_busy_turn.setOnClickListener(this);
		ll_noanswer_turn.setOnClickListener(this);
		ll_noanswer_overtime.setOnClickListener(this);
		ll_hotline_number.setOnClickListener(this);
		ll_hotline_delaytime.setOnClickListener(this);
		ll_voicemail_number.setOnClickListener(this);
		ll_route_ring.setOnClickListener(this);
		ll_show_calltype.setOnClickListener(this);

		tv_auto_answertime = (TextView) findViewById(R.id.tv_auto_answertime);
		tv_unconditional_turn = (TextView) findViewById(R.id.tv_unconditional_turn);
		tv_busy_turn = (TextView) findViewById(R.id.tv_busy_turn);
		tv_noanswer_turn = (TextView) findViewById(R.id.tv_noanswer_turn);
		tv_noanswer_overtime = (TextView) findViewById(R.id.tv_noanswer_overtime);
		tv_hotline_number = (TextView) findViewById(R.id.tv_hotline_number);
		tv_hotline_delaytime = (TextView) findViewById(R.id.tv_hotline_delaytime);
		tv_voicemail_number = (TextView) findViewById(R.id.tv_voicemail_number);
		tv_route_ring = (TextView) findViewById(R.id.tv_route_ring);
		tv_show_calltype = (TextView) findViewById(R.id.tv_show_calltype);
	}

	private void setvalues() {
		if (services == 1) {
			callset_name = Constant.SERVICE1;
		} else if (services == 2) {
			callset_name = Constant.SERVICE2;
		} else if (services == 3) {
			callset_name = Constant.SERVICE3;
		}

		tv_auto_answertime.setText(SystemShare.getSettingString(mContext, callset_name, Constant.autoanswertime));
		tv_unconditional_turn.setText(SystemShare.getSettingString(mContext, callset_name, Constant.unconditionalturn));
		tv_busy_turn.setText(SystemShare.getSettingString(mContext, callset_name, Constant.busyturn));
		tv_noanswer_turn.setText(SystemShare.getSettingString(mContext, callset_name, Constant.noanswerturn));
		tv_noanswer_overtime.setText(SystemShare.getSettingString(mContext, callset_name, Constant.noanswerovertime));
		tv_hotline_number.setText(SystemShare.getSettingString(mContext, callset_name, Constant.hotlinenumber));
		tv_hotline_delaytime.setText(SystemShare.getSettingString(mContext, callset_name, Constant.hotlinedelaytime));
		tv_voicemail_number.setText(SystemShare.getSettingString(mContext, callset_name, Constant.voicemailnumber));
		tv_route_ring.setText(SystemShare.getSettingString(mContext, callset_name, Constant.routering));
		tv_show_calltype.setText(SystemShare.getSettingString(mContext, callset_name, Constant.showcalltype));

		cb_auto_switchover
				.setChecked(SystemShare.getSettingBoolean(mContext, callset_name, Constant.autoswitchover, false));
		cb_open_unconditional
				.setChecked(SystemShare.getSettingBoolean(mContext, callset_name, Constant.openunconditional, false));
		cb_open_busy.setChecked(SystemShare.getSettingBoolean(mContext, callset_name, Constant.openbusy, false));
		cb_open_noanswer
				.setChecked(SystemShare.getSettingBoolean(mContext, callset_name, Constant.opennoanswer, false));
		cb_open_hotline.setChecked(SystemShare.getSettingBoolean(mContext, callset_name, Constant.openhotline, false));
		cb_open_misscall
				.setChecked(SystemShare.getSettingBoolean(mContext, callset_name, Constant.openmisscall, false));
		cb_notregister_call
				.setChecked(SystemShare.getSettingBoolean(mContext, callset_name, Constant.notregistercall, false));
		cb_open_userphone
				.setChecked(SystemShare.getSettingBoolean(mContext, callset_name, Constant.openuserphone, false));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.title_back: // 返回
			finish();
			break;
		case R.id.ll_auto_answertime: // 自动接听等候时间(0~120)
			DialogUtil.showdialog(mContext, R.string.auto_switchover, tv_auto_answertime, callset_name,
					Constant.autoanswertime);
			break;
		case R.id.ll_unconditional_turn: // 无条件前转号码
			DialogUtil.showdialog(mContext, R.string.open_unconditional, tv_unconditional_turn, callset_name,
					Constant.unconditionalturn);
			break;
		case R.id.ll_busy_turn: // 遇忙前转号码
			DialogUtil.showdialog(mContext, R.string.busy_turn, tv_busy_turn, callset_name, Constant.busyturn);
			break;
		case R.id.ll_noanswer_turn: // 无应答前转号码
			DialogUtil.showdialog(mContext, R.string.noanswer_turn, tv_noanswer_turn, callset_name,
					Constant.noanswerturn);
			break;
		case R.id.ll_noanswer_overtime: // 无应答转移超时时间(0~120)
			DialogUtil.showdialog(mContext, R.string.noanswer_overtime, tv_noanswer_overtime, callset_name,
					Constant.noanswerovertime);
			break;
		case R.id.ll_hotline_number: // 热线号码
			DialogUtil.showdialog(mContext, R.string.hotline_number, tv_hotline_number, callset_name,
					Constant.hotlinenumber);
			break;
		case R.id.ll_hotline_delaytime: // 热线延迟时间(0~9)
			DialogUtil.showdialog(mContext, R.string.hotline_delaytime, tv_hotline_delaytime, callset_name,
					Constant.hotlinedelaytime);
			break;
		case R.id.ll_voicemail_number: // 语音信箱号码
			DialogUtil.showdialog(mContext, R.string.voicemail_number, tv_voicemail_number, callset_name,
					Constant.voicemailnumber);
			break;
		case R.id.ll_route_ring: // 选择线路铃声
			DialogUtil.showdialog(mContext, R.string.route_ring, tv_route_ring, callset_name, Constant.routering);
			break;
		case R.id.ll_show_calltype: // 来电显示类型
			DialogUtil.showdialog(mContext, R.string.show_calltype, tv_show_calltype, callset_name,
					Constant.showcalltype);
			break;
		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		switch (buttonView.getId()) {
		case R.id.cb_auto_switchover: // 启用自动转接
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, callset_name, Constant.autoswitchover, istrue);
			break;
		case R.id.cb_open_unconditional: // 开启无条件前转
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, callset_name, Constant.openunconditional, istrue);
			break;
		case R.id.cb_open_busy: // 开启遇忙前转
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, callset_name, Constant.openbusy, istrue);
			break;
		case R.id.cb_open_noanswer: // 开启无应答前转
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, callset_name, Constant.opennoanswer, istrue);
			break;
		case R.id.cb_open_hotline: // 开启热线
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, callset_name, Constant.openhotline, istrue);
			break;
		case R.id.cb_open_misscall: // 开启未接来电记录
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, callset_name, Constant.openmisscall, istrue);
			break;
		case R.id.cb_notregister_call: // 允许不注册呼叫
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, callset_name, Constant.notregistercall, istrue);
			break;
		case R.id.cb_open_userphone: // 开启User=phone
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, callset_name, Constant.openuserphone, istrue);
			break;

		default:
			break;
		}
	}

}
