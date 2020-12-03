package com.xie.leetcode.reorganizeString767;

import java.util.PriorityQueue;

public class ReorganizeString3 {

    public String reorganizeString(String S) {
        int max = (S.length() + 1) / 2;
        int[] countArr = new int[26];
        for (char c : S.toCharArray()) {
            int index = c - 'a';
            countArr[index]++;
            if (countArr[index] > max) return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((k1, k2) -> {
            int i1 = k1 - 'a';
            int i2 = k2 - 'a';
            return countArr[i1] == countArr[i2] ? k1 - k2 : countArr[i2] - countArr[i1];
        });
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 0) {
                queue.add((char) (i + 'a'));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) {
            Character first = queue.poll();
            Character second = queue.poll();
            int indexFir = first - 'a';
            int indexSec = second - 'a';
            sb.append(first);
            sb.append(second);
            countArr[indexFir]--;
            countArr[indexSec]--;
            if (countArr[indexFir] > 0) {
                queue.add(first);
            }
            if (countArr[indexSec] > 0) {
                queue.add(second);
            }
        }
        if (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReorganizeString3 r = new ReorganizeString3();
        System.out.println(r.reorganizeString("aaabcc"));
        System.out.println(r.reorganizeString("aab"));
        System.out.println(r.reorganizeString("aaab"));
    }
}
