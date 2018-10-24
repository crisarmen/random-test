package com.test;

/**
 * Created by carmentano on 31/08/2018.
 */
public class RemoveDuplicatesInSortedArray {
    //remove duplicates..
    public static void main(String[] args) {
        int[] n = {1,1,2};
        new RemoveDuplicatesInSortedArray().removeDuplicates(n);
        int a = 1;
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        } else {
            int totElem = nums.length;
            int currIdx = 0;
            int nextIdx = 1;

            while(nextIdx < totElem) {
                while(nextIdx < totElem && nums[currIdx] == nums[nextIdx]) {
                    nextIdx++;
                }

                int diff = nextIdx - currIdx - 1;
                if(diff > 0) {
                    shift(nums, currIdx, totElem, diff);
                    totElem -= diff;
                }

                currIdx++;
                nextIdx = currIdx + 1;
            }
            return totElem;
        }
    }

    private void shift(int[] nums, int startIdx, int totElem, int delta) {
        System.arraycopy(nums, startIdx + 1 + delta, nums, startIdx + 1, totElem - delta - (startIdx + 1));
    }
}
