package com.duanxr.yith.midium;

/**
 * @author 段然 2021/9/1
 */
public class CompareVersionNumbers {

  /**
   * Given two version numbers, version1 and version2, compare them.
   *
   * Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
   *
   * To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
   *
   * Return the following:
   *
   * If version1 < version2, return -1.
   * If version1 > version2, return 1.
   * Otherwise, return 0.
   *  
   *
   * Example 1:
   *
   * Input: version1 = "1.01", version2 = "1.001"
   * Output: 0
   * Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
   * Example 2:
   *
   * Input: version1 = "1.0", version2 = "1.0.0"
   * Output: 0
   * Explanation: version1 does not specify revision 2, which means it is treated as "0".
   * Example 3:
   *
   * Input: version1 = "0.1", version2 = "1.1"
   * Output: -1
   * Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
   * Example 4:
   *
   * Input: version1 = "1.0.1", version2 = "1"
   * Output: 1
   * Example 5:
   *
   * Input: version1 = "7.5.2.4", version2 = "7.5.3"
   * Output: -1
   *  
   *
   * Constraints:
   *
   * 1 <= version1.length, version2.length <= 500
   * version1 and version2 only contain digits and '.'.
   * version1 and version2 are valid version numbers.
   * All the given revisions in version1 and version2 can be stored in a 32-bit integer.
   *
   * 给你两个版本号 version1 和 version2 ，请你比较它们。
   *
   * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
   *
   * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
   *
   * 返回规则如下：
   *
   * 如果 version1 > version2 返回 1，
   * 如果 version1 < version2 返回 -1，
   * 除此之外返回 0。
   *  
   *
   * 示例 1：
   *
   * 输入：version1 = "1.01", version2 = "1.001"
   * 输出：0
   * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
   * 示例 2：
   *
   * 输入：version1 = "1.0", version2 = "1.0.0"
   * 输出：0
   * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
   * 示例 3：
   *
   * 输入：version1 = "0.1", version2 = "1.1"
   * 输出：-1
   * 解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
   * 示例 4：
   *
   * 输入：version1 = "1.0.1", version2 = "1"
   * 输出：1
   * 示例 5：
   *
   * 输入：version1 = "7.5.2.4", version2 = "7.5.3"
   * 输出：-1
   *  
   *
   * 提示：
   *
   * 1 <= version1.length, version2.length <= 500
   * version1 和 version2 仅包含数字和 '.'
   * version1 和 version2 都是 有效版本号
   * version1 和 version2 的所有修订号都可以存储在 32 位整数 中
   *
   */
  class Solution {

    public int compareVersion(String version1, String version2) {
      String[] split1 = version1.split("\\.");
      String[] split2 = version2.split("\\.");
      int length1 = split1.length;
      int length2 = split2.length;
      int i1 = 0;
      int i2 = 0;
      while (i1 < length1 || i2 < length2) {
        int n1 = i1 < length1 ? Integer.parseInt(split1[i1++]) : 0;
        int n2 = i2 < length2 ? Integer.parseInt(split2[i2++]) : 0;
        if (n1 != n2) {
          return n1 < n2 ? -1 : 1;
        }
      }
      return 0;
    }
  }
}
