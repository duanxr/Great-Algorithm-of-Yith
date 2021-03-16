package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/3/16
 */
public class StackOfPlatesLCCI {

  /**
   * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there were just a single stack). Follow Up: Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
   *
   * You should delete the sub-stack when it becomes empty. pop, popAt should return -1 when there's no element to pop.
   *
   * Example1:
   *
   *  Input:
   * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
   * [[1], [1], [2], [1], [], []]
   *  Output:
   * [null, null, null, 2, 1, -1]
   *  Explanation:
   * Example2:
   *
   *  Input:
   * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
   * [[2], [1], [2], [3], [0], [0], [0]]
   *  Output:
   * [null, null, null, null, 2, 1, 3]
   *
   * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
   *
   * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
   *
   * 示例1:
   *
   *  输入：
   * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
   * [[1], [1], [2], [1], [], []]
   *  输出：
   * [null, null, null, 2, 1, -1]
   * 示例2:
   *
   *  输入：
   * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
   * [[2], [1], [2], [3], [0], [0], [0]]
   *  输出：
   * [null, null, null, null, 2, 1, 3]
   *
   */
  class StackOfPlates {

    int cap;
    List<int[]> valList;
    List<Integer> indexList;

    public StackOfPlates(int cap) {
      this.cap = cap;
      valList = new ArrayList<>(cap);
      indexList = new ArrayList<>(cap);
    }

    public void push(int val) {
      if (cap == 0) {
        return;
      }
      if (valList.size() == 0) {
        int[] vals = new int[cap];
        vals[0] = val;
        valList.add(vals);
        indexList.add(1);
      } else {
        int si = valList.size() - 1;
        int vi = indexList.get(si);
        if (vi == cap) {
          int[] vals = new int[cap];
          vals[0] = val;
          valList.add(vals);
          indexList.add(1);
        } else {
          valList.get(si)[vi++] = val;
          indexList.set(si, vi);
        }
      }
    }

    public int pop() {
      return popAt(valList.size() - 1);
    }

    public int popAt(int index) {
      if (cap == 0) {
        return -1;
      }
      if (index >= valList.size() || index < 0) {
        return -1;
      }
      int[] vals = valList.get(index);
      int vi = indexList.get(index);
      int n = vals[--vi];
      indexList.set(index, vi);
      if (vi == 0) {
        valList.remove(index);
        indexList.remove(index);
      }
      return n;
    }
  }
}
