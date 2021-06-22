package com.thread.executor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @moudle: MonitorThread
 * @version:v1.0
 * @Description: 监视线程：监视线程池状态
 * @author: xukai
 * @date: 2017年7月24日 下午5:28:14
 *
 */
public class MonitorThread implements Runnable {

	ThreadPoolExecutor executor;

	public MonitorThread(ThreadPoolExecutor executor) {
		super();
		this.executor = executor;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("WorkQueue.size=" + executor.getQueue().size());
			if (executor.isTerminated()) {
				System.out.println("over");
				break;
			}
			try {
				// 每秒扫描一次
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
			}
		}
	}

}
