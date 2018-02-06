package com.wzb.setting.broadcast;

import com.wzb.setting.interf.WApplication;
import com.wzb.setting.util.Constant;
import com.wzb.setting.util.LogUtil;
import com.wzb.setting.util.SystemShare;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

public class CommonReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action=intent.getAction();
		LogUtil.logMessage("wzb", "CommonReceiver action:"+action);
		if(action.equals("com.android.sip.update")){
			String sip1account=intent.getStringExtra("sip1account");
			String sip1password=intent.getStringExtra("sip1password");
			String sip1host=intent.getStringExtra("sip1host");
			String sip1port=intent.getStringExtra("sip1port");
			String sip1protocol=intent.getStringExtra("sip1protocol");
			LogUtil.logMessage("wzb", "account:"+sip1account);
			LogUtil.logMessage("wzb", "password:"+sip1password);
			LogUtil.logMessage("wzb", "host:"+sip1host);
			LogUtil.logMessage("wzb", "port:"+sip1port);
			LogUtil.logMessage("wzb", "protocol:"+sip1protocol);
			WApplication.sp.set("sip1account", sip1account);
			WApplication.sp.set("sip1password", sip1password);
			WApplication.sp.set("sip1host", sip1host);
			WApplication.sp.set("sip1port", sip1port);
			WApplication.sp.set("sip1protocol", sip1protocol);
		}else if(action.equals("com.android.custom.net_static")){
			WApplication.sp.set("eth_type", "StaticIP");
			WApplication.sp.set("eth_mask", intent.getStringExtra("mask"));
			WApplication.sp.set("eth_gate", intent.getStringExtra("gate"));
		}else if(action.equals("com.android.custom.net_dhcp")){
			WApplication.sp.set("eth_type", "DHCP");
		}else if(action.equals("android.intent.action.BOOT_COMPLETED")){
			String sipUri1=SystemShare.getSettingString(context, Constant.ROUTE1, Constant.sipuri,"");
			String sipUri2=SystemShare.getSettingString(context, Constant.ROUTE2, Constant.sipuri,"");
			String sipUri3=SystemShare.getSettingString(context, Constant.ROUTE3, Constant.sipuri,"");
			String sipUri4=SystemShare.getSettingString(context, Constant.ROUTE4, Constant.sipuri,"");
			android.os.SystemProperties.set("custom.lp.sip1", sipUri1);
			android.os.SystemProperties.set("custom.lp.sip2", sipUri2);
			android.os.SystemProperties.set("custom.lp.sip3", sipUri3);
			android.os.SystemProperties.set("custom.lp.sip4", sipUri4);
			
		}
	}

}
