package com.exercise.other;

import java.util.Scanner;

/**
 * @moudle: Fibonacci 
 * @version:v1.0
 * @Description: TODO
 * @author: xukai
 * @date: 2017年6月12日 上午11:06:59
 *
 */ 
public class Fibonacci {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();
		System.out.println(test1(i));
		System.out.println(test2(i));
	}

	private static int test2(int i) {
		int f0 = 0;
		int f1 = 1;
		int f2 = 1;
		
		if (i == 0)
			return f0;
		if (i == 1)
			return f1;
		while (i > 1) {
			f2 = f0 + f1;
			f0 = f1;
			f1 = f2;
			i--;
		}
		return f2;
	}

	/**
	 * 迭代
	 * <p>Title: test1</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年6月12日 上午11:09:29</p>
	 * @param i
	 * @return
	 */
	private static int test1(int i) {
		if (i == 0)
			return 0;
		if (i == 1)
			return 1;
		return test1(i - 1) + test1(i - 2);
	}
	
}
