package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author 段然 2021/3/25
 */
public class RobotInAGridLCCI {

  /**
   * Imagine a robot sitting on the upper left corner of grid with r rows and c columns. The robot can only move in two directions, right and down, but certain cells are "off limits" such that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right.
   *
   *
   *
   * "off limits" and empty grid are represented by 1 and 0 respectively.
   *
   * Return a valid path, consisting of row number and column number of grids in the path.
   *
   * Example 1:
   *
   * Input:
   * [
   *   [0,0,0],
   *   [0,1,0],
   *   [0,0,0]
   * ]
   * Output: [[0,0],[0,1],[0,2],[1,2],[2,2]]
   * Note:
   *
   * r, c <= 100
   *
   * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
   *
   *
   *
   * 网格中的障碍物和空位置分别用 1 和 0 来表示。
   *
   * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
   *
   * 示例 1:
   *
   * 输入:
   * [
   *   [0,0,0],
   *   [0,1,0],
   *   [0,0,0]
   * ]
   * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
   * 解释:
   * 输入中标粗的位置即为输出表示的路径，即
   * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
   * 说明：r 和 c 的值均不超过 100。
   *
   */
  class Solution {

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
      if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
        return Collections.emptyList();
      }
      Stack<List<Integer>> stack = new Stack<>();
      List<List<Integer>> lists = new ArrayList<>();
      findPath(0, 0, obstacleGrid, stack, lists);
      return lists;
    }

    private void findPath(int x, int y, int[][] obstacleGrid,
        Stack<List<Integer>> stack, List<List<Integer>> lists) {
      if (x == obstacleGrid[0].length || y == obstacleGrid.length || obstacleGrid[y][x] == 1
          || !lists
          .isEmpty()) {
        return;
      }
      obstacleGrid[y][x] = 1;
      List<Integer> position = new ArrayList<>(2);
      position.add(y);
      position.add(x);
      stack.push(position);
      if (y == obstacleGrid.length - 1 && x == obstacleGrid[0].length - 1) {
        lists.addAll(stack);
      }
      findPath(x + 1, y, obstacleGrid, stack, lists);
      findPath(x, y + 1, obstacleGrid, stack, lists);
      stack.pop();
    }
  }
}

