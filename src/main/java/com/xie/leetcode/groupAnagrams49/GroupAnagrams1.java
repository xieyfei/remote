package com.xie.leetcode.groupAnagrams49;

import java.util.*;

public class GroupAnagrams1 {

//    ["eat", "tea", "tan", "ate", "nat", "bat"]

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        List<String> emptyList = new ArrayList<>();
        for (String str : strs) {
            if (str.isEmpty()) {
                emptyList.add("");
                continue;
            }
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        if (!emptyList.isEmpty()) {
            ret.add(emptyList);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ret.add(entry.getValue());
        }
        return ret;
    }

    public static void main(String[] args) {
        GroupAnagrams1 g = new GroupAnagrams1();
        System.out.println(g.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
