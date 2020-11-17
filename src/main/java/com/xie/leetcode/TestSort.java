package com.xie.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestSort {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("2020-11-01T00:00:00Z");
        list.add("2020-11-02T00:00:00Z");
        list.add("2020-09-22T10:22:34");
        list.add("2020-10-23T10:49:54");
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}
