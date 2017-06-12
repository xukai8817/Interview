package question;

import com.edu.chapter.twenty_six.day0416.BinaryTree;
import com.edu.chapter.twenty_six.day0416.BinaryTree.TreeNode;

/**
 * @moudle: MyQuestion11
 * @version:v1.0
 * @Description: 求一棵二叉树中相距最远的两个节点之间的距离
 * @author: xukai
 * @date: 2017年5月24日 下午9:05:56
 *
 */
public class MyQuestion11 {

	public static void main(String[] args) {
		Integer[] array = { 5, 3, 7, 2, 4, 6, 8 };
		BinaryTree<Integer> bt = new BinaryTree<>(array);
		MyQuestion11 q = new MyQuestion11();
		System.out.println(q.getDistance(bt.getRoot()));
		System.out.println(q.maxDistance(bt.getRoot()));
		Integer[] array2 = { 5, 1, 10, 2, 3, 11 };
		BinaryTree<Integer> bt2 = new BinaryTree<>(array2);
		System.out.println(q.getDistance(bt2.getRoot()));
		System.out.println(q.maxDistance(bt2.getRoot()));

	}

	private int getDistance(TreeNode<Integer> root) {
		int leftDepth = 0; // 左侧深度
		int rightDepth = 0; // 右侧深度
		if (root.left != null)
			leftDepth = heigh(root.left);
		if (root.right != null)
			rightDepth = heigh(root.right);
		return Math.max(leftDepth, Math.max(rightDepth, leftDepth + rightDepth));
	}

	private int heigh(TreeNode<Integer> node) {
		if (node == null)
			return 0;
		return Math.max(heigh(node.left), heigh(node.right)) + 1;
	}

	public int maxDistance(TreeNode<Integer> root) {
		MyInteger my = new MyInteger(0);
		return helper(root, my);
	}

	private int helper(TreeNode<Integer> root, MyInteger my) {
		if (root == null) {
			my = new MyInteger(0);
			return 0;
		}
		MyInteger ld = new MyInteger(0);
		MyInteger rd = new MyInteger(0);
		int maxleft = helper(root.left, ld);
		int maxRight = helper(root.right, rd);
		my.element = Math.max(ld.element, rd.element) + 1;
		return Math.max(maxleft, Math.max(maxRight, ld.element + rd.element));
	}

	class MyInteger {

		int element;

		public MyInteger(int element) {
			super();
			this.element = element;
		}
	}

}
