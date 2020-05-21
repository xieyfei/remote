package com.xie.leetcode.findClosestElements658;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr = {};
        System.out.println(s.findClosestElements(arr, 4, 3));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int i = left - 1;
        int j = left;
        int count = 0;
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        while (i >= 0 && j < arr.length && count < k) {
            if (x - arr[i] <= arr[j] - x) {
                leftList.add(i--);
            } else {
                rightList.add(j++);
            }
            count++;
        }
        while (count < k) {
            if (i >= 0) {
                leftList.add(i--);
            } else {
                rightList.add(j++);
            }
            count++;
        }
        List<Integer> list = new LinkedList<>();
        for (int h = leftList.size() - 1; h >= 0; h--) {
            list.add(arr[leftList.get(h)]);
        }
        for (int h = 0; h < rightList.size(); h++) {
            list.add(arr[rightList.get(h)]);
        }
        return list;
    }
}
