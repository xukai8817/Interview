package com.sort;

import java.util.ArrayList;

/**
 * @moudle: 堆类：1.每个结点大于它的所有子结点。2.完全二叉树
 * @version:v1.0
 * @Description: TODO
 * @author: xukai
 * @date: 2017年5月21日 下午1:58:16
 *
 * @param <E>
 */
public class Heap<E extends Comparable<E>> {

	private ArrayList<E> list = new ArrayList<>();

	public Heap() {
	}

	public Heap(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}

	public void add(E object) {
		list.add(object);
		// 1.新元素下标
		int currentIndex = list.size() - 1;

		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2; // 当前结点的父结点

			// 2.新元素大于其父结点,swap
			if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
			} else {
				break;
			}
			
			// 3.向上遍历树
			currentIndex = parentIndex;
		}
	}

	public E remove() {
		// 1.判断是否为空树,if(true) return null
		if (list.size() == 0)
			return null;

		// 2.将最后的元素放置在index=0(根)，并移除原先元素
		E removeObject = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		
		// 3.从头遍历树
		int currentIndex = 0;
		while (currentIndex < list.size()) {
			// 3.1 maxIndex(left,right)
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = leftChildIndex + 1;
			if (leftChildIndex >= list.size())
				break; // 超出范围
			int maxIndex = leftChildIndex; // 默认为左子结点，右子节点可能为空
			if (rightChildIndex < list.size())
				if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) 
					maxIndex = rightChildIndex;
				
			// 3.2 if(current<maxIndex) swap(current, maxIndex)
			if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
				E temp = list.get(maxIndex);
				list.set(maxIndex, list.get(currentIndex));
				list.set(currentIndex, temp);
				currentIndex = maxIndex;
			} else {
				break;
			}
		}
		// 4.返回被删除元素
		return removeObject;
	}
	
	public int getSize() {
		return list.size();
	}
}
