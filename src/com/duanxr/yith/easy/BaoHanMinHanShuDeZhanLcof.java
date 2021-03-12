package com.duanxr.yith.easy;

import java.util.Stack;

/**
 * @author 段然 2021/3/12
 */
public class BaoHanMinHanShuDeZhanLcof {

  /**
   * English description is not available for the problem.
   *
   * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
   *
   *  
   *
   * 示例:
   *
   * MinStack minStack = new MinStack();
   * minStack.push(-2);
   * minStack.push(0);
   * minStack.push(-3);
   * minStack.min();   --> 返回 -3.
   * minStack.pop();
   * minStack.top();      --> 返回 0.
   * minStack.min();   --> 返回 -2.
   *  
   *
   * 提示：
   *
   * 各函数的调用总次数不超过 20000 次
   *  
   *
   * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
   *
   */
  class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
      stack.push(x);
      if (min.isEmpty() || x <= min.peek()) {
        min.push(x);
      }
    }

    public void pop() {
      if (!stack.isEmpty()) {
        Integer pop = stack.pop();
        if (pop <= min.peek()) {
          min.pop();
        }
      }
    }

    public int top() {
      if (!stack.isEmpty()) {
        return stack.peek();
      }
      return -1;
    }

    public int min() {
      if (!min.isEmpty()) {
        return min.peek();
      }
      return -1;
    }
  }

}
