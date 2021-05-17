package com.duanxr.yith.easy;

/**
 * @author 段然 2021/5/17
 */
public class RecyclableAndLowFatProducts {

  /**
   * 表：Products
   *
   * +-------------+---------+
   * | Column Name | Type    |
   * +-------------+---------+
   * | product_id  | int     |
   * | low_fats    | enum    |
   * | recyclable  | enum    |
   * +-------------+---------+
   * product_id 是这个表的主键。
   * low_fats 是枚举类型，取值为以下两种 ('Y', 'N')，其中 'Y' 表示该产品是低脂产品，'N' 表示不是低脂产品。
   * recyclable 是枚举类型，取值为以下两种 ('Y', 'N')，其中 'Y' 表示该产品可回收，而 'N' 表示不可回收。
   *  
   *
   * 写出 SQL 语句，查找既是低脂又是可回收的产品编号。
   *
   * 返回结果 无顺序要求 。
   *
   * 查询结果格式如下例所示：
   *
   * Products 表：
   * +-------------+----------+------------+
   * | product_id  | low_fats | recyclable |
   * +-------------+----------+------------+
   * | 0           | Y        | N          |
   * | 1           | Y        | Y          |
   * | 2           | N        | Y          |
   * | 3           | Y        | Y          |
   * | 4           | N        | N          |
   * +-------------+----------+------------+
   * Result 表：
   * +-------------+
   * | product_id  |
   * +-------------+
   * | 1           |
   * | 3           |
   * +-------------+
   * 只有产品 id 为 1 和 3 的产品，既是低脂又是可回收的产品。
   *
   * Table: Products
   *
   * +-------------+---------+
   * | Column Name | Type    |
   * +-------------+---------+
   * | product_id  | int     |
   * | low_fats    | enum    |
   * | recyclable  | enum    |
   * +-------------+---------+
   * product_id is the primary key for this table.
   * low_fats is an ENUM of type ('Y', 'N') where 'Y' means this product is low fat and 'N' means it is not.
   * recyclable is an ENUM of types ('Y', 'N') where 'Y' means this product is recyclable and 'N' means it is not.
   *  
   *
   * Write an SQL query to find the ids of products that are both low fat and recyclable.
   *
   * Return the result table in any order.
   *
   * The query result format is in the following example:
   *
   *  
   *
   * Products table:
   * +-------------+----------+------------+
   * | product_id  | low_fats | recyclable |
   * +-------------+----------+------------+
   * | 0           | Y        | N          |
   * | 1           | Y        | Y          |
   * | 2           | N        | Y          |
   * | 3           | Y        | Y          |
   * | 4           | N        | N          |
   * +-------------+----------+------------+
   * Result table:
   * +-------------+
   * | product_id  |
   * +-------------+
   * | 1           |
   * | 3           |
   * +-------------+
   * Only products 1 and 3 are both low fat and recyclable.
   *
   */
  private static final String SQL = ""
      + "SELECT\n"
      + "\tproduct_id \n"
      + "FROM\n"
      + "\tProducts \n"
      + "WHERE\n"
      + "\tlow_fats = 'Y' \n"
      + "\tAND recyclable = 'Y'";
}
