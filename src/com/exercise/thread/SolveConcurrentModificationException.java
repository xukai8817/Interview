package com.exercise.thread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * @moudle: SolveConcurrentModificationException 
 * @version:v1.0
 * @Description: 解决迭代器快速失败特性
 * @author: xukai
 * @date: 2017年4月30日 下午5:37:36
 *
 */ 
public class SolveConcurrentModificationException {

	private Set<Integer> set = new HashSet<Integer>();
	
	public SolveConcurrentModificationException() {
		set = Collections.synchronizedSet(set);
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
					set.add((int)(Math.random() * 100 + 1));
					Thread.sleep(1L);
				}
			} catch (InterruptedException e) {
			}
		}
	}
	
	class IteratorTask implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (set) {
					Iterator<Integer> iterator = set.iterator();
					while (iterator.hasNext()) {
						System.out.print(iterator.next() + " ");
					}
					System.out.print("\n");
					try {
						Thread.sleep(1000L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new SolveConcurrentModificationException();
	}
	
}
