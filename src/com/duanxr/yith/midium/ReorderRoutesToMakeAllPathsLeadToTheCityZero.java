package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author 段然 2021/9/27
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {

  /**
   * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
   *
   * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
   *
   * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
   *
   * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
   *
   * It's guaranteed that each city can reach city 0 after reorder.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
   * Output: 3
   * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
   * Example 2:
   *
   *
   * Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
   * Output: 2
   * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
   * Example 3:
   *
   * Input: n = 3, connections = [[1,0],[2,0]]
   * Output: 0
   *  
   *
   * Constraints:
   *
   * 2 <= n <= 5 * 104
   * connections.length == n - 1
   * connections[i].length == 2
   * 0 <= ai, bi <= n - 1
   * ai != bi
   *
   * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
   *
   * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
   *
   * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
   *
   * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
   *
   * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
   *
   *  
   *
   * 示例 1：
   *
   *
   *
   * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
   * 输出：3
   * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
   * 示例 2：
   *
   *
   *
   * 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
   * 输出：2
   * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
   * 示例 3：
   *
   * 输入：n = 3, connections = [[1,0],[2,0]]
   * 输出：0
   *  
   *
   * 提示：
   *
   * 2 <= n <= 5 * 10^4
   * connections.length == n-1
   * connections[i].length == 2
   * 0 <= connections[i][0], connections[i][1] <= n-1
   * connections[i][0] != connections[i][1]
   */
  class Solution {

    public int minReorder(int n, int[][] connections) {
      int sum = 0;
      Set<Integer> toZero = new HashSet<>(n);
      toZero.add(0);
      while (toZero.size() != n) {
        for (int[] connection : connections) {
          int f = connection[0];
          int t = connection[1];
          if (toZero.contains(f)) {
            if (toZero.add(t)) {
              sum++;
            }
          } else if (toZero.contains(t)) {
            toZero.add(f);
          }
        }
      }
      return sum;
    }
  }


  class Solution1 {

    public int minReorder(int n, int[][] connections) {
      int sum = 0;
      Set<Integer> notToZero = new HashSet<>();
      for (int i = 1; i < n; i++) {
        notToZero.add(i);
      }
      HashMap<Integer, List<int[]>> map = new HashMap<>(connections.length);
      for (int[] connection : connections) {
        map.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(connection);
        map.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(connection);
      }
      while (!notToZero.isEmpty()) {
        for (Iterator<Integer> iterator = notToZero.iterator(); iterator.hasNext(); ) {
          Integer i = iterator.next();
          List<int[]> list = map.get(i);
          for (int[] ints : list) {
            int c = ints[0] == i ? ints[1] : ints[0];
            if (!notToZero.contains(c)) {
              if (c == ints[0]) {
                sum++;
              }
              iterator.remove();
              break;
            }
          }
        }
      }
      return sum;
    }
  }
}
