package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/3/30
 */
public class T9LCCI {

  /**
   * On old cell phones, users typed on a numeric keypad and the phone would provide a list of words
   * that matched these numbers. Each digit mapped to a set of 0 - 4 letters. Implement an
   * algo­rithm to return a list of matching words, given a sequence of digits. You are provided a
   * list of valid words. The mapping is shown in the diagram below:
   *
   *
   *
   * Example 1:
   *
   * Input: num = "8733", words = ["tree", "used"] Output: ["tree", "used"] Example 2:
   *
   * Input: num = "2", words = ["a", "b", "c", "d"] Output: ["a", "b", "c"] Note:
   *
   * num.length <= 1000 words.length <= 500 words[i].length == num.length There are no number 0 and
   * 1 in num.
   *
   * 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。映射如下图所示：
   *
   *
   *
   * 示例 1:
   *
   * 输入: num = "8733", words = ["tree", "used"]
   * 输出: ["tree", "used"]
   * 示例 2:
   *
   * 输入: num = "2", words = ["a", "b", "c", "d"]
   * 输出: ["a", "b", "c"]
   * 提示：
   *
   * num.length <= 1000
   * words.length <= 500
   * words[i].length == num.length
   * num中不会出现 0, 1 这两个数字
   *
   *
   * */
  class Solution {

    public List<String> getValidT9Words(String num, String[] words) {
      List<String> list = new ArrayList<>(words.length);
      for (String word : words) {
        if (word.length() == num.length()) {
          list.add(word);
        }
      }
      for (int i = 0; i < num.length(); i++) {
        int nc = num.charAt(i) - '0';
        int finalI = i;
        list.removeIf(str -> {
          char wc = str.charAt(finalI);
          switch (nc) {
            case 1:
              return wc != '!' && wc != '@' && wc != '#';
            case 2:
              return wc < 'a' || wc > 'c';
            case 3:
              return wc < 'd' || wc > 'f';
            case 4:
              return wc < 'g' || wc > 'i';
            case 5:
              return wc < 'j' || wc > 'l';
            case 6:
              return wc < 'm' || wc > 'o';
            case 7:
              return wc < 'p' || wc > 's';
            case 8:
              return wc < 't' || wc > 'v';
            case 9:
              return wc < 'w' || wc > 'z';
            default:
              return wc != '_';
          }
        });
      }
      return list;
    }
  }

  class Solution1 {

    private final int[] MAP = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6,
        6, 6, 7, 7, 7, 7};

    public List<String> getValidT9Words(String num, String[] words) {
      List<String> list = new ArrayList<>(words.length);
      for (String word : words) {
        if (word.length() == num.length()) {
          list.add(word);
        }
      }
      for (int i = 0; i < num.length(); i++) {
        int nc = num.charAt(i) - '0';
        int finalI = i;
        list.removeIf(str -> MAP[str.charAt(finalI) - 'a'] != nc);
      }
      return list;
    }
  }
}
