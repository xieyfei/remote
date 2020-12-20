package com.xie.leetcode.removeDuplicateLetters316;

public class RemoveDuplicateLetters1 {

    public String removeDuplicateLetters(String s) {
        char[] chs = s.toCharArray();
        int[] last = new int[26];
        boolean[] exist = new boolean[26];
        char[] stack = new char[chs.length];
        int top = -1;
        for (int i = chs.length - 1; i >= 0; i--) {
            int tmp = chs[i] - 'a';
            if (last[tmp] == 0) {
                last[tmp] = i;
            }
        }
        for (int i = 0; i < chs.length;) {
            int tmp = chs[i] - 'a';
            if (exist[tmp]) {
                i++;
                continue;
            }
            if (top >= 0 && chs[i] < stack[top] && last[stack[top] - 'a'] > i) {
                exist[stack[top--] - 'a'] = false;
            } else {
                stack[++top] = chs[i++];
                exist[tmp] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters1 r = new RemoveDuplicateLetters1();
        System.out.println(r.removeDuplicateLetters("cbacdcbc"));
        System.out.println(r.removeDuplicateLetters("bcabc"));
    }
}
