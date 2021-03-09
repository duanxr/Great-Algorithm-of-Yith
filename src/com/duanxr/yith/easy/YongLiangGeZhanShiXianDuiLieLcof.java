package com.duanxr.yith.easy;

import java.util.Stack;

/**
 * @author 段然 2021/3/8
 */
public class YongLiangGeZhanShiXianDuiLieLcof {

  /**
   * English description is not available for the problem.
   *
   * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
   *
   *  
   *
   * 示例 1：
   *
   * 输入：
   * ["CQueue","appendTail","deleteHead","deleteHead"]
   * [[],[3],[],[]]
   * 输出：[null,null,3,-1]
   * 示例 2：
   *
   * 输入：
   * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
   * [[],[],[5],[2],[],[]]
   * 输出：[null,-1,null,null,5,2]
   * 提示：
   *
   * 1 <= values <= 10000
   * 最多会对 appendTail、deleteHead 进行 10000 次调用
   *
   */
  class CQueue {

    private Stack<Integer> ls;
    private Stack<Integer> rs;
    //private boolean onRight = false;

    public CQueue() {
      ls = new Stack<>();
      rs = new Stack<>();
    }

    public void appendTail(int value) {
      ls.push(value);
    }

    public int deleteHead() {
      if (rs.isEmpty()) {
        stackMove(ls, rs);
      }
      return rs.isEmpty() ? -1 : rs.pop();
    }

   /* public void appendTail(int value) {
      if (onRight) {
        stackMove(rs, ls);
        onRight = false;
      }
      ls.push(value);
    }

    public int deleteHead() {
      if (!onRight) {
        stackMove(ls, rs);
        onRight = true;
      }
      return rs.isEmpty() ? -1 : rs.pop();
    }*/

    private void stackMove(Stack<Integer> origin, Stack<Integer> target) {
      while (!origin.isEmpty()) {
        target.push(origin.pop());
      }
    }
  }

}
