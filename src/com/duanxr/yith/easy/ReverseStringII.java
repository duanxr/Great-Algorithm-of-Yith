package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class ReverseStringII {

  /**
   * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
   *
   * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
   *
   *  
   *
   * Example 1:
   *
   * Input: s = "abcdefg", k = 2
   * Output: "bacdfeg"
   * Example 2:
   *
   * Input: s = "abcd", k = 2
   * Output: "bacd"
   *  
   *
   * Constraints:
   *
   * 1 <= s.length <= 104
   * s consists of only lowercase English letters.
   * 1 <= k <= 104
   *
   * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
   *
   * 如果剩余字符少于 k 个，则将剩余字符全部反转。
   * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
   *  
   *
   * 示例:
   *
   * 输入: s = "abcdefg", k = 2
   * 输出: "bacdfeg"
   *  
   *
   * 提示：
   *
   * 该字符串只包含小写英文字母。
   * 给定字符串的长度和 k 在 [1, 10000] 范围内。
   *
   */
  class Solution {

    public String reverseStr(String s, int k) {
      StringBuilder sb = new StringBuilder(s);
      int length = s.length();
      int index = 0;
      while (true) {
        if (length - index < k) {
          reverseChar(sb, index, length - 1);
          break;
        }
        if (length - index < 2 * k) {
          reverseChar(sb, index, index + k - 1);
          break;
        }
        reverseChar(sb, index, index + k - 1);
        index += 2 * k;
      }
      return sb.toString();
    }

    private void reverseChar(StringBuilder sb, int l, int r) {
      while (l < r) {
        char tmp = sb.charAt(l);
        sb.setCharAt(l, sb.charAt(r));
        sb.setCharAt(r, tmp);
        l++;
        r--;
      }
    }
  }
}
