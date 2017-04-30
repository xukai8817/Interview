package com.thread.sync;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @moudle: ConsumerPorducer 
 * @version:v1.0
 * @Description: 生产者和消费者
 * @author: xukai
 * @date: 2017年4月28日 下午10:19:56
 *
 */ 
public class ConsumerPorducer {

	private static Buffer buffer = new Buffer();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());

		executor.shutdown();

	}

	private static class ProducerTask implements Runnable {
		@Override
		public void run() {
			int i = 1;
			while (true) {
				try {
					System.out.println("Producer write: " + i);
					buffer.write(i++);
					Thread.sleep((long) (Math.random() * 10000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static class ConsumerTask implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					System.out.println("Consumer read: " + buffer.read());;
					Thread.sleep((long) (Math.random() * 10000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	private static class Buffer {
		private static final int CAPACITY = 1;
		
		private LinkedList<Integer> queue = new LinkedList<>();
		
		private static Lock lock = new ReentrantLock();
		private static Condition notFull = lock.newCondition();
		private static Condition notEmpty = lock.newCondition();
		
		public void write(int value) {
			lock.lock();
			try {
				while (queue.size() == CAPACITY) {
					System.out.println("Wait for Not Full condition");
					notFull.await();
				}
				queue.offer(value);
				notEmpty.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		
		public int read() {
			int value = 0;
			lock.lock();
			try {
				while (queue.isEmpty()) {
					System.out.println("Wait for Not Empty condition");
					notEmpty.await();
				}
				value = queue.remove();
				notFull.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
			return value;
		}
		
	}

}
