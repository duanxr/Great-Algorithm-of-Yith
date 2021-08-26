package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 段然 2021/8/26
 */
public class AllPathsFromSourceToTarget {

  /**
   * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
   *
   * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: graph = [[1,2],[3],[3],[]]
   * Output: [[0,1,3],[0,2,3]]
   * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
   * Example 2:
   *
   *
   * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
   * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
   * Example 3:
   *
   * Input: graph = [[1],[]]
   * Output: [[0,1]]
   * Example 4:
   *
   * Input: graph = [[1,2,3],[2],[3],[]]
   * Output: [[0,1,2,3],[0,2,3],[0,3]]
   * Example 5:
   *
   * Input: graph = [[1,3],[2],[3],[]]
   * Output: [[0,1,2,3],[0,3]]
   *  
   *
   * Constraints:
   *
   * n == graph.length
   * 2 <= n <= 15
   * 0 <= graph[i][j] < n
   * graph[i][j] != i (i.e., there will be no self-loops).
   * All the elements of graph[i] are unique.
   * The input graph is guaranteed to be a DAG.
   *
   * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
   *
   * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
   *
   * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
   *
   *  
   *
   * 示例 1：
   *
   *
   *
   * 输入：graph = [[1,2],[3],[3],[]]
   * 输出：[[0,1,3],[0,2,3]]
   * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
   * 示例 2：
   *
   *
   *
   * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
   * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
   * 示例 3：
   *
   * 输入：graph = [[1],[]]
   * 输出：[[0,1]]
   * 示例 4：
   *
   * 输入：graph = [[1,2,3],[2],[3],[]]
   * 输出：[[0,1,2,3],[0,2,3],[0,3]]
   * 示例 5：
   *
   * 输入：graph = [[1,3],[2],[3],[]]
   * 输出：[[0,1,2,3],[0,3]]
   *  
   *
   * 提示：
   *
   * n == graph.length
   * 2 <= n <= 15
   * 0 <= graph[i][j] < n
   * graph[i][j] != i（即，不存在自环）
   * graph[i] 中的所有元素 互不相同
   * 保证输入为 有向无环图（DAG）
   *
   */
  class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      return find(0, graph, new HashMap<>(graph.length));
    }

    private List<List<Integer>> find(int i, int[][] graph,
        Map<Integer, List<List<Integer>>> cacheMap) {
      List<List<Integer>> path = cacheMap.get(i);
      if (path != null) {
        return path;
      }
      if (i == graph.length - 1) {
        path = Collections.singletonList(Collections.singletonList(i));
      } else {
        int[] next = graph[i];
        path = new ArrayList<>();
        for (int n : next) {
          List<List<Integer>> nextPath = find(n, graph, cacheMap);
          for (List<Integer> nextList : nextPath) {
            List<Integer> list = new ArrayList<>(nextList.size() + 1);
            list.add(i);
            list.addAll(nextList);
            path.add(list);
          }
        }
      }
      cacheMap.put(i, path);
      return path;
    }
  }
}
