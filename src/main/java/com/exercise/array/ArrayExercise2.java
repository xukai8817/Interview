package com.exercise.array;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * @moudle: ArrayExercise2 
 * @version:v1.0
 * @Description: 		
 * 		int[] set1 = {1, 2, 3};
		int[] set2 = {1, 3, 5};
		int[] setCombine = {1, 2, 3, 5};
 * @author: xukai
 * @date: 2017年5月11日 下午8:34:03
 *
 */ 
public class ArrayExercise2 {

	public static void main(String[] args) {
		Integer[] set1 = {1, 2, 3};
		Integer[] set2 = {1, 3, 5};
		Set<Integer> s1 = new TreeSet<>();
		Set<Integer> s2 = new TreeSet<>();
		Collections.addAll(s1, set1);
		Collections.addAll(s2, set2);
		s1.addAll(s2);
		System.out.println(s1);
		test();
		t();
	}
	
	
	public static void test() {
		int[] set1 = {1, 2, 3};
		int[] set2 = {1, 3, 5};
		int[] setCombine = new int[set1.length+set2.length];
		System.out.println(setCombine[0]);
		for (int i = 0; i < setCombine.length; i++) {
			System.out.print(setCombine[i]);
		}
		System.arraycopy(set1, 0, setCombine, 0, set1.length);
		System.arraycopy(set2, 0, setCombine, set1.length, set2.length);
		
		for(int i = 0; i < setCombine.length; i++) {
			for (int j = 0; j < setCombine.length - 1; j++) {
				if (setCombine[j] > setCombine[j+1]) {
					int temp = setCombine[j] ;
					setCombine[j]  = setCombine[j+1];
					setCombine[j+1] = temp;
				} else if (setCombine[j] == setCombine[j+1]) {
					setCombine[j+1] = 0;
				}
			}
		}
		
		for (int i = 0; i < setCombine.length; i++) {
			System.out.print(setCombine[i]);
		}
	}
	
	private static void t() {
		int[] set1 = {1, 2, 3};
		int[] set2 = {1, 3, 5};
		Integer[] integer1 = new Integer[set1.length];
		Integer[] integer2 = new Integer[set2.length];
		for(int i = 0; i < set1.length; i++) {
			integer1[i] = new Integer(set1[i]);
		}
		for(int j = 0; j < set2.length; j++) {
			integer2[j] = new Integer(set2[j]);
		}
		Set<Integer> treeSet1 = new TreeSet<Integer>();
		Set<Integer> treeSet2 = new TreeSet<Integer>();
		Collections.addAll(treeSet1, integer1);
		Collections.addAll(treeSet2, integer2);
		treeSet1.addAll(treeSet2);
		System.out.println(treeSet1);
	}
}
