package question;

import question.LinkedList.Node;

/**
 * @moudle: MyQuestion8 
 * @version:v1.0
 * @Description: TODO
 * @author: xukai
 * @date: 2017年5月23日 下午4:25:51
 *
 */ 
public class MyQuestion8<E> {

	public static void main(String[] args) {
		MyQuestion8<Integer> q = new MyQuestion8<Integer>();
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		LinkedList<Integer> list1 = new LinkedList<Integer>(array);
		Node<Integer> node = q.reverse(list1.head);
		while (node != null) {
			System.out.print(node.element + " ");
			node = node.next;
		}
		LinkedList<Integer> list2 = new LinkedList<Integer>(array);
		node = q.reverseNonrecurisve(list2.head);
		while (node != null) {
			System.out.print(node.element + " ");
			node = node.next;
		}
		System.out.println(q.reverseString("abcd"));
		int[] numArray = new int[1001];
		for (int i = 1; i < numArray.length; i++) {
			numArray[i] = i;
		}
		numArray[0] = 2;
		System.out.println(q.getNum(numArray));
		
		LinkedList<Integer> list3 = new LinkedList<Integer>(array);
		node = q.reverse2(list3.head);
		while (node != null) {
			System.out.print(node.element + " ");
			node = node.next;
		}
	}
	
	/**
	 * 
	 * <p>Title: 颠倒一个无环链接表的顺序，递归</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月23日 下午4:26:50</p>
	 * @param list
	 * @return
	 */
	public Node<E> reverse(Node<E> current) {
		// 1.空树、或者树尾，返回树尾
		if (current == null || current.next == null)
			return current;
		// 2.递归返回树尾
		Node<E> tail = reverse(current.next);
		// 3.reverse
		current.next.next = current;
		// 4.取消之前的指向
		current.next = null;
		return tail;
	}
	/**
	 * 
	 * <p>Title: 颠倒一个无环链接表的顺序，不用递归</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月23日 下午4:26:50</p>
	 * @param list
	 * @return
	 */
	public Node<E> reverseNonrecurisve(Node<E> head) {
		if (head == null)
			return head;
		Node<E> prevoius = null;
		while (head.next != null) {
			// 1.保存当前结点指向的下一结点
			Node<E> nextNode = head.next;
			// 2.将当前结点的下一节点指向prevoius
			head.next = prevoius;
			// 3.将当前结点设置为prevoius
			prevoius = head;
			// 4.当前结点向后移动
			head = nextNode;
		}
		head.next = prevoius; // 最后一个结点
		return head;
	}
	
	/**
	 * 面试题
	 * <p>Title: reverse2</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年6月13日 上午1:05:21</p>
	 * @param current
	 * @return
	 */
	public Node<E> reverse2(Node<E> current) {
		Node<E> pre = null;
		while(current != null) {
			// 1.保存当前元素指向的对象
			Node<E> next = current.next;
			// 2.当前元素指向pre
			current.next = pre;
			// 3.将当前对象赋给pre
			pre = current;
			// 4.向后移动
			current = next;
		}
		return pre;
	}
	
	/**
	 * 反转字符串
	 * <p>Title: reverseString</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月24日 上午11:37:50</p>
	 * @param str
	 * @return
	 */
	public String reverseString(String str) {
		char[] array = str.toCharArray();
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			swap(array, low, high);
			low++;
			high--;
		}
		return new String(array);
	}

	private void swap(char[] array, int low, int high) {
		char c = array[low];
		array[low] = array[high];
		array[high] = c;
	}

	/**
	 * 
	 * <p>Title: 1~1000&&array.length=1001<br>
	 * 		1+2+...+n = n(n+1)/2</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月24日 上午11:49:48</p>
	 * @param array
	 * @return
	 */
	public int getNum(int[] array) {
		int s1 = 0;
		int s2 = 1000 * 1001 / 2;
		for (int i = 0; i < array.length; i++) {
			s1 += array[i];
		}
		return s1 - s2;
	}
}
