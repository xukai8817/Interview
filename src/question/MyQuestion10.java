package question;

/**
 * @moudle: MyQuestion10
 * @version:v1.0
 * @Description: 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变<br>
 *               I am a student.<br>
 *               student. a am I<br>
 * @author: xukai
 * @date: 2017年5月24日 下午5:03:26
 *
 */
public class MyQuestion10 {

	public static void main(String[] args) {
		String str = "I am a student.";
		System.out.println(reverse(str));
		String str2 = "I am a student.";
		jiekou.reverseSentence(str2);
		System.out.println(str2);
		jiekou.reverseSentence1(str2);
		System.out.println(str2);
	}

	private static String reverse(String str) {
		StringBuilder result = new StringBuilder();
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String[] array = new String(sb).split(" ");
		for (int i = 0; i < array.length; i++) {
			result.append(new StringBuffer(array[i]).reverse());
			result.append(" ");
		}
		return result.substring(0, result.length() - 1).toString();
	}

	static class jiekou {

		public static void reverseSentence(String sentence) {
			if (sentence == null)
				return;
			String[] str = sentence.split(" ");
			System.out.println("str.length=" + str.length);
			StringBuffer sb = new StringBuffer();
			for (int i = str.length - 1; i >= 0; i--) {
				sb.append(str[i] + " ");
			}
			System.out.println(sb);
		}

		public static void reverseSentence1(String sentence) {
			System.out.println("第二个方法");
			if (sentence == null)
				return;
			String sentenceReverse = reverse(sentence);
			String[] splitStrings = sentenceReverse.split(" ");
			String resultBuffer = "";
			for (String s : splitStrings)
				resultBuffer = resultBuffer + reverse(s) + " ";
			System.out.println(resultBuffer);
		}

		public static String reverse(String str) {
			char[] array = str.toCharArray();
			for (int i = 0; i < (array.length) / 2; i++) {
				char temp = array[i];
				array[i] = array[array.length - 1 - i];
				array[array.length - i - 1] = temp;
			}
			return String.valueOf(array);
		}
	}
}
