package com.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


/**
 * @moudle: AccountWithSemaphore 
 * @version:v1.0
 * @Description: 信号量：限制访问共享资源的线程数
 * @author: xukai
 * @date: 2017年4月28日 下午11:23:50
 *
 */ 
public class AccountWithSemaphore {

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
		private static Semaphore semaphore = new Semaphore(1);
		private int blanace = 0;

		public int getBlanace() {
			return blanace;
		}
		
		public void deposit(int amount) {
			try {
				semaphore.acquire();
				int newBlanace = blanace + amount;
				Thread.sleep(50L);
				blanace = newBlanace;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaphore.release();
			}
		}
		
	}
	
}
