package com.exercise.other;

/**
 * @moudle: MyPrint 
 * @version:v1.0
 * @Description: 打印平行四边形
 * @author: xukai
 * @date: 2017年4月28日 下午9:33:55
 *
 */ 
public class MyPrint {

	public static void main(String[] args) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < 8; k++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
	}
	
}
