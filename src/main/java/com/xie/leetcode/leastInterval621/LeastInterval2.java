package com.xie.leetcode.leastInterval621;

import java.util.Arrays;
// error answer
public class LeastInterval2 {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] counts = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
        }
        Integer[] sort = new Integer[26];
        int countGreater = 0;
        for (int i = 0; i < counts.length; i++) {
            sort[i] = i;
            if (counts[i] > 0) {
                countGreater++;
            }
        }
        Arrays.sort(sort, (o1, o2) -> counts[o2] - counts[o1]);
        int ret = 0;
        int end = countGreater;
        while (countGreater > 0) {
            int idx = 0;
            int i = 0;
            for (; i <= n; i++) {
                while (idx < end && counts[sort[idx]] <= 0) {
                    idx++;
                }
                if (idx < end) {
                    counts[sort[idx]]--;
                    if (counts[sort[idx]] == 0) {
                        countGreater--;
                    }
                    idx++;
                } else {
                    break;
                }
            }
            if (countGreater > 0) {
                ret += n + 1;
            } else {
                ret += i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeastInterval2 a = new LeastInterval2();
//        System.out.println(a.leastInterval(new char[]{'D','D','D','B','B','B'}, 2));
//        System.out.println(a.leastInterval(new char[]{'A','A','A','B','B','B','C'}, 2));
        System.out.println(a.leastInterval(new char[]{'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'}, 2));
    }
}
