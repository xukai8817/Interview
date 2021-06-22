package com.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @moudle: StudyExecutors 
 * @version:v1.0
 * @Description: 线程池的四种使用情况
 * @author: xukai
 * @date: 2017年4月27日 下午6:00:42
 *
 */ 
public class StudyExecutors {
	
	public static void main(String[] args) {
		StudyExecutors mine = new StudyExecutors();
		mine.newCachedThreadPool();
		System.out.println();
		mine.newFixedThreadPool();
		System.out.println();
		mine.newSingleThreadExecutor();
		System.out.println();
		mine.newScheduledThreadPool();
	}
	

	/**
	 * 创建一个可缓存的线程池，当前规模<处理需求，回收空闲的线程，需求增加，可添加新线程，规模无限制
	 * <p>Title: newCachedThreadPool</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年4月27日 下午6:19:52</p>
	 */
	private void newCachedThreadPool() {
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(new MyThread(1));
		executor.execute(new MyThread(2));
		executor.execute(new MyThread(3));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();
	}
	
	/**
	 * 创建固定长度的线程池，提交一个任务创建一个线程，到达最大数量，规模不在变化
	 * <p>Title: newCachedThreadPool</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年4月27日 下午6:02:33</p>
	 */
	private void newFixedThreadPool() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new MyThread(1));
		executor.execute(new MyThread(2));
		executor.execute(new MyThread(3));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();
	}
	
	/**
	 * 单线程的线程池，确保任务在队列中串行执行
	 * <p>Title: newSingleThreadExecutor</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年4月27日 下午6:22:04</p>
	 */
	private void newSingleThreadExecutor() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(new MyThread(1));
		executor.execute(new MyThread(2));
		executor.execute(new MyThread(3));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();
	}
	
	/**
	 * 创建固定长度线程池，具有延迟或定时的方式执行任务
	 * <p>Title: newSingleThreadExecutor</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年4月27日 下午6:23:42</p>
	 */
	private void newScheduledThreadPool() {
		ExecutorService executor = Executors.newScheduledThreadPool(3);
		executor.execute(new MyThread(1));
		executor.execute(new MyThread(2));
		executor.execute(new MyThread(3));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();
	}

	class MyThread implements Runnable {

		private int num;
		
		public MyThread(int num) {
			this.num = num;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < num; i++) {
				System.out.print(i + " ");
			}
		}
		
	}
}
