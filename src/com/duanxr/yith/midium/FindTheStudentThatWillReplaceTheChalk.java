package com.duanxr.yith.midium;

/**
 * @author 段然 2021/9/10
 */
public class FindTheStudentThatWillReplaceTheChalk {

  /**
   * There are n students in a class numbered from 0 to n - 1. The teacher will give each student a problem starting with the student number 0, then the student number 1, and so on until the teacher reaches the student number n - 1. After that, the teacher will restart the process, starting with the student number 0 again.
   *
   * You are given a 0-indexed integer array chalk and an integer k. There are initially k pieces of chalk. When the student number i is given a problem to solve, they will use chalk[i] pieces of chalk to solve that problem. However, if the current number of chalk pieces is strictly less than chalk[i], then the student number i will be asked to replace the chalk.
   *
   * Return the index of the student that will replace the chalk.
   *
   *  
   *
   * Example 1:
   *
   * Input: chalk = [5,1,5], k = 22
   * Output: 0
   * Explanation: The students go in turns as follows:
   * - Student number 0 uses 5 chalk, so k = 17.
   * - Student number 1 uses 1 chalk, so k = 16.
   * - Student number 2 uses 5 chalk, so k = 11.
   * - Student number 0 uses 5 chalk, so k = 6.
   * - Student number 1 uses 1 chalk, so k = 5.
   * - Student number 2 uses 5 chalk, so k = 0.
   * Student number 0 does not have enough chalk, so they will have to replace it.
   * Example 2:
   *
   * Input: chalk = [3,4,1,2], k = 25
   * Output: 1
   * Explanation: The students go in turns as follows:
   * - Student number 0 uses 3 chalk so k = 22.
   * - Student number 1 uses 4 chalk so k = 18.
   * - Student number 2 uses 1 chalk so k = 17.
   * - Student number 3 uses 2 chalk so k = 15.
   * - Student number 0 uses 3 chalk so k = 12.
   * - Student number 1 uses 4 chalk so k = 8.
   * - Student number 2 uses 1 chalk so k = 7.
   * - Student number 3 uses 2 chalk so k = 5.
   * - Student number 0 uses 3 chalk so k = 2.
   * Student number 1 does not have enough chalk, so they will have to replace it.
   *  
   *
   * Constraints:
   *
   * chalk.length == n
   * 1 <= n <= 105
   * 1 <= chalk[i] <= 105
   * 1 <= k <= 109
   *
   * 一个班级里有 n 个学生，编号为 0 到 n - 1 。每个学生会依次回答问题，编号为 0 的学生先回答，然后是编号为 1 的学生，以此类推，直到编号为 n - 1 的学生，然后老师会重复这个过程，重新从编号为 0 的学生开始回答问题。
   *
   * 给你一个长度为 n 且下标从 0 开始的整数数组 chalk 和一个整数 k 。一开始粉笔盒里总共有 k 支粉笔。当编号为 i 的学生回答问题时，他会消耗 chalk[i] 支粉笔。如果剩余粉笔数量 严格小于 chalk[i] ，那么学生 i 需要 补充 粉笔。
   *
   * 请你返回需要 补充 粉笔的学生 编号 。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：chalk = [5,1,5], k = 22
   * 输出：0
   * 解释：学生消耗粉笔情况如下：
   * - 编号为 0 的学生使用 5 支粉笔，然后 k = 17 。
   * - 编号为 1 的学生使用 1 支粉笔，然后 k = 16 。
   * - 编号为 2 的学生使用 5 支粉笔，然后 k = 11 。
   * - 编号为 0 的学生使用 5 支粉笔，然后 k = 6 。
   * - 编号为 1 的学生使用 1 支粉笔，然后 k = 5 。
   * - 编号为 2 的学生使用 5 支粉笔，然后 k = 0 。
   * 编号为 0 的学生没有足够的粉笔，所以他需要补充粉笔。
   * 示例 2：
   *
   * 输入：chalk = [3,4,1,2], k = 25
   * 输出：1
   * 解释：学生消耗粉笔情况如下：
   * - 编号为 0 的学生使用 3 支粉笔，然后 k = 22 。
   * - 编号为 1 的学生使用 4 支粉笔，然后 k = 18 。
   * - 编号为 2 的学生使用 1 支粉笔，然后 k = 17 。
   * - 编号为 3 的学生使用 2 支粉笔，然后 k = 15 。
   * - 编号为 0 的学生使用 3 支粉笔，然后 k = 12 。
   * - 编号为 1 的学生使用 4 支粉笔，然后 k = 8 。
   * - 编号为 2 的学生使用 1 支粉笔，然后 k = 7 。
   * - 编号为 3 的学生使用 2 支粉笔，然后 k = 5 。
   * - 编号为 0 的学生使用 3 支粉笔，然后 k = 2 。
   * 编号为 1 的学生没有足够的粉笔，所以他需要补充粉笔。
   *  
   *
   * 提示：
   *
   * chalk.length == n
   * 1 <= n <= 105
   * 1 <= chalk[i] <= 105
   * 1 <= k <= 109
   *
   */
  class Solution {

    public int chalkReplacer(int[] chalk, int k) {
      long round = 0;
      for (int n : chalk) {
        round += n;
      }
      k %= round;
      for (int i = 0; i < chalk.length; i++) {
        if (k < chalk[i]) {
          return i;
        }
        k -= chalk[i];
      }
      return -1;
    }
  }
}
