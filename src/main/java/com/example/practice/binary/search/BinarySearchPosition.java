package com.example.practice.binary.search;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */

public class BinarySearchPosition {
    public static int searchInsert(int[] nums, int target) {
        return binarySearchPos(nums, target, 0, nums.length-1);
    }

    public static int binarySearchPos(int [] nums, int target, int start, int end) {
        if(nums.length == 0) return 0;
        if(target < nums[0]) return 0;
        int mid = (start+end)/2;
        if(target == nums[mid]) return mid;
        if(start>=end) {
            if(target > nums[mid]) return mid+1;
            return mid;
        }

        if(target < nums[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return binarySearchPos(nums, target, start, end);
    }

    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 5));//2
        System.out.println(searchInsert(nums, 2));//1
        System.out.println(searchInsert(nums, 7));//4
        System.out.println(searchInsert(nums, 0));//0
        System.out.println(searchInsert(nums, 2));//1
//        Input: nums = [1,3,5,6], target = 2
//        Output: 1
//        Example 3:
    }
}
