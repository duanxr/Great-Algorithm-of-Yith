package com.duanxr.yith.midium;

import java.util.Arrays;

/**
 * @author 段然 2021/8/26
 */
public class BoatsToSavePeople {

  /**
   * You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
   *
   * Return the minimum number of boats to carry every given person.
   *
   *  
   *
   * Example 1:
   *
   * Input: people = [1,2], limit = 3
   * Output: 1
   * Explanation: 1 boat (1, 2)
   * Example 2:
   *
   * Input: people = [3,2,2,1], limit = 3
   * Output: 3
   * Explanation: 3 boats (1, 2), (2) and (3)
   * Example 3:
   *
   * Input: people = [3,5,3,4], limit = 5
   * Output: 4
   * Explanation: 4 boats (3), (3), (4), (5)
   *  
   *
   * Constraints:
   *
   * 1 <= people.length <= 5 * 104
   * 1 <= people[i] <= limit <= 3 * 104
   *
   * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
   *
   * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
   *
   * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：people = [1,2], limit = 3
   * 输出：1
   * 解释：1 艘船载 (1, 2)
   * 示例 2：
   *
   * 输入：people = [3,2,2,1], limit = 3
   * 输出：3
   * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
   * 示例 3：
   *
   * 输入：people = [3,5,3,4], limit = 5
   * 输出：4
   * 解释：4 艘船分别载 (3), (3), (4), (5)
   * 提示：
   *
   * 1 <= people.length <= 50000
   * 1 <= people[i] <= limit <= 30000
   *
   */
  class Solution {

    public int numRescueBoats(int[] people, int limit) {
      Arrays.sort(people);
      int l = 0;
      int r = people.length - 1;
      int num = 0;
      while (l <= r) {
        if (people[l] + people[r] <= limit && l != r) {
          l++;
          r--;
          num++;
        } else {
          r--;
          num++;
        }
      }
      return num;
    }
  }
}
