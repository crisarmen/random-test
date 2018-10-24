package com.test;

/**
 * Created by carmentano on 02/07/2018.
 */
public class GasStation {

    public static void main (String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,100,2};
        int i = new GasStation().canCompleteCircuit(gas, cost);
        int d = 3;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;


        if(gas.length == 1) {
            if(gas[0] >= cost[0]) {
                return 0;
            } else {
                return - 1;
            }
        } else {
            int start, end;
            int petrol = 0;
            start = end = 0;

            do {
                do {
                    petrol += gas[end] - cost[end];
                    end = (end + 1) % n;
                } while(petrol >= 0 && (start + n) % n != (end + n) % n);

                if((start + n) % n != (end + n) % n) {
                    do {
                        start = (start - 1 + n) % n;
                        petrol += gas[start] - cost[start];
                    } while(petrol < 0 && (start + n) % n != (end + n) % n);
                }
            } while ((start + n) % n != (end + n) % n);

            if(petrol >= 0){
                return start;
            } else {
                return -1;
            }
        }
    }
}
