package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 段然 2021/7/21
 */
public class GroupAnagramsLCCI {

  /**
   * Write a method to sort an array of strings so that all the anagrams are in the same group.
   *
   * Note: This problem is slightly different from the original one the book.
   *
   * Example:
   *
   * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
   * Output:
   * [
   *   ["ate","eat","tea"],
   *   ["nat","tan"],
   *   ["bat"]
   * ]
   * Notes:
   *
   * All inputs will be in lowercase.
   * The order of your output does not matter.
   *
   * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
   *
   * 注意：本题相对原题稍作修改
   *
   * 示例:
   *
   * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
   * 输出:
   * [
   *   ["ate","eat","tea"],
   *   ["nat","tan"],
   *   ["bat"]
   * ]
   * 说明：
   *
   * 所有输入均为小写字母。
   * 不考虑答案输出的顺序。
   */
  class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
      Map<Integer, List<String>> map = new HashMap<>(strs.length);
      for (String str : strs) {
        int[] hash = new int[26];
        for (int i = 0; i < str.length(); i++) {
          char c = str.charAt(i);
          hash[c - 'a']++;
        }
        map.computeIfAbsent(Arrays.hashCode(hash), k -> new ArrayList<>()).add(str);
      }
      return new ArrayList<>(map.values());
    }
  }

  class Solution1 {

    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> map = new HashMap<>(strs.length);
      for (String str : strs) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        map.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(str);
      }
      return new ArrayList<>(map.values());
    }
  }

}
