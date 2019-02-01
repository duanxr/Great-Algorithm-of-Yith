package com.duanxr.leetcode.easy;

import com.duanxr.leetcode.define.listNode.ListNode;
import java.util.LinkedList;

/**
 * @author Duanran 2019/1/30 0030
 */
public class PalindromeLinkedList {

  /**
   * Given a singly linked list, determine if it is a palindrome.
   *
   * Example 1:
   *
   * Input: 1->2
   *
   * Output: false
   *
   * Example 2:
   *
   * Input: 1->2->2->1
   *
   * Output: true
   *
   * Follow up:
   *
   * Could you do it in O(n) time and O(1) space?
   *
   * 请判断一个链表是否为回文链表。
   *
   * 示例 1:
   *
   * 输入: 1->2
   *
   * 输出: false
   *
   * 示例 2:
   *
   * 输入: 1->2->2->1
   *
   * 输出: true
   *
   * 进阶：
   *
   * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
   */
  class Solution {

    public boolean isPalindrome(ListNode head) {
      if (head == null || head.next == null) {
        return true;
      }
      LinkedList<Integer> stack = new LinkedList<>();
      ListNode slow = head;
      ListNode fast = head;
      while (fast != null) {
        stack.push(slow.val);
        slow = slow.next;
        fast = fast.next;
        if (fast == null) {
          stack.pop();
          break;
        }
        fast = fast.next;
      }
      while (!stack.isEmpty() && slow != null) {
        if (stack.pop() != slow.val) {
          return false;
        }
        slow = slow.next;
      }
      return stack.isEmpty() && slow == null;
    }
  }
}
