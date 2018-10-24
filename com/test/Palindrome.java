package com.test;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(5));
        System.out.println(new Palindrome().isPalindrome(10));
        System.out.println(new Palindrome().isPalindrome(11));
        System.out.println(new Palindrome().isPalindrome(100));
        System.out.println(new Palindrome().isPalindrome(101));
        System.out.println(new Palindrome().isPalindrome(103301));
        System.out.println(new Palindrome().isPalindrome(1000021));
    }
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        } else if(x < 10) {
            return true;
        } else {
            int approxLog10 = approxLog10(x);
            int t = (int)Math.pow(10, approxLog10);

            while(t > 1) {
                int msd = x / t;
                int lsd = x % 10;
                if(msd != lsd) {
                    return false;
                } else {
                    x = (x - msd * t) / 10;
                    t /= 100;
                }
            }
        }

        return true;
    }

    int approxLog10(int x) {
        int res = 0;
        while (x >= 10) {
            res++;
            x /= 10;
        }
        return res;
    }
}
