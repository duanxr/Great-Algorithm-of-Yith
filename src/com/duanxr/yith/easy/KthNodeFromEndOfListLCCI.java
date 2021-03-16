package com.duanxr.yith.easy;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/3/16
 */
public class KthNodeFromEndOfListLCCI {

  /**
   * Implement an algorithm to find the kth to last element of a singly linked list. Return the value of the element.
   *
   * Note: This problem is slightly different from the original one in the book.
   *
   * Example:
   *
   * Input:  1->2->3->4->5 和 k = 2
   * Output:  4
   * Note:
   *
   * k is always valid.
   *
   * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
   *
   * 注意：本题相对原题稍作改动
   *
   * 示例：
   *
   * 输入： 1->2->3->4->5 和 k = 2
   * 输出： 4
   * 说明：
   *
   * 给定的 k 保证是有效的。
   *
   */
  class Solution {

    public int kthToLast(ListNode head, int k) {
      ListNode first = head;
      ListNode second = head;
      while (first != null) {
        if (k == 0) {
          second = second.next;
        } else {
          k--;
        }
        first = first.next;
      }
      return second.val;
    }
  }
}
