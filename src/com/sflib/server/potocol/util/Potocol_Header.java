package com.sflib.server.potocol.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class Potocol_Header {
	/**
	 * IMEI码
	 */
	private String IMEI = "-1";
	

	/**
	 * sim卡IMSI码
	 */
	private String IMSI = "-1";
	/**
	 * 时间戳
	 */
	private String Time_Stamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	
	/**
	 * 协议类型
	 */
	private String Potocol_Type = "-1";
	
	/**
	 * 全局唯一的交易编码
	 */
	private String Transaction_Code = UUID.randomUUID().toString();
	
	
	public String getIMSI() {
		return IMSI;
	}

	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}

	public String getTime_Stamp() {
		return Time_Stamp;
	}

	public void setTime_Stamp(String timeStamp) {
		Time_Stamp = timeStamp;
	}

	public String getPotocol_Type() {
		return Potocol_Type;
	}

	public void setPotocol_Type(String potocolType) {
		Potocol_Type = potocolType;
	}

	public String getTransaction_Code() {
		return Transaction_Code;
	}

	public void setTransaction_Code(String transactionCode) {
		Transaction_Code = transactionCode;
	}

	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
}
