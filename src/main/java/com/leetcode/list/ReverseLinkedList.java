package com.leetcode.list;

/**
 * 单链表反转
 *
 * @author xukai
 * @since 2021/6/20 17:32
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        System.out.println("初始化完毕");
        n1.showList();

        System.out.println("迭代反转一次");
        ListNode iterateHead = reverseByIterate(n1);
        if (iterateHead != null) {
            iterateHead.showList();
        }

        System.out.println("递归再反转一次");
        ListNode recursionHead = reverseByRecursion(iterateHead);
        if (recursionHead != null) {
            recursionHead.showList();
        }
    }

    private static ListNode reverseByRecursion(ListNode current) {
        if (current == null || current.next == null) {
            return current;
        }
        // 1.递归查询新的头节点
        ListNode newHead = reverseByRecursion(current.next);
        // 2.从新的头节点开始反转
        current.next.next = current;
        current.next = null;
        return newHead;
    }

    private static ListNode reverseByIterate(ListNode n1) {
        ListNode current = n1;
        ListNode next, pre = null;
        while (current != null) {
            // 1.保留next引用
            next = current.next;
            // 2.指针反转
            current.next = pre;
            // 3.保留pre引用为已反转节点
            pre = current;
            // 4.继续循环
            current = next;
        }
        return pre;
    }

    static class ListNode {

        public ListNode(Integer value) {
            this.value = value;
        }

        public ListNode(Integer value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        private Integer value;

        private ListNode next;

        public void showList() {
            System.out.println("节点值：" + value);
            if (next != null) {
                next.showList();
            }
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

}
