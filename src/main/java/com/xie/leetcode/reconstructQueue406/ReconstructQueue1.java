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
        return null;
    }

    public static void main(String[] args) {
        ReconstructQueue1 r = new ReconstructQueue1();
//        r.reconstructQueue()
    }
}
