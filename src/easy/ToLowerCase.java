package easy;

/**
 * @author Duanran 2019/1/16 0016
 */
public class ToLowerCase {

  /**
   * Implement function ToLowerCase() that has a string parameter str, and returns the same string
   * in lowercase.
   *
   * Example 1:
   *
   * Input: "Hello" Output: "hello"
   *
   * Example 2:
   *
   * Input: "here" Output: "here"
   *
   * Example 3:
   *
   * Input: "LOVELY" Output: "lovely"
   *
   * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
   *
   * 示例 1：
   *
   * 输入: "Hello" 输出: "hello"
   *
   * 示例 2：
   *
   * 输入: "here" 输出: "here"
   *
   * 示例 3：
   *
   * 输入: "LOVELY"
   *
   * 输出: "lovely"
   */
  class Solution {

    public String toLowerCase(String str) {
      StringBuilder sb = new StringBuilder();
      for (char c : str.toCharArray()) {
        sb.append(Character.toLowerCase(c));
      }
      return sb.toString();
    }
  }
}
