package com.xie.leetcode.findInMountainArray1095;

// 0ms
public class FindInMountainArray2 {

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
        int left = 0, right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int tmp = inner(mountainArr, target, 0, left, true);
        if (tmp != -1) return tmp;
        return inner(mountainArr, target, left + 1, mountainArr.length() - 1, false);
    }

    private int inner(MountainArray mountainArr, int target, int left, int right, boolean flag) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            int res;
            if (flag) {
                res = mountainArr.get(mid) - target;
            } else {
                res = target - mountainArr.get(mid);
            }
            if (res < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return mountainArr.get(left) == target ? left : -1;
    }

    public static void main(String[] args) {
        FindInMountainArray2 f = new FindInMountainArray2();
//        System.out.println(f.findInMountainArray(3, new MountainArray(new int[]{0, 1, 2, 4, 2, 1})));
        System.out.println(f.findInMountainArray(0, new MountainArray(new int[]{1,2,3,5,3})));
    }
}
