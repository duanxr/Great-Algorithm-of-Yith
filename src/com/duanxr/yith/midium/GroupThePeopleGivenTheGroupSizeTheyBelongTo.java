package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 段然 2021/10/13
 */
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {

  /**
   * There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.
   *
   * You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in. For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
   *
   * Return a list of groups such that each person i is in a group of size groupSizes[i].
   *
   * Each person should appear in exactly one group, and every person must be in a group. If there are multiple answers, return any of them. It is guaranteed that there will be at least one valid solution for the given input.
   *
   *  
   *
   * Example 1:
   *
   * Input: groupSizes = [3,3,3,3,3,1,3]
   * Output: [[5],[0,1,2],[3,4,6]]
   * Explanation:
   * The first group is [5]. The size is 1, and groupSizes[5] = 1.
   * The second group is [0,1,2]. The size is 3, and groupSizes[0] = groupSizes[1] = groupSizes[2] = 3.
   * The third group is [3,4,6]. The size is 3, and groupSizes[3] = groupSizes[4] = groupSizes[6] = 3.
   * Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
   * Example 2:
   *
   * Input: groupSizes = [2,1,3,3,3,2]
   * Output: [[1],[0,5],[2,3,4]]
   *  
   *
   * Constraints:
   *
   * groupSizes.length == n
   * 1 <= n <= 500
   * 1 <= groupSizes[i] <= n
   *
   * 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
   *
   * 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：groupSizes = [3,3,3,3,3,1,3]
   * 输出：[[5],[0,1,2],[3,4,6]]
   * 解释：
   * 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
   * 示例 2：
   *
   * 输入：groupSizes = [2,1,3,3,3,2]
   * 输出：[[1],[0,5],[2,3,4]]
   *  
   *
   * 提示：
   *
   * groupSizes.length == n
   * 1 <= n <= 500
   * 1 <= groupSizes[i] <= n
   *
   */
  class Solution {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
      List<List<Integer>> result = new ArrayList<>();
      List<Integer>[] countMap = new List[500];
      for (int i = 0; i < groupSizes.length; i++) {
        int groupSize = groupSizes[i];
        List<Integer> list = countMap[groupSize];
        if (list == null) {
          list = new ArrayList<>();
          countMap[groupSize] = list;
        } else if (list.size() == groupSize) {
          result.add(list);
          list = new ArrayList<>();
          countMap[groupSize] = list;
        }
        list.add(i);
      }
      for (List<Integer> list : countMap) {
        if (list != null) {
          result.add(list);
        }
      }
      return result;
    }
  }


  class Solution1 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
      List<List<Integer>> result = new ArrayList<>();
      Map<Integer, List<Integer>> countMap = new HashMap<>();
      for (int i = 0; i < groupSizes.length; i++) {
        int groupSize = groupSizes[i];
        countMap.compute(groupSize,
            (key, value) -> {
              if (value == null) {
                return new ArrayList<>();
              }
              if (value.size() == groupSize) {
                result.add(value);
                return new ArrayList<>();
              }
              return value;
            }).add(i);
      }
      result.addAll(countMap.values());
      return result;
    }
  }
}
