package com.thread.executor;

/**
 * @moudle: TaskThread
 * @version:v1.0
 * @Description: 任务线程：此类实例表示一个需要处理的任务
 * @author: xukai
 * @date: 2017年7月24日 下午5:27:30
 *
 */
public class TaskThread implements Runnable {

	String state;

	public TaskThread(String state) {
		super();
		this.state = state;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread() + ".state=" + state + "," + System.currentTimeMillis());
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
