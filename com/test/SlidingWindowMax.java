package com.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int[] arr = {1,3,1,2,0,5};
        int[] ints = new SlidingWindowMax().maxSlidingWindow(arr, 3);
        int a = 1;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < k - 1; i++){
            adjustQueue(q, i, nums, k);
        }


        for(int j =0, i = k -1; i < nums.length; i++, j++){
            adjustQueue(q, i, nums, k);
            result[j] = nums[q.getFirst()];
        }

        return result;
    }

    private void adjustQueue(Deque<Integer> q, int idx, int[] nums, int k){
        //removing indexes out of the window from the left
        while(!q.isEmpty() && q.peekFirst() <= idx - k){
            q.removeFirst();
        }

        //removing indexes which are less than current element
        while(!q.isEmpty() && nums[q.peekLast()] <= nums[idx]) {
            q.removeLast();
        }

        //add current element
        q.addLast(idx);
    }
}
