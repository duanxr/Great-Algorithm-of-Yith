package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class DetectCapital {

  /**
   * Given a word, you need to judge whether the usage of capitals in it is right or not.
   *
   * We define the usage of capitals in a word to be right when one of the following cases holds:
   *
   * All letters in this word are capitals, like "USA".
   * All letters in this word are not capitals, like "leetcode".
   * Only the first letter in this word is capital, like "Google".
   * Otherwise, we define that this word doesn't use capitals in a right way.
   *  
   *
   * Example 1:
   *
   * Input: "USA"
   * Output: True
   *  
   *
   * Example 2:
   *
   * Input: "FlaG"
   * Output: False
   *  
   *
   * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
   *
   * 给定一个单词，你需要判断单词的大写使用是否正确。
   *
   * 我们定义，在以下情况时，单词的大写用法是正确的：
   *
   * 全部字母都是大写，比如"USA"。
   * 单词中所有字母都不是大写，比如"leetcode"。
   * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
   * 否则，我们定义这个单词没有正确使用大写字母。
   *
   * 示例 1:
   *
   * 输入: "USA"
   * 输出: True
   * 示例 2:
   *
   * 输入: "FlaG"
   * 输出: False
   * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
   *
   */
  class Solution {

    public boolean detectCapitalUse(String word) {
      boolean bhl = false;
      boolean bhu = false;
      boolean f = Character.isUpperCase(word.charAt(0));
      for (int i = 1; i < word.length(); i++) {
        if (Character.isUpperCase(word.charAt(i))) {
          bhu = true;
        } else {
          bhl = true;
        }
      }
      return f && word.length() == 1 || f && bhu && !bhl || !f && !bhu || f && !bhu;
    }
  }
}
