package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 段然 2021/9/16
 */
public class BitwiseORsOfSubarrays {

  /**
   * We have an array arr of non-negative integers.
   *
   * For every (contiguous) subarray sub = [arr[i], arr[i + 1], ..., arr[j]] (with i <= j), we take the bitwise OR of all the elements in sub, obtaining a result arr[i] | arr[i + 1] | ... | arr[j].
   *
   * Return the number of possible results. Results that occur more than once are only counted once in the final answer
   *
   *  
   *
   * Example 1:
   *
   * Input: arr = [0]
   * Output: 1
   * Explanation: There is only one possible result: 0.
   * Example 2:
   *
   * Input: arr = [1,1,2]
   * Output: 3
   * Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
   * These yield the results 1, 1, 2, 1, 3, 3.
   * There are 3 unique values, so the answer is 3.
   * Example 3:
   *
   * Input: arr = [1,2,4]
   * Output: 6
   * Explanation: The possible results are 1, 2, 3, 4, 6, and 7.
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 5 * 104
   * 0 <= nums[i] <= 109
   *
   * 我们有一个非负整数数组 A。
   *
   * 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
   *
   * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
   *
   *  
   *
   * 示例 1：
   *
   * 输入：[0]
   * 输出：1
   * 解释：
   * 只有一个可能的结果 0 。
   * 示例 2：
   *
   * 输入：[1,1,2]
   * 输出：3
   * 解释：
   * 可能的子数组为 [1]，[1]，[2]，[1, 1]，[1, 2]，[1, 1, 2]。
   * 产生的结果为 1，1，2，1，3，3 。
   * 有三个唯一值，所以答案是 3 。
   * 示例 3：
   *
   * 输入：[1,2,4]
   * 输出：6
   * 解释：
   * 可能的结果是 1，2，3，4，6，以及 7 。
   *  
   *
   * 提示：
   *
   * 1 <= A.length <= 50000
   * 0 <= A[i] <= 10^9
   *
   */
  class Solution {

    public int subarrayBitwiseORs(int[] arr) {
      Set<Integer> result = new HashSet<>();
      Set<Integer> set = new HashSet<>();
      for (int i : arr) {
        Set<Integer> set1 = new HashSet<>();
        for (Integer si : set) {
          set1.add(si | i);
        }
        set1.add(i);
        set = set1;
        result.addAll(set1);
      }
      return result.size();
    }
  }


  class Solution1 {

    public int subarrayBitwiseORs(int[] arr) {
      Set<Integer> result = new HashSet<>();
      Set<Integer> set = new HashSet<>();
      List<Integer> list = new ArrayList<>();
      for (int i : arr) {
        for (Integer si : set) {
          list.add(si | i);
        }
        set.clear();
        set.addAll(list);
        set.add(i);
        list.clear();
        result.addAll(set);
      }
      return result.size();
    }
  }
}
