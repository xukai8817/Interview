package com.exercise.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @moudle: StringQuestion 
 * @version:v1.0
 * @Description: TODO
 * @author: xukai
 * @date: 2017年6月12日 上午10:50:17
 *
 */ 
public class StringQuestion {

	public static void main(String[] args) {
		new StringQuestion().getCount(" HelloWorld！ 2017-6-12 10:53:42").getSubString("abdcabdc");
	}
	
	/**
	 * 输入一行字符，分别统计出其中字母、空格、数字和其他字符的个数
	 * <p>Title: getCount</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年6月12日 上午10:51:09</p>
	 * @param str
	 */
	public StringQuestion getCount(String str) {
		int letterCount = 0;
		int spaceCount = 0;
		int digitCount = 0;
		int otherCount = 0;
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isLetter(c))
				letterCount++;
			else if (Character.isWhitespace(c))
				spaceCount++;
			else if (Character.isDigit(c))
				digitCount++;
			else 
				otherCount++;
		}
		System.out.println("字母个数为：" + letterCount);
		System.out.println("空格个数为：" + spaceCount);
		System.out.println("数字个数为：" + digitCount);
		System.out.println("其他字符个数为：" + otherCount);
		return this;
	}
	
	/**
	 * 打印子字符串和次数
	 * <p>Title: getSubString</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年6月12日 下午6:41:19</p>
	 * @param str
	 * @return
	 */
	public StringQuestion getSubString(String str) {
		final Map<String, Integer> map = new HashMap<>();
		for (int start = 0; start < str.length(); start++) {
			for (int end = start + 1; end - start <= 3 && end < str.length(); end++) {
				String sub = str.substring(start, end);
				if (map.containsKey(sub)) {
					map.put(sub, map.get(sub) + 1);
				} else {
					map.put(sub, 1);
				}
			}
		}
		List<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int count1 = map.containsKey(o1) ? map.get(o1) : 0;
				int count2 = map.containsKey(o2) ? map.get(o2) : 0;
				return count1 == count2 ? o1.compareTo(o2) : count2 - count1;
			}
		});
		for (String string : list) {
			System.out.println(string + " " + map.get(string));
		}
		return this;
	}
}
