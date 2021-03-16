package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/16
 */
public class StringToURLLCCI {

  /**
   * Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters,and that you are given the "true" length of the string. (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
   *
   * Example 1:
   *
   * Input: "Mr John Smith ", 13
   * Output: "Mr%20John%20Smith"
   * Example 2:
   *
   * Input: "               ", 5
   * Output: "%20%20%20%20%20"
   *  
   *
   * Note:
   *
   * 0 <= S.length <= 500000
   *
   * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
   *
   *  
   *
   * 示例 1：
   *
   * 输入："Mr John Smith    ", 13
   * 输出："Mr%20John%20Smith"
   * 示例 2：
   *
   * 输入："               ", 5
   * 输出："%20%20%20%20%20"
   *  
   *
   * 提示：
   *
   * 字符串长度在 [0, 500000] 范围内。
   *
   */
  class Solution {

    public String replaceSpaces(String S, int length) {
      int spaceCount = 0;
      char[] chars = S.toCharArray();
      for (int i = 0; i < length; i++) {
        if (chars[i] == ' ') {
          spaceCount++;
        }
      }
      int newLength = length + spaceCount * 2;
      char[] newChars = new char[newLength];
      int newIndex = 0;
      for (int i = 0; i < length; i++) {
        if (chars[i] == ' ') {
          newChars[newIndex++] = '%';
          newChars[newIndex++] = '2';
          newChars[newIndex++] = '0';

        } else {
          newChars[newIndex++] = chars[i];
        }
      }
      return new String(newChars);
    }
  }

  class Solution1 {

    public String replaceSpaces(String S, int length) {
      int spaceCount = 0;
      char[] chars = S.toCharArray();
      for (int i = 0; i < length; i++) {
        if (chars[i] == ' ') {
          spaceCount++;
        }
      }
      int newLength = length + spaceCount * 2;
      int newIndex = newLength - 1;
      for (int i = length - 1; i >= 0; i--) {
        if (chars[i] == ' ') {
          chars[newIndex--] = '0';
          chars[newIndex--] = '2';
          chars[newIndex--] = '%';
        } else {
          chars[newIndex--] = chars[i];
        }
      }
      return new String(chars, 0, newIndex);
    }
  }
}
