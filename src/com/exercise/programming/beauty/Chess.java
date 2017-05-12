package com.exercise.programming.beauty;

/**
 * @moudle: Chess
 * @version:v1.0
 * @Description: 将和帅的位置
 * @author: xukai
 * @date: 2017年5月3日 下午2:51:09
 *
 */
public class Chess {

	public static void main(String[] args) {
		byte i = 81;
		while (i > 0) {
			i--;
			if (i / 9 % 3 == i % 9 % 3)
				continue;
			System.out.printf("A = %d, B = %d \n", i / 9 + 1, i % 9 + 1);
		}
	}

}
