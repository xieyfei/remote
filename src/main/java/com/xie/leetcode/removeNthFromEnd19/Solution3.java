package com.xie.leetcode.removeNthFromEnd19;



public class Solution3 {

    public static void main(String[] args) {
        Solution3 s = new Solution3();
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
        ListNode tmp = sentinal;
        int step = 0;
        while (tmp != null && step <= n) {
            tmp = tmp.next;
            step++;
        }
        ListNode sec = sentinal;
        while (tmp != null) {
            tmp = tmp.next;
            sec = sec.next;
        }
        sec.next = sec.next.next;
        return sentinal.next;
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
