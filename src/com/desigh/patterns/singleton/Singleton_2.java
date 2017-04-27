package com.desigh.patterns.singleton;

/**
 * @moudle: Singleton_2 
 * @version:v1.0
 * @Description: 懒汉模式
 * @author: xukai
 * @date: 2017年4月27日 上午10:58:28
 *
 */ 
public class Singleton_2 {

	private static Singleton_2 singleton = null;
	
	private Singleton_2() {
	}
	
	public static synchronized Singleton_2 getInstance() {
		if (singleton != null) {
			singleton = new Singleton_2();
		}
		return singleton;
	}
	
}
