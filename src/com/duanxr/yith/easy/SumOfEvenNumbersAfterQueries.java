package com.duanxr.yith.easy;

/**
 * @author Duanran 2019/2/13 0013
 */
public class SumOfEvenNumbersAfterQueries {

  /**
   * We have an array A of integers, and an array queries of queries.
   *
   * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then,
   * the answer to the i-th query is the sum of the even values of A.
   *
   * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies
   * the array A.)
   *
   * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the
   * i-th query.
   *
   *
   *
   * Example 1:
   *
   * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
   *
   * Output: [8,6,2,4]
   *
   * Explanation:
   *
   * At the beginning, the array is [1,2,3,4].
   *
   * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
   *
   * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
   *
   * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
   *
   * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
   *
   *
   * Note:
   *
   * 1 <= A.length <= 10000
   *
   * -10000 <= A[i] <= 10000
   *
   * 1 <= queries.length <= 10000
   *
   * -10000 <= queries[i][0] <= 10000
   *
   * 0 <= queries[i][1] < A.length
   *
   * 给出一个整数数组 A 和一个查询数组 queries。
   *
   * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A
   * 中偶数值的和。
   *
   * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
   *
   * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
   *
   *
   *
   * 示例：
   *
   * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
   *
   * 输出：[8,6,2,4]
   *
   * 解释：
   *
   * 开始时，数组为 [1,2,3,4]。
   *
   * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
   *
   * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
   *
   * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
   *
   * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
   *
   *
   * 提示：
   *
   * 1 <= A.length <= 10000
   *
   * -10000 <= A[i] <= 10000
   *
   * 1 <= queries.length <= 10000
   *
   * -10000 <= queries[i][0] <= 10000
   *
   * 0 <= queries[i][1] < A.length
   */
  class Solution {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
      int[] result = new int[queries.length];
      int sum = 0;
      for (int i = 0; i < queries.length; i++) {
        if (i == 0) {
          A[queries[i][1]] += queries[i][0];
          for (int n : A) {
            if (n % 2 == 0) {
              sum += n;
            }
          }
        } else {
          if (A[queries[i][1]] % 2 == 0) {
            sum -= A[queries[i][1]];
          }
          A[queries[i][1]] += queries[i][0];
          if (A[queries[i][1]] % 2 == 0) {
            sum += A[queries[i][1]];
          }
        }
        result[i] = sum;
      }
      return result;
    }
  }
}
