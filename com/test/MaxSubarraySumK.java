package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by carmentano on 06/07/2018.
 */
public class MaxSubarraySumK {

    public static void main(String[] args) {
        int [] v = {1, -1, 5, -2, -3};
        int i = new MaxSubarraySumK().maxSubArrayLen(v,991);
        int a = 1;
    }
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> minIdxPerSum = new HashMap<>();
        int[] partialSums = new int[nums.length + 1];
        int maxDim = 0;

        partialSums[0] = 0;
        minIdxPerSum.put(0, 0);
        for(int i = 1; i <= nums.length; i++) {
            partialSums[i] = nums[i - 1] + partialSums[i - 1];
            int remaining = partialSums[i] - k;
            if(minIdxPerSum.get(remaining) != null) {
                if(i - minIdxPerSum.get(remaining) > maxDim) {
                    maxDim = i - minIdxPerSum.get(remaining);
                }
            }

            minIdxPerSum.putIfAbsent(partialSums[i], i);
        }

        return maxDim;
    }
}
