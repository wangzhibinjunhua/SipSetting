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
import android.widget.TextView;
import android.widget.Toast;

public class DialogUtil {

	private static Context mContext;
	private static Dialog dialog;
	private static TextView dialogtitle;
	private static EditText edit_text;
	private static TextView dialog_ok;
	private static TextView dialog_cancel;

	public static void showdialog(Context context, final int serverAddress, final TextView textView,
			final String sp_name, final String str) {
		mContext = context;
		View view = LayoutInflater.from(context).inflate(R.layout.mydialog, null);
		dialog = new Dialog(mContext, R.style.mydialog);
		dialogtitle = (TextView) view.findViewById(R.id.dialogtitle);
		edit_text = (EditText) view.findViewById(R.id.edit_text);
		dialog_ok = (TextView) view.findViewById(R.id.dialog_ok);
		dialog_cancel = (TextView) view.findViewById(R.id.dialog_cancel);
		dialog_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String text = edit_text.getText().toString();
				if (edit_text.getText().toString().equals("")) {
					ToastUtil.showToast(mContext, dialogtitle.getText().toString() + "不能为空！", Toast.LENGTH_SHORT);
				} else {
//					SystemShare.setSettingString(mContext, sp_name, str, text);
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

}
