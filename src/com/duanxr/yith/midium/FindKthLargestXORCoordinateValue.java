package com.duanxr.yith.midium;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author 段然 2021/5/19
 */
public class FindKthLargestXORCoordinateValue {

  /**
   *
   * You are given a 2D matrix of size m x n, consisting of non-negative integers. You are also given an integer k.
   *
   * The value of coordinate (a, b) of the matrix is the XOR of all matrix[i][j] where 0 <= i <= a < m and 0 <= j <= b < n (0-indexed).
   *
   * Find the kth largest value (1-indexed) of all the coordinates of matrix.
   *
   *  
   *
   * Example 1:
   *
   * Input: matrix = [[5,2],[1,6]], k = 1
   * Output: 7
   * Explanation: The value of coordinate (0,1) is 5 XOR 2 = 7, which is the largest value.
   * Example 2:
   *
   * Input: matrix = [[5,2],[1,6]], k = 2
   * Output: 5
   * Explanation: The value of coordinate (0,0) is 5 = 5, which is the 2nd largest value.
   * Example 3:
   *
   * Input: matrix = [[5,2],[1,6]], k = 3
   * Output: 4
   * Explanation: The value of coordinate (1,0) is 5 XOR 1 = 4, which is the 3rd largest value.
   * Example 4:
   *
   * Input: matrix = [[5,2],[1,6]], k = 4
   * Output: 0
   * Explanation: The value of coordinate (1,1) is 5 XOR 2 XOR 1 XOR 6 = 0, which is the 4th largest value.
   *  
   *
   * Constraints:
   *
   * m == matrix.length
   * n == matrix[i].length
   * 1 <= m, n <= 1000
   * 0 <= matrix[i][j] <= 106
   * 1 <= k <= m * n
   *
   * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
   *
   * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
   *
   * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：matrix = [[5,2],[1,6]], k = 1
   * 输出：7
   * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
   * 示例 2：
   *
   * 输入：matrix = [[5,2],[1,6]], k = 2
   * 输出：5
   * 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
   * 示例 3：
   *
   * 输入：matrix = [[5,2],[1,6]], k = 3
   * 输出：4
   * 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
   * 示例 4：
   *
   * 输入：matrix = [[5,2],[1,6]], k = 4
   * 输出：0
   * 解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。
   *  
   *
   * 提示：
   *
   * m == matrix.length
   * n == matrix[i].length
   * 1 <= m, n <= 1000
   * 0 <= matrix[i][j] <= 106
   * 1 <= k <= m * n
   *
   */
  class Solution {

    public int kthLargestValue(int[][] matrix, int k) {
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
      for (int i = 0; i < matrix.length; i++) {
        int[] row = matrix[i];
        for (int j = 0; j < row.length; j++) {
          if (i > 0) {
            matrix[i][j] ^= matrix[i - 1][j];
          }
          if (j > 0) {
            matrix[i][j] ^= matrix[i][j - 1];
          }
          if (j > 0 && i > 0) {
            matrix[i][j] ^= matrix[i - 1][j - 1];
          }

          if (priorityQueue.size() < k) {
            priorityQueue.offer(matrix[i][j]);
          } else if (priorityQueue.peek() < matrix[i][j]) {
            priorityQueue.poll();
            priorityQueue.offer(matrix[i][j]);
          }
        }
      }
      return priorityQueue.peek();
    }
  }


  class Solution1 {

    public int kthLargestValue(int[][] matrix, int k) {
      Stack<Integer> big = new Stack<>();
      Stack<Integer> small = new Stack<>();
      for (int i = 0; i < matrix.length; i++) {
        int[] row = matrix[i];
        for (int j = 0; j < row.length; j++) {
          if (i > 0) {
            matrix[i][j] ^= matrix[i - 1][j];
          }
          if (j > 0) {
            matrix[i][j] ^= matrix[i][j - 1];
          }
          if (j > 0 && i > 0) {
            matrix[i][j] ^= matrix[i - 1][j - 1];
          }

          if (big.isEmpty()) {
            big.push(matrix[i][j]);
          } else if (big.peek() < matrix[i][j] || big.size() < k) {
            while (!big.isEmpty() && big.peek() < matrix[i][j]) {
              small.push(big.pop());
            }
            big.push(matrix[i][j]);
            while (!small.isEmpty() && big.size() != k) {
              big.push(small.pop());
            }
          }
        }
      }
      return big.size() == k ? big.peek() : 0;
    }
  }
}
