package com.sflib.server.service.impl;



import org.springframework.jdbc.core.JdbcTemplate;

import com.sflib.server.service.ISFLibService;


public class Log_Operate extends JdbcTemplate implements ISFLibService {
	
	public String dealRequest(String content) {
		
		//解析并写入数据库
//		Gson gson = new Gson();
//		
//		Potocol pHeader = gson.fromJson(content, Potocol.class );  
//		String result = "-1";
//		
//		int rs = 0;
//		
//		try {
//			rs = this.update("insert into SF_Log (IMEI,Time_stamp,Potocol_Type,Potocol_Content) values(?,?,?,?)",
//					new Object[]{pHeader.getHEAD().getIMEI(),
//									pHeader.getHEAD().getTime_Stamp(),
//									pHeader.getHEAD().getPotocol_Type(),
//									content});
//			
//			if(rs > 0)
//			{
//				result = "1";
//			}
//			else
//			{
//				result = "-1";
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//		}
				
		return "1";
		
	}

}
