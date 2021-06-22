package com.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @moudle: AccountWithOutSync 
 * @version:v1.0
 * @Description: 未同步的账户类:线程不安全
 * @author: xukai
 * @date: 2017年4月28日 下午3:25:27
 *
 */ 
public class AccountWithOutSync {

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
		private int blanace = 0;

		public int getBlanace() {
			return blanace;
		}
		
		public synchronized void deposit(int amount) {
			int newBlanace = blanace + amount;
			try {
				Thread.sleep(50L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			blanace = newBlanace;
		}
		
	}
	
}
