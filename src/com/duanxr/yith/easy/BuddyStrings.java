package com.duanxr.yith.easy;

/**
 * @author 段然 2021/6/17
 */
public class BuddyStrings {

  /**
   * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
   *
   * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
   *
   * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
   *  
   *
   * Example 1:
   *
   * Input: s = "ab", goal = "ba"
   * Output: true
   * Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
   * Example 2:
   *
   * Input: s = "ab", goal = "ab"
   * Output: false
   * Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
   * Example 3:
   *
   * Input: s = "aa", goal = "aa"
   * Output: true
   * Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
   * Example 4:
   *
   * Input: s = "aaaaaaabc", goal = "aaaaaaacb"
   * Output: true
   *  
   *
   * Constraints:
   *
   * 1 <= s.length, goal.length <= 2 * 104
   * s and goal consist of lowercase letters.
   *
   * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
   *
   * 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
   *
   *  
   *
   * 示例 1：
   *
   * 输入： A = "ab", B = "ba"
   * 输出： true
   * 解释： 你可以交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 相等。
   * 示例 2：
   *
   * 输入： A = "ab", B = "ab"
   * 输出： false
   * 解释： 你只能交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 不相等。
   * 示例 3:
   *
   * 输入： A = "aa", B = "aa"
   * 输出： true
   * 解释： 你可以交换 A[0] = 'a' 和 A[1] = 'a' 生成 "aa"，此时 A 和 B 相等。
   * 示例 4：
   *
   * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
   * 输出： true
   * 示例 5：
   *
   * 输入： A = "", B = "aa"
   * 输出： false
   *  
   *
   * 提示：
   *
   * 0 <= A.length <= 20000
   * 0 <= B.length <= 20000
   * A 和 B 仅由小写字母构成。
   *
   */
  class Solution {

    public boolean buddyStrings(String a, String b) {
      if (a.length() != b.length()) {
        return false;
      }
      int i1 = -1;
      int i2 = -1;
      byte[] bits = new byte[26];
      char[] ca = a.toCharArray();
      char[] cb = b.toCharArray();
      boolean isRepeat = false;
      for (int i = 0; i < a.length(); i++) {
        if (ca[i] == cb[i]) {
          if (!isRepeat) {
            int bit = bits[ca[i] - 'a'];
            if (bit == 1) {
              isRepeat = true;
            } else {
              bits[ca[i] - 'a'] = (byte) (bit + 1);
            }
          }
        } else {
          if (i2 != -1) {
            return false;
          } else if (i1 != -1) {
            i2 = i;
          } else {
            i1 = i;
          }
        }
      }
      if (i1 != -1) {
        if (i2 == -1) {
          return false;
        }
        return ca[i1] == cb[i2] && ca[i2] == cb[i1];
      }
      return isRepeat;
    }
  }


  class Solution2 {

    public boolean buddyStrings(String a, String b) {
      if (a.length() != b.length()) {
        return false;
      }
      int i1 = -1;
      int i2 = -1;
      int[] bits = new int[26];
      char[] ca = a.toCharArray();
      char[] cb = b.toCharArray();
      for (int i = 0; i < a.length(); i++) {
        if (ca[i] == cb[i]) {
          bits[ca[i] - 'a']++;
        } else {
          if (i2 != -1) {
            return false;
          } else if (i1 != -1) {
            i2 = i;
          } else {
            i1 = i;
          }
        }
      }
      if (i1 != -1) {
        if (i2 == -1) {
          return false;
        }
        return ca[i1] == cb[i2] && ca[i2] == cb[i1];
      }
      for (int bit : bits) {
        if (bit >= 2) {
          return true;
        }
      }
      return false;
    }
  }


  class Solution1 {

    public boolean buddyStrings(String a, String b) {
      if (a.length() != b.length()) {
        return false;
      }
      int i1 = -1;
      int i2 = -1;
      int[] bits = new int[26];
      for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) == b.charAt(i)) {
          bits[a.charAt(i) - 'a']++;
        } else {
          if (i2 != -1) {
            return false;
          } else if (i1 != -1) {
            i2 = i;
          } else {
            i1 = i;
          }
        }
      }
      if (i1 != -1) {
        if (i2 == -1) {
          return false;
        }
        return a.charAt(i1) == b.charAt(i2) && a.charAt(i2) == b.charAt(i1);
      }
      for (int bit : bits) {
        if (bit >= 2) {
          return true;
        }
      }
      return false;
    }
  }
}
