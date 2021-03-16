package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/16
 */
public class PalindromePermutationLCCI {

  /**
   * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
   *
   *  
   *
   * Example1:
   *
   * Input: "tactcoa"
   * Output: true（permutations: "tacocat"、"atcocta", etc.）
   *  
   *
   * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
   *
   * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
   *
   * 回文串不一定是字典当中的单词。
   *
   *  
   *
   * 示例1：
   *
   * 输入："tactcoa"
   * 输出：true（排列有"tacocat"、"atcocta"，等等）
   *  
   *
   */
  class Solution {

    public boolean canPermutePalindrome(String s) {
      int[] bit = new int[256];
      for (int i = 0; i < s.length(); i++) {
        int c = s.charAt(i);
        bit[c]++;
      }
      boolean flag = false;
      for (int n : bit) {
        if (n % 2 == 1) {
          if (flag) {
            return false;
          }
          flag = true;
        }
      }
      return true;
    }
  }
}
