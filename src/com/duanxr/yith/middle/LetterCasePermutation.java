package com.duanxr.yith.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 段然 2021/3/8
 */
public class LetterCasePermutation {

  /**
   * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
   *
   * Return a list of all possible strings we could create. You can return the output in any order.
   *
   *  
   *
   * Example 1:
   *
   * Input: S = "a1b2"
   * Output: ["a1b2","a1B2","A1b2","A1B2"]
   * Example 2:
   *
   * Input: S = "3z4"
   * Output: ["3z4","3Z4"]
   * Example 3:
   *
   * Input: S = "12345"
   * Output: ["12345"]
   * Example 4:
   *
   * Input: S = "0"
   * Output: ["0"]
   *  
   *
   * Constraints:
   *
   * S will be a string with length between 1 and 12.
   * S will consist only of letters or digits.
   *
   * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
   *
   *  
   *
   * 示例：
   * 输入：S = "a1b2"
   * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
   *
   * 输入：S = "3z4"
   * 输出：["3z4", "3Z4"]
   *
   * 输入：S = "12345"
   * 输出：["12345"]
   *  
   *
   * 提示：
   *
   * S 的长度不超过12。
   * S 仅由数字和字母组成。
   *
   */
  class Solution {

    public List<String> letterCasePermutation(String S) {
      if (S == null) {
        return new LinkedList<>();
      }
      List<Integer> index = new ArrayList<>(12);
      for (int i = 0; i < S.length(); i++) {
        if (Character.isLetter(S.charAt(i))) {
          index.add(i);
        }
      }
      List<String> strings = new LinkedList<>();
      if (index.size() == 0) {
        strings.add(S);
        return strings;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < Math.pow(2, index.size()); i++) {
        sb.setLength(0);
        sb.append(S);
        char[] chars = Integer.toBinaryString(i).toCharArray();
        List<Integer> integers = new ArrayList<>();
        for (int j = 0; j < index.size(); j++) {
          int ji = chars.length - 1 - j;
          if (ji < 0 || chars[ji] == '0') {
            int ii = index.get(j);
            sb.setCharAt(ii, Character.toLowerCase(S.charAt(ii)));
          } else {
            int ii = index.get(j);
            sb.setCharAt(ii, Character.toUpperCase(S.charAt(ii)));
          }
        }
        strings.add(sb.toString());
      }
      return strings;
    }

  }
}
