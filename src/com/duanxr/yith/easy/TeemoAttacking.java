package com.duanxr.yith.easy;

/**
 * @author 段然 2021/11/11
 */
public class TeemoAttacking {

  /**
   * Our hero Teemo is attacking an enemy Ashe with poison attacks! When Teemo attacks Ashe, Ashe gets poisoned for a exactly duration seconds. More formally, an attack at second t will mean Ashe is poisoned during the inclusive time interval [t, t + duration - 1]. If Teemo attacks again before the poison effect ends, the timer for it is reset, and the poison effect will end duration seconds after the new attack.
   *
   * You are given a non-decreasing integer array timeSeries, where timeSeries[i] denotes that Teemo attacks Ashe at second timeSeries[i], and an integer duration.
   *
   * Return the total number of seconds that Ashe is poisoned.
   *
   *  
   *
   * Example 1:
   *
   * Input: timeSeries = [1,4], duration = 2
   * Output: 4
   * Explanation: Teemo's attacks on Ashe go as follows:
   * - At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
   * - At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
   * Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.
   * Example 2:
   *
   * Input: timeSeries = [1,2], duration = 2
   * Output: 3
   * Explanation: Teemo's attacks on Ashe go as follows:
   * - At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
   * - At second 2 however, Teemo attacks again and resets the poison timer. Ashe is poisoned for seconds 2 and 3.
   * Ashe is poisoned for seconds 1, 2, and 3, which is 3 seconds in total.
   *  
   *
   * Constraints:
   *
   * 1 <= timeSeries.length <= 104
   * 0 <= timeSeries[i], duration <= 107
   * timeSeries is sorted in non-decreasing order.
   *
   * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄。他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
   *
   * 当提莫攻击艾希，艾希的中毒状态正好持续 duration 秒。
   *
   * 正式地讲，提莫在 t 发起发起攻击意味着艾希在时间区间 [t, t + duration - 1]（含 t 和 t + duration - 1）处于中毒状态。如果提莫在中毒影响结束 前 再次攻击，中毒状态计时器将会 重置 ，在新的攻击之后，中毒影响将会在 duration 秒后结束。
   *
   * 给你一个 非递减 的整数数组 timeSeries ，其中 timeSeries[i] 表示提莫在 timeSeries[i] 秒时对艾希发起攻击，以及一个表示中毒持续时间的整数 duration 。
   *
   * 返回艾希处于中毒状态的 总 秒数。
   *
   *  
   * 示例 1：
   *
   * 输入：timeSeries = [1,4], duration = 2
   * 输出：4
   * 解释：提莫攻击对艾希的影响如下：
   * - 第 1 秒，提莫攻击艾希并使其立即中毒。中毒状态会维持 2 秒，即第 1 秒和第 2 秒。
   * - 第 4 秒，提莫再次攻击艾希，艾希中毒状态又持续 2 秒，即第 4 秒和第 5 秒。
   * 艾希在第 1、2、4、5 秒处于中毒状态，所以总中毒秒数是 4 。
   * 示例 2：
   *
   * 输入：timeSeries = [1,2], duration = 2
   * 输出：3
   * 解释：提莫攻击对艾希的影响如下：
   * - 第 1 秒，提莫攻击艾希并使其立即中毒。中毒状态会维持 2 秒，即第 1 秒和第 2 秒。
   * - 第 2 秒，提莫再次攻击艾希，并重置中毒计时器，艾希中毒状态需要持续 2 秒，即第 2 秒和第 3 秒。
   * 艾希在第 1、2、3 秒处于中毒状态，所以总中毒秒数是 3 。
   *  
   *
   * 提示：
   *
   * 1 <= timeSeries.length <= 104
   * 0 <= timeSeries[i], duration <= 107
   * timeSeries 按 非递减 顺序排列
   *
   */
  class Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
      int count = 0;
      int start = 0;
      int end = 0;
      for (int time : timeSeries) {
        if (end < time) {
          count += end - start;
          start = time;
          end = start + duration;
        } else {
          end = time + duration;
        }
      }
      count += end - start;
      return count;
    }
  }
}
