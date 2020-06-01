package com.xie.leetcode.removeNthFromEnd19;



public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode res = s.removeNthFromEnd(l1, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        int size = 0;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        if (size == n) {
            return head.next;
        }
        tmp = head;
        int k = size - n - 1;
        int i = 0;
        while (i < k) {
            i++;
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
