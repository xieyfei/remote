package com.xie.leetcode.findInMountainArray1095;

import java.util.function.Function;

// 3ms
public class FindInMountainArray1 {

    public static class MountainArray {

        int[] arr;

        public MountainArray(int[] arr) {
            this.arr = arr;
        }

        int length() {
            return arr.length;
        }

        int get(int index) {
            return arr[index];
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int top = inner(0, mountainArr.length() - 1, m -> mountainArr.get(m) - mountainArr.get(m + 1));
        int left = inner(0, top, m -> mountainArr.get(m) - target);
        if (mountainArr.get(left) == target) return left;
        int right = inner(top + 1, mountainArr.length() - 1, m -> target - mountainArr.get(m));
        return mountainArr.get(right) == target ? right : -1;
    }

    private int inner(int left, int right, Function<Integer, Integer> fun) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (fun.apply(mid) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindInMountainArray1 f = new FindInMountainArray1();
        System.out.println(f.findInMountainArray(3, new MountainArray(new int[]{0, 1, 2, 4, 2, 1})));
    }
}
