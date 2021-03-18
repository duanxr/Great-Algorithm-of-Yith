package com.duanxr.yith.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 段然 2021/3/18
 */
public class ReverseBitsLcci {

  /**
   * You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to find the length of the longest sequence of 1s you could create.
   *
   * Example 1:
   *
   * Input: num = 1775(110111011112)
   * Output: 8
   * Example 2:
   *
   * Input: num = 7(01112)
   * Output: 4
   *
   * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
   *
   * 示例 1：
   *
   * 输入: num = 1775(110111011112)
   * 输出: 8
   * 示例 2：
   *
   * 输入: num = 7(01112)
   * 输出: 4
   *
   */
  class Solution {

    public int reverseBits(int num) {
      int[] bits = new int[32];
      int i = 0;
      while (num != 0) {
        bits[i++] = num & 1;
        num = num >>> 1;
      }
      boolean has0 = false;
      Queue<Integer> queue = new LinkedList<>();
      int max = 1;
      for (int b : bits) {
        if (queue.isEmpty()) {
          if (b == 0) {
            has0 = true;
          }
          queue.offer(b);
        } else {
          if (b == 0) {
            if (!has0) {
              has0 = true;
            } else {
              while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                if (poll == 0) {
                  break;
                }
              }
            }
          }
          queue.offer(b);
          max = Math.max(max, queue.size());
        }
      }
      return max;
    }
  }
}
