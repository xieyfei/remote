package com.xie.leetcode.multiply43;

import java.util.ArrayList;
import java.util.List;

public class Multiply1 {

    public static void main(String[] args) {
        Multiply1 m = new Multiply1();
        System.out.println(m.multiply("999", "999"));
    }

    public String multiply(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        if (arr2.length > arr1.length) {
            char[] tmp = arr1;
            arr1 = arr2;
            arr2 = tmp;
        }
        List<Integer> listRes = null;
        for (int i = arr2.length - 1; i >= 0; i--) {
            List<Integer> list = new ArrayList<>(arr1.length + 1);
            int m = arr2[i] - '0';
            int sign = 0;
            for (int j = arr1.length - 1; j >= 0; j--) {
                int res = m * (arr1[j] - '0') + sign;
                sign = res / 10;
                list.add(res % 10);
            }
            if (sign > 0) {
                list.add(sign);
            }
            listRes = sum(listRes, list, arr2.length - i - 1);
        }
        return reverse(listRes);
    }

    private List<Integer> sum(List<Integer> listRes, List<Integer> list, int start) {
        if (listRes == null) {
            return list;
        } else {
            int sign = 0, j = 0;
            for (int i = start; i < listRes.size() && j < list.size(); i++, j++) {
                int sum = listRes.get(i) + list.get(j) + sign;
                sign = sum / 10;
                listRes.set(i, sum % 10);
            }
            for (; j < list.size(); j++) {
                int sum = list.get(j) + sign;
                sign = sum / 10;
                listRes.add(sum % 10);
            }
            if (sign > 0) {
                listRes.add(sign);
            }
            return listRes;
        }
    }

    private String reverse(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            Integer num = list.get(i);
            if (sb.length() == 0 && num.equals(0)) {
                continue;
            }
            sb.append(num);
        }
        String res = sb.toString();
        return res.isEmpty() ? "0" : res;
    }
}
