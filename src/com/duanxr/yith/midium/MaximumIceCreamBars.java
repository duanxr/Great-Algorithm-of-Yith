package com.duanxr.yith.midium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author 段然 2021/7/2
 */
public class MaximumIceCreamBars {

  /**
   * It is a sweltering summer day, and a boy wants to buy some ice cream bars.
   *
   * At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins. The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible. 
   *
   * Return the maximum number of ice cream bars the boy can buy with coins coins.
   *
   * Note: The boy can buy the ice cream bars in any order.
   *
   *  
   *
   * Example 1:
   *
   * Input: costs = [1,3,2,4,1], coins = 7
   * Output: 4
   * Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.
   * Example 2:
   *
   * Input: costs = [10,6,8,7,7,8], coins = 5
   * Output: 0
   * Explanation: The boy cannot afford any of the ice cream bars.
   * Example 3:
   *
   * Input: costs = [1,6,3,1,2,5], coins = 20
   * Output: 6
   * Explanation: The boy can buy all the ice cream bars for a total price of 1 + 6 + 3 + 1 + 2 + 5 = 18.
   *  
   *
   * Constraints:
   *
   * costs.length == n
   * 1 <= n <= 105
   * 1 <= costs[i] <= 105
   * 1 <= coins <= 108
   *
   * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
   *
   * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
   *
   * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
   *
   * 注意：Tony 可以按任意顺序购买雪糕。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：costs = [1,3,2,4,1], coins = 7
   * 输出：4
   * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
   * 示例 2：
   *
   * 输入：costs = [10,6,8,7,7,8], coins = 5
   * 输出：0
   * 解释：Tony 没有足够的钱买任何一支雪糕。
   * 示例 3：
   *
   * 输入：costs = [1,6,3,1,2,5], coins = 20
   * 输出：6
   * 解释：Tony 可以买下所有的雪糕，总价为 1 + 6 + 3 + 1 + 2 + 5 = 18 。
   *  
   *
   * 提示：
   *
   * costs.length == n
   * 1 <= n <= 105
   * 1 <= costs[i] <= 105
   * 1 <= coins <= 108
   *
   */
  class Solution {

    public int maxIceCream(int[] costs, int coins) {
      int[] range = new int[100001];
      for (int cost : costs) {
        range[cost]++;
      }
      int n = 0;
      for (int i = 0; i < range.length; i++) {
        int num = range[i];
        if (num != 0) {
          int count = num * i;
          if (coins >= count) {
            n += num;
            coins -= count;
          } else {
            n += coins / i;
            break;
          }
        }
      }
      return n;
    }

  }


  class Solution2 {

    public int maxIceCream(int[] costs, int coins) {
      PriorityQueue<Integer> minHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
      int total = 0;
      for (int cost : costs) {
        minHeap.offer(cost);
        total += cost;
        while (!minHeap.isEmpty() && total > coins) {
          total -= minHeap.poll();
        }
      }
      return minHeap.size();
    }
  }


  class Solution1 {

    public int maxIceCream(int[] costs, int coins) {
      Arrays.sort(costs);
      int n = 0;
      for (int cost : costs) {
        if (coins >= cost) {
          coins -= cost;
          n++;
        } else {
          break;
        }
      }
      return n;
    }
  }
}
