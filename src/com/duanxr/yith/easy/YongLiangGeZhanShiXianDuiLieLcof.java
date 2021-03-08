package com.duanxr.yith.easy;

import java.util.Stack;

/**
 * @author 段然 2021/3/8
 */
public class YongLiangGeZhanShiXianDuiLieLcof {

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
