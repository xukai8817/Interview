package com.reflect.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @moudle: CalInvocationHandler 
 * @version:v1.0
 * @Description: 调用捕获
 * @author: xukai
 * @date: 2017年6月18日 下午4:53:31
 *
 */ 
public class CalInvocationHandler implements InvocationHandler {

	Object realObject;
	
	public CalInvocationHandler(Object realObject) {
		this.realObject = realObject;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 1.before
		System.out.println("Before:proxy=" + proxy.getClass().getName() + ",method=" + method.getName());
		// 2.do
		Object obj = method.invoke(realObject, args);
		// 3.after
		System.out.println("After");
		return obj;
	}


}
