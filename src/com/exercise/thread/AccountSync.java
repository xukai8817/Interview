package com.exercise.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @moudle: AccountSync
 * @version:v1.0
 * @Description: 账户同步
 * @author: xukai
 * @date: 2017年4月29日 下午11:54:34
 *
 */
public class AccountSync {

	private static Account account = new Account();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new DepositTask());
		executor.execute(new Withdraw());
		executor.shutdown();
		System.out.println("Deopist Task\t\tWithdraw Task\t\tBalance");
	}

	private static class DepositTask implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					account.deposit((int) ( Math.random() * 10 + 1));
					Thread.sleep(1000);
				}
			} catch (Exception e) {
			}
		}
	}

	private static class Withdraw implements Runnable {
		@Override
		public void run() {
			while (true) {
				account.withdraw((int) (Math.random() * 10) + 1);
			}
		}
	}

	private static class Account {
		private int balance = 0;

		public int getBalance() {
			return balance;
		}

		public synchronized void deposit(int amount) {
			balance += amount;
			System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
			notifyAll();
		}

		public synchronized void withdraw(int amount) {
			try {
				while (balance < amount) {
					wait();
				}
				balance -= amount;
				System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
