package com.xie.leetcode.candy135;

import java.util.PriorityQueue;

public class Candy1 {

    public int candy(int[] ratings) {
        int len = ratings.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int start = 0;
        Boolean up = null;
        for (int idx = 0; idx < len - 1; idx++) {
            if (ratings[idx] > ratings[idx + 1]) {
                if (up == null) {
                    up = false;
                    start = idx;
                } else if (up) {
                    up = false;
                    queue.add(new int[]{idx - start, start});
                    start = idx;
                }
            } else if (ratings[idx] < ratings[idx + 1]) {
                if (up == null) {
                    up = true;
                    start = idx;
                } else if (!up) {
                    up = true;
                    queue.add(new int[]{idx - start, start});
                    start = idx;
                }
            } else {
                if (up != null) {
                    queue.add(new int[]{idx - start, start});
                    start = idx;
                }
                up = null;
            }
        }
        if (up != null) {
            queue.add(new int[]{len - 1 - start, start});
        }
        int[] candyArr = new int[len];
        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            int idx = ints[1];
            int size = ints[0];
            if (ratings[idx] < ratings[idx + 1]) {
                if (candyArr[idx] == 0) {
                    candyArr[idx] = 1;
                }
                for (int i = idx + 1; i <= size + idx; i++) {
                    if (candyArr[i] == 0) {
                        candyArr[i] = candyArr[i - 1] + 1;
                    }
                }
            } else {
                if (candyArr[idx + size] == 0) {
                    candyArr[idx + size] = 1;
                }
                for (int i = idx + size - 1; i >= idx; i--) {
                    if (candyArr[i] == 0) {
                        candyArr[i] = candyArr[i + 1] + 1;
                    }
                }
            }
        }
        int count = 0;
        for (int c : candyArr) {
            if (c == 0) {
                count++;
            } else {
                count += c;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Candy1 c = new Candy1();
//        System.out.println(c.candy(new int[]{1,0,2}));
//        System.out.println(c.candy(new int[]{1,2,2}));
//        System.out.println(c.candy(new int[]{1,3,4,5,2}));
        System.out.println(c.candy(new int[]{1,2,3,5,4,3,2,1,4,3,2,1}));
    }
}
