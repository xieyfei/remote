package com.xie.leetcode.sort;

public class HeapSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
//        for (int i = 1; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    private static void heapInsert(int[] arr, int index) {
        int parent;
        while (arr[index] > arr[parent = (index - 1) / 2]) {
            swap(arr, index, parent);
            index = parent;
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int heapLeft = index * 2 + 1;
        while (heapLeft < heapSize) {
            int largest = heapLeft + 1 < heapSize && arr[heapLeft] < arr[heapLeft + 1] ? heapLeft + 1 : heapLeft;
            largest = arr[index] < arr[largest] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            heapLeft = largest * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
