package com.xie.leetcode.groupAnagrams49;

import java.util.*;

public class GroupAnagrams3 {

//    ["eat", "tea", "tan", "ate", "nat", "bat"]

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int c : count) {
                sb.append('#');
                sb.append(c);
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams3 g = new GroupAnagrams3();
//        System.out.println(g.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(g.groupAnagrams(new String[]{"", ""}));
    }
}
