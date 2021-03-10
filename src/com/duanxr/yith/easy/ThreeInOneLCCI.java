package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/10
 */
public class ThreeInOneLCCI {

  /**
   * Describe how you could use a single array to implement three stacks.
   *
   * You should implement push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum) methods. stackNum is the index of the stack. value is the value that pushed to the stack.
   *
   * The constructor requires a stackSize parameter, which represents the size of each stack.
   *
   * Example1:
   *
   *  Input:
   * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
   * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
   *  Output:
   * [null, null, null, 1, -1, -1, true]
   * Explanation: When the stack is empty, `pop, peek` return -1. When the stack is full, `push` does nothing.
   * Example2:
   *
   *  Input:
   * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
   * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
   *  Output:
   * [null, null, null, null, 2, 1, -1, -1]
   *
   * 三合一。描述如何只用一个数组来实现三个栈。
   *
   * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
   *
   * 构造函数会传入一个stackSize参数，代表每个栈的大小。
   *
   * 示例1:
   *
   *  输入：
   * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
   * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
   *  输出：
   * [null, null, null, 1, -1, -1, true]
   * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
   * 示例2:
   *
   *  输入：
   * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
   * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
   *  输出：
   * [null, null, null, null, 2, 1, -1, -1]
   *
   */
  class TripleInOne {

    private int N = 3;
    int[] value;
    int[][] point;
    int stackSize;

    public TripleInOne(int stackSize) {
      this.stackSize = stackSize;
      value = new int[stackSize * N];
      point = new int[N][3];
      for (int i = 0; i < point.length; i++) {
        point[i][0] = stackSize * i;
        point[i][1] = stackSize * i;
        point[i][2] = stackSize * i + stackSize;
      }
    }


    public void push(int stackNum, int value) {
      if (point[stackNum][0] == point[stackNum][2]) {
        return;
      }
      this.value[point[stackNum][0]++] = value;
    }

    public int pop(int stackNum) {
      if (isEmpty(stackNum)) {
        return -1;
      }
      return value[--point[stackNum][0]];
    }

    public int peek(int stackNum) {
      if (isEmpty(stackNum)) {
        return -1;
      }
      return value[point[stackNum][0] - 1];
    }

    public boolean isEmpty(int stackNum) {
      return point[stackNum][0] == point[stackNum][1];
    }
  }

}
