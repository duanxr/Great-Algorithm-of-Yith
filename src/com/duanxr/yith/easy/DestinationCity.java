package com.duanxr.yith.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 段然 2021/6/9
 */
public class DestinationCity {

  /**
   * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
   *
   * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
   *
   *  
   *
   * Example 1:
   *
   * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
   * Output: "Sao Paulo"
   * Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
   * Example 2:
   *
   * Input: paths = [["B","C"],["D","B"],["C","A"]]
   * Output: "A"
   * Explanation: All possible trips are: 
   * "D" -> "B" -> "C" -> "A". 
   * "B" -> "C" -> "A". 
   * "C" -> "A". 
   * "A". 
   * Clearly the destination city is "A".
   * Example 3:
   *
   * Input: paths = [["A","Z"]]
   * Output: "Z"
   *  
   *
   * Constraints:
   *
   * 1 <= paths.length <= 100
   * paths[i].length == 2
   * 1 <= cityAi.length, cityBi.length <= 10
   * cityAi != cityBi
   * All strings consist of lowercase and uppercase English letters and the space character.
   *
   * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
   *
   * 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
   * 输出："Sao Paulo"
   * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
   * 示例 2：
   *
   * 输入：paths = [["B","C"],["D","B"],["C","A"]]
   * 输出："A"
   * 解释：所有可能的线路是：
   * "D" -> "B" -> "C" -> "A". 
   * "B" -> "C" -> "A". 
   * "C" -> "A". 
   * "A". 
   * 显然，旅行终点站是 "A" 。
   * 示例 3：
   *
   * 输入：paths = [["A","Z"]]
   * 输出："Z"
   *  
   *
   * 提示：
   *
   * 1 <= paths.length <= 100
   * paths[i].length == 2
   * 1 <= cityAi.length, cityBi.length <= 10
   * cityAi != cityBi
   * 所有字符串均由大小写英文字母和空格字符组成。
   */
  class Solution {
    public String destCity(List<List<String>> paths) {
      Set<String> set0 = new HashSet<>();
      Set<String> set1 = new HashSet<>();
      for (List<String> path : paths) {
        set0.add(path.get(0));
        set1.add(path.get(1));
      }
      for (String s : set0) {
        set1.remove(s);
      }
      return (String) set1.toArray()[0];
    }
  }
}
