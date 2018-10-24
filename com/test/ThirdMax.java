package com.test;


public class ThirdMax {
    public static void main(String[] args) {
        int[] v = {5,3,3,2};
        int i = new ThirdMax().thirdMax(v);
        int a = 1;
    }

    public int thirdMax(int[] nums) {
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }

        int excludeMax = max;
        int max1;
        boolean found = true;

        for(int j = 0; j < 2 && found; j++){
            max1 = 0;
            found = false;

            for(int i = 0; i < nums.length; i++) {
                if(nums[i] < excludeMax) {
                    if(!found) {
                        max1 = nums[i];
                        found = true;
                    } else {
                        if(nums[i] > max1) {
                            max1 = nums[i];
                        }
                    }
                }
            }

            excludeMax = max1;
        }

        if(!found) {
            return max;
        } else {
            return excludeMax;
        }
    }
}
