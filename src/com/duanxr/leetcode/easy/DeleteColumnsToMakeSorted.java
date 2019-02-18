package com.duanxr.leetcode.easy;

/**
 * @author Duanran 2019/2/18 0018
 */
public class DeleteColumnsToMakeSorted {

  /**
   * We are given an array A of N lowercase letter strings, all of the same length.
   *
   * Now, we may choose any set of deletion indices, and for each string, we delete all the
   * characters in those indices.
   *
   * For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then
   * the final array after deletions is ["bef", "vyz"], and the remaining columns of A are
   * ["b","v"], ["e","y"], and ["f","z"].  (Formally, the c-th column is [A[0][c], A[1][c], ...,
   * A[A.length-1][c]].)
   *
   * Suppose we chose a set of deletion indices D such that after deletions, each remaining column
   * in A is in non-decreasing sorted order.
   *
   * Return the minimum possible value of D.length.
   *
   *
   *
   * Example 1:
   *
   * Input: ["cba","daf","ghi"]
   *
   * Output: 1
   *
   * Explanation:
   *
   * After choosing D = {1}, each column ["c","d","g"] and ["a","f","i"] are in non-decreasing
   * sorted order.
   *
   * If we chose D = {}, then a column ["b","a","h"] would not be in non-decreasing sorted order.
   *
   * Example 2:
   *
   * Input: ["a","b"]
   *
   * Output: 0
   *
   * Explanation: D = {}
   *
   * Example 3:
   *
   * Input: ["zyx","wvu","tsr"]
   *
   * Output: 3
   *
   * Explanation: D = {0, 1, 2}
   *
   *
   * Note:
   *
   * 1 <= A.length <= 100
   *
   * 1 <= A[i].length <= 1000
   *
   * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
   *
   * 选取一个删除索引序列，对于 A 中的每个字符串，删除对应每个索引处的字符。 所余下的字符串行从上往下读形成列。
   *
   * 比如，有 A = ["abcdef", "uvwxyz"]，删除索引序列 {0, 2, 3}，删除后 A 为["bef", "vyz"]， A 的列分别为["b","v"],
   * ["e","y"], ["f","z"]。（形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
   *
   * 假设，我们选择了一组删除索引 D，那么在执行删除操作之后，A 中所剩余的每一列都必须是 非降序 排列的，然后请你返回 D.length 的最小可能值。
   *
   * 示例 1：
   *
   * 输入：["cba", "daf", "ghi"]
   *
   * 输出：1
   *
   * 解释：
   *
   * 当选择 D = {1}，删除后 A 的列为：["c","d","g"] 和 ["a","f","i"]，均为非降序排列。
   *
   * 若选择 D = {}，那么 A 的列 ["b","a","h"] 就不是非降序排列了。
   *
   * 示例 2：
   *
   * 输入：["a", "b"]
   *
   * 输出：0
   *
   * 解释：D = {}
   *
   * 示例 3：
   *
   * 输入：["zyx", "wvu", "tsr"]
   *
   * 输出：3
   *
   * 解释：D = {0, 1, 2}
   *
   * 提示：
   *
   * 1 <= A.length <= 100
   *
   * 1 <= A[i].length <= 1000
   */
  class Solution {

    public int minDeletionSize(String[] A) {
      int result = 0;
      out:
      for (int i = 0; i < A[0].length(); i++) {
        int current = Integer.MIN_VALUE;
        for (String str : A) {
          int c = str.charAt(i);
          if (c < current) {
            result++;
            continue out;
          } else {
            current = c;
          }
        }
      }
      return result;
    }
  }
}
