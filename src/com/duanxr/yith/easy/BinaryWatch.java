package com.duanxr.yith.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/3/8
 */
public class BinaryWatch {

  /**
   * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
   *
   * Each LED represents a zero or one, with the least significant bit on the right.
   *
   *
   * For example, the above binary watch reads "3:25".
   *
   * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
   *
   * Example:
   *
   * Input: n = 1
   * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
   * Note:
   * The order of output does not matter.
   * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
   * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
   *
   * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
   *
   * 每个 LED 代表一个 0 或 1，最低位在右侧。
   *
   *
   *
   * 例如，上面的二进制手表读取 “3:25”。
   *
   * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
   *
   *  
   *
   * 示例：
   *
   * 输入: n = 1
   * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
   *  
   *
   * 提示：
   *
   * 输出的顺序没有要求。
   * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
   * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
   * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
   *
   */
  class Solution {

    private int max = 1 << 10;
    private StringBuilder stringBuilder;

    public Solution() {
      stringBuilder = new StringBuilder();
    }

    public List<String> readBinaryWatch(int num) {
      List<String> list = new ArrayList<>();
      for (int i = 0; i < max; i++) {
        if (height(i) == num) {
          int h = 0;
          int m = 0;
          int bit = i;
          for (int j = 0; j < 6; j++) {
            if ((bit & 1) == 1) {
              m += 1 << j;
            }
            bit = bit >> 1;
          }
          for (int j = 0; j < 4; j++) {
            if ((bit & 1) == 1) {
              h += 1 << j;
            }
            bit = bit >> 1;
          }
          if (h <= 11 && m <= 59) {
            stringBuilder.setLength(0);
            stringBuilder.append(h).append(':');
            if (m < 10) {
              stringBuilder.append(0);
            }
            stringBuilder.append(m);
            list.add(stringBuilder.toString());
          }
        }
      }
      return list;
    }

    private int height(int num) {
      int r = 0;
      while (num > 0) {
        if ((num & 1) == 1) {
          r++;
        }
        num = num >> 1;
      }
      return r;
    }


  }
}
