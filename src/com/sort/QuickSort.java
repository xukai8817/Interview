package com.sort;

/**
 * @moudle: QuickSort
 * @version:v1.0
 * @Description: 快速排序:任意选择主元元素(默认index=0)，将数组分为两部分，左侧元素小于或等于主元，右侧元素大于主元。递归此规则。
 * @author: xukai
 * @date: 2017年5月17日 下午6:21:08
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] array = { 5, 2, 9, 3, 8, 5, 0, 1, 6, 7 };
		quickSort(array);
		print(array);
	}

	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int firstIndex, int lastIndex) {
		if (firstIndex < lastIndex) {
			int pivotIndex = partition(array, firstIndex, lastIndex);
			quickSort(array, 0, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, lastIndex);
		}
	}

	/**
	 * 
	 * <p>Title: partition</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月20日 上午11:39:50</p>
	 * @param array
	 * @param firstIndex
	 * @param lastIndex
	 * @return
	 */
	private static int partition(int[] array, int firstIndex, int lastIndex) {
		int pivot = array[firstIndex]; // 主元
		int low = firstIndex + 1; // 向前下标
		int high = lastIndex; // 向后下标

		while (low < high) {
			// 当前元素小于等于主元，next
			while (low <= high && array[low] <= pivot)
				low++;

			// 当前元素大于主元，prenext
			while (high >= low && array[high] > pivot)
				high--;

			// low,high未移动，array[low]>pivot && array[high] <= pivot
			if (low < high)
				swap(array, low, high);
		}

		// TODO
		/**
		 * case:
		 * 1.(array[high]==pivot)=true，next
		 * 2.lastIndex - firstIndex == 1
		 */
		while (high > firstIndex && array[high] >= pivot)
			high--; 

		if (array[high] < pivot) {
			// pivot放在中间
			array[firstIndex] = array[high];
			array[high] = pivot;
			return high; // 返回主元新下标
		} else {
			return firstIndex; // 主元下标
		}
	}

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print("\n");
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
