package com.duanxr.yith.midium;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Duanran 4/21/2020
 */
public class PrintFooBarAlternately {

  /**
   * Suppose you are given the following code:
   *
   * class FooBar {
   *   public void foo() {
   *     for (int i = 0; i < n; i++) {
   *       print("foo");
   *     }
   *   }
   *
   *   public void bar() {
   *     for (int i = 0; i < n; i++) {
   *       print("bar");
   *     }
   *   }
   * }
   * The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.
   *
   * Example 1:
   *
   * Input: n = 1
   * Output: "foobar"
   * Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
   * Example 2:
   *
   * Input: n = 2
   * Output: "foobarfoobar"
   * Explanation: "foobar" is being output 2 times.
   *
   * 我们提供一个类：
   *
   * class FooBar {
   *   public void foo() {
   *     for (int i = 0; i < n; i++) {
   *       print("foo");
   *     }
   *   }
   *
   *   public void bar() {
   *     for (int i = 0; i < n; i++) {
   *       print("bar");
   *     }
   *   }
   * }
   * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
   *
   * 请设计修改程序，以确保 "foobar" 被输出 n 次。
   *
   * 示例 1:
   *
   * 输入: n = 1
   * 输出: "foobar"
   * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
   * 示例 2:
   *
   * 输入: n = 2
   * 输出: "foobarfoobar"
   * 解释: "foobar" 将被输出两次。
   *
   */
  class FooBar {

    private int n;
    private BlockingQueue<Integer> blockingQueue;

    public FooBar(int n) {
      this.n = n;
      this.blockingQueue = new ArrayBlockingQueue<>(1);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

      for (int i = 0; i < n; i++) {
        blockingQueue.put(i);
        // printFoo.run() outputs "foo". Do not change or remove this line.
        printFoo.run();
        blockingQueue.put(i);
      }
    }

    public void bar(Runnable printBar) throws InterruptedException {

      for (int i = 0; i < n; i++) {
        blockingQueue.take();
        // printBar.run() outputs "bar". Do not change or remove this line.
        printBar.run();
        blockingQueue.take();
      }
    }
  }
}
