package com.duanxr.yith.easy;

/**
 * @author 段然 2021/5/14
 */
public class PercentageOfUsersAttendedAContest {
  /**
   * Table: Users
   *
   * +-------------+---------+
   * | Column Name | Type    |
   * +-------------+---------+
   * | user_id     | int     |
   * | user_name   | varchar |
   * +-------------+---------+
   * user_id is the primary key for this table.
   * Each row of this table contains the name and the id of a user.
   *  
   *
   * Table: Register
   *
   * +-------------+---------+
   * | Column Name | Type    |
   * +-------------+---------+
   * | contest_id  | int     |
   * | user_id     | int     |
   * +-------------+---------+
   * (contest_id, user_id) is the primary key for this table.
   * Each row of this table contains the id of a user and the contest they registered into.
   *  
   *
   * Write an SQL query to find the percentage of the users registered in each contest rounded to two decimals.
   *
   * Return the result table ordered by percentage in descending order. In case of a tie, order it by contest_id in ascending order.
   *
   * The query result format is in the following example.
   *
   *  
   *
   * Users table:
   * +---------+-----------+
   * | user_id | user_name |
   * +---------+-----------+
   * | 6       | Alice     |
   * | 2       | Bob       |
   * | 7       | Alex      |
   * +---------+-----------+
   *
   * Register table:
   * +------------+---------+
   * | contest_id | user_id |
   * +------------+---------+
   * | 215        | 6       |
   * | 209        | 2       |
   * | 208        | 2       |
   * | 210        | 6       |
   * | 208        | 6       |
   * | 209        | 7       |
   * | 209        | 6       |
   * | 215        | 7       |
   * | 208        | 7       |
   * | 210        | 2       |
   * | 207        | 2       |
   * | 210        | 7       |
   * +------------+---------+
   *
   * Result table:
   * +------------+------------+
   * | contest_id | percentage |
   * +------------+------------+
   * | 208        | 100.0      |
   * | 209        | 100.0      |
   * | 210        | 100.0      |
   * | 215        | 66.67      |
   * | 207        | 33.33      |
   * +------------+------------+
   * All the users registered in contests 208, 209, and 210. The percentage is 100% and we sort them in the answer table by contest_id in ascending order.
   * Alice and Alex registered in contest 215 and the percentage is ((2/3) * 100) = 66.67%
   * Bob registered in contest 207 and the percentage is ((1/3) * 100) = 33.33%
   *
   * 用户表： Users
   *
   * +-------------+---------+
   * | Column Name | Type    |
   * +-------------+---------+
   * | user_id     | int     |
   * | user_name   | varchar |
   * +-------------+---------+
   * user_id 是该表的主键。
   * 该表中的每行包括用户 ID 和用户名。
   *  
   *
   * 注册表： Register
   *
   * +-------------+---------+
   * | Column Name | Type    |
   * +-------------+---------+
   * | contest_id  | int     |
   * | user_id     | int     |
   * +-------------+---------+
   * (contest_id, user_id) 是该表的主键。
   * 该表中的每行包含用户的 ID 和他们注册的赛事。
   *  
   *
   * 写一条 SQL 语句，查询各赛事的用户注册百分率，保留两位小数。
   *
   * 返回的结果表按 percentage 的降序排序，若相同则按 contest_id 的升序排序。
   *
   * 查询结果如下示例所示：
   *
   *  
   *
   * Users 表：
   * +---------+-----------+
   * | user_id | user_name |
   * +---------+-----------+
   * | 6       | Alice     |
   * | 2       | Bob       |
   * | 7       | Alex      |
   * +---------+-----------+
   *
   * Register 表：
   * +------------+---------+
   * | contest_id | user_id |
   * +------------+---------+
   * | 215        | 6       |
   * | 209        | 2       |
   * | 208        | 2       |
   * | 210        | 6       |
   * | 208        | 6       |
   * | 209        | 7       |
   * | 209        | 6       |
   * | 215        | 7       |
   * | 208        | 7       |
   * | 210        | 2       |
   * | 207        | 2       |
   * | 210        | 7       |
   * +------------+---------+
   *
   * 结果表：
   * +------------+------------+
   * | contest_id | percentage |
   * +------------+------------+
   * | 208        | 100.0      |
   * | 209        | 100.0      |
   * | 210        | 100.0      |
   * | 215        | 66.67      |
   * | 207        | 33.33      |
   * +------------+------------+
   * 所有用户都注册了 208、209 和 210 赛事，因此这些赛事的注册率为 100% ，我们按 contest_id 的降序排序加入结果表中。
   * Alice 和 Alex 注册了 215 赛事，注册率为 ((2/3) * 100) = 66.67%
   * Bob 注册了 207 赛事，注册率为 ((1/3) * 100) = 33.33%
   *
   */
  private static final String SQL = ""
      + "SELECT\n"
      + "\tRegister.contest_id,\n"
      + "\tROUND( 100 * COUNT( Register.user_id ) / ( SELECT COUNT( Users.user_id ) FROM Users ), 2 ) AS percentage \n"
      + "FROM\n"
      + "\tRegister \n"
      + "GROUP BY\n"
      + "\tRegister.contest_id \n"
      + "ORDER BY\n"
      + "\tpercentage DESC,\n"
      + "\tcontest_id";
}
