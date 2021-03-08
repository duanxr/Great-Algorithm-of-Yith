package com.duanxr.yith.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 段然 2021/3/8
 */
public class MinimumIndexSumOfTwoLists {

  /**
   * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
   *
   * You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
   *
   *  
   *
   * Example 1:
   *
   * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
   * Output: ["Shogun"]
   * Explanation: The only restaurant they both like is "Shogun".
   * Example 2:
   *
   * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
   * Output: ["Shogun"]
   * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
   * Example 3:
   *
   * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Burger King","Tapioca Express","Shogun"]
   * Output: ["KFC","Burger King","Tapioca Express","Shogun"]
   * Example 4:
   *
   * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KNN","KFC","Burger King","Tapioca Express","Shogun"]
   * Output: ["KFC","Burger King","Tapioca Express","Shogun"]
   * Example 5:
   *
   * Input: list1 = ["KFC"], list2 = ["KFC"]
   * Output: ["KFC"]
   *  
   *
   * Constraints:
   *
   * 1 <= list1.length, list2.length <= 1000
   * 1 <= list1[i].length, list2[i].length <= 30
   * list1[i] and list2[i] consist of spaces ' ' and English letters.
   * All the stings of list1 are unique.
   * All the stings of list2 are unique.
   *
   * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
   *
   * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
   *
   * 示例 1:
   *
   * 输入:
   * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
   * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
   * 输出: ["Shogun"]
   * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
   * 示例 2:
   *
   * 输入:
   * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
   * ["KFC", "Shogun", "Burger King"]
   * 输出: ["Shogun"]
   * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
   * 提示:
   *
   * 两个列表的长度范围都在 [1, 1000]内。
   * 两个列表中的字符串的长度将在[1，30]的范围内。
   * 下标从0开始，到列表的长度减1。
   * 两个列表都没有重复的元素。
   *
   */
  class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {
      Map<String, Integer> map1 = new HashMap<>(list1.length);
      Map<String, Integer> map2 = new HashMap<>(list2.length);
      List<String> list = new ArrayList<>();
      int i1 = 0, i2 = 0;
      int min = Integer.MAX_VALUE;
      while (i1 < list1.length || i2 < list2.length) {
        if (i1 < list1.length) {
          if (map2.containsKey(list1[i1])) {
            int indexSum = i1 + map2.get(list1[i1]);
            if (indexSum < min) {
              min = indexSum;
              list.clear();
              list.add(list1[i1]);
            } else if (indexSum == min) {
              list.add(list1[i1]);
            }
          }
          map1.put(list1[i1], i1);
          i1++;
        }
        if (i2 < list2.length) {
          if (map1.containsKey(list2[i2])) {
            int indexSum = i2 + map1.get(list2[i2]);
            if (indexSum < min) {
              min = indexSum;
              list.clear();
              list.add(list2[i2]);
            } else if (indexSum == min) {
              list.add(list2[i2]);
            }
          }
          map2.put(list2[i2], i2);
          i2++;
        }
        if (i1 > min && i2 > min) {
          break;
        }
      }
      return list.toArray(new String[0]);
    }


  }
}
