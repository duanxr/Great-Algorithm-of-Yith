package com.duanxr.yith.easy;

import java.util.LinkedList;

/**
 * @author 段然 2021/3/8
 */
public class MinStack {

  /**
   * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
   *
   * push(x) -- Push element x onto stack.
   * pop() -- Removes the element on top of the stack.
   * top() -- Get the top element.
   * getMin() -- Retrieve the minimum element in the stack.
   *  
   *
   * Example 1:
   *
   * Input
   * ["MinStack","push","push","push","getMin","pop","top","getMin"]
   * [[],[-2],[0],[-3],[],[],[],[]]
   *
   * Output
   * [null,null,null,null,-3,null,0,-2]
   *
   * Explanation
   * MinStack minStack = new MinStack();
   * minStack.push(-2);
   * minStack.push(0);
   * minStack.push(-3);
   * minStack.getMin(); // return -3
   * minStack.pop();
   * minStack.top();    // return 0
   * minStack.getMin(); // return -2
   *  
   *
   * Constraints:
   *
   * Methods pop, top and getMin operations will always be called on non-empty stacks.
   *
   * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
   *
   * push(x) —— 将元素 x 推入栈中。
   * pop() —— 删除栈顶的元素。
   * top() —— 获取栈顶元素。
   * getMin() —— 检索栈中的最小元素。
   *  
   *
   * 示例:
   *
   * 输入：
   * ["MinStack","push","push","push","getMin","pop","top","getMin"]
   * [[],[-2],[0],[-3],[],[],[],[]]
   *
   * 输出：
   * [null,null,null,null,-3,null,0,-2]
   *
   * 解释：
   * MinStack minStack = new MinStack();
   * minStack.push(-2);
   * minStack.push(0);
   * minStack.push(-3);
   * minStack.getMin();   --> 返回 -3.
   * minStack.pop();
   * minStack.top();      --> 返回 0.
   * minStack.getMin();   --> 返回 -2.
   *  
   *
   * 提示：
   *
   * pop、top 和 getMin 操作总是在 非空栈 上调用。
   *
   */
  class Solution {


    LinkedList<Integer> stack = new LinkedList<>();

    LinkedList<Integer> minStack = new LinkedList<>();

    public Solution() {

    }

    public void push(int x) {
      stack.push(x);
      if (minStack.isEmpty() || x <= minStack.peek()) {
        minStack.push(x);
      }
    }

    public void pop() {
      int x = stack.pop();
      if (!minStack.isEmpty() && x == minStack.peek()) {
        minStack.pop();
      }
    }

    public int top() {
      return stack.peek();
    }

    public int getMin() {
      return minStack.isEmpty() ? 0 : minStack.peek();
    }
  }
}
