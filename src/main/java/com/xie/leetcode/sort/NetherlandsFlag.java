package com.xie.leetcode.sort;

import java.util.Arrays;

public class NetherlandsFlag {

    public static int[] solution(int[] arr, int left, int right, int num) {
        int i = left;
        while (i <= right) {
            if (arr[i] < num) {
                swap(arr, i++, left++);
            } else if (arr[i] > num) {
                swap(arr, i, right--);
            } else {
                i++;
            }
        }
        return new int[]{left, right};
    }

    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < p) {
                swap(arr, ++less, l++);
            } else if (arr[l] > p) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        return new int[] { less + 1, more - 1 };
    }

    private static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArray();
        int[] tmp = Arrays.copyOf(test, test.length);
        printArray(test);
        int[] res = solution(test, 0, test.length - 1, 1);
        int[] res2 = partition(tmp, 0, test.length - 1, 1);
        printArray(test);
        printArray(tmp);
        System.out.println(res[0]);
        System.out.println(res[1]);

        System.out.println(res2[0]);
        System.out.println(res2[1]);

    }
}
