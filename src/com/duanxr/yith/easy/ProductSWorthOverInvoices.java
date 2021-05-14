package com.duanxr.yith.easy;

/**
 * @author 段然 2021/5/14
 */
public class ProductSWorthOverInvoices {

  /**
   * Product 表：
   *
   * +-------------+---------+
   * | Column Name | Type    |
   * +-------------+---------+
   * | product_id  | int     |
   * | name        | varchar |
   * +-------------+---------+
   * product_id 是这张表的主键
   * 表中含有产品 id 、产品名称。产品名称都是小写的英文字母，产品名称都是唯一的
   *  
   *
   * Invoice 表：
   *
   * +-------------+------+
   * | Column Name | Type |
   * +-------------+------+
   * | invoice_id  | int  |
   * | product_id  | int  |
   * | rest        | int  |
   * | paid        | int  |
   * | canceled    | int  |
   * | refunded    | int  |
   * +-------------+------+
   * invoice_id 发票 id ，是这张表的主键
   * product_id 产品 id
   * rest 应缴款项
   * paid 已支付金额
   * canceled 已取消金额
   * refunded 已退款金额
   *  
   *
   * 要求写一个SQL查询，返回全部发票中每个产品的产品名称、总应缴款项、总已支付金额、总已取消金额、总已退款金额
   *
   * 查询结果按 product_name排序
   *
   * 示例：
   *
   * Product 表：
   * +------------+-------+
   * | product_id | name  |
   * +------------+-------+
   * | 0          | ham   |
   * | 1          | bacon |
   * +------------+-------+
   * Invoice table:
   * +------------+------------+------+------+----------+----------+
   * | invoice_id | product_id | rest | paid | canceled | refunded |
   * +------------+------------+------+------+----------+----------+
   * | 23         | 0          | 2    | 0    | 5        | 0        |
   * | 12         | 0          | 0    | 4    | 0        | 3        |
   * | 1          | 1          | 1    | 1    | 0        | 1        |
   * | 2          | 1          | 1    | 0    | 1        | 1        |
   * | 3          | 1          | 0    | 1    | 1        | 1        |
   * | 4          | 1          | 1    | 1    | 1        | 0        |
   * +------------+------------+------+------+----------+----------+
   * Result 表：
   * +-------+------+------+----------+----------+
   * | name  | rest | paid | canceled | refunded |
   * +-------+------+------+----------+----------+
   * | bacon | 3    | 3    | 3        | 3        |
   * | ham   | 2    | 4    | 5        | 3        |
   * +-------+------+------+----------+----------+
   * - bacon 的总应缴款项为 1 + 1 + 0 + 1 = 3
   * - bacon 的总已支付金额为 1 + 0 + 1 + 1 = 3
   * - bacon 的总已取消金额为 0 + 1 + 1 + 1 = 3
   * - bacon 的总已退款金额为 1 + 1 + 1 + 0 = 3
   * - ham 的总应缴款项为 2 + 0 = 2
   * - ham 的总已支付金额为 0 + 4 = 4
   * - ham 的总已取消金额为 5 + 0 = 5
   * - ham 的总已退款金额为 0 + 3 = 3
   *
   *
   * Table: Product
   *
   * +-------------+---------+
   * | Column Name | Type    |
   * +-------------+---------+
   * | product_id  | int     |
   * | name        | varchar |
   * +-------------+---------+
   * product_id is the primary key for this table.
   * This table contains the ID and the name of the product. The name consists of only lowercase English letters. No two products have the same name.
   *  
   *
   * Table: Invoice
   *
   * +-------------+------+
   * | Column Name | Type |
   * +-------------+------+
   * | invoice_id  | int  |
   * | product_id  | int  |
   * | rest        | int  |
   * | paid        | int  |
   * | canceled    | int  |
   * | refunded    | int  |
   * +-------------+------+
   * invoice_id is the primary key for this table and the id of this invoice.
   * product_id is the id of the product for this invoice.
   * rest is the amount left to pay for this invoice.
   * paid is the amount paid for this invoice.
   * canceled is the amount canceled for this invoice.
   * refunded is the amount refunded for this invoice.
   *  
   *
   * Write an SQL query that will, for all products, return each product name with total amount due, paid, canceled, and refunded across all invoices.
   *
   * Return the result table ordered by product_name.
   *
   * The query result format is in the following example:
   *
   *  
   *
   * Product table:
   * +------------+-------+
   * | product_id | name  |
   * +------------+-------+
   * | 0          | ham   |
   * | 1          | bacon |
   * +------------+-------+
   * Invoice table:
   * +------------+------------+------+------+----------+----------+
   * | invoice_id | product_id | rest | paid | canceled | refunded |
   * +------------+------------+------+------+----------+----------+
   * | 23         | 0          | 2    | 0    | 5        | 0        |
   * | 12         | 0          | 0    | 4    | 0        | 3        |
   * | 1          | 1          | 1    | 1    | 0        | 1        |
   * | 2          | 1          | 1    | 0    | 1        | 1        |
   * | 3          | 1          | 0    | 1    | 1        | 1        |
   * | 4          | 1          | 1    | 1    | 1        | 0        |
   * +------------+------------+------+------+----------+----------+
   * Result table:
   * +-------+------+------+----------+----------+
   * | name  | rest | paid | canceled | refunded |
   * +-------+------+------+----------+----------+
   * | bacon | 3    | 3    | 3        | 3        |
   * | ham   | 2    | 4    | 5        | 3        |
   * +-------+------+------+----------+----------+
   * - The amount of money left to pay for bacon is 1 + 1 + 0 + 1 = 3
   * - The amount of money paid for bacon is 1 + 0 + 1 + 1 = 3
   * - The amount of money canceled for bacon is 0 + 1 + 1 + 1 = 3
   * - The amount of money refunded for bacon is 1 + 1 + 1 + 0 = 3
   * - The amount of money left to pay for ham is 2 + 0 = 2
   * - The amount of money paid for ham is 0 + 4 = 4
   * - The amount of money canceled for ham is 5 + 0 = 5
   * - The amount of money refunded for ham is 0 + 3 = 3
   *
   */
  private static final String SQL = ""
      + "SELECT\n"
      + "\tProduct.NAME AS NAME,\n"
      + "\tCOALESCE ( SUM( Invoice.rest ), 0 ) AS rest,\n"
      + "\tCOALESCE ( SUM( Invoice.paid ), 0 ) AS paid,\n"
      + "\tCOALESCE ( SUM( Invoice.canceled ), 0 ) AS canceled,\n"
      + "\tCOALESCE ( SUM( Invoice.refunded ), 0 ) AS refunded \n"
      + "FROM\n"
      + "\tProduct\n"
      + "\tLEFT JOIN Invoice ON Product.product_id = Invoice.product_id \n"
      + "GROUP BY\n"
      + "\tProduct.product_id \n"
      + "ORDER BY\n"
      + "\tProduct.NAME";
}
