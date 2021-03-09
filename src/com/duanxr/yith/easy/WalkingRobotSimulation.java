package com.duanxr.yith.easy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author 段然 2021/3/9
 */
public class WalkingRobotSimulation {

  /**
   * A robot on an infinite XY-plane starts at point (0, 0) and faces north. The robot can receive one of three possible types of commands:
   *
   * -2: turn left 90 degrees,
   * -1: turn right 90 degrees, or
   * 1 <= k <= 9: move forward k units.
   * Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi).
   *
   * If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)
   *
   * Return the maximum Euclidean distance that the robot will be from the origin squared (i.e. if the distance is 5, return 25).
   *
   * Note:
   *
   * North means +Y direction.
   * East means +X direction.
   * South means -Y direction.
   * West means -X direction.
   *  
   *
   * Example 1:
   *
   * Input: commands = [4,-1,3], obstacles = []
   * Output: 25
   * Explanation: The robot starts at (0, 0):
   * 1. Move north 4 units to (0, 4).
   * 2. Turn right.
   * 3. Move east 3 units to (3, 4).
   * The furthest point away from the origin is (3, 4), which is 32 + 42 = 25 units away.
   * Example 2:
   *
   * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
   * Output: 65
   * Explanation: The robot starts at (0, 0):
   * 1. Move north 4 units to (0, 4).
   * 2. Turn right.
   * 3. Move east 1 unit and get blocked by the obstacle at (2, 4), robot is at (1, 4).
   * 4. Turn left.
   * 5. Move north 4 units to (1, 8).
   * The furthest point away from the origin is (1, 8), which is 12 + 82 = 65 units away.
   *  
   *
   * Constraints:
   *
   * 1 <= commands.length <= 104
   * commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9].
   * 0 <= obstacles.length <= 104
   * -3 * 104 <= xi, yi <= 3 * 104
   * The answer is guaranteed to be less than 231.
   *
   * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
   *
   * -2 ：向左转 90 度
   * -1 ：向右转 90 度
   * 1 <= x <= 9 ：向前移动 x 个单位长度
   * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
   *
   * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
   *
   * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
   *
   *  
   * 注意：
   *
   * 北表示 +Y 方向。
   * 东表示 +X 方向。
   * 南表示 -Y 方向。
   * 西表示 -X 方向。
   *  
   *
   * 示例 1：
   *
   * 输入：commands = [4,-1,3], obstacles = []
   * 输出：25
   * 解释：
   * 机器人开始位于 (0, 0)：
   * 1. 向北移动 4 个单位，到达 (0, 4)
   * 2. 右转
   * 3. 向东移动 3 个单位，到达 (3, 4)
   * 距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
   * 示例 2：
   *
   * 输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
   * 输出：65
   * 解释：机器人开始位于 (0, 0)：
   * 1. 向北移动 4 个单位，到达 (0, 4)
   * 2. 右转
   * 3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
   * 4. 左转
   * 5. 向北走 4 个单位，到达 (1, 8)
   * 距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65
   *  
   *
   * 提示：
   *
   * 1 <= commands.length <= 104
   * commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9].
   * 0 <= obstacles.length <= 104
   * -3 * 104 <= xi, yi <= 3 * 104
   * 答案保证小于 231
   *
   */
  class Solution {

    class Location {

      public Location(int x, int y) {
        this.x = x;
        this.y = y;
      }

      private int x;
      private int y;

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        Location location = (Location) o;
        return x == location.x &&
            y == location.y;
      }

      @Override
      public int hashCode() {
        return Objects.hash(x, y);
      }
    }

    public int robotSim(int[] commands, int[][] obstacles) {
      int direct = 0;
      int max = 0;
      int x = 0;
      int y = 0;
      Set<Location> set = new HashSet<>();
      for (int[] obstacle : obstacles) {
        Location location = new Location(obstacle[0], obstacle[1]);
        set.add(location);
      }
      for (int command : commands) {
        if (command < 0) {
          max = Math.max(x * x + y * y, max);
          direct = direct(direct, command);
        } else {
          switch (direct) {
            case 0:
              for (int i = 1; i <= command; i++) {
                Location location = new Location(x, y + 1);
                if (!set.contains(location)) {
                  y++;
                } else {
                  break;
                }
              }
              break;
            case 1:
              for (int i = 1; i <= command; i++) {
                Location location = new Location(x + 1, y);
                if (!set.contains(location)) {
                  x++;
                } else {
                  break;
                }
              }
              break;
            case 2:
              for (int i = 1; i <= command; i++) {
                Location location = new Location(x, y - 1);
                if (!set.contains(location)) {
                  y--;
                } else {
                  break;
                }
              }
              break;
            default:
              for (int i = 1; i <= command; i++) {
                Location location = new Location(x - 1, y);
                if (!set.contains(location)) {
                  x--;
                } else {
                  break;
                }
              }
          }
        }
      }
      return Math.max(x * x + y * y, max);
    }

    private int direct(int d, int c) {
      if (c == -1) {
        d++;
        return d == 4 ? 0 : d;
      } else {
        d--;
        return d == -1 ? 3 : d;
      }
    }
  }
}
