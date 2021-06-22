package question;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @moudle: MyQuestion5 
 * @version:v1.0
 * @Description: 输入 n 个整数，输出其中最小的 k 个。
 * @author: xukai
 * @date: 2017年5月15日 下午11:26:06
 *
 */ 
public class MyQuestion5 {


	public static void main(String[] args) {
		int n = 10;
		int[] array = new int[n];
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < array.length; i++) {
			array[i] = input.nextInt();
		}
		System.out.println(Arrays.toString(array));
		
		// 插入排序思想
		sortMin(array, 5);
		System.out.println(Arrays.toString(array));
	}

	private static void sortMin(int[] array, int k) {
		// 输出的个数
		for (int i = 0; i < k; i++) {
			// 遍历剩余数组，找出最小值
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
	}
	
}
