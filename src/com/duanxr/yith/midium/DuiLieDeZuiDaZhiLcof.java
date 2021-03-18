package com.duanxr.yith.midium;

import java.util.LinkedList;

/**
 * @author 段然 2021/3/17
 */
public class DuiLieDeZuiDaZhiLcof {

  /**
   * English description is not available for the problem.
   *
   * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
   *
   * 若队列为空，pop_front 和 max_value 需要返回 -1
   *
   * 示例 1：
   *
   * 输入:
   * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
   * [[],[1],[2],[],[],[]]
   * 输出: [null,null,null,2,1,2]
   * 示例 2：
   *
   * 输入:
   * ["MaxQueue","pop_front","max_value"]
   * [[],[],[]]
   * 输出: [null,-1,-1]
   *  
   *
   * 限制：
   *
   * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
   * 1 <= value <= 10^5
   *
   */
  class MaxQueue {

    LinkedList<Integer> value;
    LinkedList<Integer> max;

    public MaxQueue() {
      value = new LinkedList<>();
      max = new LinkedList<>();
    }

    public int max_value() {
      return max.isEmpty() ? -1 : max.getFirst();
    }

    public void push_back(int val) {
      value.addLast(val);
      while (!max.isEmpty() && max.getLast() < val) {
        max.removeLast();
      }
      max.addLast(val);
    }

    public int pop_front() {
      if (value.isEmpty()) {
        return -1;
      }
      int pop = value.removeFirst();
      if (pop == max.getFirst()) {
        max.removeFirst();
      }
      return pop;
    }
  }

}
