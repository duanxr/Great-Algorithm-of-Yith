package com.duanxr.yith.hard;

import java.util.Stack;

/**
 * @author 段然 2021/10/11
 */
public class IntegerToEnglishWords {

  /**
   * Convert a non-negative integer num to its English words representation.
   *
   *  
   *
   * Example 1:
   *
   * Input: num = 123
   * Output: "One Hundred Twenty Three"
   * Example 2:
   *
   * Input: num = 12345
   * Output: "Twelve Thousand Three Hundred Forty Five"
   * Example 3:
   *
   * Input: num = 1234567
   * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
   * Example 4:
   *
   * Input: num = 1234567891
   * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
   *  
   *
   * Constraints:
   *
   * 0 <= num <= 231 - 1
   *
   * 将非负整数 num 转换为其对应的英文表示。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：num = 123
   * 输出："One Hundred Twenty Three"
   * 示例 2：
   *
   * 输入：num = 12345
   * 输出："Twelve Thousand Three Hundred Forty Five"
   * 示例 3：
   *
   * 输入：num = 1234567
   * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
   * 示例 4：
   *
   * 输入：num = 1234567891
   * 输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
   *  
   *
   * 提示：
   *
   * 0 <= num <= 231 - 1
   *
   */
  class Solution {

    private final String[] w1 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
        "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"};

    private final String[] w2 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
        "Ninety"};

    private final String[] w3 = {"", "Thousand", "Million", "Billion", "Trillion"};


    public String numberToWords(int num) {
      return num == 0 ? w1[0] : toString(new Stack<>(), num);
    }

    private String toString(Stack<String> stack, int num) {
      int i = 0;
      while (num != 0) {
        int val = num % 1000;
        if (val != 0) {
          if (i > 0) {
            stack.push(w3[i]);
          }
          toString999(stack, val);
        }
        num /= 1000;
        i++;
      }
      StringBuilder sb = new StringBuilder();
      while (!stack.isEmpty()) {
        sb.append(stack.pop()).append(' ');
      }
      sb.setLength(sb.length() - 1);
      return sb.toString();
    }


    private void toString999(Stack<String> stack, int num) {
      toString99(stack, num % 100);
      toString900(stack, num / 100);
    }

    private void toString900(Stack<String> stack, int num) {
      if (num != 0) {
        stack.push("Hundred");
        stack.push(w1[num]);
      }
    }

    private void toString99(Stack<String> stack, int num) {
      if (num != 0) {
        if (num < 20) {
          stack.push(w1[num]);
        } else {
          int mod = num % 10;
          if (mod != 0) {
            stack.push(w1[mod]);
          }
          stack.push(w2[num / 10 - 2]);
        }
      }
    }
  }


  class Solution1 {

    private final String[] w0 = {"Thousand", "Million", "Billion", "Trillion"};

    private final String[] w1 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
        "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"};

    private final String[] w2 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
        "Ninety"};


    public String numberToWords(int num) {
      return num == 0 ? w1[0] : toString(new Stack<>(), num);
    }

    private String toString(Stack<String> stack, int num) {
      int i = 0;
      while (num != 0) {
        int val = num % 1000;
        if (val != 0) {
          if (i > 0) {
            stack.push(w0[i - 1]);
          }
          toString999(stack, val);
        }
        num /= 1000;
        i++;
      }
      StringBuilder sb = new StringBuilder();
      while (!stack.isEmpty()) {
        sb.append(stack.pop()).append(' ');
      }
      sb.setLength(sb.length() - 1);
      return sb.toString();
    }


    private void toString999(Stack<String> stack, int num) {
      if (num != 0) {
        toString99(stack, num % 100);
        toString900(stack, num / 100);
      }
    }

    private void toString900(Stack<String> stack, int num) {
      if (num != 0) {
        stack.push("Hundred");
        stack.push(w1[num]);
      }
    }

    private void toString99(Stack<String> stack, int num) {
      if (num != 0) {
        if (num < 20) {
          stack.push(w1[num]);
        } else {
          int mod = num % 10;
          if (mod != 0) {
            stack.push(w1[mod]);
          }
          stack.push(w2[num / 10 - 2]);
        }
      }
    }
  }
}
