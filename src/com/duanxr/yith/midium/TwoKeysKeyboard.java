package com.duanxr.yith.midium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 段然 2021/9/23
 */
public class TwoKeysKeyboard {

  /**
   * There is only one character 'A' on the screen of a notepad. You can perform two operations on this notepad for each step:
   *
   * Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
   * Paste: You can paste the characters which are copied last time.
   * Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
   *
   *  
   *
   * Example 1:
   *
   * Input: n = 3
   * Output: 3
   * Explanation: Intitally, we have one character 'A'.
   * In step 1, we use Copy All operation.
   * In step 2, we use Paste operation to get 'AA'.
   * In step 3, we use Paste operation to get 'AAA'.
   * Example 2:
   *
   * Input: n = 1
   * Output: 0
   *  
   *
   * Constraints:
   *
   * 1 <= n <= 1000
   *
   * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
   *
   * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
   * Paste（粘贴）：粘贴 上一次 复制的字符。
   * 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：3
   * 输出：3
   * 解释：
   * 最初, 只有一个字符 'A'。
   * 第 1 步, 使用 Copy All 操作。
   * 第 2 步, 使用 Paste 操作来获得 'AA'。
   * 第 3 步, 使用 Paste 操作来获得 'AAA'。
   * 示例 2：
   *
   * 输入：n = 1
   * 输出：0
   *  
   *
   * 提示：
   *
   * 1 <= n <= 1000
   *
   */
  class Solution {

    private final int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
        53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149,
        151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241,
        251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353,
        359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461,
        463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587,
        593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691,
        701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823,
        827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947,
        953, 967, 971, 977, 983, 991, 997};

    public int minSteps(int n) {
      if (n == 1) {
        return 0;
      }
      Set<Integer> set = new HashSet<>();
      for (int prime : primes) {
        set.add(prime);
      }
      int steps = 0;
      while (!set.contains(n)) {
        for (int prime : primes) {
          if (n % prime == 0) {
            steps += prime;
            n /= prime;
            break;
          }
        }
      }
      return steps + n;
    }
  }
}
