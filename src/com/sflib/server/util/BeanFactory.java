package com.sflib.server.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sflib.server.service.ISFLibService;

public class BeanFactory {
	
	private static ApplicationContext ctx;
	private static final String config = "beans.xml";
	
	static{
		
		ctx = new ClassPathXmlApplicationContext(config);
		
	}
	
	public static ApplicationContext getContext(){
		
		if(null == ctx)
			ctx = new ClassPathXmlApplicationContext(config);
		
		return ctx;
		
	}
	
	public static ISFLibService getService(String dealType){
		
		ISFLibService service = (ISFLibService) ctx.getBean(dealType);
		
		return service;
	}

}
