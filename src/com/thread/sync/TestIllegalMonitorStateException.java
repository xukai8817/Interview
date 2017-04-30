package com.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @moudle: 测试IllegalMonitorStateException
 * @version:v1.0
 * @Description: TODO
 * @author: xukai
 * @date: 2017年4月29日 下午10:30:34
 *
 */
public class TestIllegalMonitorStateException {

	private static Account account = new Account();
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new ThreadTask1());
		executor.execute(new ThreadTask2());
		executor.shutdown();
	}

	private static class ThreadTask1 implements Runnable {
		@Override
		public void run() {
			while (true) {
				account.deposit((int)Math.random() * 10 + 1);
			}
		}
	}
	
	private static class ThreadTask2 implements Runnable {
		@Override
		public void run() {
			while (true) {
				account.withdraw((int)Math.random() * 10 + 1);
			}
		}
	}

	private static class Account {
		private int blanace = 0;
		private Lock lock = new ReentrantLock();
		private Condition notEmpty = lock.newCondition();
		private Condition notFull = lock.newCondition();

		public int getBlanace() {
			return this.blanace;
		}
		
		public void deposit(int amount) {
//			lock.lock();
			try {
				while (blanace == 100) {
					notFull.await();
				}
				blanace += amount;
				System.out.println("after deposit blanace = " + getBlanace());
				notEmpty.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			finally {
//				lock.unlock();
//			}
		} 

		public void withdraw(int amount) {
//			lock.lock();
			try {
				while (blanace == 0) {
					notEmpty.await();
				}
				blanace -= amount;
				System.out.println("after withdraw blanace = " + getBlanace());
				notFull.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			finally {
//				lock.unlock();
//			}
		}
	}
}
