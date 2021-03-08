package com.duanxr.yith.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 段然 2021/3/8
 */
public class ReverseVowelsOfAString {

  /**
   * Write a function that takes a string as input and reverse only the vowels of a string.
   *
   * Example 1:
   *
   * Input: "hello"
   * Output: "holle"
   * Example 2:
   *
   * Input: "leetcode"
   * Output: "leotcede"
   * Note:
   * The vowels does not include the letter "y".
   *
   * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
   *
   *  
   *
   * 示例 1：
   *
   * 输入："hello"
   * 输出："holle"
   * 示例 2：
   *
   * 输入："leetcode"
   * 输出："leotcede"
   *  
   *
   * 提示：
   *
   * 元音字母不包含字母 "y" 。
   *
   */
  class Solution {

    public Solution() {
      characters = new HashSet<>(5);
      characters.add('a');
      characters.add('e');
      characters.add('i');
      characters.add('o');
      characters.add('u');
      characters.add('A');
      characters.add('E');
      characters.add('I');
      characters.add('O');
      characters.add('U');
    }

    private Set<Character> characters;

    public String reverseVowels(String s) {
      StringBuilder sb = new StringBuilder();
      List<Character> characterList = new ArrayList<>(s.length());
      List<Integer> integerList = new ArrayList<>(s.length());
      int i = 0;
      for (char c : s.toCharArray()) {
        sb.append(c);
        if (characters.contains(c)) {
          characterList.add(c);
          integerList.add(i);
        }
        i++;
      }
      i = characterList.size() - 1;
      for (Integer index : integerList) {
        sb.setCharAt(index, characterList.get(i));
        i--;
      }
      return sb.toString();
    }
  }
}
