package com.xie.leetcode.sortString1370;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class SortString1 {

    public String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        LinkedList<Character> list = new LinkedList<>();
        for (char c : chars) {
            list.add(c);
        }
        int idx = 0;
        char[] result = new char[chars.length];
        while (!list.isEmpty()) {
            Character last = 0;
            ListIterator<Character> it = list.listIterator();
            while (it.hasNext()) {
                Character next = it.next();
                if (next > last) {
                    result[idx++] = next;
                    last = next;
                    it.remove();
                }
            }
            last = 'z' + 1;
            while (it.hasPrevious()) {
                Character next = it.previous();
                if (next < last) {
                    result[idx++] = next;
                    last = next;
                    it.remove();
                }
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        SortString1 s = new SortString1();
        System.out.println(s.sortString("aaaabbbbcccc"));
        System.out.println(s.sortString("rat"));
        System.out.println(s.sortString("leetcode"));
        System.out.println(s.sortString("ggggggg"));
        System.out.println(s.sortString("spo"));
        System.out.println(s.sortString("s"));
    }
}
