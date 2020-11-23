package com.xie.leetcode.groupAnagrams49;

import java.util.*;

public class GroupAnagrams2 {

//    ["eat", "tea", "tan", "ate", "nat", "bat"]

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
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
        GroupAnagrams2 g = new GroupAnagrams2();
        System.out.println(g.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
