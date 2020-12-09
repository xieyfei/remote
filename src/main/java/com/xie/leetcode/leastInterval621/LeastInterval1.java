package com.xie.leetcode.leastInterval621;

import java.util.PriorityQueue;

public class LeastInterval1 {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] counts = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> counts[o2] - counts[o1]);
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                queue.add(i);
            }
        }
        int ret = 0;
        int[] arr = new int[n + 1];
        while (!queue.isEmpty()) {
            int size = 0;
            for (int i = 0; i <= n && !queue.isEmpty(); i++, size++) {
                arr[i] = queue.poll();
            }
            for (int i = 0; i < size; i++) {
                int idx = arr[i];
                counts[idx]--;
                if (counts[idx] > 0) {
                    queue.offer(idx);
                }
            }
            if (queue.isEmpty()) {
                ret += size;
            } else {
                ret += n + 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeastInterval1 a = new LeastInterval1();
        System.out.println(a.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
}
