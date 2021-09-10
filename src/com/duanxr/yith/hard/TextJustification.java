package com.duanxr.yith.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/9/10
 */
public class TextJustification {

  /**
   * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
   *
   * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
   *
   * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
   *
   * For the last line of text, it should be left-justified and no extra space is inserted between words.
   *
   * Note:
   *
   * A word is defined as a character sequence consisting of non-space characters only.
   * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
   * The input array words contains at least one word.
   *  
   *
   * Example 1:
   *
   * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
   * Output:
   * [
   *    "This    is    an",
   *    "example  of text",
   *    "justification.  "
   * ]
   * Example 2:
   *
   * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
   * Output:
   * [
   *   "What   must   be",
   *   "acknowledgment  ",
   *   "shall be        "
   * ]
   * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
   * Note that the second line is also left-justified becase it contains only one word.
   * Example 3:
   *
   * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
   * Output:
   * [
   *   "Science  is  what we",
   *   "understand      well",
   *   "enough to explain to",
   *   "a  computer.  Art is",
   *   "everything  else  we",
   *   "do                  "
   * ]
   *  
   *
   * Constraints:
   *
   * 1 <= words.length <= 300
   * 1 <= words[i].length <= 20
   * words[i] consists of only English letters and symbols.
   * 1 <= maxWidth <= 100
   * words[i].length <= maxWidth
   *
   * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
   *
   * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
   *
   * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
   *
   * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
   *
   * 说明:
   *
   * 单词是指由非空格字符组成的字符序列。
   * 每个单词的长度大于 0，小于等于 maxWidth。
   * 输入单词数组 words 至少包含一个单词。
   * 示例:
   *
   * 输入:
   * words = ["This", "is", "an", "example", "of", "text", "justification."]
   * maxWidth = 16
   * 输出:
   * [
   *    "This    is    an",
   *    "example  of text",
   *    "justification.  "
   * ]
   * 示例 2:
   *
   * 输入:
   * words = ["What","must","be","acknowledgment","shall","be"]
   * maxWidth = 16
   * 输出:
   * [
   *   "What   must   be",
   *   "acknowledgment  ",
   *   "shall be        "
   * ]
   * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
   *      因为最后一行应为左对齐，而不是左右两端对齐。
   *      第二行同样为左对齐，这是因为这行只包含一个单词。
   * 示例 3:
   *
   * 输入:
   * words = ["Science","is","what","we","understand","well","enough","to","explain",
   *          "to","a","computer.","Art","is","everything","else","we","do"]
   * maxWidth = 20
   * 输出:
   * [
   *   "Science  is  what we",
   *   "understand      well",
   *   "enough to explain to",
   *   "a  computer.  Art is",
   *   "everything  else  we",
   *   "do                  "
   * ]
   *
   */
  class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
      List<String> list = new ArrayList<>();
      List<String> tmp = new ArrayList<>();
      int cl = 0;
      int i = 0;
      while (i < words.length) {
        String word = words[i];
        if (cl == 0) {
          tmp.add(word);
          cl += word.length();
        } else if (cl + word.length() + 1 <= maxWidth) {
          tmp.add(word);
          cl += word.length() + 1;
        } else {
          full(tmp, list, maxWidth);
          tmp.add(word);
          cl = word.length();
        }
        i++;
      }
      full0(tmp, list, maxWidth);
      return list;
    }

    private void full0(List<String> tmp, List<String> list, int maxWidth) {
      if (!tmp.isEmpty()) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.size(); i++) {
          sb.append(tmp.get(i));
          if (i != tmp.size() - 1) {
            sb.append(" ");
          }
        }
        while (sb.length() < maxWidth) {
          sb.append(" ");
        }
        list.add(sb.toString());
      }
    }

    private void full(List<String> tmp, List<String> list, int maxWidth) {
      int n = 0;
      for (String s : tmp) {
        n += s.length();
      }
      n = maxWidth - n;
      boolean isOnlyOne = (tmp.size() - 1) == 0;
      int pd = isOnlyOne ? n : n % (tmp.size() - 1);
      n = isOnlyOne ? 0 : n / (tmp.size() - 1);
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < tmp.size(); i++) {
        sb.append(tmp.get(i));
        if (i != tmp.size() - 1) {
          for (int j = 0; j < n; j++) {
            sb.append(" ");
          }
          if (pd != 0) {
            sb.append(" ");
            pd--;
          }
        } else {
          while (pd != 0) {
            sb.append(" ");
            pd--;
          }
        }
      }
      list.add(sb.toString());
      tmp.clear();
    }
  }


  class Solution1 {

    public List<String> fullJustify(String[] words, int maxWidth) {
      List<String> list = new ArrayList<>();
      List<String> tmp = new ArrayList<>();
      int cl = 0;
      int i = 0;
      while (i < words.length) {
        if (cl == 0) {
          tmp.add(words[i]);
          cl += words[i].length();
        } else if (cl + words[i].length() + 1 <= maxWidth) {
          tmp.add(words[i]);
          cl += words[i].length() + 1;
        } else {
          full(tmp, list, maxWidth);
          tmp.add(words[i]);
          cl = words[i].length();
        }
        i++;
      }
      full0(tmp, list, maxWidth);

      return list;
    }

    private void full0(List<String> tmp, List<String> list, int maxWidth) {
      if (!tmp.isEmpty()) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.size(); i++) {
          sb.append(tmp.get(i));
          if (i != tmp.size() - 1) {
            sb.append(" ");
          }
        }
        while (sb.length() < maxWidth) {
          sb.append(" ");
        }
        list.add(sb.toString());
      }
    }

    private void full(List<String> tmp, List<String> list, int maxWidth) {
      int n = 0;
      for (String s : tmp) {
        n += s.length();
      }
      n = maxWidth - n;
      int pd = (tmp.size() - 1) == 0 ? n : n % (tmp.size() - 1);
      n = (tmp.size() - 1) == 0 ? 0 : n / (tmp.size() - 1);
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < tmp.size(); i++) {
        sb.append(tmp.get(i));
        if (i != tmp.size() - 1) {
          for (int j = 0; j < n; j++) {
            sb.append(" ");
          }
          if (pd != 0) {
            sb.append(" ");
            pd--;
          }
        } else {
          while (pd != 0) {
            sb.append(" ");
            pd--;
          }
        }

      }
      list.add(sb.toString());
      tmp.clear();
    }
  }
}
