package com.xie.leetcode.merge88;

import java.util.Arrays;

public class Merge3 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m - 1, k = n - 1;
        for (int i = m + n - 1; i >= 0 && j >= 0 && k >= 0; i--) {
            nums1[i] = nums1[j] > nums2[k] ? nums1[j--] : nums2[k--];
        }
        if (k >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, k + 1);
        }
    }

    public static void main(String[] args) {
//        [1,2,4,5,6,0]
//5
//[3]
//1
        Merge3 m = new Merge3();
        int[] nums1 = {0};
        int[] nums2 = {1};
        m.merge(nums1, 0, nums2, 1);

        System.out.println(Arrays.toString(nums1));
    }
}
