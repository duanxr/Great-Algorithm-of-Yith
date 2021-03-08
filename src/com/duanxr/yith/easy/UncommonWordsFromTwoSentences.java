package com.duanxr.yith.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author 段然 2021/3/8
 */
public class UncommonWordsFromTwoSentences {

  /**
   * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
   *
   * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
   *
   * Return a list of all uncommon words. 
   *
   * You may return the list in any order.
   *
   *  
   *
   * Example 1:
   *
   * Input: A = "this apple is sweet", B = "this apple is sour"
   * Output: ["sweet","sour"]
   * Example 2:
   *
   * Input: A = "apple apple", B = "banana"
   * Output: ["banana"]
   *  
   *
   * Note:
   *
   * 0 <= A.length <= 200
   * 0 <= B.length <= 200
   * A and B both contain only spaces and lowercase letters.
   *
   * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
   *
   * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
   *
   * 返回所有不常用单词的列表。
   *
   * 您可以按任何顺序返回列表。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：A = "this apple is sweet", B = "this apple is sour"
   * 输出：["sweet","sour"]
   * 示例 2：
   *
   * 输入：A = "apple apple", B = "banana"
   * 输出：["banana"]
   *  
   *
   * 提示：
   *
   * 0 <= A.length <= 200
   * 0 <= B.length <= 200
   * A 和 B 都只包含空格和小写字母。
   *
   */
  class Solution {

    public String[] uncommonFromSentences(String A, String B) {
      List<String> strings = new ArrayList<>();
      Map<String, Integer> map = new HashMap<>();
      String[] a = A.split(" ");
      String[] b = B.split(" ");

      for (String s : a) {
        if (map.containsKey(s)) {
          map.put(s, map.get(s + 1));
        } else {
          map.put(s, 1);
        }
      }
      for (String s : b) {
        if (map.containsKey(s)) {
          map.put(s, map.get(s + 1));
        } else {
          map.put(s, 1);
        }
      }
      for (Map.Entry<String, Integer> entry : map.entrySet()) {
        if (entry.getValue() != null && entry.getValue() == 1) {
          strings.add(entry.getKey());
        }
      }
      String[] r = new String[strings.size()];
      Iterator iterator = strings.iterator();
      for (int i = 0; i < strings.size(); i++) {
        r[i] = (String) iterator.next();
      }
      return r;
    }
  }

}
