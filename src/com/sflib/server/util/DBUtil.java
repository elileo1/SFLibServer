package com.sflib.server.util;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;


public class DBUtil extends HibernateTemplate{
	
	private static DataSource ds = null;
	
	public Connection getConnection() throws SQLException{
		
		Connection conn = null;
		
		try {
			
			if(null==ds)
				ds = SessionFactoryUtils.getDataSource(getSessionFactory());
						
			conn = ds.getConnection();
			
		} catch (SQLException e) {
			throw e;
		}
		
		return conn;
		
	}
	
	//insert or update can use this function
	public int update(String sql,Object[] objs)throws Exception{
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		conn.setAutoCommit(false);
		int count = -1;
		try{
			stmt = conn.prepareStatement(sql);
			//setting parameters
			for(int i=0;i<objs.length;i++)
				stmt.setObject(i+1, objs[i]);
			count = stmt.executeUpdate();
		}catch(Exception e){
			conn.rollback();
		}finally{
			colse(conn,stmt,null);
		}
		return count;
	}
	
	//query all data for corresponding object(single object)
	public List getAll(String sql,Object[] objs,Class clazz)throws Exception{
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List objList = new ArrayList();
		try{
			stmt = conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++)
				stmt.setObject(i+1, objs[i]);
			rs = stmt.executeQuery();
			while(rs.next()){
				Object ins = clazz.newInstance();
				//setting value of each field
				Field[] fields = clazz.getDeclaredFields();
				for(Field f:fields){
					String fName = f.getName();
					String methodName = "set"+fName.substring(0).toUpperCase()+fName.substring(1, fName.length());
					Method method = clazz.getDeclaredMethod(methodName, String.class);//???the type should be flexible by each field
					method.invoke(ins, rs.getObject(fName));//???here the field name of the object should be the same as the DB
				}
				objList.add(ins);
			}
		}catch(Exception e){
			
		}finally{
			colse(conn,stmt,rs);
		}
		return objList;
	}
	
	public static void colse(Connection conn,Statement stmt,ResultSet rs){
		
		if(rs!=null)try {rs.close();} catch (Exception e) {}
		if(stmt!=null)try {stmt.close();} catch (Exception e) {}
		if(conn!=null)try {conn.close();} catch (Exception e) {}

	}

}
