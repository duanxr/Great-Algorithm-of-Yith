package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 段然 2021/10/8
 */
public class RepeatedDNASequences {

  /**
   * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
   *
   * For example, "ACGAATTCCG" is a DNA sequence.
   * When studying DNA, it is useful to identify repeated sequences within the DNA.
   *
   * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
   *
   *  
   *
   * Example 1:
   *
   * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
   * Output: ["AAAAACCCCC","CCCCCAAAAA"]
   * Example 2:
   *
   * Input: s = "AAAAAAAAAAAAA"
   * Output: ["AAAAAAAAAA"]
   *  
   *
   * Constraints:
   *
   * 1 <= s.length <= 105
   * s[i] is either 'A', 'C', 'G', or 'T'.
   *
   * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
   *
   * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
   * 输出：["AAAAACCCCC","CCCCCAAAAA"]
   * 示例 2：
   *
   * 输入：s = "AAAAAAAAAAAAA"
   * 输出：["AAAAAAAAAA"]
   *  
   *
   * 提示：
   *
   * 0 <= s.length <= 105
   * s[i] 为 'A'、'C'、'G' 或 'T'
   *
   */
  class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
      Set<String> list = new HashSet<>();
      Set<String> set = new HashSet<>();
      for (int i = 0; i < s.length() - 9; i++) {
        String s1 = s.substring(i, i + 10);
        if (!set.add(s1)) {
          list.add(s1);
        }
      }
      return new ArrayList<>(list);
    }
  }
}
