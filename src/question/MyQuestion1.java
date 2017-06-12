package question;

/**
 * @moudle: MyQuestion1
 * @version:v1.0
 * @Description: 要求不能创建任何新的结点，只调整指针的指向
 * @date: 2017年5月15日 下午2:09:13
 *
 */
public class MyQuestion1 {
	
	public static void main(String[] args) {
		MyQuestion1 q = new MyQuestion1();
		Integer[] array = {10, 6, 14, 4, 8, 12, 16};
		
		BSTree<Integer> bs = q.new BSTree<>(array);
		
		bs.inorderForLinked(bs.root);
		
		BSTree<Integer>.TreeNode<Integer> temp = bs.head;
		for (int i = 0; i < 10; i++) {
			if (temp != null) {
				System.out.println(temp.element);
				temp = temp.right;
			}
		}
		BSTree<Integer>.TreeNode<Integer> t =  bs.tail;
		for (int i = 0; i < 10; i++) {
			if (t != null) {
				System.out.println(t.element);
				t = t.left;
			}
		}
	}

	/**
	 * 
	 * @moudle: 二叉排序树
	 * @version:v1.0
	 * @Description: TODO
	 * @author: xukai
	 * @date: 2017年5月15日 下午6:49:15
	 *
	 */
	class BSTree<E extends Comparable<E>> {

		TreeNode<E> root;
		
		TreeNode<E> head;	// 头
		TreeNode<E> tail; // 尾

		public BSTree(E[] array) {
			for (int i = 0; i < array.length; i++) {
				insert(array[i]);
			}
		}

		public boolean insert(E e) {
			if (root == null)
				root = createNewNode(e);
			else {
				TreeNode<E> current = root;
				TreeNode<E> parent = null;

				while (current != null) {
					if (e.compareTo(current.element) > 0) {
						parent = current;
						current = parent.right;
					} else if (e.compareTo(current.element) < 0) {
						parent = current;
						current = current.left;
					} else {
						return false;
					}
				}
				
				if (e.compareTo(parent.element) > 0) {
					parent.right = createNewNode(e);
				} else {
					parent.left = createNewNode(e);
				}
			}
			return true;
		}

		private TreeNode<E> createNewNode(E e) {
			return new TreeNode<E>(e);
		}
		
		/**
		 * 
		 * <p>Title: 当前节点->链尾<br>tail.rigth==current&&current.left==tail</p>
		 * <p>author : xukai</p>
		 * <p>date : 2017年5月15日 下午7:26:13</p>
		 * @param current
		 */
		public void transformToLinkedList(TreeNode<E> current) {
			// 1.将尾的pre指向
			current.left = tail;
			if (tail != null) {
				tail.right = current;
			} else {
				head = current;
			}
			tail = current;
		}
		
		public void inorderForLinked(TreeNode<E> node) {
			if (node == null) 
				return ;
			inorderForLinked(node.left);
			transformToLinkedList(node);
			inorderForLinked(node.right);
		}

		/**
		 * 
		 * @moudle: 树节点
		 * @version:v1.0
		 * @Description: TODO
		 * @author: xukai
		 * @date: 2017年5月15日 下午6:49:03
		 *
		 * @param <E>
		 */
		@SuppressWarnings("hiding")
		class TreeNode<E> {
			E element;
			TreeNode<E> left;
			TreeNode<E> right;

			public TreeNode(E element) {
				this.element = element;
			}
		}
	}

}
