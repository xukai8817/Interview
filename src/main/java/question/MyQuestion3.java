package question;

/**
 * @moudle: MyQuestion3
 * @version:v1.0
 * @Description: 求所有子数组和的最大值<br>数组中连续的一个或多个整数组成一个子数组
 * @author: xukai
 * @date: 2017年5月15日 上午1:25:12
 *
 */
public class MyQuestion3 {

	public static void main(String[] args) {
		int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
		System.out.println(maxSubarray(array, array.length));
		System.out.println(ben(array, array.length));
		int[] array2 = {1, 3, -1, 4};
		System.out.println(maxSubarray(array2, array2.length));
		System.out.println(ben(array2, array2.length));
		System.out.println(Integer.MAX_VALUE + "," + Integer.MIN_VALUE);
		System.out.println(1<<31);
	}

	/**
	 * 
	 * <p>Title: 复杂度O(n)</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月15日 上午1:58:28</p>
	 * @param a
	 * @param size
	 * @return
	 */
	static int maxSubarray(int a[], int size) {
		if (size <= 0)
			System.out.println("error array size");
		int sum = 0;
		int max = 1 << 31;// -2147483648
		int cur = 0;
		while (cur < size) {
			sum += a[cur++];
			if (sum > max) {
				max = sum;
			} else if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}
	
	/**
	 * 
	 * <p>Title: 最笨的方法</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月15日 上午1:59:40</p>
	 * @param a
	 * @param size
	 * @return
	 */
	static int ben(int a[], int size) {
		int sum = 0;
		int cursor = 0;	// 子数组起始
		while (cursor < size) {
			// i为子数组的长度
			for (int i = 1; i <= a.length; i++) {
				int temp = 0;
				// 去掉(游标地址>=数组长度)
				if (cursor >= i) 
					continue;
				for (int j = cursor; j < i; j++) {
					System.out.print(a[j] + " ");
					temp += a[j];
				}
				System.out.println("cursor:" + cursor);
				if (temp > sum) 
					sum = temp;
			}
			cursor++;
		}
		return sum;
	}
}
