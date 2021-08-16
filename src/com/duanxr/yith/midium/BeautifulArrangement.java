package com.duanxr.yith.midium;

/**
 * @author 段然 2021/8/16
 */
public class BeautifulArrangement {

  /**
   * Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
   *
   * perm[i] is divisible by i.
   * i is divisible by perm[i].
   * Given an integer n, return the number of the beautiful arrangements that you can construct.
   *
   *  
   *
   * Example 1:
   *
   * Input: n = 2
   * Output: 2
   * Explanation:
   * The first beautiful arrangement is [1,2]:
   *     - perm[1] = 1 is divisible by i = 1
   *     - perm[2] = 2 is divisible by i = 2
   * The second beautiful arrangement is [2,1]:
   *     - perm[1] = 2 is divisible by i = 1
   *     - i = 2 is divisible by perm[2] = 1
   * Example 2:
   *
   * Input: n = 1
   * Output: 1
   *  
   *
   * Constraints:
   *
   * 1 <= n <= 15
   *
   * 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
   *
   * 第 i 位的数字能被 i 整除
   * i 能被第 i 位上的数字整除
   * 现在给定一个整数 N，请问可以构造多少个优美的排列？
   *
   * 示例1:
   *
   * 输入: 2
   * 输出: 2
   * 解释:
   *
   * 第 1 个优美的排列是 [1, 2]:
   *   第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
   *   第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
   *
   * 第 2 个优美的排列是 [2, 1]:
   *   第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
   *   第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
   * 说明:
   *
   * N 是一个正整数，并且不会超过15。
   *
   */
  class Solution {

    public int countArrangement(int n) {
      int np = n + 1;
      int count = 1;
      boolean[][] maps = new boolean[np][np];
      for (int i = 1; i < maps.length; i++) {
        boolean[] map = new boolean[np];
        maps[i] = map;
        for (int j = 1; j < map.length; j++) {
          map[j] = i % j == 0;
        }
      }
      int[] ints = new int[n];
      for (int i = 0; i < ints.length; i++) {
        ints[i] = i + 1;
      }
      return count(ints, maps, 0);
    }

    private int count(int[] ints, boolean[][] maps, int index) {
      int count = 0;
      int indexP = index + 1;
      for (int i = index; i < ints.length; i++) {
        swap(ints, i, index);
        if (maps[ints[index]][indexP] || maps[indexP][ints[index]]) {
          if (index == ints.length - 1) {
            return 1;
          }
          count += count(ints, maps, indexP);
        }
        swap(ints, i, index);
      }
      return count;
    }

    private void swap(int[] ints, int l, int r) {
      int tmp = ints[l];
      ints[l] = ints[r];
      ints[r] = tmp;
    }
  }


  class Solution4 {

    public int countArrangement(int n) {
      int np = n + 1;
      int count = 1;
      byte[][] maps = new byte[np][np];
      for (int i = 1; i < maps.length; i++) {
        maps[i] = new byte[np];
      }
      int[] ints = new int[n];
      for (int i = 0; i < ints.length; i++) {
        ints[i] = i + 1;
      }
      return count(ints, maps, 0);
    }

    private int count(int[] ints, byte[][] maps, int index) {
      int count = 0;
      for (int i = index; i < ints.length; i++) {
        swap(ints, i, index);
        if (isBeautiful(index, maps, ints)) {
          if (index == ints.length - 1) {
            return 1;
          }
          count += count(ints, maps, index + 1);
        }
        swap(ints, i, index);
      }
      return count;
    }

    private boolean isBeautiful(int index, byte[][] maps, int[] ints) {
      int indexp = index + 1;
      return isBeautiful0(ints[index], indexp, maps, ints) || isBeautiful0(indexp, ints[index],
          maps, ints);
    }

    private boolean isBeautiful0(int li, int ri, byte[][] maps, int[] ints) {
      byte f = maps[li][ri];
      if (f == 0) {
        f = (byte) (li % ri == 0 ? 1 : -1);
        maps[li][ri] = f;
      }
      return f > 0;
    }


    private void swap(int[] ints, int l, int r) {
      if (l == r) {
        return;
      }
      int tmp = ints[l];
      ints[l] = ints[r];
      ints[r] = tmp;
    }
  }



  class Solution2 {

    public int countArrangement(int n) {
      int np = n + 1;
      int count = 1;
      boolean[][] maps = new boolean[np][np];
      for (int i = 1; i < maps.length; i++) {
        boolean[] map = new boolean[np];
        maps[i] = map;
        for (int j = 1; j < map.length; j++) {
          map[j] = i % j == 0;
        }
      }
      int[] ints = new int[n];
      for (int i = 0; i < ints.length; i++) {
        ints[i] = i + 1;
      }

      return count(ints, maps, 0);

    }

    private int count(int[] ints, boolean[][] maps, int index) {
      int count = 0;
      for (int i = index; i < ints.length; i++) {
        swap(ints, i, index);
        if (!maps[ints[index]][index + 1] && !maps[index + 1][ints[index]]) {
          swap(ints, i, index);
          continue;
        }
        if (index == ints.length - 1) {
          count = 1;
        } else {
          count += count(ints, maps, index + 1);
        }
        swap(ints, i, index);
      }
      return count;
    }

    private void swap(int[] ints, int l, int r) {
      int tmp = ints[l];
      ints[l] = ints[r];
      ints[r] = tmp;
    }
  }


  class Solution1 {

    public int countArrangement(int n) {
      int np = n + 1;
      int count = 1;
      boolean[][] maps = new boolean[np][np];
      for (int i = 1; i < maps.length; i++) {
        boolean[] map = new boolean[np];
        maps[i] = map;
        for (int j = 1; j < map.length; j++) {
          map[j] = i % j == 0;
        }
      }
      int[] ints = new int[n];
      for (int i = 0; i < ints.length; i++) {
        ints[i] = i + 1;
      }

      return count(ints, maps, 0);

    }

    private int count(int[] ints, boolean[][] maps, int index) {
      int count = 0;
      for (int i = index; i < ints.length; i++) {
        swap(ints, i, index);
        if (index == ints.length - 1) {
          count = 1;
          for (int fi = 0; fi < ints.length; fi++) {
            if (!maps[ints[fi]][fi + 1] && !maps[fi + 1][ints[fi]]) {
              count = 0;
              break;
            }
          }
        } else {
          count += count(ints, maps, index + 1);
        }
        swap(ints, i, index);
      }
      return count;
    }

    private void swap(int[] ints, int l, int r) {
      int tmp = ints[l];
      ints[l] = ints[r];
      ints[r] = tmp;
    }
  }
}
