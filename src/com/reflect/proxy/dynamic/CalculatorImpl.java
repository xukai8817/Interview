package com.reflect.proxy.dynamic;

/**
 * @moudle: CalculatorImpl 
 * @version:v1.0
 * @Description: 计算器实现：单一职责
 * @author: xukai
 * @date: 2017年6月18日 下午4:50:53
 *
 */ 
public class CalculatorImpl implements Calculator{

	@Override
	public double add(double a, double b) {
		System.out.println("CalculatorImpl.add()");
		return a + b;
	}

	@Override
	public double sub(double a, double b) {
		System.out.println("CalculatorImpl.sub()");
		return a - b;
	}

	@Override
	public double multi(double a, double b) {
		System.out.println("CalculatorImpl.multi()");
		return a * b;
	}

	@Override
	public double divis(double a, double b) {
		System.out.println("CalculatorImpl.divis()");
		return a / b;
	}

}
