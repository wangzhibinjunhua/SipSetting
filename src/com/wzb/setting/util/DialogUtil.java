package com.wzb.setting.util;

import com.wzb.setting.R;
import com.wzb.setting.activity.SIPRouteActivity;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class DialogUtil {

	private static Context mContext;
	private static Dialog dialog;
	private static TextView dialogtitle;
	private static EditText edit_text;
	private static TextView dialog_ok;
	private static TextView dialog_cancel;
	private static LinearLayout ll_editinput;
	private static RadioGroup rg_transport;
	private static RadioButton rb_udp, rb_tcp, rb_tls;

	private static String transprot_type;

	public static void showdialog(Context context, final int serverAddress, final TextView textView,
			final String sp_name, final String str) {
		mContext = context;
		View view = LayoutInflater.from(context).inflate(R.layout.mydialog, null);
		dialog = new Dialog(mContext, R.style.mydialog);
		dialogtitle = (TextView) view.findViewById(R.id.dialogtitle);
		edit_text = (EditText) view.findViewById(R.id.edit_text);
		dialog_ok = (TextView) view.findViewById(R.id.dialog_ok);
		dialog_cancel = (TextView) view.findViewById(R.id.dialog_cancel);
		rg_transport = (RadioGroup) view.findViewById(R.id.rg_transport);
		rg_transport.setVisibility(View.GONE);
		dialog_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String text = edit_text.getText().toString();
				if (edit_text.getText().toString().equals("")) {
					ToastUtil.showToast(mContext, dialogtitle.getText().toString() + "不能为空！", Toast.LENGTH_SHORT);
				} else {
					SystemShare.setSettingString(mContext, sp_name, str, text);
					textView.setText(text);
					dialog.dismiss();
				}
			}
		});
		dialog_cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		dialog.setContentView(view);
		dialogtitle.setText(serverAddress);
		dialog.show();
	}

	public static void showdialog(Context context, final int serverAddress, final TextView textView,
			final String sp_name, String str, int type) {
		mContext = context;
		View view = LayoutInflater.from(context).inflate(R.layout.mydialog, null);
		dialog = new Dialog(mContext, R.style.mydialog);
		dialogtitle = (TextView) view.findViewById(R.id.dialogtitle);
		ll_editinput = (LinearLayout) view.findViewById(R.id.ll_editinput);
		ll_editinput.setVisibility(View.GONE);
		dialog_ok = (TextView) view.findViewById(R.id.dialog_ok);
		dialog_cancel = (TextView) view.findViewById(R.id.dialog_cancel);
		rg_transport = (RadioGroup) view.findViewById(R.id.rg_transport);
		rb_udp = (RadioButton) view.findViewById(R.id.rb_udp);
		rb_tcp = (RadioButton) view.findViewById(R.id.rb_tcp);
		rb_tls = (RadioButton) view.findViewById(R.id.rb_tls);
		if (str.equals("UDP")) {
			rb_udp.setChecked(true);
			transprot_type = "UDP";
		} else if (str.equals("TCP")) {
			rb_tcp.setChecked(true);
			transprot_type = "TCP";
		} else {
			rb_tls.setChecked(true);
			transprot_type = "TLS";
		}
		rg_transport.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.rb_udp:
					transprot_type = "UDP";
					break;
				case R.id.rb_tcp:
					transprot_type = "TCP";
					break;
				case R.id.rb_tls:
					transprot_type = "TLS";
					break;
				default:
					break;
				}
			}
		});
		dialog_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textView.setText(transprot_type);
				dialog.dismiss();
			}
		});
		dialog_cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		dialog.setContentView(view);
		dialogtitle.setText(serverAddress);
		dialog.show();
	}

}
