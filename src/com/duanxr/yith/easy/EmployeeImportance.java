package com.duanxr.yith.easy;

import com.duanxr.yith.define.employee.Employee;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 段然 2021/3/8
 */
public class EmployeeImportance {

  /**
   * You are given a data structure of employee information, which includes the employee's unique id, their importance value and their direct subordinates' id.
   *
   * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
   *
   * Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all their subordinates.
   *
   * Example 1:
   *
   * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
   * Output: 11
   * Explanation:
   * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
   *  
   *
   * Note:
   *
   * One employee has at most one direct leader and may have several subordinates.
   * The maximum number of employees won't exceed 2000.
   *
   * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
   *
   * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
   *
   * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
   *
   * 示例 1:
   *
   * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
   * 输出: 11
   * 解释:
   * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
   * 注意:
   *
   * 一个员工最多有一个直系领导，但是可以有多个直系下属
   * 员工数量不超过2000。
   *
   */
  class Solution {

    public int getImportance(List<Employee> employees, int id) {
      if (employees == null) {
        return 0;
      }
      Map<Integer, Employee> map = new HashMap<>();
      for (Employee employee : employees) {
        map.put(employee.id, employee);
      }
      return getImportance(map, id);
    }

    public int getImportance(Map<Integer, Employee> map, int id) {
      Employee employee = map.get(id);
      if (employee == null) {
        return 0;
      }
      int importance = employee.importance;
      if (employee.subordinates != null) {
        for (int i : employee.subordinates) {
          importance += getImportance(map, i);
        }
      }
      return importance;
    }
  }
}
