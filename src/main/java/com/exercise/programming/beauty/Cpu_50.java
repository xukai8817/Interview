package com.exercise.programming.beauty;

/**
 * @moudle: Cpu_50
 * @version:v1.0
 * @Description: 使CPU保持50%使用率，任务管理器一条直线
 * @author: xukai
 * @date: 2017年5月3日 下午2:34:49
 *
 */
public class Cpu_50 {

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			int busyTime = 10;
			int idleTime = busyTime;

			while (true) {
				long startTime = System.currentTimeMillis();
				// busy loop:
				while ((System.currentTimeMillis() - startTime) <= busyTime);
				Thread.sleep(idleTime);
			}
		}
	}

}
