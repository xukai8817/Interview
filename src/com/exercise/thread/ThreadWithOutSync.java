package com.exercise.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @moudle: ThreadWithSync 
 * @version:v1.0
 * @Description: 非同步线程
 * @author: xukai
 * @date: 2017年4月29日 下午11:37:39
 *
 */ 
public class ThreadWithOutSync {

	private  Integer sum = new Integer(0);
	
	class MyThread implements Runnable {
		@Override
		public void run() {
			int value = sum.intValue() + 1;
			sum = new Integer(value);
		}
	}
	
	public ThreadWithOutSync() {
		ExecutorService executor = Executors.newFixedThreadPool(1000);
		for (int i = 0; i < 1000; i++) {
			executor.execute(new MyThread());
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
			
		}
	}
	
	public static void main(String[] args) {
		ThreadWithOutSync mytest = new ThreadWithOutSync();
		System.out.println(mytest.sum);
	}
}
