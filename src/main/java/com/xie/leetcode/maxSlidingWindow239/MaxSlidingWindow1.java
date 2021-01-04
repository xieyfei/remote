package com.xie.leetcode.maxSlidingWindow239;

import java.util.Arrays;
import java.util.LinkedList;

public class MaxSlidingWindow1 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1 || k == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        len = len > 0 ? len : 1;
        int[] ret = new int[len];
        int idx = 0;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i >= k && !list.isEmpty()) {
                ret[idx++] = list.peekFirst();
                if (nums[i - k] == list.peekFirst()) {
                    list.removeFirst();
                }
            }
            while (!list.isEmpty() && nums[i] > list.peekLast()) {
                list.removeLast();
            }
            list.addLast(nums[i]);
        }
        if (!list.isEmpty()) {
            ret[idx] = list.peekFirst();
        }
        return ret;
    }

    public static void main(String[] args) {
        MaxSlidingWindow1 m = new MaxSlidingWindow1();
        System.out.println(Arrays.toString(m.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(m.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 7)));
        System.out.println(Arrays.toString(m.maxSlidingWindow(new int[]{1,-1}, 1)));
        System.out.println(Arrays.toString(m.maxSlidingWindow(new int[]{7,2,4}, 2)));
        System.out.println(Arrays.toString(m.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
    }
}
