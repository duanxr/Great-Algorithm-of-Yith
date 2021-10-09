package com.duanxr.yith.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 段然 2021/10/9
 */
public class DataStreamAsDisjointIntervals {

  /**
   * Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.
   *
   * Implement the SummaryRanges class:
   *
   * SummaryRanges() Initializes the object with an empty stream.
   * void addNum(int val) Adds the integer val to the stream.
   * int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi].
   *  
   *
   * Example 1:
   *
   * Input
   * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
   * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
   * Output
   * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
   *
   * Explanation
   * SummaryRanges summaryRanges = new SummaryRanges();
   * summaryRanges.addNum(1);      // arr = [1]
   * summaryRanges.getIntervals(); // return [[1, 1]]
   * summaryRanges.addNum(3);      // arr = [1, 3]
   * summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
   * summaryRanges.addNum(7);      // arr = [1, 3, 7]
   * summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
   * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
   * summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
   * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
   * summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
   *  
   *
   * Constraints:
   *
   * 0 <= val <= 104
   * At most 3 * 104 calls will be made to addNum and getIntervals.
   *  
   *
   * Follow up: What if there are lots of merges and the number of disjoint intervals is small compared to the size of the data stream?
   *
   * 给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。
   *
   * 实现 SummaryRanges 类：
   *
   * SummaryRanges() 使用一个空数据流初始化对象。
   * void addNum(int val) 向数据流中加入整数 val 。
   * int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。
   *  
   *
   * 示例：
   *
   * 输入：
   * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
   * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
   * 输出：
   * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
   *
   * 解释：
   * SummaryRanges summaryRanges = new SummaryRanges();
   * summaryRanges.addNum(1);      // arr = [1]
   * summaryRanges.getIntervals(); // 返回 [[1, 1]]
   * summaryRanges.addNum(3);      // arr = [1, 3]
   * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
   * summaryRanges.addNum(7);      // arr = [1, 3, 7]
   * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
   * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
   * summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
   * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
   * summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
   *  
   *
   * 提示：
   *
   * 0 <= val <= 104
   * 最多调用 addNum 和 getIntervals 方法 3 * 104 次
   *  
   *
   * 进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
   *
   */
  class SummaryRanges {

    int[][] list;
    int size;

    public SummaryRanges() {
      list = new int[10000][];
      size = 0;
    }

    public void addNum(int val) {
      if (size == 0) {
        list[size++] = new int[]{val, val};
      } else {
        int index = binarySearch(val);
        if (index == -1) {
          int[] ints = list[0];
          if (ints[0] == val + 1) {
            ints[0] = val;
          } else {
            add(0, new int[]{val, val});
          }
        } else {
          int[] ints = list[index];
          if (ints[1] < val) {
            int ip1 = index + 1;
            if (ints[1] == val - 1) {
              ints[1] = val;
              if (ip1 != size) {
                int[] ints2 = list[ip1];
                if (ints2[0] == val + 1) {
                  remove(ip1);
                  ints[1] = ints2[1];
                }
              }
            } else if (ip1 != size) {
              int[] ints2 = list[ip1];
              if (ints2[0] == val + 1) {
                ints2[0] = val;
              } else {
                add(ip1, new int[]{val, val});
              }
            } else {
              add(ip1, new int[]{val, val});
            }
          } else if (val < ints[0]) {
            add(0, new int[]{val, val});
          }
        }
      }
    }

    private void remove(int index) {
      if (size - index >= 0)
        System.arraycopy(list, index + 1, list, index, size - index);
      size--;
    }

    private void add(int index, int[] ints) {
      if (size - index >= 0)
        System.arraycopy(list, index, list, index + 1, size - index);
      list[index] = ints;
      size++;
    }

    public int[][] getIntervals() {
      return Arrays.copyOf(list, size);
    }

    private int binarySearch(int key) {
      int low = 0;
      int high = size - 1;
      while (low <= high) {
        int mid = (low + high) >>> 1;
        int midVal = list[mid][0];
        if (midVal < key) {
          low = mid + 1;
        } else if (midVal > key) {
          high = mid - 1;
        } else {
          return mid;
        }
      }
      return high;
    }

  }


  class SummaryRanges4 {

    int[][] list;
    int size;

    public SummaryRanges4() {
      list = new int[10001][];
      size = 0;
    }

    public void addNum(int val) {
      if (size == 0) {
        list[size++] = new int[]{val, val};
      } else {
        int index = binarySearch(val);
        if (index == -1) {
          int[] ints = list[0];
          if (ints[0] == val + 1) {
            ints[0] = val;
          } else {
            add(0, new int[]{val, val});
          }
        } else {
          int[] ints = list[index];
          if (ints[1] < val) {
            int ip1 = index + 1;
            if (ints[1] == val - 1) {
              ints[1] = val;
              if (ip1 != size) {
                int[] ints2 = list[ip1];
                if (ints2[0] == val + 1) {
                  remove(ip1);
                  ints[1] = ints2[1];
                }
              }
            } else if (ip1 != size) {
              int[] ints2 = list[ip1];
              if (ints2[0] == val + 1) {
                ints2[0] = val;
              } else {
                add(ip1, new int[]{val, val});
              }
            } else {
              add(ip1, new int[]{val, val});
            }
          } else if (val < ints[0]) {
            add(0, new int[]{val, val});
          }
        }
      }
    }

