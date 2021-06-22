package question;

import java.util.ArrayList;

/**
 * @moudle: MyQuestion2
 * @version:v1.0
 * @Description: 定义栈的数据结构，要求添加一个 min 函数，能够得到栈的最小元素。<br>
 *               要求函数 min、 push 以及 pop 的时间复杂度都是 O(1)
 * @author: xukai
 * @date: 2017年5月15日 上午11:46:08
 *
 */
public class MyQuestion2 {

	public static void main(String[] args) {
		new MyQuestion2();
	}

	public MyQuestion2() {
		MyStack mystack = new MyStack();
		mystack.push(9);
		mystack.push(3);
		mystack.push(5);
		mystack.push(1);
		mystack.push(2);
		mystack.push(1);
		mystack.pop();
		mystack.pop();
		mystack.pop();
		System.out.println(mystack.min());
	}

	class MyStack {
		private ArrayList<Integer> stack;
		private ArrayList<Integer> minStack;

		public MyStack() {
			stack = new ArrayList<>();
			minStack = new ArrayList<>();
		}

		/**
		 * 
		 * <p>Title: 大于栈顶的元素不需要入栈</p>
		 * <p>author : xukai</p>
		 * <p>date : 2017年5月15日 下午2:05:05</p>
		 * @param i
		 */
		public void push(Integer i) {
			if (minStack.isEmpty()) {
				minStack.add(i);
			} else if (minStack.get(minStack.size() - 1) >= i) {
				minStack.add(i);
			}
			stack.add(i);
		}

		public Integer peek() {
			return stack.get(stack.size() - 1);
		}

		public Integer pop() {
			Integer i = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
			if (i.equals(minStack.get(minStack.size() - 1))) {
				minStack.remove(minStack.size() - 1);
			}
			return i;
		}

		public Integer min() {
			return minStack.get(minStack.size() - 1);
		}
	}

}
