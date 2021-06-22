package com.xk.collection.list;

import java.util.Iterator;
import java.util.List;

import com.collection.arraylist.ArrayList;

public class ListRemove {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		// 1.异常
		//exception(list);
		solve1(list);
	}
	
	public static void exception(List<String> list) {
		List<String> l = new java.util.ArrayList<>(list);
		for(Iterator<String> iterator = l.iterator(); iterator.hasNext();) {
			if (iterator.next() == "b") {
				l.remove(iterator.next());
			}
		}
	}
	
	// 使用迭代器的remove方法
	public static void solve1(List<String> list) {
		List<String> l = new java.util.ArrayList<>(list);
		for(Iterator<String> iterator = l.iterator(); iterator.hasNext();) {
			if (iterator.next() == "b") {
				iterator.remove();
			}
		}
		System.out.println(l);
	}
	
	// 从后面循环
	public static void solve2(List<String> list) {
		List<String> l = new java.util.ArrayList<>(list);
		for(int i = list.size(); i >= 0; i--) {
			if(l.get(i) == "b") 
				l.remove(i);
		}
		System.out.println(l);
	}
	
}
