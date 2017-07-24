package com.reflect.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @moudle: TestCalculator
 * @version:v1.0
 * @Description: 动态代理测试
 * @author: xukai
 * @date: 2017年6月18日 下午4:58:03
 *
 */
public class DynamicProxy {

	public static void main(String[] args) {
		CalculatorImpl impl = new CalculatorImpl();
		Calculator proxy = (Calculator) Proxy.newProxyInstance(CalculatorImpl.class.getClassLoader(),
				new Class[] { Calculator.class }, new CalInvocationHandler(impl));
		System.out.println(proxy.add(1.0, 1.0));
	}

}
