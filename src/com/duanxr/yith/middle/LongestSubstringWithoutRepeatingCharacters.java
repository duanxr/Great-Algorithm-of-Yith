package com.duanxr.yith.middle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 段然 2021/3/8
 */
public class LongestSubstringWithoutRepeatingCharacters {

  /**
   * Given a string s, find the length of the longest substring without repeating characters.
   *
   *  
   *
   * Example 1:
   *
   * Input: s = "abcabcbb"
   * Output: 3
   * Explanation: The answer is "abc", with the length of 3.
   * Example 2:
   *
   * Input: s = "bbbbb"
   * Output: 1
   * Explanation: The answer is "b", with the length of 1.
   * Example 3:
   *
   * Input: s = "pwwkew"
   * Output: 3
   * Explanation: The answer is "wke", with the length of 3.
   * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
   * Example 4:
   *
   * Input: s = ""
   * Output: 0
   *  
   *
   * Constraints:
   *
   * 0 <= s.length <= 5 * 104
   * s consists of English letters, digits, symbols and spaces.
   *
   * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
   *
   *  
   *
   * 示例 1:
   *
   * 输入: s = "abcabcbb"
   * 输出: 3
   * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
   * 示例 2:
   *
   * 输入: s = "bbbbb"
   * 输出: 1
   * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
   * 示例 3:
   *
   * 输入: s = "pwwkew"
   * 输出: 3
   * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
   *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
   * 示例 4:
   *
   * 输入: s = ""
   * 输出: 0
   *  
   *
   * 提示：
   *
   * 0 <= s.length <= 5 * 104
   * s 由英文字母、数字、符号和空格组成
   *
   */
  class Solution {

    public int lengthOfLongestSubstring(String s) {
      Queue<Character> holder = new LinkedList<>();
      int l = 0, ns = 0, ne = 0;
      char[] charArray = s.toCharArray();
      for (int i = 0; i < charArray.length; i++) {
        Character c = charArray[i];
        if (holder.contains(c)) {
          while (true) {
            Character cc = holder.poll();
            ns++;
            if (cc.equals(c)) {
              break;
            }
          }
        }
        holder.offer(c);
        ne++;
        if (holder.size() > l) {
          l = ne - ns;
        }
      }
      return l;
    }
  }
}
