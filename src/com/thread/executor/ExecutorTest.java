package com.thread.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @moudle: ExecutorTest
 * @version:v1.0
 * @Description: TODO
 * @author: xukai
 * @date: 2017年7月24日 下午5:15:50
 *
 */
public class ExecutorTest {

	public final static String THREAD_STATE_INIT = "init";
	public final static String THREAD_STATE_EXECUTE = "execute";

	
	public static void main(String[] args) {
		final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(11);
		for (int i = 0; i < 10; i++) {
			queue.add(new TaskThread(i + THREAD_STATE_INIT));
		}
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 20, 2000L, TimeUnit.SECONDS, queue);
		new Thread(new MonitorThread(executor)).start();	// 启动监视线程
		System.out.println("线程池创建完毕，工作线程未创建，任务等待");
		for (int i = 4; i > 0; i--)
			executor.execute(new TaskThread(THREAD_STATE_EXECUTE));
		executor.shutdown();
	}

}
