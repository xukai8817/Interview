package com.leetcode;

/**
 * <p>将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。</p>
 *
 * @author xukai
 * @since 2021/6/20 0:04
 */
public class MergeLinkedList {

    public static void main(String[] args) {
        ListNode oddHead = null, evenHead = null;
        ListNode odd = null, even = null;
        for (int i = 0; i < 10; i++) {
            ListNode newNode = new ListNode(i);
            if (i % 2 == 0) {
                if (even != null) {
                    even.next = newNode;
                } else {
                    evenHead = newNode;
                }
                even = newNode;
            } else {
                if (odd != null) {
                    odd.next = newNode;
                } else {
                    oddHead = newNode;
                }
                odd = newNode;
            }
        }
        //oddHead.showList();
        //evenHead.showList();

        mergeByRecursion(oddHead, evenHead).showList();

    }

    public static ListNode mergeByIterate(ListNode l1, ListNode l2) {
        ListNode head = null;
        if (l1 != null && l2 != null) {
            ListNode p = null;
            ListNode p1 = l1, p2 = l2;
            while (p1 != null || p2 != null) {
                if (p1 == null) {
                    p.next = p2;
                    p2 = p2.next;
                    p = p.next;
                    p.next = null;
                    continue;
                }
                if (p2 == null) {
                    p.next = p1;
                    p = p.next;
                    p.next = null;
                    p1 = p1.next;
                    continue;
                }
                if (p1.value < p2.value) {
                    if (p == null) {
                        head = p = p1;
                    } else {
                        p.next = p1;
                        p = p.next;
                    }
                    p1 = p1.next;
                    p.next = null;
                } else {
                    if (p == null) {
                        head = p = p2;
                    } else {
                        p.next = p2;
                        p = p.next;
                    }
                    p2 = p2.next;
                    p.next = null;
                }
            }
        } else if (l1 == null) {
            head = l2;
        } else {
            head = l1;
        }
        return head;
    }

    public static ListNode mergeByRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode node = null;
        if (l1.value < l2.value) {
            l1.next = mergeByRecursion(l1.next, l2);
            node = l1;
        } else {
            l2.next = mergeByRecursion(l1, l2.next);
            node = l2;
        }

        return node;
    }

    static class ListNode {

        public ListNode(Integer value) {
            this.value = value;
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
