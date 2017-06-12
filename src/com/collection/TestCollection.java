package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @moudle: TestCollection 
 * @version:v1.0
 * @Description: TODO
 * @author: xukai
 * @date: 2017年5月13日 上午11:33:13
 *
 */ 
public class TestCollection {

	public static void main(String[] args) {
		Collection<String> strs = new ArrayList<>();
		strs.add("1");
		strs.add("2");
		strs.add("3");
		Object[] strArray = Arrays.copyOf(strs.toArray(), strs.size(), Object[].class);
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
	}
	
}
