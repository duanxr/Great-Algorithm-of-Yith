package com.duanxr.yith.easy;

import java.util.Stack;

/**
 * @author 段然 2021/3/16
 */
public class ImplementQueueUsingStacksLCCI {

  /**
   * Implement a MyQueue class which implements a queue using two stacks.
   *
   *  
   * Example:
   *
   * MyQueue queue = new MyQueue();
   *
   * queue.push(1);
   * queue.push(2);
   * queue.peek();  // return 1
   * queue.pop();   // return 1
   * queue.empty(); // return false
   *  
   *
   * Notes:
   *
   * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
   * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
   * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
   *  
   *
   * 实现一个MyQueue类，该类用两个栈来实现一个队列。
   *
   *
   * 示例：
   *
   * MyQueue queue = new MyQueue();
   *
   * queue.push(1);
   * queue.push(2);
   * queue.peek();  // 返回 1
   * queue.pop();   // 返回 1
   * queue.empty(); // 返回 false
   *
   * 说明：
   *
   * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
   * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
   * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
   *
   */
  class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public MyQueue() {
      pushStack = new Stack<>();
      popStack = new Stack<>();
    }

    public void push(int x) {
      pushStack.push(x);
    }

    public int pop() {
      if (empty()) {
        return -1;
      }else if (popStack.isEmpty()) {
        transfer();
      }
      return popStack.pop();
    }

    public int peek() {
      if (empty()) {
        return -1;
      } else if (popStack.isEmpty()) {
        transfer();
      }
      return popStack.peek();
    }

    public boolean empty() {
      return popStack.isEmpty() && pushStack.isEmpty();
    }

    private void transfer() {
      while (!pushStack.isEmpty()) {
        popStack.push(pushStack.pop());
      }
    }
  }
}
