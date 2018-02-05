package com.wzb.setting.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SystemShare {

	private static final String PREFIX_NAME = "jetsen_catch";

	public static final int PRIVATE = Context.MODE_PRIVATE;
	public static final int MODE_MULTI_PROCESS = Context.MODE_MULTI_PROCESS;

	/**
	 * 保存String类型数据
	 *
	 * @param context
	 * @param user
	 * @param key
	 * @param value
	 */
	public static void setSettingString(Context context, String user, String key, String value) {
		SharedPreferences sp = context.getSharedPreferences(user, PRIVATE);
		Editor editor = sp.edit();
		editor.putString(key, value);
		editor.commit();
	}

	/**
	 * 获取String类型数据
	 *
	 * @param context
	 */
	public static String getSettingString(Context context, String user, String strKey) {
		SharedPreferences sp = context.getSharedPreferences(user, PRIVATE);
		String strValue = sp.getString(strKey, "");
		return strValue;
	}
	
	public static String getSettingString(Context context, String user, String strKey, String str) {
		SharedPreferences sp = context.getSharedPreferences(user, PRIVATE);
		String strValue = sp.getString(strKey, str);
		return strValue;
	}

	/**
	 * 删除String类型数据
	 *
	 * @param context
	 */
	public static void ClearSettingString(Context context, String user, String strKey) {
		SharedPreferences clientPreferences = context.getSharedPreferences(user, PRIVATE);
		SharedPreferences.Editor prefEditor = clientPreferences.edit();
		prefEditor.remove(strKey);
		prefEditor.commit();
	}

	/**
	 * 保存boolean类型数据
	 *
	 * @param context
	 */
	public static void setSettingBoolean(Context context, String user, String strKey, boolean value) {
		SharedPreferences sp = context.getSharedPreferences(user, PRIVATE);
		Editor editor = sp.edit();
		editor.putBoolean(strKey, value);
		editor.commit();
	}

	/**
	 * 获取boolean类型数据
	 *
	 * @param context
	 */
	public static boolean getSettingBoolean(Context context, String user, String strKey) {
		SharedPreferences sp = context.getSharedPreferences(user, PRIVATE);
		boolean value = sp.getBoolean(strKey, false);
		return value;
	}

	public static boolean getSettingBoolean(Context context, String user, String strKey, boolean value) {
		SharedPreferences sp = context.getSharedPreferences(user, PRIVATE);
		boolean ret = sp.getBoolean(strKey, value);
		return ret;
	}

	/**
	 * 保存int类型数据
	 *
	 * @param context
	 * @param value
	 */
	public static void setSettingInt(Context context, String user, String strKey, int value) {
		SharedPreferences sp = context.getSharedPreferences(user, PRIVATE);
		Editor editor = sp.edit();
		editor.putInt(strKey, value);
		editor.commit();
	}

	/**
	 * 获取int类型数据
	 *
	 * @param context
	 */
	public static int getSettingInt(Context context, String user, String strKey) {
		SharedPreferences sp = context.getSharedPreferences(user, PRIVATE);
		int value = sp.getInt(strKey, 0);
		return value;
	}

	public static int getSettingInt(Context context, String user, String strKey, int value) {
		SharedPreferences sp = context.getSharedPreferences(user, PRIVATE);
		int values = sp.getInt(strKey, value);
		return values;
	}

}
