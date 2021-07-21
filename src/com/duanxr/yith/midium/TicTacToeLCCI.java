package com.duanxr.yith.midium;

/**
 * @author 段然 2021/7/21
 */
public class TicTacToeLCCI {

  /**
   * Design an algorithm to figure out if someone has won a game of tic-tac-toe. Input is a string array of size N x N, including characters " ", "X" and "O", where " " represents a empty grid.
   *
   * The rules of tic-tac-toe are as follows:
   *
   * Players place characters into an empty grid(" ") in turn.
   * The first player always place character "O", and the second one place "X".
   * Players are only allowed to place characters in empty grid. Replacing a character is not allowed.
   * If there is any row, column or diagonal filled with N same characters, the game ends. The player who place the last charater wins.
   * When there is no empty grid, the game ends.
   * If the game ends, players cannot place any character further.
   * If there is any winner, return the character that the winner used. If there's a draw, return "Draw". If the game doesn't end and there is no winner, return "Pending".
   *
   * Example 1:
   *
   * Input:  board = ["O X"," XO","X O"]
   * Output:  "X"
   * Example 2:
   *
   * Input:  board = ["OOX","XXO","OXO"]
   * Output:  "Draw"
   * Explanation:  no player wins and no empty grid left
   * Example 3:
   *
   * Input:  board = ["OOX","XXO","OX "]
   * Output:  "Pending"
   * Explanation:  no player wins but there is still a empty grid
   * Note:
   *
   * 1 <= board.length == board[i].length <= 100
   * Input follows the rules.
   *
   * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
   *
   * 以下是井字游戏的规则：
   *
   * 玩家轮流将字符放入空位（" "）中。
   * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
   * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
   * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
   * 当所有位置非空时，也算为游戏结束。
   * 如果游戏结束，玩家不允许再放置字符。
   * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
   *
   * 示例 1：
   *
   * 输入： board = ["O X"," XO","X O"]
   * 输出： "X"
   * 示例 2：
   *
   * 输入： board = ["OOX","XXO","OXO"]
   * 输出： "Draw"
   * 解释： 没有玩家获胜且不存在空位
   * 示例 3：
   *
   * 输入： board = ["OOX","XXO","OX "]
   * 输出： "Pending"
   * 解释： 没有玩家获胜且仍存在空位
   * 提示：
   *
   * 1 <= board.length == board[i].length <= 100
   * 输入一定遵循井字棋规则
   *
   */
  class Solution {

    public String tictactoe(String[] board) {
      int n = board.length;
      boolean hasEmpty = false;
      int[] rows = new int[board.length + 1];
      int[] cols = new int[board[0].length() + 1];

      for (int r = 0; r < n; r++) {
        String s = board[r];
        for (int c = 0; c < n; c++) {
          char ch = s.charAt(c);
          if (ch == ' ') {
            hasEmpty = true;
            continue;
          }
          int d = ch == 'X' ? 1 : -1;
          rows[r] += d;
          cols[c] += d;
          if (r == c) {
            rows[n] += d;
          }
          if (r == n - c - 1) {
            cols[n] += d;
          }
        }
      }

      for (int i = 0; i <= n; i++) {
        int row = rows[i];
        int col = cols[i];
        if (row == n || col == n) {
          return "X";
        } else if (row == -n || col == -n) {
          return "O";
        }
      }

      return hasEmpty ? "Pending" : "Draw";
    }
  }
}
