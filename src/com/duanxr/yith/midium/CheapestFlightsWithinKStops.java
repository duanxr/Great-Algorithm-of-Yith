package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 段然 2021/8/24
 */
public class CheapestFlightsWithinKStops {

  /**
   * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
   *
   * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
   * Output: 200
   * Explanation: The graph is shown.
   * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
   * Example 2:
   *
   *
   * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
   * Output: 500
   * Explanation: The graph is shown.
   * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
   *  
   *
   * Constraints:
   *
   * 1 <= n <= 100
   * 0 <= flights.length <= (n * (n - 1) / 2)
   * flights[i].length == 3
   * 0 <= fromi, toi < n
   * fromi != toi
   * 1 <= pricei <= 104
   * There will not be any multiple flights between two cities.
   * 0 <= src, dst, k < n
   * src != dst
   *
   * 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 toi 抵达 pricei。
   *
   * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
   *
   *  
   *
   * 示例 1：
   *
   * 输入:
   * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
   * src = 0, dst = 2, k = 1
   * 输出: 200
   * 解释:
   * 城市航班图如下
   *
   *
   * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
   * 示例 2：
   *
   * 输入:
   * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
   * src = 0, dst = 2, k = 0
   * 输出: 500
   * 解释:
   * 城市航班图如下
   *
   *
   * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
   *  
   *
   * 提示：
   *
   * 1 <= n <= 100
   * 0 <= flights.length <= (n * (n - 1) / 2)
   * flights[i].length == 3
   * 0 <= fromi, toi < n
   * fromi != toi
   * 1 <= pricei <= 104
   * 航班没有重复，且不存在自环
   * 0 <= src, dst, k < n
   * src != dst
   *
   */
  class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      int[][] princes = new int[k + 2][n];
      for (int[] prince : princes) {
        Arrays.fill(prince, Integer.MAX_VALUE);
        prince[src] = 0;
      }
      for (int i = 1; i < k + 2; i++) {
        for (int[] flight : flights) {
          if (princes[i - 1][flight[0]] != Integer.MAX_VALUE) {
            princes[i][flight[1]] = Math.min(
                Math.min(princes[i - 1][flight[1]], princes[i][flight[1]]),
                princes[i - 1][flight[0]] + flight[2]);
          }
        }
      }
      int min = princes[k + 1][dst];
      return min == Integer.MAX_VALUE ? -1 : min;
    }
  }


  class Solution2 {

    private int min = -1;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      int[][] prices = new int[n][n];
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < prices.length; i++) {
        prices[i] = new int[n];
      }
      for (int i = 0; i < flights.length; i++) {
        int[] flight = flights[i];
        prices[flight[0]][flight[1]] = flight[2];
        List<Integer> list = map.computeIfAbsent(flight[0], kk -> new ArrayList<>());
        list.add(flight[1]);
      }
      find(prices, map, src, dst, new int[n], k, -1, 0);
      return min;
    }

    private void find(int[][] prices, Map<Integer, List<Integer>> map, int src, int dst,
        int[] visited, int k, int i, int count) {
      if (src == dst) {
        if (min == -1 || min > count) {
          min = count;
        }
        return;
      }
      List<Integer> list = null;
      if (visited[src] == 1 || i == k || (min != -1 && count > min)
          || (list = map.get(src)) == null) {
        return;
      }
      visited[src] = 1;
      for (Integer next : list) {
        int price = prices[src][next] + count;
        find(prices, map, next, dst, visited, k, i + 1, price);
      }
      visited[src] = 0;
    }
  }


  class Solution1 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      int[][] prices = new int[n][n];
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < prices.length; i++) {
        prices[i] = new int[n];
      }
      for (int i = 0; i < flights.length; i++) {
        int[] flight = flights[i];
        prices[flight[0]][flight[1]] = flight[2];
        List<Integer> list = map.computeIfAbsent(flight[0], kk -> new ArrayList<>());
        list.add(flight[1]);
      }
      return find(prices, map, src, dst, new int[n], k, -1);
    }

    private int find(int[][] prices, Map<Integer, List<Integer>> map, int src, int dst,
        int[] visited, int k, int i) {
      if (src == dst) {
        return 0;
      }
      List<Integer> list = null;
      if (visited[src] == 1 || i == k || (list = map.get(src)) == null) {
        return -1;
      }
      visited[src] = 1;
      int price = -1;
      for (Integer next : list) {
        int thisWay = find(prices, map, next, dst, visited, k, i + 1);
        if (thisWay != -1) {
          thisWay += prices[src][next];
          if (price == -1 || price > thisWay) {
            price = thisWay;
          }
        }
      }
      visited[src] = 0;
      return price;
    }
  }
}
