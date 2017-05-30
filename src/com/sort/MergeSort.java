package com.sort;

/**
 * @moudle: MergeSort
 * @version:v1.0
 * @Description: 归并排序:将数组分为两半，对每部分递归归并排序
 * @author: xukai
 * @date: 2017年5月17日 下午4:58:19
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] array = { 2, 9, 5, 4, 1, 6, 7, 6 };
		mergeSort(array);
	}

	/**
	 * 
	 * <p>Title: 1.递归拆除数组</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月17日 下午5:51:16</p>
	 * @param array
	 */
	public static void mergeSort(int[] array) {
		if (array.length > 1) {
			// 1.左侧数组
			int[] arrayLeft = new int[array.length / 2];
			System.arraycopy(array, 0, arrayLeft, 0, array.length / 2);
			mergeSort(arrayLeft);
			
			// 2.右侧数组
			int arrayRightLength = array.length - arrayLeft.length;
			int[] arrayRight = new int[arrayRightLength];
			System.arraycopy(array, array.length / 2, arrayRight, 0, arrayRightLength);
			mergeSort(arrayRight);
			
			// 3.左右侧数组合并
			int[] temp = merge(arrayLeft, arrayRight);
			print(temp);

			// 4.返回已经排序完毕的子数组
			System.arraycopy(temp, 0, array, 0, temp.length);
		} else {
			return;
		}
	}

	/**
	 * 
	 * <p>Title: 合并两个数组</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月17日 下午5:51:33</p>
	 * @param arrayLeft
	 * @param arrayRight
	 * @return
	 */
	private static int[] merge(int[] arrayLeft, int[] arrayRight) {
		int[] temp = new int[arrayLeft.length + arrayRight.length];
		int indexOfLeft = 0;
		int indexOfRight = 0;
		int indexOfTemp = 0;

		while (indexOfLeft < arrayLeft.length && indexOfRight < arrayRight.length) {
			if (arrayLeft[indexOfLeft] < arrayRight[indexOfRight]) {
				temp[indexOfTemp++] = arrayLeft[indexOfLeft++];
			} else {
				temp[indexOfTemp++] = arrayRight[indexOfRight++];
			}
		}

		while (indexOfLeft < arrayLeft.length) {
			// 左侧未遍历完
			temp[indexOfTemp++] = arrayLeft[indexOfLeft++];
		}

		while (indexOfRight < arrayRight.length) {
			// 右侧未遍历完
			temp[indexOfTemp++] = arrayRight[indexOfRight++];
		}

		return temp;
	}

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print("\n");
	}
}
