package com.example.practice.binary.search;

import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;


/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

 */

public class BinarySearchRangeDemo {
    public int[] searchRange(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    public int[] binarySearch(int[] nums, int target, int low, int high) {

        if(nums.length > 0) {
            int lowRange=nums.length-1, highRange = 0;
            int mid = (low+high)/2;
            if(target == nums[mid]) {
                lowRange=min(mid, lowRange);
                highRange=max(mid, highRange);

                if(lowRange > 0 && nums[mid-1] == target
                        && low<high) {
                    lowRange=min(lowRange, binarySearch(nums, target, low,mid-1)[0]);
                }
                if(highRange < nums.length-1 && nums[mid+1] == target
                        && low<high) {
                    highRange=max(highRange, binarySearch(nums, target, mid+1, high)[1]);
                }
                return new int[]{lowRange, highRange};
            }

            if(target < nums[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }

            if(low <= high) {
                return binarySearch(nums, target, low, high);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        BinarySearchRangeDemo binarySearchDemo = new BinarySearchRangeDemo();
//        int [] nums = {0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10};
        int [] nums = {2,2};
        int [] response = binarySearchDemo.searchRange(nums, 2);
        System.out.println(Arrays.toString(response));
    }
}
