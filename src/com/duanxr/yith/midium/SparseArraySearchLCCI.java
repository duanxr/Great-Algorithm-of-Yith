package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/4/7
 */
public class SparseArraySearchLCCI {


  /**
   * Given a sorted array of strings that is interspersed with empty strings, write a method to find the location of a given string.
   *
   * Example1:
   *
   *  Input: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
   *  Output: -1
   *  Explanation: Return -1 if s is not in words.
   * Example2:
   *
   *  Input: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
   *  Output: 4
   * Note:
   *
   * 1 <= words.length <= 1000000
   *
   * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
   *
   * 示例1:
   *
   *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
   *  输出：-1
   *  说明: 不存在返回-1。
   * 示例2:
   *
   *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
   *  输出：4
   * 提示:
   *
   * words的长度在[1, 1000000]之间
   *
   */
  class Solution {

    public int findString(String[] words, String s) {
      if (words.length == 0) {
        return -1;
      }
      List<String> wordList = new ArrayList<>();
      List<Integer> indexList = new ArrayList<>();
      for (int i = 0; i < words.length; i++) {
        String word = words[i];
        if (!word.isEmpty()) {
          wordList.add(word);
          indexList.add(i);
        }
      }
      return find(wordList, indexList, s, 0, wordList.size() - 1);
    }

    private int find(List<String> wordList, List<Integer> indexList, String s, int l, int r) {
      if (l > r) {
        return -1;
      }
      int index = l + ((r - l) / 2);
      int compare = wordList.get(index).compareTo(s);
      if (compare == 0) {
        return indexList.get(index);
      }
      if (compare > 0) {
        return find(wordList, indexList, s, l, index - 1);
      } else {
        return find(wordList, indexList, s, index + 1, r);
      }
    }
  }
}
