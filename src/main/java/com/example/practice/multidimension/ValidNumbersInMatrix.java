package com.example.practice.multidimension;


/*
An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).

Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.



Example 1:


Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
Output: true
Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
Hence, we return true.
Example 2:


Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
Output: false
Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
Hence, we return false.


Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
1 <= matrix[i][j] <= n
 */

import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

public class ValidNumbersInMatrix {

    public static boolean checkValid(int[][] matrix) {
        Set<Integer> validRowSet = new HashSet<>(matrix.length);
        Set<Integer> validColumnSet = new HashSet<>(matrix.length);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(!validRowSet.add(matrix[i][j]))
                    return false;
                if(!validColumnSet.add(matrix[j][i]))
                    return false;
            }
            validRowSet.clear();
            validColumnSet.clear();
        }
        return true;
    }

    public static boolean checkValid2(int[][] matrix) {
        int len = matrix.length;

        for(int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                if (matrix[i][j] < 1 || matrix[i][j] > len) return false;
                sum = sum + matrix[i][j];
            }
            if(sum != (len * (len + 1))/2) return false;
        }

        for(int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                if (matrix[j][i] < 1 || matrix[j][i] > len) return false;
                sum = sum + matrix[j][i];
            }
            if(sum != (len * (len + 1))/2) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,1,1},{1,2,3},{1,2,3}};
        Assert.isTrue(!checkValid(matrix), "Invalid Matrix");
        Assert.isTrue(!checkValid2(matrix), "Invalid Matrix");

        matrix = new int[][]{{1, 2, 3}, {3, 1, 2}, {2, 3, 1}};
        Assert.isTrue(checkValid(matrix), "Valid Matrix");
        Assert.isTrue(checkValid2(matrix), "Valid Matrix");
    }
}
