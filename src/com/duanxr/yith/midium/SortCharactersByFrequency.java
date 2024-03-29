package com.duanxr.yith.midium;

import java.util.Arrays;

/**
 * @author 段然 2021/7/22
 */
public class SortCharactersByFrequency {

  /**
   * Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string.
   *
   *  
   *
   * Example 1:
   *
   * Input: s = "tree"
   * Output: "eert"
   * Explanation: 'e' appears twice while 'r' and 't' both appear once.
   * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
   * Example 2:
   *
   * Input: s = "cccaaa"
   * Output: "aaaccc"
   * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
   * Note that "cacaca" is incorrect, as the same characters must be together.
   * Example 3:
   *
   * Input: s = "Aabb"
   * Output: "bbAa"
   * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
   * Note that 'A' and 'a' are treated as two different characters.
   *  
   *
   * Constraints:
   *
   * 1 <= s.length <= 5 * 105
   * s consists of English letters and digits.
   *
   * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
   *
   * 示例 1:
   *
   * 输入:
   * "tree"
   *
   * 输出:
   * "eert"
   *
   * 解释:
   * 'e'出现两次，'r'和't'都只出现一次。
   * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
   * 示例 2:
   *
   * 输入:
   * "cccaaa"
   *
   * 输出:
   * "cccaaa"
   *
   * 解释:
   * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
   * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
   * 示例 3:
   *
   * 输入:
   * "Aabb"
   *
   * 输出:
   * "bbAa"
   *
   * 解释:
   * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
   * 注意'A'和'a'被认为是两种不同的字符。
   *
   */
  class Solution {

    public String frequencySort(String s) {
      if (s.length() == 0) {
        return "";
      }
      int[][] list = new int[256][2];

      for (int i = 0; i < list.length; i++) {
        int[] ints = new int[2];
        ints[1] = i;
        list[i] = ints;
      }

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        list[c][0]++;
      }

      Arrays.sort(list, (o1, o2) -> Integer.compare(o2[0], o1[0]));

      StringBuilder sb = new StringBuilder();

      for (int[] ints : list) {
        if (ints[0] == 0) {
          break;
        }
        char c = (char) ints[1];
        for (int i = 0; i < ints[0]; i++) {
          sb.append(c);
        }
      }

      return sb.toString();
    }
  }
}
