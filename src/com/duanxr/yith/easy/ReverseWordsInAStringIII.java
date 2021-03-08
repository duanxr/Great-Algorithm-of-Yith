package com.duanxr.yith.easy;

import java.util.LinkedList;

/**
 * @author 段然 2021/3/8
 */
public class ReverseWordsInAStringIII {

  /**
   * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
   *
   *  
   *
   * Example 1:
   *
   * Input: s = "Let's take LeetCode contest"
   * Output: "s'teL ekat edoCteeL tsetnoc"
   * Example 2:
   *
   * Input: s = "God Ding"
   * Output: "doG gniD"
   *  
   *
   * Constraints:
   *
   * 1 <= s.length <= 5 * 104
   * s contains printable ASCII characters.
   * s does not contain any leading or trailing spaces.
   * There is at least one word in s.
   * All the words in s are separated by a single space.
   *
   * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
   *
   *  
   *
   * 示例：
   *
   * 输入："Let's take LeetCode contest"
   * 输出："s'teL ekat edoCteeL tsetnoc"
   *  
   *
   * 提示：
   *
   * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
   *
   */
  class Solution {

    public String reverseWords(String s) {
      StringBuilder stringBuilder = new StringBuilder();
      LinkedList<Character> stack = new LinkedList<>();
      for (char c : s.toCharArray()) {
        if (c != ' ') {
          stack.push(c);
        } else {
          while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
          }
          stringBuilder.append(c);
        }
      }
      while (!stack.isEmpty()) {
        stringBuilder.append(stack.pop());
      }
      return stringBuilder.toString();
    }
  }
}
