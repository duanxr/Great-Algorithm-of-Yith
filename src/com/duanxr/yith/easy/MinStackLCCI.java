package com.duanxr.yith.easy;

import java.util.Stack;

/**
 * @author 段然 2021/3/16
 */
public class MinStackLCCI {

  /**
   * How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.
   *
   * Example:
   *
   * MinStack minStack = new MinStack();
   * minStack.push(-2);
   * minStack.push(0);
   * minStack.push(-3);
   * minStack.getMin();   --> return -3.
   * minStack.pop();
   * minStack.top();      --> return 0.
   * minStack.getMin();   --> return -2.
   *
   * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
   *
   *
   * 示例：
   *
   * MinStack minStack = new MinStack();
   * minStack.push(-2);
   * minStack.push(0);
   * minStack.push(-3);
   * minStack.getMin();   --> 返回 -3.
   * minStack.pop();
   * minStack.top();      --> 返回 0.
   * minStack.getMin();   --> 返回 -2.
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
        int n = stack.pop();
        if (n == min.peek()) {
          min.pop();
        }
      }
    }

    public int top() {
      return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
      return min.isEmpty() ? -1 : min.peek();
    }
  }
}
