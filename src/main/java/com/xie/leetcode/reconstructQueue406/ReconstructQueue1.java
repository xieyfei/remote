package com.xie.leetcode.reconstructQueue406;

import java.util.*;

public class ReconstructQueue1 {

//    [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

    public int[][] reconstructQueue(int[][] people) {
        Map<Integer, List<int[]>> map = new TreeMap<>();
        for (int[] person : people) {
            int k = person[1];
            if (map.containsKey(k)) {
                map.get(k).add(person);
            } else {
                List<int[]> p = new ArrayList<>();
                p.add(person);
                map.put(k, p);
            }
        }
        List<int[]> resList = null;
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            List<int[]> value = entry.getValue();
            value.sort(Comparator.comparingInt(o -> o[0]));
            if (resList == null) {
                resList = value;
            } else {
                for (int[] person : value) {
                    int i = 0, count = 0;
                    for (; i < resList.size() && count <= person[1]; i++) {
                        if (resList.get(i)[0] >= person[0]) {
                            count++;
                        }
                    }
                    if (count > person[1]) {
                        resList.add(i - 1, person);
                    } else {
                        resList.add(person);
                    }
                }
            }
        }
        if (resList == null) {
            return new int[0][0];
        }
        return resList.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        ReconstructQueue1 r = new ReconstructQueue1();
        int[] a = {1,2};
        int[][] arr = new int[6][2];
        arr[0] = new int[]{7,0};
        arr[1] = new int[]{4,4};
        arr[2] = new int[]{7,1};
        arr[3] = new int[]{5,0};
        arr[4] = new int[]{6,1};
        arr[5] = new int[]{5,2};
        r.reconstructQueue(arr);
    }
}
