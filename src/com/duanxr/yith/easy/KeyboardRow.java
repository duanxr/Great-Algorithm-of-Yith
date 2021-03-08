package com.duanxr.yith.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author 段然 2021/3/8
 */
public class KeyboardRow {

  /**
   * Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
   *
   * In the American keyboard:
   *
   * the first row consists of the characters "qwertyuiop",
   * the second row consists of the characters "asdfghjkl", and
   * the third row consists of the characters "zxcvbnm".
   *
   *  
   *
   * Example 1:
   *
   * Input: words = ["Hello","Alaska","Dad","Peace"]
   * Output: ["Alaska","Dad"]
   * Example 2:
   *
   * Input: words = ["omk"]
   * Output: []
   * Example 3:
   *
   * Input: words = ["adsdf","sfd"]
   * Output: ["adsdf","sfd"]
   *  
   *
   * Constraints:
   *
   * 1 <= words.length <= 20
   * 1 <= words[i].length <= 100
   * words[i] consists of English letters (both lowercase and uppercase). 
   *
   * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
   *
   * 美式键盘 中：
   *
   * 第一行由字符 "qwertyuiop" 组成。
   * 第二行由字符 "asdfghjkl" 组成。
   * 第三行由字符 "zxcvbnm" 组成。
   *
   *
   *  
   *
   * 示例 1：
   *
   * 输入：words = ["Hello","Alaska","Dad","Peace"]
   * 输出：["Alaska","Dad"]
   * 示例 2：
   *
   * 输入：words = ["omk"]
   * 输出：[]
   * 示例 3：
   *
   * 输入：words = ["adsdf","sfd"]
   * 输出：["adsdf","sfd"]
   *  
   *
   * 提示：
   *
   * 1 <= words.length <= 20
   * 1 <= words[i].length <= 100
   * words[i] 由英文字母（小写和大写字母）组成
   *
   */
  class Solution {

    public String[] findWords(String[] words) {
      char[] qList = new char[]{'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};
      char[] aList = new char[]{'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'};
      char[] zList = new char[]{'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
      Map<Character, Character> map = new HashMap<>();
      for (char c : qList) {
        map.put(c, 'Q');
      }
      for (char c : aList) {
        map.put(c, 'A');
      }
      for (char c : zList) {
        map.put(c, 'Z');
      }

      List<String> list = new LinkedList<>();
      outer:
      for (String word : words) {
        String w = word.toUpperCase();
        char c = '0';
        for (int i = 0; i < w.length(); i++) {
          char t = map.get(w.charAt(i));
          if (c != '0' && c != t) {
            continue outer;
          } else if (i == w.length() - 1) {
            list.add(word);
          }
          c = t;
        }
      }
      return list.toArray(new String[list.size()]);
    }
  }
}
