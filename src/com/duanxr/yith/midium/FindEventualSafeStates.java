package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 段然 2021/8/5
 */
public class FindEventualSafeStates {

  /**
   * We start at some node in a directed graph, and every turn, we walk along a directed edge of the graph. If we reach a terminal node (that is, it has no outgoing directed edges), we stop.
   *
   * We define a starting node to be safe if we must eventually walk to a terminal node. More specifically, there is a natural number k, so that we must have stopped at a terminal node in less than k steps for any choice of where to walk.
   *
   * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
   *
   * The directed graph has n nodes with labels from 0 to n - 1, where n is the length of graph. The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph, going from node i to node j.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
   * Output: [2,4,5,6]
   * Explanation: The given graph is shown above.
   * Example 2:
   *
   * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
   * Output: [4]
   *  
   *
   * Constraints:
   *
   * n == graph.length
   * 1 <= n <= 104
   * 0 <= graph[i].length <= n
   * graph[i] is sorted in a strictly increasing order.
   * The graph may contain self-loops.
   * The number of edges in the graph will be in the range [1, 4 * 104].
   *
   * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
   *
   * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
   *
   * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
   *
   * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
   * 输出：[2,4,5,6]
   * 解释：示意图如上。
   * 示例 2：
   *
   * 输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
   * 输出：[4]
   *  
   *
   * 提示：
   *
   * n == graph.length
   * 1 <= n <= 104
   * 0 <= graph[i].length <= n
   * graph[i] 按严格递增顺序排列。
   * 图中可能包含自环。
   * 图中边的数目在范围 [1, 4 * 104] 内。
   *
   */
  class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
      List<Integer> list = new ArrayList<>();
      int length = graph.length;
      int[] isSafe = new int[length];
      int[] visited = new int[length];
      for (int i = 0; i < length; i++) {
        if (isSafe(graph, i, isSafe, visited) >= 0) {
          list.add(i);
        }
      }
      return list;
    }

    private int isSafe(int[][] graph, int i, int[] isSafe, int[] visited) {
      if (isSafe[i] != 0) {
        return isSafe[i];
      }
      if (visited[i] == 1) {
        isSafe[i] = -1;
        return -1;
      }
      if (graph[i].length == 0) {
        isSafe[i] = i;
        return i;
      }
      visited[i] = 1;
      for (int n : graph[i]) {
        int safe = isSafe(graph, n, isSafe, visited);
        if (safe < 0) {
          isSafe[i] = -1;
          return -1;
        }
      }
      visited[i] = 0;
      isSafe[i] = i;
      return i;

    }
  }


  class Solution2 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
      List<Integer> list = new ArrayList<>();
      int[] isSafe = new int[graph.length];
      for (int i = 0; i < graph.length; i++) {
        if (isSafe(graph, i, isSafe, new int[graph.length]) >= 0) {
          list.add(i);
        }
      }
      return list;
    }

    private int isSafe(int[][] graph, int i, int[] isSafe, int[] visited) {
      if (isSafe[i] != 0) {
        return isSafe[i];
      }
      if (visited[i] == 1) {
        isSafe[i] = Integer.MIN_VALUE;
        return isSafe[i];
      }
      if (graph[i].length != 0) {
        visited[i] = 1;
        for (int n : graph[i]) {
          int safe = isSafe(graph, n, isSafe, visited);
          if (safe < 0) {
            isSafe[i] = Integer.MIN_VALUE;
            return isSafe[i];
          }
        }
        visited[i] = 0;
        isSafe[i] = i;
        return i;
      }
      isSafe[i] = i;
      return i;
    }
  }


  class Solution1 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
      List<Integer> list = new ArrayList<>();
      int[] isSafe = new int[graph.length];
      for (int i = 0; i < graph.length; i++) {
        if (isSafe(graph, i, isSafe, new int[graph.length]) >= 0) {
          list.add(i);
        }
      }
      return list;
    }

    private int isSafe(int[][] graph, int i, int[] isSafe, int[] visited) {
      if (isSafe[i] != 0) {
        return isSafe[i];
      }
      if (visited[i] == 1) {
        isSafe[i] = Integer.MIN_VALUE;
        return isSafe[i];
      }
      if (graph[i].length != 0) {
        visited[i] = 1;
        Set<Integer> set = new HashSet<>();
        for (int n : graph[i]) {
          int safe = isSafe(graph, n, isSafe, visited);
          set.add(safe);
          if (safe < 1 || set.size() > 1) {
            isSafe[i] = Integer.MIN_VALUE;
            return isSafe[i];
          }
        }
        visited[i] = 0;
        for (Integer integer : set) {
          isSafe[i] = integer;
          return integer;
        }
      }
      isSafe[i] = i;
      return i;
    }
  }
}
