package com.desigh.patterns.singleton;

/**
 * @moudle: Singleton 
 * @version:v1.0
 * @Description: 饿汉模式：太占资源
 * @author: xukai
 * @date: 2017年4月27日 上午10:56:34
 *
 */ 
public class Singleton_1 {

	private static Singleton_1 singleton = new Singleton_1();
	
	private Singleton_1() {
	}
	
	public static Singleton_1 getInstance() {
		return singleton;
	}
	
}
