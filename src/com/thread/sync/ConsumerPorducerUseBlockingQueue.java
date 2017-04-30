package com.thread.sync;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerPorducerUseBlockingQueue {

	private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(2);
	
	
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
					buffer.put(i++);
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
					System.out.println("Consumer read: " + buffer.take());;
					Thread.sleep((long) (Math.random() * 10000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
