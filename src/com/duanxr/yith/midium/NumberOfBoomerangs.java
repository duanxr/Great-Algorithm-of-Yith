package com.duanxr.yith.midium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 段然 2021/3/8
 */
public class NumberOfBoomerangs {

  /**
   * You are given n points in the plane that are all distinct, where points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
   *
   * Return the number of boomerangs.
   *
   *  
   *
   * Example 1:
   *
   * Input: points = [[0,0],[1,0],[2,0]]
   * Output: 2
   * Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
   * Example 2:
   *
   * Input: points = [[1,1],[2,2],[3,3]]
   * Output: 2
   * Example 3:
   *
   * Input: points = [[1,1]]
   * Output: 0
   *  
   *
   * Constraints:
   *
   * n == points.length
   * 1 <= n <= 500
   * points[i].length == 2
   * -104 <= xi, yi <= 104
   * All the points are unique.
   *
   * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
   *
   * 返回平面上所有回旋镖的数量。
   *
   *  
   * 示例 1：
   *
   * 输入：points = [[0,0],[1,0],[2,0]]
   * 输出：2
   * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
   * 示例 2：
   *
   * 输入：points = [[1,1],[2,2],[3,3]]
   * 输出：2
   * 示例 3：
   *
   * 输入：points = [[1,1]]
   * 输出：0
   *  
   *
   * 提示：
   *
   * n == points.length
   * 1 <= n <= 500
   * points[i].length == 2
   * -104 <= xi, yi <= 104
   * 所有点都 互不相同
   *
   */
  class Solution {

    public int numberOfBoomerangs(int[][] points) {
      int r = 0;
      Map<Double, Set<int[]>> map = new HashMap<>(points.length);
      for (int i = 0; i < points.length; i++) {
        map.clear();
        for (int j = 0; j < points.length; j++) {
          if (i != j) {
            double l = Math.pow(Math.abs(points[i][0] - points[j][0]), 2) + Math
                .pow(Math.abs(points[i][1] - points[j][1]), 2);
            if (map.containsKey(l)) {
              map.get(l).add(points[j]);
            } else {
              Set<int[]> list = new HashSet<>();
              list.add(points[j]);
              map.put(l, list);
            }
          }
        }
        for (Map.Entry entry : map.entrySet()) {
          Set<Integer[]> list = (Set<Integer[]>) entry.getValue();
          if (list != null && list.size() > 1) {
            for (int j = 0; j < list.size(); j++) {
              for (int k = j + 1; k < list.size(); k++) {
                r += 2;
              }
            }
          }
        }
      }
      return r;
    }

  }
}
