package com.exercise.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @moudle: ArrayExercise 
 * @version:v1.0
 * @Description: 找出两个数组之间不同的元素，最多使用一个for循环
 * @author: xukai
 * @date: 2017年4月27日 上午11:15:22
 *
 */ 
public class ArrayExercise {

	public static void main(String[] args) {
		Integer[] obj1 = {1, 2, 3, 4};
		Integer[] obj2 = {2, 3, 4, 5};
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		Collections.addAll(list1, obj1);
		Collections.addAll(list2, obj2);
		List<Integer> tempList = new ArrayList<>(list1);
		tempList.retainAll(list2);
		list1.removeAll(tempList);
		list2.removeAll(tempList);
		System.out.println("list1:" + list1);
		System.out.println("list2:" + list2);
	}
	
}
