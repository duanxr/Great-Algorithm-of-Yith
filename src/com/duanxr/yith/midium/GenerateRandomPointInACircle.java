package com.duanxr.yith.midium;

import java.util.Random;

/**
 * @author 段然 2021/5/26
 */
public class GenerateRandomPointInACircle {

  /**
   * Given the radius and the position of the center of a circle, implement the function randPoint which generates a uniform random point inside the circle.
   *
   * Implement the Solution class:
   *
   * Solution(double radius, double x_center, double y_center) initializes the object with the radius of the circle radius and the position of the center (x_center, y_center).
   * randPoint() returns a random point inside the circle. A point on the circumference of the circle is considered to be in the circle. The answer is returned as an array [x, y].
   *  
   *
   * Example 1:
   *
   * Input
   * ["Solution", "randPoint", "randPoint", "randPoint"]
   * [[1.0, 0.0, 0.0], [], [], []]
   * Output
   * [null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]
   *
   * Explanation
   * Solution solution = new Solution(1.0, 0.0, 0.0);
   * solution.randPoint(); // return [-0.02493, -0.38077]
   * solution.randPoint(); // return [0.82314, 0.38945]
   * solution.randPoint(); // return [0.36572, 0.17248]
   *  
   *
   * Constraints:
   *
   * 0 < radius <= 108
   * -107 <= x_center, y_center <= 107
   * At most 3 * 104 calls will be made to randPoint.
   *
   * 给定圆的半径和圆心的 x、y 坐标，写一个在圆中产生均匀随机点的函数 randPoint 。
   *
   * 说明:
   *
   * 输入值和输出值都将是浮点数。
   * 圆的半径和圆心的 x、y 坐标将作为参数传递给类的构造函数。
   * 圆周上的点也认为是在圆中。
   * randPoint 返回一个包含随机点的x坐标和y坐标的大小为2的数组。
   * 示例 1：
   *
   * 输入:
   * ["Solution","randPoint","randPoint","randPoint"]
   * [[1,0,0],[],[],[]]
   * 输出: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
   * 示例 2：
   *
   * 输入:
   * ["Solution","randPoint","randPoint","randPoint"]
   * [[10,5,-7.5],[],[],[]]
   * 输出: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
   * 输入语法说明：
   *
   * 输入是两个列表：调用成员函数名和调用的参数。Solution 的构造函数有三个参数，圆的半径、圆心的 x 坐标、圆心的 y 坐标。randPoint 没有参数。输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。
   *
   */
  class Solution {

    private final double radius;
    private final double x_center;
    private final double y_center;
    private final Random random;

    public Solution(double radius, double x_center, double y_center) {
      this.radius = radius;
      this.x_center = x_center;
      this.y_center = y_center;
      this.random = new Random();
    }

    public double[] randPoint() {
      double randomRadius = random.nextDouble();
      double r = Math.sqrt(radius * radius * randomRadius);
      double randomAngle = random.nextDouble();
      double a = Math.PI * 2 * randomAngle;
      double x = r * Math.cos(a);
      double y = r * Math.sin(a);
      double[] point = new double[2];
      point[0] = x + x_center;
      point[1] = y + y_center;
      return point;
    }
  }
}
