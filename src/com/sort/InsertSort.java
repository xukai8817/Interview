package com.sort;

import java.util.Arrays;

/**
 * @moudle: InsertSort
 * @version:v1.0
 * @Description: 插入排序：将新元素重复插入已排序好的子数列中
 * @author: xukai
 * @date: 2017年5月21日 下午3:03:51
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] array = { 5, 2, 9, 3, 8, 5, 0, 1, 6, 7 };
		insertSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void insertSort(int[] array) {
		// 遍历未排序数组下标
		for (int i = 1; i < array.length; i++) {
			// 遍历已排序完毕的子数组下标
			for (int j = 0; j < i; j++) {
				if (array[j] > array[i]) {
					// j为插入位置
					int insert = array[i];
					for (int k = i; k > j; k--) {
						array[k] = array[k - 1];
					}
					array[j] = insert;
				}
			}
			System.out.print("第" + i + "次循环执行之后：");
			System.out.println(Arrays.toString(array));
		}
	}
}
