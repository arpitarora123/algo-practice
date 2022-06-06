package com.example.practice.binary.search;

import java.util.Arrays;

public class BinarySearchDemo {

    public int binarySearch(int[] nums, int target, int low, int high) {

        int mid = (low+high)/2;
        if(target == nums[mid]) return mid;

        if(target < nums[mid]) {
            high = mid-1;
        } else {
            low = mid+1;
        }

        if(low <= high) {
            return binarySearch(nums, target, low, high);
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchDemo binarySearchDemo = new BinarySearchDemo();
        int [] nums = {1, 2, 3, 4, 4, 5, 6};
        System.out.println(binarySearchDemo.binarySearch(nums, 6, 0, nums.length-1));
    }
}
