package com.duanxr.yith.midium;

import java.util.Arrays;

/**
 * @author 段然 2021/8/13
 */
public class MPnaiL {

  /**
   * English description is not available for the problem. Please switch to Chinese.
   *
   * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
   *
   * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
   *
   *  
   *
   * 示例 1：
   *
   * 输入: s1 = "ab" s2 = "eidbaooo"
   * 输出: True
   * 解释: s2 包含 s1 的排列之一 ("ba").
   * 示例 2：
   *
   * 输入: s1= "ab" s2 = "eidboaoo"
   * 输出: False
   *  
   *
   * 提示：
   *
   * 1 <= s1.length, s2.length <= 104
   * s1 和 s2 仅包含小写字母
   *  
   *
   * 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/
   *
   */
  class Solution {

    public boolean checkInclusion(String s1, String s2) {

      int[] map1 = new int[26];
      int[] map2 = new int[26];
      int length1 = s1.length();
      int length2 = s2.length();
      int length3 = s1.length() - 1;

      for (int i = 0; i < length1; i++) {
        map1[s1.charAt(i) - 'a']++;
      }

      for (int i = 0; i < length2; i++) {
        map2[s2.charAt(i) - 'a']++;
        if (i > length3) {
          map2[s2.charAt(i - length1) - 'a']--;
        }
        if (i >= length3) {
          if (Arrays.equals(map1, map2)) {
            return true;
          }
        }
      }

      return false;
    }
  }
}
