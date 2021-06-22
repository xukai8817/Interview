package com.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @moudle: ThreadCooperation
 * @version:v1.0
 * @Description: 线程通信
 * @author: xukai
 * @date: 2017年4月28日 下午4:00:36
 *
 */
public class ThreadCooperation {

	private static Account account = new Account();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new DepositTask());
		executor.execute(new WithDrawTask());

		executor.shutdown();
		System.out.println("Thread 1\t\tThread2 \t\tBlanace");

	}

	private static class DepositTask implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					account.deposit((int) (Math.random() * 10) + 1);
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static class WithDrawTask implements Runnable {

		@Override
		public void run() {
			while (true) {
				account.withdraw((int) (Math.random() * 10) + 1);
			}
		}

	}

	private static class Account {

		private Lock lock = new ReentrantLock();
		private Condition newDeposit = lock.newCondition();
		private int blanace = 0;

		public int getBlanace() {
			return blanace;
		}

		public void deposit(int amount) {
			lock.lock();
			try {
				this.blanace += amount;
				System.out.println("Deposit:" + amount + "\t\t\t\t\t" + getBlanace());
				newDeposit.signalAll();
			} finally {
				lock.unlock();
			}
		}

		public void withdraw(int amount) {
			lock.lock();
			try {
				while (blanace < amount) {
					System.out.println("\t\t\tWait for deposit");
					newDeposit.await();
				}
				this.blanace -= amount;
				System.out.println("\t\t\tWithdraw:" + amount + "\t\t" + getBlanace());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

	}

}
