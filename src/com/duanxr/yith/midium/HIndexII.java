package com.duanxr.yith.midium;

/**
 * @author 段然 2021/7/12
 */
public class HIndexII {

  /**
   * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper and citations is sorted in an ascending order, return compute the researcher's h-index.
   *
   * According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each, and the other n − h papers have no more than h citations each.
   *
   * If there are several possible values for h, the maximum one is taken as the h-index.
   *
   * You must write an algorithm that runs in logarithmic time.
   *
   *  
   *
   * Example 1:
   *
   * Input: citations = [0,1,3,5,6]
   * Output: 3
   * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had received 0, 1, 3, 5, 6 citations respectively.
   * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
   * Example 2:
   *
   * Input: citations = [1,2,100]
   * Output: 2
   *  
   *
   * Constraints:
   *
   * n == citations.length
   * 1 <= n <= 105
   * 0 <= citations[i] <= 1000
   * citations is sorted in ascending order.
   *
   * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。
   *
   * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
   *
   *  
   *
   * 示例:
   *
   * 输入: citations = [0,1,3,5,6]
   * 输出: 3
   * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
   *      由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
   *  
   *
   * 说明:
   *
   * 如果 h 有多有种可能的值 ，h 指数是其中最大的那个。
   *
   *  
   *
   * 进阶：
   *
   * 这是 H 指数 的延伸题目，本题中的 citations 数组是保证有序的。
   * 你可以优化你的算法到对数时间复杂度吗？
   *
   */
  class Solution {

    public int hIndex(int[] citations) {
      int max = 0;
      int count = 0;
      for (int i = citations.length - 1; i >= 0; i--) {
        count++;
        int min = Math.min(count, citations[i]);
        if (min > max) {
          max = min;
        }
        if (citations[i] < max) {
          break;
        }
      }
      return max;
    }
  }


  class Solution1 {

    public int hIndex(int[] citations) {
      int max = 0;
      int count = 0;
      for (int i = citations.length - 1; i >= 0; i--) {
        count++;
        int min = Math.min(count, citations[i]);
        if (min > max) {
          max = min;
        }
        if (citations[i] > max) {
          break;
        }
      }
      return max;
    }
  }
}
