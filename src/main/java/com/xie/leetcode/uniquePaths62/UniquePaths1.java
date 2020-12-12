package com.xie.leetcode.uniquePaths62;

public class UniquePaths1 {

    int count = 0;

    public int uniquePaths(int m, int n) {
        inner(m, n, 1, 1);
        return count;
    }

    private void inner(int m, int n, int curi, int curj) {
        if (curi == m && curj == n) {
            count++;
            return;
        }
        if (curi < m) {
            inner(m, n, curi + 1, curj);
        }
        if (curj < n) {
            inner(m, n, curi, curj + 1);
        }
    }

    public static void main(String[] args) {
        UniquePaths1 u = new UniquePaths1();
        System.out.println(u.uniquePaths(19, 13));
    }
}
