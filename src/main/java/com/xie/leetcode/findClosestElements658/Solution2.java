package com.xie.leetcode.findClosestElements658;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] arr = {1,2,3,4,5};
        System.out.println(s.findClosestElements(arr, 4, -1));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0;
        int j = arr.length - 1;
        int rm = arr.length - k;
        int count = 0;
        while (count < rm) {
            if (Math.abs(x - arr[i]) <= Math.abs(x - arr[j])) {
                j--;
            } else {
                i++;
            }
            count++;
        }
        List<Integer> list = new LinkedList<>();
        for (int h = i; h < i + k; h++) {
            list.add(arr[h]);
        }
        return list;
    }
}
