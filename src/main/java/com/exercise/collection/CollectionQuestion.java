package com.exercise.collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * @moudle: 合并集合 
 * @version:v1.0
 * @Description: TODO
 * @author: xukai
 * @date: 2017年6月12日 上午11:18:44
 *
 */ 
public class CollectionQuestion {

	public static void main(String[] args) {
		int[] array1 = {1, 2, 3};
		int[] array2 = {2, 3, 5, 8};
		new CollectionQuestion().hebin(array1, array2);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CollectionQuestion hebin(int[] array1, int[] array2) {
		Set s1 = new TreeSet<>();
		for(int i = 0; i < array1.length; i++) {
			s1.add(array1[i]);
		}
		for(int i = 0; i < array2.length; i++) {
			s1.add(array2[i]);
		}
		System.out.println(s1);
		return this;
	}
}
