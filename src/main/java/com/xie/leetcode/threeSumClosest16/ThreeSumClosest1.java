package com.xie.leetcode.threeSumClosest16;

import java.util.Arrays;

public class ThreeSumClosest1 {

    public static void main(String[] args) {
        // [1,2,4,8,16,32,64,128]
        // 82
        int[] nums = {1,2,4,8,16,32,64,128};
        threeSumClosest(nums, 82);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        int dis = Math.abs(target - closest);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            int ta = target - nums[i];
            int sum;
            int sumDis;
            while (j < k) {
                sum = nums[j] + nums[k];
                if (sum > ta) {
                    k--;
                } else if (sum < ta) {
                    j++;
                } else {
                    return sum;
                }
                sumDis = Math.abs(ta - sum);
                if (sumDis < dis) {
                    closest = sum + nums[i];
                    dis = sumDis;
                }
            }
        }
        return closest;
    }
}
