package com.xie.leetcode.fib509;

public class Fib1 {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int c = 1;
        int i = 0, j = 1;
        for (; c < n; c += 2) {
            i += j;
            j += i;
        }
        return c == n ? j : i;
    }

    public static void main(String[] args) {
        Fib1 f = new Fib1();
        for (int i = 0; i < 20; i++) {
            System.out.println(f.fib(i));
        }
    }
}
