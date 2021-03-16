package com.duanxr.yith.midium;

import java.util.Stack;

/**
 * @author 段然 2021/3/16
 */
public class SortOfStacksLCCI {

  /**
   * Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty. When the stack is empty, peek should return -1.
   *
   * Example1:
   *
   *  Input:
   * ["SortedStack", "push", "push", "peek", "pop", "peek"]
   * [[], [1], [2], [], [], []]
   *  Output:
   * [null,null,null,1,null,2]
   * Example2:
   *
   *  Input:
   * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
   * [[], [], [], [1], [], []]
   *  Output:
   * [null,null,null,null,null,true]
   * Note:
   *
   * The total number of elements in the stack is within the range [0, 5000].
   *
   * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
   *
   * 示例1:
   *
   *  输入：
   * ["SortedStack", "push", "push", "peek", "pop", "peek"]
   * [[], [1], [2], [], [], []]
   *  输出：
   * [null,null,null,1,null,2]
   * 示例2:
   *
   *  输入：
   * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
   * [[], [], [], [1], [], []]
   *  输出：
   * [null,null,null,null,null,true]
   * 说明:
   *
   * 栈中的元素数目在[0, 5000]范围内。
   *
   */
  class SortedStack {

    Stack<Integer> stackA;
    Stack<Integer> stackB;

    public SortedStack() {
      stackA = new Stack<>();
      stackB = new Stack<>();
    }

    public void push(int val) {
      if (stackA.isEmpty() || stackA.peek() >= val) {
        stackA.push(val);
      } else {
        sortedPush(val, true);
        Stack<Integer> temp = stackA;
        stackA = stackB;
        stackB = temp;
      }
    }

    private void sortedPush(int val, boolean needPush) {
      int n = stackA.pop();
      if (needPush && (stackA.isEmpty() || (stackA.peek() >= val && n < val))) {
        needPush = false;
        if (!stackA.isEmpty()) {
          sortedPush(val, needPush);
        }
        stackB.push(val);
      } else if (!stackA.isEmpty()) {
        sortedPush(val, needPush);
      }
      stackB.push(n);
    }

    public void pop() {
      if (!stackA.isEmpty()) {
        stackA.pop();
      }
    }

    public int peek() {
      if (stackA.isEmpty()) {
        return -1;
      }
      return stackA.peek();
    }

    public boolean isEmpty() {
      return stackA.isEmpty();
    }
  }
}
