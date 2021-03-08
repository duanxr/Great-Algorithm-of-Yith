package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class FindSmallestLetterGreaterThanTarget {

  /**
   * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
   *
   * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
   *
   * Examples:
   * Input:
   * letters = ["c", "f", "j"]
   * target = "a"
   * Output: "c"
   *
   * Input:
   * letters = ["c", "f", "j"]
   * target = "c"
   * Output: "f"
   *
   * Input:
   * letters = ["c", "f", "j"]
   * target = "d"
   * Output: "f"
   *
   * Input:
   * letters = ["c", "f", "j"]
   * target = "g"
   * Output: "j"
   *
   * Input:
   * letters = ["c", "f", "j"]
   * target = "j"
   * Output: "c"
   *
   * Input:
   * letters = ["c", "f", "j"]
   * target = "k"
   * Output: "c"
   * Note:
   * letters has a length in range [2, 10000].
   * letters consists of lowercase letters, and contains at least 2 unique letters.
   * target is a lowercase letter.
   *
   * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
   *
   * 在比较时，字母是依序循环出现的。举个例子：
   *
   * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
   *  
   *
   * 示例：
   *
   * 输入:
   * letters = ["c", "f", "j"]
   * target = "a"
   * 输出: "c"
   *
   * 输入:
   * letters = ["c", "f", "j"]
   * target = "c"
   * 输出: "f"
   *
   * 输入:
   * letters = ["c", "f", "j"]
   * target = "d"
   * 输出: "f"
   *
   * 输入:
   * letters = ["c", "f", "j"]
   * target = "g"
   * 输出: "j"
   *
   * 输入:
   * letters = ["c", "f", "j"]
   * target = "j"
   * 输出: "c"
   *
   * 输入:
   * letters = ["c", "f", "j"]
   * target = "k"
   * 输出: "c"
   *  
   *
   * 提示：
   *
   * letters长度范围在[2, 10000]区间内。
   * letters 仅由小写字母组成，最少包含两个不同的字母。
   * 目标字母target 是一个小写字母。
   *
   */
  class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
      int ascii = target;
      if (letters[letters.length - 1] <= ascii) {
        return letters[0];
      }
      for (int i = 0; i < letters.length; i++) {
        if (letters[i] > ascii) {
          return letters[i];
        }
      }
      return target;
    }

  }
}
