package com.duanxr.yith.midium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author 段然 2021/6/23
 */
public class CheckIfArrayPairsAreDivisibleByK {

  /**
   * Given an array of integers arr of even length n and an integer k.
   *
   * We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
   *
   * Return True If you can find a way to do that or False otherwise.
   *
   *  
   *
   * Example 1:
   *
   * Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
   * Output: true
   * Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).
   * Example 2:
   *
   * Input: arr = [1,2,3,4,5,6], k = 7
   * Output: true
   * Explanation: Pairs are (1,6),(2,5) and(3,4).
   * Example 3:
   *
   * Input: arr = [1,2,3,4,5,6], k = 10
   * Output: false
   * Explanation: You can try all possible pairs to see that there is no way to divide arr into 3 pairs each with sum divisible by 10.
   * Example 4:
   *
   * Input: arr = [-10,10], k = 2
   * Output: true
   * Example 5:
   *
   * Input: arr = [-1,1,-2,2,-3,3,-4,4], k = 3
   * Output: true
   *  
   *
   * Constraints:
   *
   * arr.length == n
   * 1 <= n <= 105
   * n is even.
   * -109 <= arr[i] <= 109
   * 1 <= k <= 105
   *
   * 给你一个整数数组 arr 和一个整数 k ，其中数组长度是偶数，值为 n 。
   *
   * 现在需要把数组恰好分成 n / 2 对，以使每对数字的和都能够被 k 整除。
   *
   * 如果存在这样的分法，请返回 True ；否则，返回 False 。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：arr = [1,2,3,4,5,10,6,7,8,9], k = 5
   * 输出：true
   * 解释：划分后的数字对为 (1,9),(2,8),(3,7),(4,6) 以及 (5,10) 。
   * 示例 2：
   *
   * 输入：arr = [1,2,3,4,5,6], k = 7
   * 输出：true
   * 解释：划分后的数字对为 (1,6),(2,5) 以及 (3,4) 。
   * 示例 3：
   *
   * 输入：arr = [1,2,3,4,5,6], k = 10
   * 输出：false
   * 解释：无法在将数组中的数字分为三对的同时满足每对数字和能够被 10 整除的条件。
   * 示例 4：
   *
   * 输入：arr = [-10,10], k = 2
   * 输出：true
   * 示例 5：
   *
   * 输入：arr = [-1,1,-2,2,-3,3,-4,4], k = 3
   * 输出：true
   *  
   *
   * 提示：
   *
   * arr.length == n
   * 1 <= n <= 10^5
   * n 为偶数
   * -10^9 <= arr[i] <= 10^9
   * 1 <= k <= 10^5
   *
   */
  class Solution {

    public boolean canArrange(int[] arr, int k) {
      int[] bit = new int[k];
      for (int n : arr) {
        int d = n % k;
        bit[d < 0 ? d + k : d]++;
      }
      int b = bit.length / 2;
      for (int i = 1; i <= b; i++) {
        if (bit[i] != bit[k - i]) {
          return false;
        }
      }
      return bit[0] % 2 == 0;
    }
  }


  class Solution3 {

    public boolean canArrange(int[] arr, int k) {
      int[] bit = new int[k];
      for (int n : arr) {
        int d = n % k;
        bit[d < 0 ? d + k : d]++;
      }
      if (bit[0] % 2 != 0) {
        return false;
      }
      int b = bit.length / 2;
      for (int i = 1; i <= b; i++) {
        if (bit[i] != bit[k - i]) {
          return false;
        }
      }
      return true;
    }
  }


  class Solution2 {

    public boolean canArrange(int[] arr, int k) {
      int[] map = new int[k];
      for (int n : arr) {
        int d = n % k;
        if (d < 0) {
          d += k;
        }
        int i = d == 0 ? 0 : k - d;
        if (map[i] > 0) {
          map[i]--;
        } else {
          map[d]++;
        }
      }
      for (int i : map) {
        if (i != 0) {
          return false;
        }
      }
      return true;
    }
  }


  class Solution1 {

    public boolean canArrange(int[] arr, int k) {
      Map<Integer, Stack<Integer>> map = new HashMap<>();
      for (int n : arr) {
        int d = n % k;
        if (d < 0) {
          d += k;
        }
        Stack<Integer> stack = map.get(d == 0 ? 0 : k - d);
        if (stack != null && !stack.isEmpty()) {
          Integer x = stack.pop();
        } else {
          Stack<Integer> stack1 = map.computeIfAbsent(d, key -> new Stack<>());
          stack1.push(n);
        }
      }
      System.out.println(map);
      for (Stack<Integer> value : map.values()) {
        if (!value.isEmpty()) {
          return false;
        }
      }
      return true;
    }
  }
}
