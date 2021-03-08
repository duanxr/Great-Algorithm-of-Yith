package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class RisingTemperature {

  /**
   * Table: Weather
   *
   * +---------------+---------+
   * | Column Name   | Type    |
   * +---------------+---------+
   * | id            | int     |
   * | recordDate    | date    |
   * | temperature   | int     |
   * +---------------+---------+
   * id is the primary key for this table.
   * This table contains information about the temperature in a certain day.
   *  
   *
   * Write an SQL query to find all dates' id with higher temperature compared to its previous dates (yesterday).
   *
   * Return the result table in any order.
   *
   * The query result format is in the following example:
   *
   * Weather
   * +----+------------+-------------+
   * | id | recordDate | Temperature |
   * +----+------------+-------------+
   * | 1  | 2015-01-01 | 10          |
   * | 2  | 2015-01-02 | 25          |
   * | 3  | 2015-01-03 | 20          |
   * | 4  | 2015-01-04 | 30          |
   * +----+------------+-------------+
   *
   * Result table:
   * +----+
   * | id |
   * +----+
   * | 2  |
   * | 4  |
   * +----+
   * In 2015-01-02, temperature was higher than the previous day (10 -> 25).
   * In 2015-01-04, temperature was higher than the previous day (20 -> 30).
   *
   * 表 Weather
   *
   * +---------------+---------+
   * | Column Name   | Type    |
   * +---------------+---------+
   * | id            | int     |
   * | recordDate    | date    |
   * | temperature   | int     |
   * +---------------+---------+
   * id 是这个表的主键
   * 该表包含特定日期的温度信息
   *  
   *
   * 编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。
   *
   * 返回结果 不要求顺序 。
   *
   * 查询结果格式如下例：
   *
   * Weather
   * +----+------------+-------------+
   * | id | recordDate | Temperature |
   * +----+------------+-------------+
   * | 1  | 2015-01-01 | 10          |
   * | 2  | 2015-01-02 | 25          |
   * | 3  | 2015-01-03 | 20          |
   * | 4  | 2015-01-04 | 30          |
   * +----+------------+-------------+
   *
   * Result table:
   * +----+
   * | id |
   * +----+
   * | 2  |
   * | 4  |
   * +----+
   * 2015-01-02 的温度比前一天高（10 -> 25）
   * 2015-01-04 的温度比前一天高（20 -> 30）
   *
   */
  private String solution = "SELECT W1.Id FROM Weather W1 JOIN Weather W2 WHERE W1.Temperature > W2.Temperature AND W1.RecordDate = DATE_ADD(W2.RecordDate,INTERVAL 1 DAY)";

}
