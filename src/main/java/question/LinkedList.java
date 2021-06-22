package question;

/**
 * @moudle: 单向链表 
 * @version:v1.0
 * @Description: TODO
 * @author: xukai
 * @date: 2017年5月23日 下午4:24:20
 *
 * @param <E>
 */ 
public class LinkedList<E> {
	int size;
	Node<E> head;

	public LinkedList() {
	}

	public LinkedList(E[] array) {
		for (int i = 0; i < array.length; i++) {
			add(array[i]);
		}
	}

	public void add(E e) {
		if (size == 0) {
			head = new Node<E>(e);
		} else {
			Node<E> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node<E>(e);
		}
		size++;
	}

	/**
	 * 
	 *
	 * <p>Title: 链表中无环</p>
	 * <p>author : xukai</p>
	 * <p>date : 2017年5月23日 下午4:11:21</p>
	 * @return
	 */
	@Override
	public String toString() {
		if (head == null)
			return "null";
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		Node<E> current = head;
		for (; current != null; current = current.next) {
			sb.append(current.element);
			if (current.next == null)
				return sb.append(']').toString();
			sb.append(',');
		}
		return sb.toString();
	}

	static class Node<E> {
		E element;
		Node<E> next;

		public Node(E e) {
			element = e;
		}
	}
}
