package com.sort;

import java.util.Arrays;

/**
 * @moudle: SelectSort
 * @version:v1.0
 * @Description: 选择排序:遍历数组，将最小的数放在最前面。遍历剩余元素，持续此操作。
 * @author: xukai
 * @date: 2017年5月21日 下午2:51:31
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] array = { 5, 2, 9, 3, 8, 5, 0, 1, 6, 7 };
		selectSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void selectSort(int[] array) {
		// 遍历次数为length - 1;
		for (int i = 0; i < array.length - 1; i++) {
			// 1.遍历数组找到min元素
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			// 2.swap(array[i],array[index])
			if (minIndex != i) {
				int temp = array[minIndex];
				array[minIndex] = array[i];
				array[i] = temp;
			}
			System.out.print("第" + (i+1) + "次循环执行之后：");
			System.out.println(Arrays.toString(array));
		}
	}

}
