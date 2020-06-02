package com.xie.leetcode.countAndSay38;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
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
        String said = "1";
        while (--n > 0) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            char[] chs = said.toCharArray();
            int i = 1;
            for (; i < chs.length; i++) {
                if (chs[i] == chs[i - 1]) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(chs[i - 1]);
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(chs[i - 1]);
            said = sb.toString();
        }
        return said;
    }
}
