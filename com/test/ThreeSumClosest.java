package com.test;

import java.util.Arrays;

/**
 * Created by carmentano on 13/06/2018.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] v = {1,1,1,0};
        int closest = new ThreeSumClosest().threeSumClosest(v, -100);
        int a = 1;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer currResult = null;

        for(int i =0; i < nums.length - 2; i ++){
            int newTarget = target - nums[i];
            int start = i + 1;
            int end = nums.length -1;
            if(currResult == null)
                currResult = nums[i] + nums[start] + nums[end];

            while(start < end) {
                int partialSum = nums[start] + nums[end];

                if(nums[i]+partialSum == target) {
                    return target;
                } else {
                    if(Math.abs(target - currResult) > Math.abs(target - (nums[i] + partialSum))) {
                        currResult = (nums[i] + partialSum);
                    }

                    if(partialSum < newTarget) {
                        start++;
                    }else {
                        end--;
                    }
                }
            }
        }

        return currResult;
    }

    //TODO: how to make this return the closest?
    private int findClosest(int[] nums, int target, int start, int end) {
        int idx = (start + end) / 2;
        if(nums[idx] == target || start == end) {
            return nums[idx];
        } else if (nums[idx] > target){
            return findClosest(nums, target, start, idx - 1);
        } else {
            return findClosest(nums, target, idx + 1, end);
        }
    }
}
