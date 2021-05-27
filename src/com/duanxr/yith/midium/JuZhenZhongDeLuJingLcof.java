package com.duanxr.yith.midium;

/**
 * @author 段然 2021/5/27
 */
public class JuZhenZhongDeLuJingLcof {

  /**
   * English description is not available for the problem. Please switch to Chinese.
   *
   * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
   *
   * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
   *
   *  
   *
   * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
   *
   *
   *
   *  
   *
   * 示例 1：
   *
   * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
   * 输出：true
   * 示例 2：
   *
   * 输入：board = [["a","b"],["c","d"]], word = "abcd"
   * 输出：false
   *  
   *
   * 提示：
   *
   * 1 <= board.length <= 200
   * 1 <= board[i].length <= 200
   * board 和 word 仅由大小写英文字母组成
   *  
   *
   * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
   *
   */
  class Solution {

    public boolean exist(char[][] board, String word) {
      char[] chars = word.toCharArray();
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (find(board, chars, i, j, 0)) {
            return true;
          }
        }
      }
      return false;
    }

    private boolean find(char[][] board, char[] chars, int i, int j, int s) {
      if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != chars[s]) {
        return false;
      }
      if (s == chars.length - 1) {
        return true;
      }
      board[i][j] = '/';
      boolean result = find(board, chars, i, j + 1, s + 1) || find(board, chars, i + 1, j, s + 1)
          || find(board, chars, i - 1, j, s + 1) || find(board, chars, i, j - 1, s + 1);
      board[i][j] = chars[s];
      return result;
    }

  }

  class Solution4 {

    public boolean exist(char[][] board, String word) {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (find(board, word, i, j, 0)) {
            return true;
          }
        }
      }
      return false;
    }

    private boolean find(char[][] board, String word, int i, int j, int s) {
      if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != word
          .charAt(s)) {
        return false;
      }
      if (s == word.length() - 1) {
        return true;
      }
      board[i][j] = '/';
      boolean result = find(board, word, i, j + 1, s + 1) || find(board, word, i + 1, j, s + 1)
          || find(board, word, i - 1, j, s + 1) || find(board, word, i, j - 1, s + 1);
      board[i][j] = word.charAt(s);
      return result;
    }

  }


  class Solution3 {

    public boolean exist(char[][] board, String word) {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (find(board, word, i, j, 0, new byte[board.length][board[i].length])) {
            return true;
          }
        }
      }
      return false;
    }

    private boolean find(char[][] board, String word, int i, int j, int s, byte[][] bytes) {
      if (i < 0 || j < 0 || i == board.length || j == board[0].length || bytes[i][j] == 1
          || board[i][j] != word.charAt(s)) {
        return false;
      }
      if (s == word.length() - 1) {
        return true;
      }
      bytes[i][j] = 1;
      boolean result =
          find(board, word, i, j + 1, s + 1, bytes) || find(board, word, i + 1, j, s + 1, bytes)
              || find(board, word, i - 1, j, s + 1, bytes) || find(board, word, i, j - 1, s + 1,
              bytes);
      bytes[i][j] = 0;
      return result;
    }

  }


  class Solution1 {

    public boolean exist(char[][] board, String word) {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (find(board, word, i, j, 0, new byte[board.length][board[i].length])) {
            return true;
          }
        }
      }
      return false;
    }

    private boolean find(char[][] board, String word, int i, int j, int s, byte[][] bytes) {
      if (i < 0 || j < 0 || i == board.length || j == board[0].length || bytes[i][j] == 1
          || board[i][j] != word.charAt(s)) {
        return false;
      }
      if (s == word.length() - 1) {
        return true;
      }
      bytes[i][j] = 1;
      boolean up = find(board, word, i + 1, j, s + 1, bytes);
      boolean down = find(board, word, i - 1, j, s + 1, bytes);
      boolean left = find(board, word, i, j + 1, s + 1, bytes);
      boolean right = find(board, word, i, j - 1, s + 1, bytes);
      bytes[i][j] = 0;
      return up || down || left || right;
    }

  }
}
