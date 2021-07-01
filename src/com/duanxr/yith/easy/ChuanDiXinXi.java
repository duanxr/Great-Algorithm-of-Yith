package com.duanxr.yith.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 段然 2021/7/1
 */
public class ChuanDiXinXi {

  /**
   * English description is not available for the problem. Please switch to Chinese.
   *
   * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
   *
   * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
   * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
   * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
   * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
   *
   * 示例 1：
   *
   * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
   *
   * 输出：3
   *
   * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
   *
   * 示例 2：
   *
   * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
   *
   * 输出：0
   *
   * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
   *
   * 限制：
   *
   * 2 <= n <= 10
   * 1 <= k <= 5
   * 1 <= relation.length <= 90, 且 relation[i].length == 2
   * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
   *
   */
  class Solution {

    public int numWays(int n, int[][] relation, int k) {
      List<List<Integer>> pre = new ArrayList<>(n);
      List<List<Integer>> rev = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        pre.add(new ArrayList<>());
        rev.add(new ArrayList<>());
      }
      for (int[] ints : relation) {
        pre.get(ints[0]).add(ints[1]);
        rev.get(ints[1]).add(ints[0]);
      }
      Map<Integer, Integer> start = new HashMap<>();
      Map<Integer, Integer> end = new HashMap<>();

      start.put(0, 1);
      end.put(n - 1, 1);

      while (k != 0) {
        if (k % 2 == 1) {
          Map<Integer, Integer> map = new HashMap<>();
          for (java.util.Map.Entry<Integer, Integer> entry : start.entrySet()) {
            List<Integer> list = pre.get(entry.getKey());
            for (Integer integer : list) {
              map.compute(integer, (key, value) ->
                  value == null ? entry.getValue() : value + entry.getValue());
            }
          }
          start = map;
        } else {
          Map<Integer, Integer> map = new HashMap<>();
          for (java.util.Map.Entry<Integer, Integer> entry : end.entrySet()) {
            List<Integer> list = rev.get(entry.getKey());
            for (Integer integer : list) {
              map.compute(integer, (key, value) ->
                  value == null ? entry.getValue() : value + entry.getValue());
            }
          }
          end = map;
        }
        k--;
      }

      int result = 0;

      for (java.util.Map.Entry<Integer, Integer> entry : start.entrySet()) {
        result += entry.getValue() * end.getOrDefault(entry.getKey(), 0);
      }

      return result;
    }
  }


  class Solution2 {

    public int numWays(int n, int[][] relation, int k) {
      List<List<Integer>> pre = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        pre.add(new ArrayList<>());

      }
      for (int[] ints : relation) {
        pre.get(ints[0]).add(ints[1]);
      }
      List<Integer> start = new ArrayList<>();
      start.add(0);
      while (k != 0) {
        List<Integer> set = new ArrayList<>();
        for (Integer integer : start) {
          set.addAll(pre.get(integer));
        }
        start = set;
        k--;
      }
      int result = 0;
      for (Integer integer : start) {
        if (integer == n - 1) {
          result++;
        }
      }
      return result;
    }
  }

  class Solution1 {

    public int numWays(int n, int[][] relation, int k) {
      List<List<Integer>> pre = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        pre.add(new ArrayList<>());
      }
      for (int[] ints : relation) {
        pre.get(ints[0]).add(ints[1]);
      }
      List<Integer> start = new ArrayList<>();
      start.add(0);
      while (k != 0) {
        List<Integer> set = new ArrayList<>();
        for (Integer integer : start) {
          set.addAll(pre.get(integer));
          start = set;
          k--;
        }
      }
      int result = 0;
      for (Integer integer : start) {
        if (integer == n - 1) {
          result++;
        }
      }
      return result;
    }
  }
}
