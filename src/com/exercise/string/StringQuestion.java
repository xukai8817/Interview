package com.exercise.string;

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
		new StringQuestion().getCount(" HelloWorld！ 2017-6-12 10:53:42");
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
}
