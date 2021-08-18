package com.duanxr.yith.midium;

/**
 * @author 段然 2021/8/17
 */
public class WordSearch {

  /**
   * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
   *
   * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
   * Output: true
   * Example 2:
   *
   *
   * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
   * Output: true
   * Example 3:
   *
   *
   * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
   * Output: false
   *  
   *
   * Constraints:
   *
   * m == board.length
   * n = board[i].length
   * 1 <= m, n <= 6
   * 1 <= word.length <= 15
   * board and word consists of only lowercase and uppercase English letters.
   *  
   *
   * Follow up: Could you use search pruning to make your solution faster with a larger board?
   *
   * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
   *
   * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
   * 输出：true
   * 示例 2：
   *
   *
   * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
   * 输出：true
   * 示例 3：
   *
   *
   * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
   * 输出：false
   *  
   *
   * 提示：
   *
   * m == board.length
   * n = board[i].length
   * 1 <= m, n <= 6
   * 1 <= word.length <= 15
   * board 和 word 仅由大小写英文字母组成
   *  
   *
   * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
   *
   */
  class Solution {

    public boolean exist(char[][] board, String word) {
      char[] chars = word.toCharArray();
      int wordLength = word.length();
      int rowLength = board.length;
      int colLength = board[0].length;
      for (int i = 0; i < rowLength; i++) {
        for (int j = 0; j < colLength; j++) {
          if (find(board, chars, 0, i, j, rowLength, colLength,
              wordLength)) {
            return true;
          }
        }
      }
      return false;
    }

    private boolean find(char[][] board, char[] chars, int ci, int i, int j,
        int rowLength, int colLength, int wordLength) {
      if (i < 0 || j < 0 || i == rowLength || j == colLength
          || board[i][j] != chars[ci]) {
        return false;
      }
      char c = board[i][j];
      board[i][j] = 0;
      int nci = ci + 1;
      boolean re = nci == wordLength ||
          find(board, chars, nci, i + 1, j, rowLength, colLength, wordLength) ||
          find(board, chars, nci, i, j + 1, rowLength, colLength, wordLength) ||
          find(board, chars, nci, i - 1, j, rowLength, colLength, wordLength) ||
          find(board, chars, nci, i, j - 1, rowLength, colLength, wordLength);
      board[i][j] = c;
      return re;
    }
  }


  class Solution1 {

    public boolean exist(char[][] board, String word) {
      char[] chars = word.toCharArray();
      int wordLength = word.length();
      int rowLength = board.length;
      int colLength = board[0].length;
      byte[][] visited = new byte[rowLength][colLength];
      for (int i = 0; i < rowLength; i++) {
        for (int j = 0; j < colLength; j++) {
          if (find(board, chars, 0, i, j, visited, rowLength, colLength,
              wordLength)) {
            return true;
          }
        }
      }
      return false;
    }

    private boolean find(char[][] board, char[] chars, int ci, int i, int j, byte[][] visited,
        int rowLength, int colLength, int wordLength) {
      if (i < 0 || j < 0 || i == rowLength || j == colLength
          || visited[i][j] == 1 || board[i][j] != chars[ci]) {
        return false;
      }
      visited[i][j] = 1;
      int nci = ci + 1;
      boolean re = nci == wordLength ||
          find(board, chars, nci, i + 1, j, visited, rowLength, colLength, wordLength) ||
          find(board, chars, nci, i, j + 1, visited, rowLength, colLength, wordLength) ||
          find(board, chars, nci, i - 1, j, visited, rowLength, colLength, wordLength) ||
          find(board, chars, nci, i, j - 1, visited, rowLength, colLength, wordLength);
      visited[i][j] = 0;
      return re;
    }
  }
}
