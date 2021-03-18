package com.duanxr.yith.midium;

/**
 * @author 段然 2021/3/18
 */
public class BianryNumberToStringLCCI {

  /**
   * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation. If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR".
   *
   * Example1:
   *
   *  Input: 0.625
   *  Output: "0.101"
   * Example2:
   *
   *  Input: 0.1
   *  Output: "ERROR"
   *  Note: 0.1 cannot be represented accurately in binary.
   * Note:
   *
   * This two charaters "0." should be counted into 32 characters.
   *
   * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
   *
   * 示例1:
   *
   *  输入：0.625
   *  输出："0.101"
   * 示例2:
   *
   *  输入：0.1
   *  输出："ERROR"
   *  提示：0.1无法被二进制准确表示
   * 提示：
   *
   * 32位包括输出中的"0."这两位。
   *
   */
  class Solution {

    public String printBin(double num) {
      StringBuilder sb = new StringBuilder("0.");

      double value = 1D;
      while (sb.length() <= 32 && num != 0D) {
        value /= 2D;
        if (num < value) {
          sb.append('0');
        } else {
          num -= value;
          sb.append('1');
        }
      }

      return num == 0D ? sb.toString() : "ERROR";
    }
  }
}
