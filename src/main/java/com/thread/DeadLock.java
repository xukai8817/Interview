package com.thread;

/**
 * @moudle: DeadLock
 * @version:v1.0
 * @Description: 死锁
 * @author: xukai
 * @date: 2017年4月30日 下午4:14:32
 *
 */
public class DeadLock {

	private static Object obj1 = new Object();
	private static Object obj2 = new Object();

	private static class TaskThread1 extends Thread {
		@Override
		public void run() {
			synchronized (obj1) {
				try {
					print(obj1);
					Thread.sleep(1000);
					synchronized (obj2) {
						print(obj2);
						this.interrupt();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static class TaskThread2 extends Thread {
		@Override
		public void run() {
			synchronized (obj2) {
				try {
					print(obj2);
					Thread.sleep(1000);
					synchronized (obj1) {
						print(obj1);
						this.interrupt();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void print(Object obj) {
		System.out.printf("%s get %s\n", Thread.currentThread(), obj);
	}

	public static void main(String[] args) {
		Thread task1 = new TaskThread1();
		Thread task2 = new TaskThread2();
		task1.start();
		task2.start();
	}
}
