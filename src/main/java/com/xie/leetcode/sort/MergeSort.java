package com.xie.leetcode.sort;

public class MergeSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp =  new int[right - left + 1];
        int index = 0;
        int p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            tmp[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            tmp[index++] = arr[p1++];
        }
        while (p2 <= right) {
            tmp[index++] = arr[p2++];
        }
        System.arraycopy(tmp, 0, arr, left, right - left + 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
