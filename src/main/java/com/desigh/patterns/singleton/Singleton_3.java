package com.desigh.patterns.singleton;

/**
 * @moudle: Singleton_3 
 * @version:v1.0
 * @Description: 双重检查锁
 * @author: xukai
 * @date: 2017年4月27日 上午11:04:38
 *
 */ 
public class Singleton_3 {

	private static Singleton_3 singleton = null;
	
	private Singleton_3() {
	}

	public static Singleton_3 getInstance() {
		if (singleton == null) {
			synchronized (Singleton_3.class) {
				if (singleton == null) {
					singleton = new Singleton_3();
				}
			}
		}
		return singleton;
	}
}