    private void remove(int index) {
      for (int i = index; i < size; i++) {
        list[i] = list[i + 1];
      }
      size--;
    }

    private void add(int index, int[] ints) {
      for (int i = size - 1; i >= index; i--) {
        list[i + 1] = list[i];
      }
      list[index] = ints;
      size++;
    }

    public int[][] getIntervals() {
      return Arrays.copyOf(list, size);
    }

    private int binarySearch(int key) {
      int low = 0;
      int high = size - 1;
      while (low <= high) {
        int mid = (low + high) >>> 1;
        int midVal = list[mid][0];
        if (midVal < key) {
          low = mid + 1;
        } else if (midVal > key) {
          high = mid - 1;
        } else {
          return mid;
        }
      }
      return high;
    }

  }


  class SummaryRanges3 {

    List<int[]> list = new ArrayList<>();

    public SummaryRanges3() {

    }

    public void addNum(int val) {
      if (list.isEmpty()) {
        list.add(new int[]{val, val});
      } else {
        int index = binarySearch(val);
        if (index == -1) {
          int[] ints = list.get(0);
          if (ints[0] == val + 1) {
            ints[0] = val;
          } else {
            list.add(0, new int[]{val, val});
          }
        } else {
          int[] ints = list.get(index);
          if (ints[1] < val) {
            int ip1 = index + 1;
            if (ints[1] == val - 1) {
              ints[1] = val;
              if (ip1 != list.size()) {
                int[] ints2 = list.get(ip1);
                if (ints2[0] == val + 1) {
                  list.remove(ip1);
                  ints[1] = ints2[1];
                }
              }
            } else if (ip1 != list.size()) {
              int[] ints2 = list.get(ip1);
              if (ints2[0] == val + 1) {
                ints2[0] = val;
              } else {
                list.add(ip1, new int[]{val, val});
              }
            } else {
              list.add(ip1, new int[]{val, val});
            }
          } else if (val < ints[0]) {
            list.add(0, new int[]{val, val});
          }
        }
      }
    }

    public int[][] getIntervals() {
      int[][] intervals = new int[list.size()][2];
      return list.toArray(intervals);
    }

    private int binarySearch(int key) {
      int low = 0;
      int high = list.size() - 1;
      while (low <= high) {
        int mid = (low + high) >>> 1;
        int midVal = list.get(mid)[0];
        if (midVal < key) {
          low = mid + 1;
        } else if (midVal > key) {
          high = mid - 1;
        } else {
          return mid;
        }
      }
      return high;
    }

  }


  class SummaryRanges2 {

    List<int[]> list = new ArrayList<>();

    public SummaryRanges2() {

    }

    public void addNum(int val) {
      if (list.isEmpty()) {
        list.add(new int[]{val, val});
      } else {
        int index = binarySearch(val);
        if (index == -1) {
          int[] ints = list.get(0);
          if (ints[0] == val + 1) {
            ints[0] = val;
          } else {
            list.add(0, new int[]{val, val});
          }
        } else {
          int[] ints = list.get(index);
          if (ints[1] < val) {
            if (ints[1] == val - 1) {
              ints[1] = val;
              if (index + 1 != list.size()) {
                int[] ints2 = list.get(index + 1);
                if (ints2[0] == val + 1) {
                  list.remove(index + 1);
                  ints[1] = ints2[1];
                }
              }
            } else if (index + 1 != list.size()) {
              int[] ints2 = list.get(index + 1);
              if (ints2[0] == val + 1) {
                ints2[0] = val;
              } else {
                list.add(index + 1, new int[]{val, val});
              }
            } else {
              list.add(index + 1, new int[]{val, val});
            }
          } else if (val < ints[0]) {
            list.add(0, new int[]{val, val});
          }
        }
      }
    }

    public int[][] getIntervals() {
      int[][] intervals = new int[list.size()][2];
      return list.toArray(intervals);
    }

    private int binarySearch(int key) {
      int low = 0;
      int high = list.size() - 1;
      while (low <= high) {
        int mid = (low + high) >>> 1;
        int midVal = list.get(mid)[0];
        if (midVal < key) {
          low = mid + 1;
        } else if (midVal > key) {
          high = mid - 1;
        } else {
          return mid;
        }
      }
      return high;
    }

  }


  class SummaryRanges1 {

    int[] ints = new int[10002];

    public SummaryRanges1() {

    }

    public void addNum(int val) {
      ints[val] = 1;
    }

    public int[][] getIntervals() {
      List<int[]> list = new ArrayList<>();
      int s = -1;
      for (int i = 0; i < ints.length; i++) {
        if (ints[i] == 1 && s == -1) {
          s = i;
        } else if (ints[i] == 0 && s != -1) {
          list.add(new int[]{s, i - 1});
          s = -1;
        }
      }
      int[][] intervals = new int[list.size()][2];
      return list.toArray(intervals);
    }
  }

}
