package com.exercise.thread;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @moudle: TestConcurrentModificationException 
 * @version:v1.0
 * @Description: 测试迭代器快速失败特性
 * @author: xukai
 * @date: 2017年4月30日 下午5:26:01
 *
 */ 
public class TestConcurrentModificationException {

	private Set<Integer> set = new HashSet<>();
	
	public TestConcurrentModificationException() {
		Thread depositTask = new Thread(new DepositTask());
		Thread iteratorTask = new Thread(new IteratorTask());
		depositTask.start();
		iteratorTask.start();
	}
	
	class DepositTask implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					set.add((int)(Math.random() * 10 + 1));
					Thread.sleep(1000L);
				}
			} catch (InterruptedException e) {
			}
		}
	}
	
	class IteratorTask implements Runnable {
		@Override
		public void run() {
			while (true) {
				Iterator<Integer> iterator = set.iterator();
				while (iterator.hasNext()) {
					System.out.print(iterator.next() + " ");
				}
				System.out.print("\n");
			}
		}
	}
	
	public static void main(String[] args) {
		new TestConcurrentModificationException();
	}
	
}
