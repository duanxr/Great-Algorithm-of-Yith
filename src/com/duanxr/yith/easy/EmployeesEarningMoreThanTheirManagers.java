package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class EmployeesEarningMoreThanTheirManagers {

  /**
   * The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.
   *
   * +----+-------+--------+-----------+
   * | Id | Name  | Salary | ManagerId |
   * +----+-------+--------+-----------+
   * | 1  | Joe   | 70000  | 3         |
   * | 2  | Henry | 80000  | 4         |
   * | 3  | Sam   | 60000  | NULL      |
   * | 4  | Max   | 90000  | NULL      |
   * +----+-------+--------+-----------+
   * Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.
   *
   * +----------+
   * | Employee |
   * +----------+
   * | Joe      |
   * +----------+
   *
   * Employee 表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。
   *
   * +----+-------+--------+-----------+
   * | Id | Name  | Salary | ManagerId |
   * +----+-------+--------+-----------+
   * | 1  | Joe   | 70000  | 3         |
   * | 2  | Henry | 80000  | 4         |
   * | 3  | Sam   | 60000  | NULL      |
   * | 4  | Max   | 90000  | NULL      |
   * +----+-------+--------+-----------+
   * 给定 Employee 表，编写一个 SQL 查询，该查询可以获取收入超过他们经理的员工的姓名。在上面的表格中，Joe 是唯一一个收入超过他的经理的员工。
   *
   * +----------+
   * | Employee |
   * +----------+
   * | Joe      |
   * +----------+
   *
   */
  private String solution = "SELECT A.Name AS Employee FROM Employee A,Employee B WHERE A.ManagerId = B.Id AND A.Salary > B.Salary";
}
