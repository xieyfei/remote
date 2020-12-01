package com.xie.leetcode.merge88;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Merge1 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Deque<Integer> queue = new ArrayDeque<>(m);
        int j = 0;
        for (int i = 0; i < m; i++) {
            if (j < n && nums1[i] > nums2[j] && (queue.isEmpty() || nums2[j] < queue.getFirst())) {
                queue.addLast(nums1[i]);
                nums1[i] = nums2[j++];
            } else if (!queue.isEmpty() && nums1[i] > queue.getFirst()) {
                queue.addLast(nums1[i]);
                nums1[i] = queue.removeFirst();
            }
        }
        for (int i = m; i < m + n; i++) {
            if (j < n && !queue.isEmpty()) {
                if (nums2[j] < queue.getFirst()) {
                    nums1[i] = nums2[j++];
                } else {
                    nums1[i] = queue.removeFirst();
                }
            } else if (j < n) {
                nums1[i] = nums2[j++];
            } else {
                nums1[i] = queue.removeFirst();
            }
        }
    }

    public static void main(String[] args) {
//        [1,2,4,5,6,0]
//5
//[3]
//1
        Merge1 m = new Merge1();
        int[] nums1 = {1,2,4,5,6,0};
        int[] nums2 = {3};
        m.merge(nums1, 5, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
