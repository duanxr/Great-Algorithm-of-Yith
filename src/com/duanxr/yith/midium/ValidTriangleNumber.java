package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 段然 2021/8/4
 */
public class ValidTriangleNumber {

  /**
   * Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [2,2,3,4]
   * Output: 3
   * Explanation: Valid combinations are:
   * 2,3,4 (using the first 2)
   * 2,3,4 (using the second 2)
   * 2,2,3
   * Example 2:
   *
   * Input: nums = [4,2,3,4]
   * Output: 4
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 1000
   * 0 <= nums[i] <= 1000
   *
   * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
   *
   * 示例 1:
   *
   * 输入: [2,2,3,4]
   * 输出: 3
   * 解释:
   * 有效的组合是:
   * 2,3,4 (使用第一个 2)
   * 2,3,4 (使用第二个 2)
   * 2,2,3
   * 注意:
   *
   * 数组长度不超过1000。
   * 数组里整数的范围为 [0, 1000]。
   *
   */
  class Solution {

    public int triangleNumber(int[] nums) {
      int count = 0;
      nums = sort(nums);
      int ol = nums.length;
      int fl = nums.length - 2;
      int sl = nums.length - 1;
      for (int i = 0; i < fl; i++) {
        int num1 = nums[i];
        for (int j = i + 1; j < sl; j++) {
          int num2 = nums[j];
          int limit = num1 + num2 - 1;
          int ts = j + 1;
          int index = binarySearch(nums, ts, ol, limit);
          count += index - ts;
        }
      }
      return count;
    }

    private int[] sort(int[] nums) {
      int[] map = new int[1001];
      for (int num : nums) {
        map[num]++;
      }
      int[] ints = new int[nums.length - map[0]];
      int ii = 0;
      for (int i = 1; i < map.length; i++) {
        int mi = map[i];
        if (mi != 0) {
          for (int j = 0; j < mi; j++) {
            ints[ii++] = i;
          }
        }
      }
      return ints;
    }

    private int binarySearch(int[] nums, int low, int toIndex,
        long key) {
      int high = toIndex - 1;
      while (low <= high) {
        int mid = (low + high) >>> 1;
        long midVal = nums[mid];
        if (midVal <= key) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      return low;
    }
  }


  class Solution5 {

    public int triangleNumber(int[] nums) {
      int count = 0;
      Arrays.sort(nums);
      int ol = nums.length;
      int fl = nums.length - 2;
      int sl = nums.length - 1;
      for (int i = 0; i < fl; i++) {
        int num1 = nums[i];
        if (num1 == 0) {
          continue;
        }
        for (int j = i + 1; j < sl; j++) {
          int num2 = nums[j];
          int limit = num1 + num2 - 1;
          int ts = j + 1;
          int index = binarySearch(nums, ts, ol, limit);
          count += index - ts;
        }
      }
      return count;
    }

    private int binarySearch(int[] nums, int low, int toIndex,
        long key) {
      int high = toIndex - 1;
      while (low <= high) {
        int mid = (low + high) >>> 1;
        long midVal = nums[mid];
        if (midVal <= key) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      return low;
    }
  }


  class Solution4 {

    public int triangleNumber(int[] nums) {
      int count = 0;
      Arrays.sort(nums);
      for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
        int num = nums[i];
        if (num == 0) {
          continue;
        }
        for (int j = i + 1; j < numsLength - 1; j++) {
          int num2 = nums[j];
          int limit = num + num2 - 1;
          int index = binarySearch(nums, j + 1, numsLength, limit);
          int count1 = index - j - 1;
          count += count1;
        }
      }
      return count;
    }

    private int binarySearch(int[] nums, int fromIndex, int toIndex,
        long key) {
      int low = fromIndex;
      int high = toIndex - 1;
      while (low <= high) {
        int mid = (low + high) >>> 1;
        long midVal = nums[mid];
        if (midVal <= key) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      return low;
    }
  }


  class Solution3 {

    public int triangleNumber(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>(nums.length);
      List<int[]> ints = new ArrayList<>(nums.length);
      int count = 0;
      Arrays.sort(nums);
      for (int num : nums) {
        if (num == 0) {
          continue;
        }
        ints.sort((o1, o2) -> Integer.compare(o2[0], o1[0]));
        for (int[] ii : ints) {
          if (ii[0] <= num) {
            break;
          }
          count += ii[1];
        }
        for (java.util.Map.Entry<Integer, Integer> entry : map.entrySet()) {
          int s = entry.getKey() + num;
          int[] ii = new int[]{s, entry.getValue()};
          ints.add(ii);
        }
        map.compute(num, (k, v) -> v == null ? 1 : v + 1);
      }
      return count;
    }
  }


  class Solution2 {

    public int triangleNumber(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>(nums.length);
      List<Integer> ints = new ArrayList<>(nums.length);
      int count = 0;
      Arrays.sort(nums);
      for (int num : nums) {
        if (num == 0) {
          continue;
        }
        ints.sort(Comparator.reverseOrder());
        for (Integer integer : ints) {
          if (integer <= num) {
            break;
          }
          count++;
        }
        for (java.util.Map.Entry<Integer, Integer> entry : map.entrySet()) {
          int s = entry.getKey() + num;
          for (int k = 0; k < entry.getValue(); k++) {
            ints.add(s);
          }
        }
        map.compute(num, (k, v) -> v == null ? 1 : v + 1);
      }
      return count;
    }
  }

  class Solution1 {

    public int triangleNumber(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      int[] ints = new int[2001];
      int count = 0;
      Arrays.sort(nums);
      for (int num : nums) {
        if (num == 0) {
          continue;
        }
        count += ints[num];
        for (java.util.Map.Entry<Integer, Integer> entry : map.entrySet()) {
          int s = entry.getKey() + num;
          for (int i = 0; i < s; i++) {
            ints[i] += entry.getValue();
          }
        }
        map.compute(num, (k, v) -> v == null ? 1 : v + 1);
      }
      return count;
    }
  }

}
