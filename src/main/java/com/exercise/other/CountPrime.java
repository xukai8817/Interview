package com.exercise.other;

/**
 * 给定数n，计算出1-n的素数个数
 *
 * @author xukai
 * @since 2021/6/20 22:41
 */
public class CountPrime {

    public static void main(String[] args) {
        int count = countPrime(100);
        System.out.println(count);
    }

    public static int countPrime(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
