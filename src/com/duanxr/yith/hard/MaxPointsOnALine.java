package com.duanxr.yith.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javafx.util.Pair;

/**
 * @author 段然 2021/6/24
 */
public class MaxPointsOnALine {

  /**
   * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: points = [[1,1],[2,2],[3,3]]
   * Output: 3
   * Example 2:
   *
   *
   * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
   * Output: 4
   *  
   *
   * Constraints:
   *
   * 1 <= points.length <= 300
   * points[i].length == 2
   * -104 <= xi, yi <= 104
   * All the points are unique.
   *
   * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：points = [[1,1],[2,2],[3,3]]
   * 输出：3
   * 示例 2：
   *
   *
   * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
   * 输出：4
   *  
   *
   * 提示：
   *
   * 1 <= points.length <= 300
   * points[i].length == 2
   * -104 <= xi, yi <= 104
   * points 中的所有点 互不相同
   *
   */
  class Solution {

    public int maxPoints(int[][] points) {
      if (points.length == 0) {
        return 0;
      }
      int max = 1;
      Map<Float, Integer> map = new HashMap<>();
      for (int i = 0; i < points.length; i++) {
        map.clear();
        int c = 0;
        for (int j = i + 1; j < points.length; j++) {
          int compute = map.compute(resolve(points[i], points[j]), (k, v) -> v == null ? 2 : v + 1);
          if (compute > c) {
            c = compute;
            if (c > max) {
              max = c;
            }
          }
        }
      }
      return max;
    }

    public Float resolve(int[] p1, int[] p2) {
      float x1 = p1[0];
      float y1 = p1[1];
      float x2 = p2[0];
      float y2 = p2[1];
      float xl = (y1 - y2) / (x1 - x2);
      return Float.isInfinite(xl) ? Float.POSITIVE_INFINITY : xl == -0F ? 0F : xl;
    }
  }


  class Solution2 {

    public int maxPoints(int[][] points) {
      if (points.length == 0) {
        return 0;
      }
      int max = 1;
      for (int i = 0; i < points.length; i++) {
        Map<Double, Integer> map = new HashMap<>();
        for (int j = i + 1; j < points.length; j++) {
          Double resolve = resolve(points[i], points[j]);
          int c = map.compute(resolve, (k, v) -> v == null ? 2 : v + 1);
          if (c > max) {
            max = c;
          }
        }
        System.out.println(map);
      }
      return max;
    }

    public Double resolve(int[] p1, int[] p2) {
      double x1 = p1[0];
      double y1 = p1[1];
      double x2 = p2[0];
      double y2 = p2[1];
      double xl = (y1 - y2) / (x1 - x2);
      return Double.isInfinite(xl) ? Double.POSITIVE_INFINITY : xl == -0D ? 0D : xl;
    }
  }

  class Solution1 {

    public int maxPoints(int[][] points) {
      if (points.length == 0) {
        return 0;
      }
      Set<Pair<Double, Double>> set = new HashSet<>();
      for (int i = 0; i < points.length; i++) {
        for (int j = i + 1; j < points.length; j++) {
          set.add(resolve(points[i], points[j]));
        }
      }
      int max = 1;
      for (Pair<Double, Double> pair : set) {
        int c = 0;
        for (int[] point : points) {
          if (check(pair, point)) {
            c++;
          }
        }
        if (c > max) {
          max = c;
        }
      }
      return max;
    }

    private boolean check(Pair<Double, Double> pair, int[] point) {
      return point[1] == (point[0] * pair.getKey()) + pair.getValue();
    }

    public Pair<Double, Double> resolve(int[] p1, int[] p2) {
      double x1 = p1[0];
      double y1 = p1[1];
      double x2 = p2[0];
      double y2 = p2[1];

      double xl = (y1 - y2) / (x1 - x2);

      double of = y2 - (x2 * xl);
      return new Pair<>(xl, of);
    }
  }
}
