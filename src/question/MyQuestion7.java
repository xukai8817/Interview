package question;

import question.LinkedList.Node;

/**
 * @moudle: MyQuestion7
 * @version:v1.0
 * @Description: 给出俩个单向链表的头指针，比如 h1， h2，判断这俩个链表是否相交
 * @author: xukai
 * @date: 2017年5月23日 上午11:18:28
 *
 */
public class MyQuestion7<E> {

	public static void main(String[] args) {
		MyQuestion7<Integer> q = new MyQuestion7<>();
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		LinkedList<Integer> list1 = new LinkedList<Integer>(array);
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.head = list1.head.next;
		System.out.println(list1.toString());
		System.out.println(list2.toString());
		System.out.println(q.isJoinSimple(list1, list2));
		
		// 两个环链表9->4
		LinkedList<Integer> list3 = new LinkedList<Integer>(array);
		Node<Integer> cursor = list3.head;
		for (int i = 0; i < list3.size; i++) {
			cursor = cursor.next;
		}
		cursor = list3.head.next.next.next;
		cursor = list3.head;
		for (int i = 0; i < list3.size; i++) {
			System.out.print(cursor.element + " ");
			cursor = cursor.next;
		}
		LinkedList<Integer> list4 = new LinkedList<Integer>();
		list4.head = list3.head.next.next;	// 从3开始
		System.out.println("3、4有交集环," + q.isJoin(list3, list4));
		list4 =new LinkedList<>(array);
		System.out.println("3有环，4无环," + q.isJoin(list3, list4));
		cursor = list4.head;
		while (cursor != null) {
			cursor = cursor.next;
		}
		cursor = list4.head.next;
		System.out.println("3有环，4有环，无交集," + q.isJoin(list3, list4));
	}
	/**
	 * 
	 * <p>Title: 两个链表中都没有环</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月23日 下午12:15:02</p>
	 * @param list1
	 * @param list2
	 * @return
	 */
	public boolean isJoinSimple(LinkedList<E> list1, LinkedList<E> list2) {
		while (list1.head.next != null)
			list1.head = list1.head.next;
		while (list2.head.next != null)
			list2.head = list2.head.next;
		// 链表尾不同，说明无交集
		return list1.head == list2.head;
	}

	public boolean isJoin(LinkedList<E> list1, LinkedList<E> list2) {
		Node<E> cylic1 = isCylic(list1);
		Node<E> cylic2 = isCylic(list2);
		// 1.无相遇点，均无环
		if (cylic1 == null && cylic2 == null)
			return isJoinSimple(list1, list2);
		// 2.其中一个有环，不可能有交集
		if ((cylic1 != null && cylic2 == null) || (cylic1 == null && cylic2 != null)) {
			return false;
		}
		// 3.两个都存在环，cylic1和cylic2必定位于环中
		Node<E> p = cylic1;
		while (true) {
			if (p == cylic2 || p.next == cylic2)
				return true;
			p = p.next.next; // 双步遍历
			cylic1 = cylic1.next; // 单步遍历
			if (p == cylic1)	// 遍历一周，未找到
				return false;
		}
	}
	
	/**
	 * 
	 * <p>Title: 判断是否有环，返回相遇点</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月23日 下午12:18:57</p>
	 * @param list
	 * @return
	 */
	public Node<E> isCylic(LinkedList<E> list) {
		Node<E> p = list.head;	// 单步遍历
		Node<E> q = list.head;	// 双步遍历
		while (q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
			if (p == q)
				return p;
		}
		return null;
	}

}
