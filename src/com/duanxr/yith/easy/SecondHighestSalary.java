package com.duanxr.yith.easy;

/**
 * @author Duanran 2019/3/1 0001
 */
public class SecondHighestSalary {

  /**
   * Write a SQL query to get the second highest salary from the Employee table.
   *
   * +----+--------+
   * | Id | Salary |
   * +----+--------+
   * | 1  | 100    |
   * | 2  | 200    |
   * | 3  | 300    |
   * +----+--------+
   *
   * For example, given the above Employee table, the query should return 200 as the second highest
   * salary. If there is no second highest salary, then the query should return null.
   *
   * +---------------------+
   * | SecondHighestSalary |
   * +---------------------+
   * | 200                 |
   * +---------------------+
   *
   * 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
   *
   * +----+--------+
   * | Id | Salary |
   * +----+--------+
   * | 1  | 100    |
   * | 2  | 200    |
   * | 3  | 300    |
   * +----+--------+
   *
   * 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
   *
   * +---------------------+
   * | SecondHighestSalary |
   * +---------------------+
   * | 200                 |
   * +---------------------+
   */
  String sql = "SELECT MAX(Salary) AS SecondHighestSalary FROM Employee WHERE Salary != (SELECT MAX(Salary) FROM Employee LIMIT 1)LIMIT 1";
}
