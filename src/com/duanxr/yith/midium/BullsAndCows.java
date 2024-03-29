package com.duanxr.yith.midium;

/**
 * @author 段然 2021/11/11
 */
public class BullsAndCows {

  /**
   * You are playing the Bulls and Cows game with your friend.
   *
   * You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:
   *
   * The number of "bulls", which are digits in the guess that are in the correct position.
   * The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
   * Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.
   *
   * The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
   *
   *  
   *
   * Example 1:
   *
   * Input: secret = "1807", guess = "7810"
   * Output: "1A3B"
   * Explanation: Bulls are connected with a '|' and cows are underlined:
   * "1807"
   *   |
   * "7810"
   * Example 2:
   *
   * Input: secret = "1123", guess = "0111"
   * Output: "1A1B"
   * Explanation: Bulls are connected with a '|' and cows are underlined:
   * "1123"        "1123"
   *   |      or     |
   * "0111"        "0111"
   * Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
   * Example 3:
   *
   * Input: secret = "1", guess = "0"
   * Output: "0A0B"
   * Example 4:
   *
   * Input: secret = "1", guess = "1"
   * Output: "1A0B"
   *  
   *
   * Constraints:
   *
   * 1 <= secret.length, guess.length <= 1000
   * secret.length == guess.length
   * secret and guess consist of digits only.
   *
   * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
   *
   * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
   *
   * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
   * 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
   * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
   *
   * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
   *
   * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
   *
   *  
   *
   * 示例 1:
   *
   * 输入: secret = "1807", guess = "7810"
   * 输出: "1A3B"
   * 解释: 数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
   * "1807"
   *   |
   * "7810"
   * 示例 2:
   *
   * 输入: secret = "1123", guess = "0111"
   * 输出: "1A1B"
   * 解释: 数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
   * "1123"        "1123"
   *   |      or     |
   * "0111"        "0111"
   * 注意，两个不匹配的 1 中，只有一个会算作奶牛（数字猜对位置不对）。通过重新排列非公牛数字，其中仅有一个 1 可以成为公牛数字。
   * 示例 3：
   *
   * 输入：secret = "1", guess = "0"
   * 输出："0A0B"
   * 示例 4：
   *
   * 输入：secret = "1", guess = "1"
   * 输出："1A0B"
   *  
   *
   * 提示：
   *
   * 1 <= secret.length, guess.length <= 1000
   * secret.length == guess.length
   * secret 和 guess 仅由数字组成
   *
   */
  class Solution {

    public String getHint(String secret, String guess) {
      int[] nums1 = new int[10];
      int[] nums2 = new int[10];
      int bull = 0;
      int cow = 0;
      int length = secret.length();
      for (int i = 0; i < length; i++) {
        char c1 = secret.charAt(i);
        char c2 = guess.charAt(i);
        if (c1 == c2) {
          bull++;
        } else {
          nums1[c1 - '0']++;
          nums2[c2 - '0']++;
        }
      }
      for (int i = 0; i < 10; i++) {
        cow += Math.min(nums1[i], nums2[i]);
      }
      return bull + "A" + cow + "B";
    }
  }
}
