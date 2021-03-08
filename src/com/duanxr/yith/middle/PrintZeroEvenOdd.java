package com.duanxr.yith.middle;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.IntConsumer;

/**
 * @author Duanran 4/21/2020
 */
public class PrintZeroEvenOdd {

  /**
   * Suppose you are given the following code:
   *
   * class ZeroEvenOdd {
   *   public ZeroEvenOdd(int n) { ... }      // constructor
   *   public void zero(printNumber) { ... }  // only output 0's
   *   public void even(printNumber) { ... }  // only output even numbers
   *   public void odd(printNumber) { ... }   // only output odd numbers
   * }
   * The same instance of ZeroEvenOdd will be passed to three different threads:
   *
   * Thread A will call zero() which should only output 0's.
   * Thread B will call even() which should only ouput even numbers.
   * Thread C will call odd() which should only output odd numbers.
   * Each of the threads is given a printNumber method to output an integer. Modify the given program to output the series 010203040506... where the length of the series must be 2n.
   *
   * Example 1:
   *
   * Input: n = 2
   * Output: "0102"
   * Explanation: There are three threads being fired asynchronously. One of them calls zero(), the other calls even(), and the last one calls odd(). "0102" is the correct output.
   * Example 2:
   *
   * Input: n = 5
   * Output: "0102030405"
   *
   * 假设有这么一个类：
   *
   * class ZeroEvenOdd {
   *   public ZeroEvenOdd(int n) { ... }      // 构造函数
   *   public void zero(printNumber) { ... }  // 仅打印出 0
   *   public void even(printNumber) { ... }  // 仅打印出 偶数
   *   public void odd(printNumber) { ... }   // 仅打印出 奇数
   * }
   * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
   *
   * 线程 A 将调用 zero()，它只输出 0 。
   * 线程 B 将调用 even()，它只输出偶数。
   * 线程 C 将调用 odd()，它只输出奇数。
   * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
   *
   * 示例 1：
   *
   * 输入：n = 2
   * 输出："0102"
   * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
   * 示例 2：
   *
   * 输入：n = 5
   * 输出："0102030405"
   */
  class ZeroEvenOdd {

    private int n;
    private BlockingQueue<Integer> zeroQ;
    private BlockingQueue<Integer> oddQ;
    private BlockingQueue<Integer> evenQ;

    public ZeroEvenOdd(int n) {
      this.n = n;
      this.zeroQ = new ArrayBlockingQueue<>(1);
      this.oddQ = new ArrayBlockingQueue<>(1);
      this.evenQ = new ArrayBlockingQueue<>(1);
      this.zeroQ.add(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
      Integer take = zeroQ.take();
      while (take < n) {
        printNumber.accept(0);
        if (take % 2 == 0) {
          oddQ.put(take + 1);
        } else {
          evenQ.put(take + 1);
        }
        take = zeroQ.take();
      }
      releaseAllThread();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
      Integer take = evenQ.take();
      while (take <= n) {
        printNumber.accept(take);
        zeroQ.put(take);
        take = evenQ.take();
      }
      releaseAllThread();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
      Integer take = oddQ.take();
      while (take <= n) {
        printNumber.accept(take);
        zeroQ.put(take);
        take = oddQ.take();
      }
      releaseAllThread();
    }

    private void releaseAllThread() {
      zeroQ.offer(Integer.MAX_VALUE);
      evenQ.offer(Integer.MAX_VALUE);
      oddQ.offer(Integer.MAX_VALUE);
    }
  }

}
