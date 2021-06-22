package question;

/**
 * @moudle: MyQuestion9
 * @version:v1.0
 * @Description: 判断整数序列是不是二元查找树的后序遍历结果
 * @author: xukai
 * @date: 2017年5月24日 下午3:31:30
 *
 */
public class MyQuestion9 {

	public static void main(String[] args) {
		int[] array = { 5, 7, 6, 9, 11, 10, 8 };
		MyQuestion9 q = new MyQuestion9();
		System.out.println(q.isPostOrderResult(array, 0, array.length - 1));
		int[] array2 = { 7, 4, 6, 5 };
		System.out.println(q.isPostOrderResult(array2, 0, array2.length - 1));
	}

	/**
	 * 
	 * <p>Title: isPostOrderResult</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月24日 下午3:55:31</p>
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean isPostOrderResult(int[] array, int start, int end) {
		if (array == null)
			return false;
		if (start > end)
			return false;
		return confirm(array, start, end);
	}

	/**
	 * 分治思想判断：
	 * 5, 7, 6, 9, 11, 10, 8
	 * 5, 7, 6 && 9, 11, 10
	 * 5, 7, 6
	 * <p>Title: confirm</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月24日 下午4:56:47</p>
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private boolean confirm(int[] array, int start, int end) {
		if (end == start) {
			return true;
		}
		int root = array[end];

		boolean left = false;
		boolean right = false;

		int leftCursor = start;
		int rightCursor = end - 1;

		while (array[leftCursor] < root) {
			leftCursor++;
		}
		int newEnd = leftCursor - 1;
		if (newEnd < start || newEnd > end) {
			return false;
		}
		left = confirm(array, start, newEnd);

		while (array[rightCursor] > root) {
			rightCursor--;
		}
		int newStart = rightCursor + 1;
		if (newStart > end - 1 || newStart < start)
			return false;
		right = confirm(array, newStart, end - 1);

		return left && right;
	}
}
