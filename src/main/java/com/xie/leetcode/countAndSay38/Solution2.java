package com.xie.leetcode.countAndSay38;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.countAndSay(1));
        System.out.println(s.countAndSay(2));
        System.out.println(s.countAndSay(3));
        System.out.println(s.countAndSay(4));
        System.out.println(s.countAndSay(5));
        System.out.println(s.countAndSay(6));
        System.out.println(s.countAndSay(7));
        System.out.println(s.countAndSay(8));
        System.out.println(s.countAndSay(9));
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String str = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int count = 1;
        for (; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                count++;
            } else {
                sb.append(count).append(str.charAt(i - 1));
                count = 1;
            }
        }
        sb.append(count).append(str.charAt(i - 1));
        return sb.toString();
    }
}
