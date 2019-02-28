package com.duanxr.yith.easy;

/**
 * @author Duanran 2019/1/22 0022
 */
public class SwapSalary {

  /**
   * Given a table salary, such as the one below, that has m=male and f=female values. Swap all f
   * and m values (i.e., change all f values to m and vice versa) with a single update query and no
   * intermediate temp table.
   *
   * For example:
   *
   * | id | name | sex | salary |
   * |----|------|-----|--------|
   * | 1  | A    | m   | 2500   |
   * | 2  | B    | f   | 1500   |
   * | 3  | C    | m   | 5500   |
   * | 4  | D    | f   | 500    |
   *
   * After running your query, the above salary table should have the following rows:
   *
   * | id | name | sex | salary |
   * |----|------|-----|--------|
   * | 1  | A    | f   | 2500   |
   * | 2  | B    | m   | 1500   |
   * | 3  | C    | f   | 5500   |
   * | 4  | D    | m   | 500    |
   *
   *
   * 给定一个 salary表，如下所示，有m=男性 和 f=女性的值 。交换所有的 f 和 m 值(例如，将所有 f 值更改为 m，反之亦然)。要求使用一个更新查询，并且没有中间临时表。
   *
   * 例如:
   *
   * | id | name | sex | salary |
   * |----|------|-----|--------|
   * | 1  | A    | m   | 2500   |
   * | 2  | B    | f   | 1500   |
   * | 3  | C    | m   | 5500   |
   * | 4  | D    | f   | 500    |
   *
   * 运行你所编写的查询语句之后，将会得到以下表:
   *
   * | id | name | sex | salary |
   * |----|------|-----|--------|
   * | 1  | A    | f   | 2500   |
   * | 2  | B    | m   | 1500   |
   * | 3  | C    | f   | 5500   |
   * | 4  | D    | m   | 500    |
   */
  String sql = "UPDATE salary SET sex = CASE WHEN sex = 'm' THEN 'f' ELSE 'm' END";
}
