package com.sort;

import java.util.Arrays;

/**
 * @moudle: HeapSort 
 * @version:v1.0
 * @Description: 堆排序
 * @author: xukai
 * @date: 2017年5月21日 下午2:38:36
 *
 */ 
public class HeapSort {

	public static void main(String[] args) {
		Integer[] array = {5, 2, 9, 3, 8, 5, 0, 1, 6, 7};
		heapSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static Integer[] heapSort(Integer[] array) {
		// 1.创建一个堆对象，并初始化完毕
		Heap<Integer> heap = new Heap<>(array);
		// 2.反向遍历数组，从头开始删除
		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = heap.remove();
		}
		return array;
	}
}
