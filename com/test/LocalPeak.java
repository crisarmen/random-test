package com.test;

public class LocalPeak {
    public static void main(String[] artgs) {
        int[] v = {100, 90, 80};
        int peakElement = new LocalPeak().findPeakElement(v);
        int a =1;
    }

    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length-1);
    }

    private int findPeak(int[] nums, int start, int end) {
        if(start == end) {
            return start;
        } else {
            int midIdx = (start + end) / 2;
            if(isPeak(nums, midIdx)) {
                return midIdx;
            } else {
                int midVal = nums[midIdx];

                // completely ascending
                if (nums[start] <= midVal && midVal <= nums[end]) {
                    return findPeak(nums, midIdx + 1, end);
                } else {
                    // completely descending
                    if (nums[start] <= midVal && midVal <= nums[end]) {
                        return findPeak(nums, start, midIdx -1);
                    } else {
                        if(midVal > nums[midIdx + 1]) {
                            return findPeak(nums, start, midIdx - 1);
                        } else {
                            return findPeak(nums, midIdx + 1, end);
                        }
                    }
                }
            }
        }
    }

    private boolean isPeak(int[] nums, int idx) {
        int val = getVal(nums, idx);
        int sx = getVal(nums, idx - 1);
        int dx = getVal(nums, idx + 1);

        return val >= sx && val >= dx;
    }

    private int getVal(int[] nums, int idx) {
        if(idx < 0 || idx >= nums.length) {
            return Integer.MIN_VALUE;
        } else {
            return nums[idx];
        }
    }
}
