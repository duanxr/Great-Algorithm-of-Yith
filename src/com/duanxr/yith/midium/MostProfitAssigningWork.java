package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author 段然 2021/11/22
 */
public class MostProfitAssigningWork {

  /**
   * You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:
   *
   * difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
   * worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
   * Every worker can be assigned at most one job, but one job can be completed multiple times.
   *
   * For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker cannot complete any job, their profit is $0.
   * Return the maximum profit we can achieve after assigning the workers to the jobs.
   *
   *  
   *
   * Example 1:
   *
   * Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
   * Output: 100
   * Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get a profit of [20,20,30,30] separately.
   * Example 2:
   *
   * Input: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
   * Output: 0
   *  
   *
   * Constraints:
   *
   * n == difficulty.length
   * n == profit.length
   * m == worker.length
   * 1 <= n, m <= 104
   * 1 <= difficulty[i], profit[i], worker[i] <= 105
   *
   * 有一些工作：difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
   *
   * 现在我们有一些工人。worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
   *
   * 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。
   *
   * 举个例子，如果 3 个工人都尝试完成一份报酬为 1 的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。
   *
   * 我们能得到的最大收益是多少？
   *
   *  
   *
   * 示例 1：
   *
   * 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
   * 输出: 100
   * 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
   * 示例 2:
   *
   * 输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
   * 输出: 0
   *  
   *
   * 提示:
   *
   * n == difficulty.length
   * n == profit.length
   * m == worker.length
   * 1 <= n, m <= 104
   * 1 <= difficulty[i], profit[i], worker[i] <= 105
   */
  class Solution {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
      List<int[]> list = new ArrayList<>(profit.length);
      for (int i = 0; i < profit.length; i++) {
        list.add(new int[]{difficulty[i], profit[i]});
      }
      list.sort(((Comparator<int[]>) (o1, o2) -> Integer.compare(o1[0], o2[0])).thenComparing(
          (o1, o2) -> Integer.compare(o2[1], o1[1])));
      int maxProfit = 0;
      for (int[] ints : list) {
        if (ints[1] > maxProfit) {
          maxProfit = ints[1];
        } else {
          ints[1] = maxProfit;
        }
      }
      int max = 0;
      for (int w : worker) {
        int[] search = indexedBinarySearch(list, w);
        if (search != null) {
          max += search[1];
        }
      }
      return max;
    }

    private int[] indexedBinarySearch(List<int[]> l, int key) {
      int low = 0;
      int high = l.size() - 1;
      while (low <= high) {
        int mid = (low + high) >>> 1;
        int[] ints = l.get(mid);
        int midVal = ints[0];
        if (key > midVal) {
          low = mid + 1;
        } else if (key < midVal) {
          high = mid - 1;
        } else {
          return ints;
        }
      }
      if (high >= 0) {
        return l.get(high);
      }
      return null;
    }

  }
}
