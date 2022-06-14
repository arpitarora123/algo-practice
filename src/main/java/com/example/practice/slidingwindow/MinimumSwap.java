package com.example.practice.slidingwindow;

/*
A swap is defined as taking two distinct positions in an array and swapping the values in them.

A circular array is defined as an array where we consider the first element and the last element to be adjacent.

Given a binary circular array nums, return the minimum number of swaps required to group all 1's present in the array together at any location.



Example 1:

Input: nums = [0,1,0,1,1,0,0]
Output: 1
Explanation: Here are a few of the ways to group all the 1's together:
[0,0,1,1,1,0,0] using 1 swap.
[0,1,1,1,0,0,0] using 1 swap.
[1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
There is no way to group all 1's together with 0 swaps.
Thus, the minimum number of swaps required is 1.
Example 2:

Input: nums = [0,1,1,1,0,0,1,1,0]
Output: 2
Explanation: Here are a few of the ways to group all the 1's together:
[1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
[1,1,1,1,1,0,0,0,0] using 2 swaps.
There is no way to group all 1's together with 0 or 1 swaps.
Thus, the minimum number of swaps required is 2.
Example 3:

Input: nums = [1,1,0,0,1]
Output: 0
Explanation: All the 1's are already grouped together due to the circular property of the array.
Thus, the minimum number of swaps required is 0.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */

import java.util.Arrays;

public class MinimumSwap {

    public static int minSwaps(int[] nums) {
        int [] numsCopy = Arrays.copyOf(nums, nums.length*2);
        for(int i = nums.length, j = 0; i < nums.length * 2; i++) numsCopy[i] = nums[j++];
        int totalOneCount  = (int) Arrays.stream(nums).filter(a -> a == 1).count(); //Window size
        if(totalOneCount == 0 || totalOneCount == nums.length) return 0;
        int j=0, oneCountInCurrentWindow = 0, swapRequired = totalOneCount;
        for (int i = 0; i < totalOneCount; i++) {
            if (numsCopy[i] == 1) ++oneCountInCurrentWindow;
        }
        while(j < numsCopy.length-totalOneCount) {
            if(totalOneCount - oneCountInCurrentWindow == 0) return 0;
            swapRequired = Math.min(swapRequired, (totalOneCount - oneCountInCurrentWindow));
            if(numsCopy[j] == 1) oneCountInCurrentWindow--;
            if(numsCopy[totalOneCount+j] == 1) oneCountInCurrentWindow++;
            j++;
        }
        return swapRequired;
    }

    public static int minSwaps2(int[] nums) {
        int totalOneCount  = 0;
        for(int i:  nums) totalOneCount+=i;
        if(totalOneCount == 0 || totalOneCount == nums.length) return 0;

        int j=0, oneCountInCurrentWindow = 0, swapRequired = totalOneCount, n = nums.length;

        for (int i = 0; i < totalOneCount; i++) oneCountInCurrentWindow+=nums[i];

        while(j < (n*2-totalOneCount)) {
            if(totalOneCount - oneCountInCurrentWindow == 0) return 0;
            swapRequired = Math.min(swapRequired, (totalOneCount - oneCountInCurrentWindow));
            if(nums[j%n] == 1) oneCountInCurrentWindow--;
            if(nums[(totalOneCount+j)%n] == 1) oneCountInCurrentWindow++;
            j++;
        }
        return swapRequired;
    }

    public static int minSwaps3(int[] arr) {
        int count = 0;
        int n=arr.length;
        for (int i = 0; i < n; ++i)
            count+=arr[i];

        // Find unwanted elements in current
        // window of size 'count'
        int bad = 0;
        for (int i = 0; i < count; ++i)
            if (arr[i] == 0)
                ++bad;

        // Initialize answer with 'bad' value of
        // current window
        int ans = bad;
        for (int i = 0, j = count; j < 2*n; ++i, ++j) {

            // Decrement count of previous window
            if (arr[i%n] == 0)
                --bad;

            // Increment count of current window
            if (arr[j%n] == 0)
                ++bad;

            // Update ans if count of 'bad'
            // is less in current window
            ans = Math.min(ans, bad);
        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] = {0,1,0,1,1,0,0};
        System.out.println(minSwaps(a));
        System.out.println(minSwaps2(a));
        System.out.println(minSwaps3(a));
    }
}
