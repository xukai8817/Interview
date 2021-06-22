package question;

import java.util.Arrays;

/**
 * @moudle: MyQuestion6
 * @version:v1.0
 * @Description: 根据上排给出的十个数，打印出下排数<br>
 *               0 1 2 3 4 5 6 7 8 9<br>
 *               6 2 1 0 0 0 1 0 0 0<br>
 *               规律：0在下排出现了6次
 * @author: xukai
 * @date: 2017年5月22日 下午8:29:48
 *
 */
public class MyQuestion6 {

	public static void main(String[] args) {
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		int[] nextArray = new int[array.length];

		boolean success = false;
		while (!success) {
			success = setArray(array, nextArray);
		}
		System.out.println(Arrays.toString(nextArray));
	}

	private static boolean setArray(int[] array, int[] nextArray) {
		boolean flag = true;
		for (int i = 0; i < nextArray.length; i++) {
			int frequency = getFrequency(nextArray, array[i]);
			if (nextArray[i] != frequency) {
				nextArray[i] = frequency;
				flag = false;
			}
		}
		System.out.println(Arrays.toString(nextArray));
		return flag;
	}

	/**
	 * 
	 * <p>Title: 获取i在数组中出现的次数</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月22日 下午9:00:11</p>
	 * @param array
	 * @param i
	 * @return
	 */
	private static int getFrequency(int[] array, int i) {
		int frequency = 0;
		for (int j = 0; j < array.length; j++) {
			if (array[j] == i) {
				frequency++;
			}
		}
		return frequency;
	}

}
