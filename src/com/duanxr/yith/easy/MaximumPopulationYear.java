package com.duanxr.yith.easy;

/**
 * @author 段然 2021/9/10
 */
public class MaximumPopulationYear {

  /**
   * You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
   *
   * The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.
   *
   * Return the earliest year with the maximum population.
   *
   *  
   *
   * Example 1:
   *
   * Input: logs = [[1993,1999],[2000,2010]]
   * Output: 1993
   * Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
   * Example 2:
   *
   * Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
   * Output: 1960
   * Explanation:
   * The maximum population is 2, and it had happened in years 1960 and 1970.
   * The earlier year between them is 1960.
   *  
   *
   * Constraints:
   *
   * 1 <= logs.length <= 100
   * 1950 <= birthi < deathi <= 2050
   *
   * 给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
   *
   * 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。
   *
   * 返回 人口最多 且 最早 的年份。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：logs = [[1993,1999],[2000,2010]]
   * 输出：1993
   * 解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
   * 示例 2：
   *
   * 输入：logs = [[1950,1961],[1960,1971],[1970,1981]]
   * 输出：1960
   * 解释：
   * 人口最多为 2 ，分别出现在 1960 和 1970 。
   * 其中最早年份是 1960 。
   *  
   *
   * 提示：
   *
   * 1 <= logs.length <= 100
   * 1950 <= birthi < deathi <= 2050
   *
   */
  class Solution {

    private static final int OFFSET = 1950;

    public int maximumPopulation(int[][] logs) {
      int[] population = new int[102];
      for (int[] log : logs) {
        population[log[0] - OFFSET]++;
        population[log[1] - OFFSET]--;
      }
      int cur = 0;
      int max = 0;
      int maxYear = 0;
      for (int i = 0; i < population.length - 1; i++) {
        cur += population[i];
        if (cur > max) {
          max = cur;
          maxYear = i;
        }
      }
      return maxYear + OFFSET;
    }
  }
}
