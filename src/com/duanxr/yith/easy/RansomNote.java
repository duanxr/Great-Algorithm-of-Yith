package com.duanxr.yith.easy;

import java.util.Arrays;

/**
 * @author 段然 2021/3/8
 */
public class RansomNote {

  /**
   * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
   *
   * Each letter in the magazine string can only be used once in your ransom note.
   *
   *  
   *
   * Example 1:
   *
   * Input: ransomNote = "a", magazine = "b"
   * Output: false
   * Example 2:
   *
   * Input: ransomNote = "aa", magazine = "ab"
   * Output: false
   * Example 3:
   *
   * Input: ransomNote = "aa", magazine = "aab"
   * Output: true
   *  
   *
   * Constraints:
   *
   * You may assume that both strings contain only lowercase letters.
   *
   * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
   *
   * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
   *
   *  
   *
   * 示例 1：
   *
   * 输入：ransomNote = "a", magazine = "b"
   * 输出：false
   * 示例 2：
   *
   * 输入：ransomNote = "aa", magazine = "ab"
   * 输出：false
   * 示例 3：
   *
   * 输入：ransomNote = "aa", magazine = "aab"
   * 输出：true
   *  
   *
   * 提示：
   *
   * 你可以假设两个字符串均只含有小写字母。
   *
   */
  class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
      if (magazine.length() < ransomNote.length()) {
        return false;
      }
      char[] r = ransomNote.toCharArray();
      char[] m = magazine.toCharArray();
      Arrays.sort(r);
      Arrays.sort(m);
      int ri = 0;
      int mi = 0;
      while (true) {
        if (ri == r.length) {
          return true;
        }
        if (mi == m.length || r[ri] < m[mi]) {
          return false;
        }
        if (r[ri] == m[mi]) {
          ri++;
          mi++;
        } else if (r[ri] > m[mi]) {
          mi++;
        }
      }
    }
  }
}
