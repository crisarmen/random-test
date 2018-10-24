package com.test;

/**
 * Created by carmentano on 04/09/2018.
 */
public class Division {
    public static void main(String[] args) {
        /*
        -2147483648
2
        */
        int divide = new Division().divide(-2147483648, -1);
        int a = 1;
    }

    public int divide(int dividend, int divisor) {
        final int MAX = 0x7FFFFFFF;
        final int MIN = 0x80000000;

        boolean positive = true;
        if(dividend == 0) {
            return 0;
        }
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            positive = false;
        }

        //checking overflow, max min cases
        if(dividend == MIN) {
            if (divisor == 1) {
                return MIN;
            } else if (divisor == -1){
                return MAX;
            }
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if(divisor > dividend) {
            return 0;
        } else {
            int res = 0;
            while(dividend >= divisor) {
                res++;
                dividend -= divisor;
            }
            if(positive) {
                return res;
            } else {
                return ~res + 1;
            }
        }
    }
}

/*

Input: -2147483648
-1
Output: 0
Expected: 2147483647

 */
