package com.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by carmentano on 03/06/2018.
 */
public class KLargest {
    public static void main(String[] args) {
        int[] v = {3,2,3,1,2,4,5,5,6};
        int kthLargest = new KLargest().findKthLargest(v, 9);
        kthLargest = new KLargest().findKthLargest(v, 8);
        kthLargest = new KLargest().findKthLargest(v, 7);
        kthLargest = new KLargest().findKthLargest(v, 6);
        kthLargest = new KLargest().findKthLargest(v, 5);
        kthLargest = new KLargest().findKthLargest(v, 4);
        kthLargest = new KLargest().findKthLargest(v, 3);
        kthLargest = new KLargest().findKthLargest(v, 2);
        kthLargest = new KLargest().findKthLargest(v, 1);



//        int aux = new KLargest().findAux(v, 0, v.length - 1, 5);
        int a = 1;
    }

    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int findKthLargest(int[] nums, int k) {
        return findAux(nums, 0, nums.length-1, nums.length-k);
    }

    private int findAux(int[] nums, int start, int end, int idx) {
        if(start == end) {
            return nums[start];
        } else {
            int pivot = nums[start];
            int posPivot = start;
            int i = start + 1;
            int j = end;

            while(i <= j) {
                while(i <= j && nums[i] <= pivot) {
                    i++;
                }

                while(i <= j && nums[j] > pivot) {
                    j--;
                }

                if (i <= j) {
                    swap(nums, i, j);
                }
            }

            swap(nums, posPivot, j);
            if(j == idx) {
                return nums[idx];
            } else if (j < idx) {
                return findAux(nums, j+1, end, idx);
            } else {
                return findAux(nums, start, j - 1, idx);
            }

        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
