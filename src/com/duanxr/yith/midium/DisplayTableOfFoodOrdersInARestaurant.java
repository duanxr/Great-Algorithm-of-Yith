package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author 段然 2021/7/6
 */
public class DisplayTableOfFoodOrdersInARestaurant {

  /**
   * Given the array orders, which represents the orders that customers have done in a restaurant. More specifically orders[i]=[customerNamei,tableNumberi,foodItemi] where customerNamei is the name of the customer, tableNumberi is the table customer sit at, and foodItemi is the item customer orders.
   *
   * Return the restaurant's “display table”. The “display table” is a table whose row entries denote how many of each food item each table ordered. The first column is the table number and the remaining columns correspond to each food item in alphabetical order. The first row should be a header whose first column is “Table”, followed by the names of the food items. Note that the customer names are not part of the table. Additionally, the rows should be sorted in numerically increasing order.
   *
   *  
   *
   * Example 1:
   *
   * Input: orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
   * Output: [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
   * Explanation:
   * The displaying table looks like:
   * Table,Beef Burrito,Ceviche,Fried Chicken,Water
   * 3    ,0           ,2      ,1            ,0
   * 5    ,0           ,1      ,0            ,1
   * 10   ,1           ,0      ,0            ,0
   * For the table 3: David orders "Ceviche" and "Fried Chicken", and Rous orders "Ceviche".
   * For the table 5: Carla orders "Water" and "Ceviche".
   * For the table 10: Corina orders "Beef Burrito".
   * Example 2:
   *
   * Input: orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
   * Output: [["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
   * Explanation:
   * For the table 1: Adam and Brianna order "Canadian Waffles".
   * For the table 12: James, Ratesh and Amadeus order "Fried Chicken".
   * Example 3:
   *
   * Input: orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
   * Output: [["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
   *  
   *
   * Constraints:
   *
   * 1 <= orders.length <= 5 * 10^4
   * orders[i].length == 3
   * 1 <= customerNamei.length, foodItemi.length <= 20
   * customerNamei and foodItemi consist of lowercase and uppercase English letters and the space character.
   * tableNumberi is a valid integer between 1 and 500.
   *
   * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
   *
   * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
   *
   * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
   * 输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
   * 解释：
   * 点菜展示表如下所示：
   * Table,Beef Burrito,Ceviche,Fried Chicken,Water
   * 3    ,0           ,2      ,1            ,0
   * 5    ,0           ,1      ,0            ,1
   * 10   ,1           ,0      ,0            ,0
   * 对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
   * 而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
   * 餐桌 10：Corina 点了 "Beef Burrito"
   * 示例 2：
   *
   * 输入：orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
   * 输出：[["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
   * 解释：
   * 对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
   * 而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
   * 示例 3：
   *
   * 输入：orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
   * 输出：[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
   *  
   *
   * 提示：
   *
   * 1 <= orders.length <= 5 * 10^4
   * orders[i].length == 3
   * 1 <= customerNamei.length, foodItemi.length <= 20
   * customerNamei 和 foodItemi 由大小写英文字母及空格字符 ' ' 组成。
   * tableNumberi 是 1 到 500 范围内的整数。
   *
   */
  class Solution {

    public List<List<String>> displayTable(List<List<String>> orders) {
      Map<String, Integer>[] maps = new Map[501];
      Set<String> foodNames = new HashSet<>();
      for (List<String> order : orders) {
        int i = Integer.parseInt(order.get(1));
        Map<String, Integer> foodMap = maps[i];
        if (foodMap == null) {
          foodMap = new HashMap<>();
          maps[i] = foodMap;
        }
        foodNames.add(order.get(2));
        foodMap.compute(order.get(2), (k, v) -> v == null ? 1 : v + 1);
      }
      List<String> foodList = new ArrayList<>(foodNames);
      foodList.sort(String::compareTo);
      foodList.add(0, "Table");
      List<List<String>> list = new ArrayList<>();
      list.add(foodList);
      for (int i = 1; i < maps.length; i++) {
        Map<String, Integer> foodMap = maps[i];
        if (foodMap != null) {
          List<String> foodList1 = new ArrayList<>(foodNames.size());
          foodList1.add(String.valueOf(i));
          for (int j = 1; j < foodList.size(); j++) {
            foodList1.add(String.valueOf(foodMap.getOrDefault(foodList.get(j), 0)));
          }
          list.add(foodList1);
        }
      }
      return list;
    }
  }


  class Solution2 {

    public List<List<String>> displayTable(List<List<String>> orders) {
      Set<String> foodNames = new HashSet<>();
      Map<String, Map<String, Integer>> orderMap = new HashMap<>();
      for (List<String> order : orders) {
        Map<String, Integer> foodMap = orderMap
            .computeIfAbsent(order.get(1), k -> new HashMap<>());
        foodNames.add(order.get(2));
        foodMap.compute(order.get(2), (k, v) -> v == null ? 1 : v + 1);
      }
      List<String> foodList = new ArrayList<>(foodNames);
      foodList.sort(String::compareTo);
      foodList.add(0, "Table");
      List<List<String>> list = new ArrayList<>();
      list.add(foodList);
      Set<java.util.Map.Entry<String, Map<String, Integer>>> entrySet = orderMap.entrySet();
      List<java.util.Map.Entry<String, Map<String, Integer>>> entryList = new ArrayList<>(
          entrySet);
      entryList.sort(Comparator.comparingInt(o -> Integer.parseInt(o.getKey())));
      for (java.util.Map.Entry<String, Map<String, Integer>> mapEntry : entryList) {
        List<String> foodList1 = new ArrayList<>(foodNames.size());
        foodList1.add(mapEntry.getKey());
        for (int i = 1; i < foodList.size(); i++) {
          foodList1.add(String.valueOf(mapEntry.getValue().getOrDefault(foodList.get(i), 0)));
        }
        list.add(foodList1);
      }
      return list;
    }
  }


  class Solution1 {

    public List<List<String>> displayTable(List<List<String>> orders) {
      Set<String> foodNames = new HashSet<>();
      Map<Integer, Map<String, Integer>> orderMap = new HashMap<>();
      for (List<String> order : orders) {
        Map<String, Integer> foodMap = orderMap
            .computeIfAbsent(Integer.parseInt(order.get(1)), k -> new HashMap<>());
        foodNames.add(order.get(2));
        foodMap.compute(order.get(2), (k, v) -> v == null ? 1 : v + 1);
      }
      List<String> foodList = new ArrayList<>(foodNames);
      foodList.sort(String::compareTo);
      foodList.add(0, "Table");
      List<List<String>> list = new ArrayList<>();
      list.add(foodList);
      Set<java.util.Map.Entry<Integer, Map<String, Integer>>> entrySet = orderMap.entrySet();
      List<java.util.Map.Entry<Integer, Map<String, Integer>>> entryList = new ArrayList<>(
          entrySet);
      entryList.sort(Comparator.comparingInt(java.util.Map.Entry::getKey));
      for (java.util.Map.Entry<Integer, Map<String, Integer>> mapEntry : entryList) {
        List<String> foodList1 = new ArrayList<>(foodNames.size());
        foodList1.add(String.valueOf(mapEntry.getKey()));
        for (int i = 1; i < foodList.size(); i++) {
          foodList1.add(String.valueOf(mapEntry.getValue().getOrDefault(foodList.get(i), 0)));
        }
        list.add(foodList1);
      }
      return list;
    }
  }
}
