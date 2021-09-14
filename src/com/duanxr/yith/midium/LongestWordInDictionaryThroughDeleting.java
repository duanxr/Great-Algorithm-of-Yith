package com.duanxr.yith.midium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author 段然 2021/9/14
 */
public class LongestWordInDictionaryThroughDeleting {

  /**
   * Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
   *
   *  
   *
   * Example 1:
   *
   * Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
   * Output: "apple"
   * Example 2:
   *
   * Input: s = "abpcplea", dictionary = ["a","b","c"]
   * Output: "a"
   *  
   *
   * Constraints:
   *
   * 1 <= s.length <= 1000
   * 1 <= dictionary.length <= 1000
   * 1 <= dictionary[i].length <= 1000
   * s and dictionary[i] consist of lowercase English letters.
   *
   * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
   *
   * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
   * 输出："apple"
   * 示例 2：
   *
   * 输入：s = "abpcplea", dictionary = ["a","b","c"]
   * 输出："a"
   *  
   *
   * 提示：
   *
   * 1 <= s.length <= 1000
   * 1 <= dictionary.length <= 1000
   * 1 <= dictionary[i].length <= 1000
   * s 和 dictionary[i] 仅由小写英文字母组成
   *
   */
  class Solution {

    public String findLongestWord(String string, List<String> dictionary) {
      Queue[] queue = new Queue[26];
      for (int i = 0; i < 26; i++) {
        queue[i] = new ArrayDeque();
      }
      for (int i = 0; i < dictionary.size(); i++) {
        String str = dictionary.get(i);
        queue[str.charAt(0) - 'a'].offer(new int[]{i, 0});
      }
      List<String> result = new ArrayList<>();
      for (int i = 0; i < string.length(); i++) {
        char c = string.charAt(i);
        Queue<int[]> list = queue[c - 'a'];
        int size = list.size();
        for (int j = 0; j < size; j++) {
          int[] ints = list.poll();
          String dic = dictionary.get(ints[0]);
          ints[1]++;
          if (ints[1] == dic.length()) {
            result.add(dic);
          } else {
            queue[dic.charAt(ints[1]) - 'a'].offer(ints);
          }
        }
      }
      if (result.isEmpty()) {
        return "";
      }
      result.sort(
          Comparator.comparing(String::length).reversed()
              .thenComparing(String.CASE_INSENSITIVE_ORDER));
      return result.get(0);
    }
  }


  class Solution1 {

    public String findLongestWord(String string, List<String> dictionary) {
      Map<Character, Queue<int[]>> map = new HashMap<>();
      for (int i = 0; i < dictionary.size(); i++) {
        String str = dictionary.get(i);
        map.computeIfAbsent(str.charAt(0), k -> new ArrayDeque<>()).offer(new int[]{i, 0});
      }
      List<String> result = new ArrayList<>();
      for (int i = 0; i < string.length(); i++) {
        char c = string.charAt(i);
        Queue<int[]> list = map.computeIfAbsent(c, k -> new ArrayDeque<>());
        int size = list.size();
        for (int j = 0; j < size; j++) {
          int[] ints = list.poll();
          String dic = dictionary.get(ints[0]);
          ints[1]++;
          if (ints[1] == dic.length()) {
            result.add(dic);
          } else {
            map.computeIfAbsent(dic.charAt(ints[1]), k -> new ArrayDeque<>()).offer(ints);
          }
        }
      }
      if (result.isEmpty()) {
        return "";
      }
      result.sort(
          Comparator.comparing(String::length).reversed()
              .thenComparing(String.CASE_INSENSITIVE_ORDER));
      return result.get(0);
    }
  }
}
