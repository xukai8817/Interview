package com.exercise.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @moudle: ThreadWithSync
 * @version:v1.0
 * @Description: 同步线程
 * @author: xukai
 * @date: 2017年4月29日 下午11:50:18
 *
 */
public class ThreadWithSync {

	private Integer sum = new Integer(0);

	private Lock lock = new ReentrantLock();

	class MyThread implements Runnable {

		@Override
		public void run() {
			lock.lock();
			int value = sum.intValue() + 1;
			sum = new Integer(value);
			lock.unlock();
		}
	}

	public ThreadWithSync() {
		ExecutorService executor = Executors.newFixedThreadPool(1000);
		for (int i = 0; i < 1000; i++) {
			executor.execute(new MyThread());
		}
		executor.shutdown();
		while (!executor.isTerminated()) {

		}
	}

	public static void main(String[] args) {
		ThreadWithSync mytest = new ThreadWithSync();
		System.out.println(mytest.sum);
	}
}
