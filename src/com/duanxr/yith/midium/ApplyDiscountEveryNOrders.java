package com.duanxr.yith.midium;

/**
 * @author 段然 2021/5/18
 */
public class ApplyDiscountEveryNOrders {

  /**
   * There is a sale in a supermarket, there will be a discount every n customer.
   * There are some products in the supermarket where the id of the i-th product is products[i] and the price per unit of this product is prices[i].
   * The system will count the number of customers and when the n-th customer arrive he/she will have a discount on the bill. (i.e if the cost is x the new cost is x - (discount * x) / 100). Then the system will start counting customers again.
   * The customer orders a certain amount of each product where product[i] is the id of the i-th product the customer ordered and amount[i] is the number of units the customer ordered of that product.
   *
   * Implement the Cashier class:
   *
   * Cashier(int n, int discount, int[] products, int[] prices) Initializes the object with n, the discount, the products and their prices.
   * double getBill(int[] product, int[] amount) returns the value of the bill and apply the discount if needed. Answers within 10^-5 of the actual value will be accepted as correct.
   *  
   *
   * Example 1:
   *
   * Input
   * ["Cashier","getBill","getBill","getBill","getBill","getBill","getBill","getBill"]
   * [[3,50,[1,2,3,4,5,6,7],[100,200,300,400,300,200,100]],[[1,2],[1,2]],[[3,7],[10,10]],[[1,2,3,4,5,6,7],[1,1,1,1,1,1,1]],[[4],[10]],[[7,3],[10,10]],[[7,5,3,1,6,4,2],[10,10,10,9,9,9,7]],[[2,3,5],[5,3,2]]]
   * Output
   * [null,500.0,4000.0,800.0,4000.0,4000.0,7350.0,2500.0]
   * Explanation
   * Cashier cashier = new Cashier(3,50,[1,2,3,4,5,6,7],[100,200,300,400,300,200,100]);
   * cashier.getBill([1,2],[1,2]);                        // return 500.0, bill = 1 * 100 + 2 * 200 = 500.
   * cashier.getBill([3,7],[10,10]);                      // return 4000.0
   * cashier.getBill([1,2,3,4,5,6,7],[1,1,1,1,1,1,1]);    // return 800.0, The bill was 1600.0 but as this is the third customer, he has a discount of 50% which means his bill is only 1600 - 1600 * (50 / 100) = 800.
   * cashier.getBill([4],[10]);                           // return 4000.0
   * cashier.getBill([7,3],[10,10]);                      // return 4000.0
   * cashier.getBill([7,5,3,1,6,4,2],[10,10,10,9,9,9,7]); // return 7350.0, Bill was 14700.0 but as the system counted three more customers, he will have a 50% discount and the bill becomes 7350.0
   * cashier.getBill([2,3,5],[5,3,2]);                    // return 2500.0
   *  
   *
   * Constraints:
   *
   * 1 <= n <= 10^4
   * 0 <= discount <= 100
   * 1 <= products.length <= 200
   * 1 <= products[i] <= 200
   * There are not repeated elements in the array products.
   * prices.length == products.length
   * 1 <= prices[i] <= 1000
   * 1 <= product.length <= products.length
   * product[i] exists in products.
   * amount.length == product.length
   * 1 <= amount[i] <= 1000
   * At most 1000 calls will be made to getBill.
   * Answers within 10^-5 of the actual value will be accepted as correct.
   *
   * 超市里正在举行打折活动，每隔 n 个顾客会得到 discount 的折扣。
   *
   * 超市里有一些商品，第 i 种商品为 products[i] 且每件单品的价格为 prices[i] 。
   *
   * 结账系统会统计顾客的数目，每隔 n 个顾客结账时，该顾客的账单都会打折，折扣为 discount （也就是如果原本账单为 x ，那么实际金额会变成 x - (discount * x) / 100 ），然后系统会重新开始计数。
   *
   * 顾客会购买一些商品， product[i] 是顾客购买的第 i 种商品， amount[i] 是对应的购买该种商品的数目。
   *
   * 请你实现 Cashier 类：
   *
   * Cashier(int n, int discount, int[] products, int[] prices) 初始化实例对象，参数分别为打折频率 n ，折扣大小 discount ，超市里的商品列表 products 和它们的价格 prices 。
   * double getBill(int[] product, int[] amount) 返回账单的实际金额（如果有打折，请返回打折后的结果）。返回结果与标准答案误差在 10^-5 以内都视为正确结果。
   *  
   *
   * 示例 1：
   *
   * 输入
   * ["Cashier","getBill","getBill","getBill","getBill","getBill","getBill","getBill"]
   * [[3,50,[1,2,3,4,5,6,7],[100,200,300,400,300,200,100]],[[1,2],[1,2]],[[3,7],[10,10]],[[1,2,3,4,5,6,7],[1,1,1,1,1,1,1]],[[4],[10]],[[7,3],[10,10]],[[7,5,3,1,6,4,2],[10,10,10,9,9,9,7]],[[2,3,5],[5,3,2]]]
   * 输出
   * [null,500.0,4000.0,800.0,4000.0,4000.0,7350.0,2500.0]
   * 解释
   * Cashier cashier = new Cashier(3,50,[1,2,3,4,5,6,7],[100,200,300,400,300,200,100]);
   * cashier.getBill([1,2],[1,2]);                        // 返回 500.0, 账单金额为 = 1 * 100 + 2 * 200 = 500.
   * cashier.getBill([3,7],[10,10]);                      // 返回 4000.0
   * cashier.getBill([1,2,3,4,5,6,7],[1,1,1,1,1,1,1]);    // 返回 800.0 ，账单原本为 1600.0 ，但由于该顾客是第三位顾客，他将得到 50% 的折扣，所以实际金额为 1600 - 1600 * (50 / 100) = 800 。
   * cashier.getBill([4],[10]);                           // 返回 4000.0
   * cashier.getBill([7,3],[10,10]);                      // 返回 4000.0
   * cashier.getBill([7,5,3,1,6,4,2],[10,10,10,9,9,9,7]); // 返回 7350.0 ，账单原本为 14700.0 ，但由于系统计数再次达到三，该顾客将得到 50% 的折扣，实际金额为 7350.0 。
   * cashier.getBill([2,3,5],[5,3,2]);                    // 返回 2500.0
   *  
   *
   * 提示：
   *
   * 1 <= n <= 10^4
   * 0 <= discount <= 100
   * 1 <= products.length <= 200
   * 1 <= products[i] <= 200
   * products 列表中 不会 有重复的元素。
   * prices.length == products.length
   * 1 <= prices[i] <= 1000
   * 1 <= product.length <= products.length
   * product[i] 在 products 出现过。
   * amount.length == product.length
   * 1 <= amount[i] <= 1000
   * 最多有 1000 次对 getBill 函数的调用。
   * 返回结果与标准答案误差在 10^-5 以内都视为正确结果。
   *
   */
  class Cashier {

    final int n;
    final int discount;
    final int[] prices;
    int cn = 0;

    public Cashier(int n, int discount, int[] products, int[] prices) {
      this.n = n;
      this.discount = discount;
      this.prices = new int[201];
      for (int i = 0; i < products.length; i++) {
        this.prices[products[i]] = prices[i];
      }
    }

    public double getBill(int[] product, int[] amount) {
      double sum = 0;
      for (int i = 0; i < product.length; i++) {
        sum += prices[product[i]] * amount[i];
      }
      if (++cn == n) {
        sum -= sum / 100 * discount;
        cn = 0;
      }
      return sum;
    }
  }


}
