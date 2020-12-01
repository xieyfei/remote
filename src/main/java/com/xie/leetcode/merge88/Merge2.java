package com.xie.leetcode.merge88;

import java.util.Arrays;

public class Merge2 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int i = 0, j = 0;
        for (int k = 0; k < m + n; k++) {
            if (i < m && j < n) {
                if (nums1_copy[i] < nums2[j]) {
                    nums1[k] = nums1_copy[i++];
                } else {
                    nums1[k] = nums2[j++];
                }
            } else if (i < m) {
                nums1[k] = nums1_copy[i++];
            } else {
                nums1[k] = nums2[j++];
            }
        }
    }

    public static void main(String[] args) {
//        [1,2,4,5,6,0]
//5
//[3]
//1
        Merge2 m = new Merge2();
        int[] nums1 = {1,2,4,5,6,0};
        int[] nums2 = {3};
        m.merge(nums1, 5, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
