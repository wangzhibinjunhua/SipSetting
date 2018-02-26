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
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CollectRuleActivity extends BaseActivity implements OnClickListener, OnCheckedChangeListener {

	private Context mContext;

	private TextView titleView;
	private ImageView backView;

	private CheckBox cb_ending_collect, cb_overtime_collect, cb_ending_turn, cb_hang_turn, cb_hang_attendturn,
			cb_meeting_hang_attendturn;

	private LinearLayout ll_overtime_collectrange;

	private RelativeLayout rl_custom_callrule;

	private TextView tv_overtime_collectrange;

	private String collectrule_name; // 存储文件名称
	private Boolean istrue = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_collectrule);
		mContext = CollectRuleActivity.this;
		setview();
		setvalues(); // 初始值设置
	}

	private void setview() {
		titleView = (TextView) findViewById(R.id.title_text);
		titleView.setText(R.string.service_title);
		backView = (ImageView) findViewById(R.id.title_back);
		backView.setOnClickListener(this);

		cb_ending_collect = (CheckBox) findViewById(R.id.cb_ending_collect);
		cb_overtime_collect = (CheckBox) findViewById(R.id.cb_overtime_collect);
		cb_ending_turn = (CheckBox) findViewById(R.id.cb_ending_turn);
		cb_hang_turn = (CheckBox) findViewById(R.id.cb_hang_turn);
		cb_hang_attendturn = (CheckBox) findViewById(R.id.cb_hang_attendturn);
		cb_meeting_hang_attendturn = (CheckBox) findViewById(R.id.cb_meeting_hang_attendturn);

		cb_ending_collect.setOnCheckedChangeListener(this);
		cb_overtime_collect.setOnCheckedChangeListener(this);
		cb_ending_turn.setOnCheckedChangeListener(this);
		cb_hang_turn.setOnCheckedChangeListener(this);
		cb_hang_attendturn.setOnCheckedChangeListener(this);
		cb_meeting_hang_attendturn.setOnCheckedChangeListener(this);

		ll_overtime_collectrange = (LinearLayout) findViewById(R.id.ll_overtime_collectrange);
		rl_custom_callrule = (RelativeLayout) findViewById(R.id.rl_custom_callrule);

		ll_overtime_collectrange.setOnClickListener(this);
		rl_custom_callrule.setOnClickListener(this);

		tv_overtime_collectrange = (TextView) findViewById(R.id.tv_overtime_collectrange);
	}

	private void setvalues() {
		collectrule_name = Constant.collectrule;

		tv_overtime_collectrange
				.setText(SystemShare.getSettingString(mContext, collectrule_name, Constant.overtimecollectrange));
		cb_ending_collect
				.setChecked(SystemShare.getSettingBoolean(mContext, collectrule_name, Constant.endingcollect, false));
		cb_overtime_collect
				.setChecked(SystemShare.getSettingBoolean(mContext, collectrule_name, Constant.overtimecollect, false));
		cb_ending_turn
				.setChecked(SystemShare.getSettingBoolean(mContext, collectrule_name, Constant.endingturn, false));
		cb_hang_turn.setChecked(SystemShare.getSettingBoolean(mContext, collectrule_name, Constant.hangturn, false));
		cb_hang_attendturn
				.setChecked(SystemShare.getSettingBoolean(mContext, collectrule_name, Constant.hangattendturn, false));
		cb_meeting_hang_attendturn.setChecked(
				SystemShare.getSettingBoolean(mContext, collectrule_name, Constant.meetinghangattendturn, false));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.title_back: // 返回
			finish();
			break;
		case R.id.ll_overtime_collectrange: // 超时收号范围(3~30)
			DialogUtil.showdialog(mContext, R.string.overtime_collectrange, tv_overtime_collectrange, collectrule_name,
					Constant.overtimecollectrange);
			break;
		case R.id.rl_custom_callrule: // 自定义拨号规则
			break;

		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		switch (buttonView.getId()) {
		case R.id.cb_ending_collect:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, collectrule_name, Constant.endingcollect, istrue);
			break;
		case R.id.cb_overtime_collect:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, collectrule_name, Constant.overtimecollect, istrue);
			break;
		case R.id.cb_ending_turn:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, collectrule_name, Constant.endingturn, istrue);
			break;
		case R.id.cb_hang_turn:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, collectrule_name, Constant.hangturn, istrue);
			break;
		case R.id.cb_hang_attendturn:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, collectrule_name, Constant.hangattendturn, istrue);
			break;
		case R.id.cb_meeting_hang_attendturn:
			istrue = isChecked ? true : false;
			SystemShare.setSettingBoolean(mContext, collectrule_name, Constant.meetinghangattendturn, istrue);
			break;

		default:
			break;
		}
	}

}
