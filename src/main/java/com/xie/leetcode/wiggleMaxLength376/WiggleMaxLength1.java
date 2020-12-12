package com.xie.leetcode.wiggleMaxLength376;

public class WiggleMaxLength1 {

    public int wiggleMaxLength(int[] nums) {
        Boolean nextUp = null;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nextUp == null) {
                if (nums[i] > nums[i - 1]) {
                    nextUp = false;
                    count = 2;
                } else if (nums[i] < nums[i - 1]) {
                    nextUp = true;
                    count = 2;
                }
            } else if (nextUp) {
                if (nums[i] > nums[i - 1]) {
                    nextUp = false;
                    count++;
                }
            } else {
                if (nums[i] < nums[i - 1]) {
                    nextUp = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        WiggleMaxLength1 w = new WiggleMaxLength1();
        System.out.println(w.wiggleMaxLength(new int[]{1,7,4,9,2,5}));
    }
}
