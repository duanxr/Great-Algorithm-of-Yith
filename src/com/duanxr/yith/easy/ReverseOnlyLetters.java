package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class ReverseOnlyLetters {

  /**
   * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
   *
   *  
   *
   * Example 1:
   *
   * Input: "ab-cd"
   * Output: "dc-ba"
   * Example 2:
   *
   * Input: "a-bC-dEf-ghIj"
   * Output: "j-Ih-gfE-dCba"
   * Example 3:
   *
   * Input: "Test1ng-Leet=code-Q!"
   * Output: "Qedo1ct-eeLg=ntse-T!"
   *  
   *
   * Note:
   *
   * S.length <= 100
   * 33 <= S[i].ASCIIcode <= 122 
   * S doesn't contain \ or "
   *
   * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
   *
   *  
   *
   * 示例 1：
   *
   * 输入："ab-cd"
   * 输出："dc-ba"
   * 示例 2：
   *
   * 输入："a-bC-dEf-ghIj"
   * 输出："j-Ih-gfE-dCba"
   * 示例 3：
   *
   * 输入："Test1ng-Leet=code-Q!"
   * 输出："Qedo1ct-eeLg=ntse-T!"
   *  
   *
   * 提示：
   *
   * S.length <= 100
   * 33 <= S[i].ASCIIcode <= 122 
   * S 中不包含 \ or "
   *
   */
  class Solution {

    public String reverseOnlyLetters(String S) {
      StringBuilder sb = new StringBuilder();
      sb.append(S);
      int l = 0;
      int r = sb.length() - 1;
      while (l <= r) {
        boolean lisl = Character.isLetter(sb.charAt(l));
        boolean risl = Character.isLetter(sb.charAt(r));
        if (lisl && risl) {
          char lchar = sb.charAt(l);
          sb.setCharAt(l, sb.charAt(r));
          sb.setCharAt(r, lchar);
          l++;
          r--;
        } else if (lisl) {
          r--;
        } else {
          l++;
        }
      }
      return sb.toString();
    }
  }
}
