package com.xie.leetcode.peakIndexInMountainArray852;

public class PeakIndexInMountainArray1 {

    public int peakIndexInMountainArray(int[] arr) {
        return inner(arr, 0, arr.length - 1);
    }

    private int inner(int[] arr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[right]) {
                left = mid + 1;
            } else {
                if (arr[mid] <= arr[left]) {
                    right = mid;
                } else {
                    int lm = inner(arr, left, mid);
                    int rm = inner(arr, mid + 1, right);
                    return arr[lm] > arr[rm] ? lm : rm;
                }
            }
        }
        return left;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray1 p = new PeakIndexInMountainArray1();
        System.out.println(p.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(p.peakIndexInMountainArray(new int[]{0,2,1,0}));
        System.out.println(p.peakIndexInMountainArray(new int[]{0,1,2,1,0}));
        System.out.println(p.peakIndexInMountainArray(new int[]{0,1,2}));
        System.out.println(p.peakIndexInMountainArray(new int[]{2,1,0}));
        System.out.println(p.peakIndexInMountainArray(new int[]{0, 4, 3, 2,1,0}));
    }
}
