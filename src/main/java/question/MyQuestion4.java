package question;

/**
 * @moudle: MyQuestion4 
 * @version:v1.0
 * @Description: 从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。打印出和与输入整数相等的所有路径。
 * @author: xukai
 * @date: 2017年5月15日 下午11:01:44
 *
 */ 
public class MyQuestion4 {

	public static void main(String[] args) {
		MyQuestion4 q = new MyQuestion4();
		Integer[] array = {10, 5, 4, 12, 7};
		
		BSTree<Integer> bs = q.new BSTree<>(array);
		bs.printPaths(bs.root, 22);
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

		int size;
		
		public BSTree(E[] array) {
			for (int i = 0; i < array.length; i++) {
				insert(array[i]);
			}
		}

		/**
		 * 
		 * <p>Title: 打印路径</p>
		 * <p>author : xukai</p>
		 * <p>date : 2017年5月15日 下午11:15:09</p>
		 * @param root
		 * @param sum
		 */
		public void printPaths(TreeNode<Integer> root, int sum) {
			// 创建路径数组
			int[] path = new int[size];
			helper(root, sum, path, 0);
		}
		
		/**
		 * 
		 * <p>Title: helper</p>
		 * <p>author : xukai</p>
		 * <p>date : 2017年5月15日 下午11:15:33</p>
		 * @param currrent
		 * @param sum	
		 * @param path	元素存放数组
		 * @param index	放入元素的下标
		 */
		private void helper(TreeNode<Integer> currrent, int sum, int[] path, int index) {
			// 1.当前元素放入数组
			path[index++] = currrent.element;
			sum -= currrent.element;
			if (currrent.left == null && currrent.right == null) {
				// 无左右子结点
				if (sum == 0)
					printPath(path, index);
			} else {
				if (currrent.left != null) 
					helper(currrent.left, sum, path, index);
				if (currrent.right != null) 
					helper(currrent.right, sum, path, index);
			}
			// 恢复下标和sum执行前的值
			index--;
			sum += currrent.element;
		}

		private void printPath(int[] path, int index) {
			for (int i = 0; i < index; i++) {
				System.out.print(path[i] + " ");
			}
			System.out.println("top:" + index);
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
			size++;
			return true;
		}

		private TreeNode<E> createNewNode(E e) {
			return new TreeNode<E>(e);
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
