package com.sort;

/**
 * @moudle: BubbleSort 
 * @version:v1.0
 * @Description: 冒泡排序
 * @author: xukai
 * @date: 2017年5月16日 下午2:43:22
 *
 */ 
public class BubbleSort {

	public static void main(String[] args) {
		int[] array1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		bubbleSort1(array1);
		int[] array2 = { 1, 0, 2, 3, 4, 5, 6, 7, 8, 9 };
		bubbleSort2(array2);
	}

	/**
	 * 
	 * <p>Title: 基础原理</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月16日 下午2:51:22</p>
	 * @param array
	 */
	public static void bubbleSort1(int[] array) {
		// 1.外层循环，次数为(length-1)
		for (int i = 1; i < array.length; i++) {
			// 2.遍历集合，比较相邻元素大小
			for (int j = 0; j < array.length - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
			System.out.print("第" + i + "次循环执行之后：");
			print(array);
		}
	}
	
	/**
	 * 
	 * <p>Title: 某次遍历没有swap（排序完成），那么下一次也不需要遍历</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月16日 下午3:10:03</p>
	 * @param array
	 */
	private static void bubbleSort2(int[] array) {
		boolean needNextPass = true;
		for (int i = 1; i < array.length && needNextPass; i++) {
			// 1.假设集合排序完毕
			needNextPass = false;
			for (int j = 0; j < array.length - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
					// 2.假如未被执行，集合排序完毕，外层循环结束
					needNextPass = true;
				}
			}
			System.out.print("第" + i + "次循环执行之后：");
			print(array);
		}
	}
	
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print("\n");
	}
}
