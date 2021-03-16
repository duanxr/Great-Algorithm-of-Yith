package com.duanxr.yith.midium;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author 段然 2021/3/16
 */
public class RouteBetweenNodesLCCI {

  /**
   * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
   *
   * Example1:
   *
   *  Input: n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
   *  Output: true
   * Example2:
   *
   *  Input: n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
   *  Output true
   * Note:
   *
   * 0 <= n <= 100000
   * All node numbers are within the range [0, n].
   * There might be self cycles and duplicated edges.
   *
   * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
   *
   * 示例1:
   *
   *  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
   *  输出：true
   * 示例2:
   *
   *  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
   *  输出 true
   * 提示：
   *
   * 节点数量n在[0, 1e5]范围内。
   * 节点编号大于等于 0 小于 n。
   * 图中可能存在自环和平行边。
   */
  class Solution {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
      Map<Integer, Set<Integer>> map = new HashMap<>();
      for (int[] ints : graph) {
        map.computeIfAbsent(ints[0], integer -> new HashSet<>()).add(ints[1]);
      }
      byte[] bit = new byte[n];
      Stack<Integer> stack = new Stack<>();
      bit[start] = 1;
      stack.push(start);
      while (!stack.isEmpty()) {
        Integer pop = stack.pop();
        Set<Integer> set = map.computeIfAbsent(pop,integer -> Collections.emptySet());
        for (Integer integer : set) {
          if (integer == target) {
            return true;
          }
          if (bit[integer] == 0) {
            bit[integer] = 1;
            stack.push(integer);
          }
        }
      }
      return false;
    }
  }
}
