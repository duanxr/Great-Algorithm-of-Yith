package com.duanxr.yith.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 段然 2021/7/5
 */
public class LoggerRateLimiter {

  /**
   * Design a logger system that receives a stream of messages along with their timestamps. Each unique message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).
   *
   * All messages will come in chronological order. Several messages may arrive at the same timestamp.
   *
   * Implement the Logger class:
   *
   * Logger() Initializes the logger object.
   * bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given timestamp, otherwise returns false.
   *  
   *
   * Example 1:
   *
   * Input
   * ["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
   * [[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
   * Output
   * [null, true, true, false, false, false, true]
   *
   * Explanation
   * Logger logger = new Logger();
   * logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
   * logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
   * logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
   * logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
   * logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
   * logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is
   *                                       // 11 + 10 = 21
   *  
   *
   * Constraints:
   *
   * 0 <= timestamp <= 109
   * Every timestamp will be passed in non-decreasing order (chronological order).
   * 1 <= message.length <= 30
   * At most 104 calls will be made to shouldPrintMessage.
   *
   * 请你设计一个日志系统，可以流式接收消息以及它的时间戳。每条 不重复 的消息最多只能每 10 秒打印一次。也就是说，如果在时间戳 t 打印某条消息，那么相同内容的消息直到时间戳变为 t + 10 之前都不会被打印。
   *
   * 所有消息都按时间顺序发送。多条消息可能到达同一时间戳。
   *
   * 实现 Logger 类：
   *
   * Logger() 初始化 logger 对象
   * bool shouldPrintMessage(int timestamp, string message) 如果这条消息 message 在给定的时间戳 timestamp 应该被打印出来，则返回 true ，否则请返回 false 。
   *  
   *
   * 示例：
   *
   * 输入：
   * ["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
   * [[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
   * 输出：
   * [null, true, true, false, false, false, true]
   *
   * 解释：
   * Logger logger = new Logger();
   * logger.shouldPrintMessage(1, "foo");  // 返回 true ，下一次 "foo" 可以打印的时间戳是 1 + 10 = 11
   * logger.shouldPrintMessage(2, "bar");  // 返回 true ，下一次 "bar" 可以打印的时间戳是 2 + 10 = 12
   * logger.shouldPrintMessage(3, "foo");  // 3 < 11 ，返回 false
   * logger.shouldPrintMessage(8, "bar");  // 8 < 12 ，返回 false
   * logger.shouldPrintMessage(10, "foo"); // 10 < 11 ，返回 false
   * logger.shouldPrintMessage(11, "foo"); // 11 >= 11 ，返回 true ，下一次 "foo" 可以打印的时间戳是 11 + 10 = 21
   *  
   *
   * 提示：
   *
   * 0 <= timestamp <= 109
   * 每个 timestamp 都将按非递减顺序（时间顺序）传递
   * 1 <= message.length <= 30
   * 最多调用 104 次 shouldPrintMessage 方法
   *
   */
  class Logger {

    private Map<String, Integer> map;

    public Logger() {
      map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
      final int nt = timestamp + 1;
      return map.compute(message, (k, v) -> {
        if (v == null) {
          return nt;
        }
        int nv = Math.abs(v);
        if (nt >= nv + 10) {
          return nt;
        }
        return -nv;
      }) > 0;
    }
  }


  class Logger1 {

    private Map<String, Integer> map;

    public Logger1() {
      map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

      return map.compute(message, (k, v) -> {
        if (v == null) {
          return timestamp + 1;
        }
        int nv = Math.abs(v);
        if (timestamp + 1 >= nv + 10) {
          return timestamp + 1;
        }
        return -nv;
      }) == timestamp + 1;
    }
  }

}
