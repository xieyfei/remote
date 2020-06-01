package com.xie.leetcode.removeNthFromEnd19;



public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode res = s.removeNthFromEnd(l1, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinal = new ListNode();
        sentinal.next = head;
        helper(sentinal, n);
        return sentinal.next;
    }

    private int helper(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        int revelCount = helper(head.next, n) + 1;
        if (revelCount == n + 1) {
            head.next = head.next.next;
        }
        return revelCount;
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
