package com.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @moudle: AccountWithSyncLock 
 * @version:v1.0
 * @Description: 显式加锁Lock
 * @author: xukai
 * @date: 2017年4月28日 下午3:52:22
 *
 */
public class AccountWithSyncLock {

	private static Account account = new Account();
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			executor.execute(new AddAccountTask());
		}
		
		executor.shutdown();
		while (!executor.isTerminated()) {
			
		}
		System.out.println("The account blanace = " + account.getBlanace());
		
	}
	
	private static class AddAccountTask implements Runnable {

		@Override
		public void run() {
			account.deposit(1);
		}
		
	}
	
	private static class Account {
		
		private Lock lock = new ReentrantLock();
		private int blanace = 0;

		public int getBlanace() {
			return blanace;
		}
		
		public void deposit(int amount) {
			lock.lock();
			int newBlanace = blanace + amount;
			try {
				Thread.sleep(50L);
				blanace = newBlanace;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		
	}
	
}
