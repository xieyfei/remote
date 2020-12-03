package com.xie.leetcode.countPrimes204;

public class CountPrimes1 {

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int i) {
        int sqrt = (int) Math.sqrt(i + 1);
        for (int j = 2; j <= sqrt; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountPrimes1 c = new CountPrimes1();
        System.out.println(c.countPrimes(10));
        System.out.println(c.countPrimes(0));
        System.out.println(c.countPrimes(1));
        System.out.println(c.countPrimes(100));
    }
}
