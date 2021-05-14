package com.duanxr.yith.easy;

/**
 * @author 段然 2021/5/14
 */
public class FindFollowersCount {

  /**
   * 表： Followers
   *
   * +-------------+------+
   * | Column Name | Type |
   * +-------------+------+
   * | user_id     | int  |
   * | follower_id | int  |
   * +-------------+------+
   * (user_id, follower_id) 是这个表的主键。
   * 该表包含一个关注关系中关注者和用户的编号，其中关注者关注用户。
   * 写出 SQL 语句，对于每一个用户，返回该用户的关注者数量。
   *
   * 按 user_id 的顺序返回结果表。
   *
   * 查询结果的格式如下示例所示：
   *
   *  
   *
   * Followers 表：
   * +---------+-------------+
   * | user_id | follower_id |
   * +---------+-------------+
   * | 0       | 1           |
   * | 1       | 0           |
   * | 2       | 0           |
   * | 2       | 1           |
   * +---------+-------------+
   * 结果表：
   * +---------+----------------+
   * | user_id | followers_count|
   * +---------+----------------+
   * | 0       | 1              |
   * | 1       | 1              |
   * | 2       | 2              |
   * +---------+----------------+
   * 0 的关注者有 {1}
   * 1 的关注者有 {0}
   * 2 的关注者有 {0,1}
   *
   * Table: Followers
   *
   * +-------------+------+
   * | Column Name | Type |
   * +-------------+------+
   * | user_id     | int  |
   * | follower_id | int  |
   * +-------------+------+
   * (user_id, follower_id) is the primary key for this table.
   * This table contains the IDs of a user and a follower in a social media app where the follower follows the user.
   * Write an SQL query that will, for each user, return the number of followers.
   *
   * Return the result table ordered by user_id.
   *
   * The query result format is in the following example:
   *
   *  
   *
   * Followers table:
   * +---------+-------------+
   * | user_id | follower_id |
   * +---------+-------------+
   * | 0       | 1           |
   * | 1       | 0           |
   * | 2       | 0           |
   * | 2       | 1           |
   * +---------+-------------+
   * Result table:
   * +---------+----------------+
   * | user_id | followers_count|
   * +---------+----------------+
   * | 0       | 1              |
   * | 1       | 1              |
   * | 2       | 2              |
   * +---------+----------------+
   * The followers of 0 are {1}
   * The followers of 1 are {0}
   * The followers of 2 are {0,1}
   *
   */
  private static final String SQL = ""
    + "SELECT\n"
    + "\tFollowers.user_id AS user_id,\n"
    + "\tCOUNT( Followers.follower_id ) AS followers_count \n"
    + "FROM\n"
    + "\tFollowers \n"
    + "GROUP BY\n"
    + "\tFollowers.user_id \n"
    + "ORDER BY\n"
    + "\tFollowers.user_id";
}
