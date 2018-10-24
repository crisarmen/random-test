package com.test;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class UglyNumbersTwo {
    public static void main(String[] args) {
        int i = new UglyNumbersTwo().nthUglyNumber(10);
        int a = 1;
    }
    //factors: 2, 3, 5
    public int nthUglyNumber(int n) {
        int[] u = new int[n];
        u[0] = 1;
        int p2,p3,p5;
        p2=p3=p5=0;

        for(int i = 1; i < n; i++){
            int min = Math.min(u[p2] * 2, Math.min(u[p3] * 3, u[p5] * 5));
            if(min == u[p2] * 2) {
                p2++;
            }

            if(min == u[p3] * 3) {
                p3++;
            }

            if(min == u[p5] * 5) {
                p5++;
            }

            u[i] = min;
        }
        return u[n-1];
    }
}
