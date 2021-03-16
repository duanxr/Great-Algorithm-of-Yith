package com.duanxr.yith.midium;

/**
 * @author 段然 2021/3/11
 */
public class ZuiChangBuHanChongFuZiFuDeZiZiFuChuanLcof {

  /**
   * English description is not available for the problem.
   *
   * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
   *
   *  
   *
   * 示例 1:
   *
   * 输入: "abcabcbb"
   * 输出: 3
   * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
   * 示例 2:
   *
   * 输入: "bbbbb"
   * 输出: 1
   * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
   * 示例 3:
   *
   * 输入: "pwwkew"
   * 输出: 3
   * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
   *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
   *  
   *
   * 提示：
   *
   * s.length <= 40000
   * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
   *
   */
  class Solution {

    public int lengthOfLongestSubstring(String s) {
      byte[] biMap = new byte[256];
      char[] chars = s.toCharArray();
      int l = 0;
      int max = 0;
      for (int i = 0; i < chars.length; i++) {
        int charNum = chars[i];
        if (biMap[charNum] == 1) {
          while (biMap[charNum] != 0) {
            biMap[chars[l++]] = 0;
          }
        }
        biMap[charNum] = 1;
        max = Math.max(i - l + 1, max);
      }
      return max;
    }
  }
}
