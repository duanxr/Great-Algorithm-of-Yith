package com.duanxr.yith.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 段然 2021/3/8
 */
public class FizzBuzz {

  /**
   * Write a program that outputs the string representation of numbers from 1 to n.
   *
   * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
   *
   * Example:
   *
   * n = 15,
   *
   * Return:
   * [
   *     "1",
   *     "2",
   *     "Fizz",
   *     "4",
   *     "Buzz",
   *     "Fizz",
   *     "7",
   *     "8",
   *     "Fizz",
   *     "Buzz",
   *     "11",
   *     "Fizz",
   *     "13",
   *     "14",
   *     "FizzBuzz"
   * ]
   *
   * 写一个程序，输出从 1 到 n 数字的字符串表示。
   *
   * 1. 如果 n 是3的倍数，输出“Fizz”；
   *
   * 2. 如果 n 是5的倍数，输出“Buzz”；
   *
   * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
   *
   * 示例：
   *
   * n = 15,
   *
   * 返回:
   * [
   *     "1",
   *     "2",
   *     "Fizz",
   *     "4",
   *     "Buzz",
   *     "Fizz",
   *     "7",
   *     "8",
   *     "Fizz",
   *     "Buzz",
   *     "11",
   *     "Fizz",
   *     "13",
   *     "14",
   *     "FizzBuzz"
   * ]
   *
   */
  class Solution {

    public List<String> fizzBuzz(int n) {
      List<String> result = new LinkedList<>();
      for (int i = 1; i <= n; i++) {
        int n3 = i % 3;
        int n5 = i % 5;
        if (n3 + n5 == 0) {
          result.add("FizzBuzz");
        } else if (n3 == 0) {
          result.add("Fizz");
        } else if (n5 == 0) {
          result.add("Buzz");

        } else {
          result.add(String.valueOf(i));
        }
      }
      return result;
    }
  }
}
