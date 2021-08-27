package com.duanxr.yith.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 段然 2021/8/27
 */
public class FindMedianfromDataStream {

  /**
   * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
   *
   * For example, for arr = [2,3,4], the median is 3.
   * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
   * Implement the MedianFinder class:
   *
   * MedianFinder() initializes the MedianFinder object.
   * void addNum(int num) adds the integer num from the data stream to the data structure.
   * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
   *  
   *
   * Example 1:
   *
   * Input
   * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
   * [[], [1], [2], [], [3], []]
   * Output
   * [null, null, null, 1.5, null, 2.0]
   *
   * Explanation
   * MedianFinder medianFinder = new MedianFinder();
   * medianFinder.addNum(1);    // arr = [1]
   * medianFinder.addNum(2);    // arr = [1, 2]
   * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
   * medianFinder.addNum(3);    // arr[1, 2, 3]
   * medianFinder.findMedian(); // return 2.0
   *  
   *
   * Constraints:
   *
   * -105 <= num <= 105
   * There will be at least one element in the data structure before calling findMedian.
   * At most 5 * 104 calls will be made to addNum and findMedian.
   *  
   *
   * Follow up:
   *
   * If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
   * If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
   *
   * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
   *
   * 例如，
   *
   * [2,3,4] 的中位数是 3
   *
   * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
   *
   * 设计一个支持以下两种操作的数据结构：
   *
   * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
   * double findMedian() - 返回目前所有元素的中位数。
   * 示例：
   *
   * addNum(1)
   * addNum(2)
   * findMedian() -> 1.5
   * addNum(3)
   * findMedian() -> 2
   * 进阶:
   *
   * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
   * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
   *
   */
  class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
      max = new PriorityQueue<>(Integer::compareTo);
      min = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
      if (max.isEmpty() || num > max.peek()) {
        max.offer(num);
        while (max.size() - 1 > min.size()) {
          min.offer(max.poll());
        }
      } else {
        min.offer(num);
        while (min.size() > max.size()) {
          max.offer(min.poll());
        }
      }
    }

    public double findMedian() {
      return max.size() == min.size() ? (max.peek() + min.peek()) / 2D : max.peek();
    }
  }

}
