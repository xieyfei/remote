package com.xie.leetcode.findClosestElements658;

import java.util.LinkedList;
import java.util.List;

public class Solution3 {

    public static void main(String[] args) {
        Solution3 s = new Solution3();
//        int[] arr = {1,2,3,4,5};
        int[] arr = {1,1,2,2,2,2,2,3,3};
        System.out.println(s.findClosestElements(arr, 3, 3));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> list = new LinkedList<>();
        for (int i = left; i < left + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
