package com.xie.leetcode.reorganizeString767;


public class ReorganizeString4 {

    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] countArr = new int[26];
        int max = (S.length() + 1) / 2;
        for (char c : S.toCharArray()) {
            int idx = c - 'a';
            countArr[idx]++;
            if (countArr[idx] > max) return "";
        }
        char[] organizeArr = new char[S.length()];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = S.length() / 2;
        for (int i = 0; i < countArr.length; i++) {
            char c = (char) (i + 'a');
            while (countArr[i] > 0 && countArr[i] <= halfLength && oddIndex < S.length()) {
                organizeArr[oddIndex] = c;
                countArr[i]--;
                oddIndex += 2;
            }
            while (countArr[i] > 0) {
                organizeArr[evenIndex] = c;
                countArr[i]--;
                evenIndex += 2;
            }
        }
        return new String(organizeArr);
    }

    public static void main(String[] args) {
        ReorganizeString4 r = new ReorganizeString4();
        System.out.println(r.reorganizeString("aab"));
    }
}
