package com.xie.leetcode.splitlist86;

public class SplitList1 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode node = head;
        pre = node.val < x ? node : null;
        while (node != null && node.next != null) {
            if (node.next.val < x) {
                if (pre == null) {
                    pre = node.next;
                    node.next = pre.next;
                    pre.next = head;
                    head = pre;
                } else if (pre == node) {
                    node = node.next;
                    pre = node;
                } else {
                    ListNode tmp = node.next;
                    node.next = tmp.next;
                    tmp.next = pre.next;
                    pre.next = tmp;
                    pre = pre.next;
                }
            } else {
                node = node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        SplitList1 s = new SplitList1();
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        head.next = node2;
        node2.next = node3;
        ListNode node = s.partition(head, 4);
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }
}
