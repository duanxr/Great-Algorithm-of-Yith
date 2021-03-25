package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/3/25
 */
public class PermutationILCCI {

  /**
   * Write a method to compute all permutations of a string of unique characters.
   *
   * Example1:
   *
   *  Input: S = "qwe"
   *  Output: ["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
   * Example2:
   *
   *  Input: S = "ab"
   *  Output: ["ab", "ba"]
   * Note:
   *
   * All charaters are English letters.
   * 1 <= S.length <= 9
   *
   * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
   *
   * 示例1:
   *
   *  输入：S = "qwe"
   *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
   * 示例2:
   *
   *  输入：S = "ab"
   *  输出：["ab", "ba"]
   * 提示:
   *
   * 字符都是英文字母。
   * 字符串长度在[1, 9]之间。
   *
   */
  class Solution {

    public String[] permutation(String S) {
      char[] chars = S.toCharArray();
      List<String> list = new ArrayList<>(getCapacity(S.length()));
      find(chars, list, 0);
      return list.toArray(new String[0]);
    }

    private void find(char[] chars, List<String> list, int i) {
      if (i == chars.length - 1) {
        list.add(new String(chars));
      } else {
        int[] visited = new int[256];
        for (int j = i; j < chars.length; j++) {
          if (visited[chars[j]] == 1) {
            continue;
          }
          visited[chars[j]] = 1;
          if (i != j) {
            swap(chars, i, j);
          }
          find(chars, list, i + 1);
          if (i != j) {
            swap(chars, i, j);
          }
        }
      }
    }

    private void swap(char[] chars, int i, int j) {
      char c = chars[i];
      chars[i] = chars[j];
      chars[j] = c;
    }


    private int getCapacity(int length) {
      if (length <= 2) {
        return length;
      }
      return getCapacity(length - 1) * length;
    }
  }
}
