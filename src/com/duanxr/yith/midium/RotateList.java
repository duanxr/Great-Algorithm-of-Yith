package com.duanxr.yith.midium;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/4/2
 */
public class RotateList {

  /**
   * Given the head of a linked list, rotate the list to the right by k places.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: head = [1,2,3,4,5], k = 2
   * Output: [4,5,1,2,3]
   * Example 2:
   *
   *
   * Input: head = [0,1,2], k = 4
   * Output: [2,0,1]
   *  
   *
   * Constraints:
   *
   * The number of nodes in the list is in the range [0, 500].
   * -100 <= Node.val <= 100
   * 0 <= k <= 2 * 109
   *
   * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：head = [1,2,3,4,5], k = 2
   * 输出：[4,5,1,2,3]
   * 示例 2：
   *
   *
   * 输入：head = [0,1,2], k = 4
   * 输出：[2,0,1]
   *  
   *
   * 提示：
   *
   * 链表中节点的数目在范围 [0, 500] 内
   * -100 <= Node.val <= 100
   * 0 <= k <= 2 * 109
   *
   */
  class Solution {

    public ListNode rotateRight(ListNode head, int k) {
      if (head == null || head.next == null) {
        return head;
      }
      int n = 0;
      ListNode current = head;
      while (current != null) {
        current = current.next;
        n++;
      }
      k %= n;
      if (k == 0) {
        return head;
      }
      current = head;
      ListNode oldTail = null;
      ListNode newHead = null;
      ListNode newTail = null;
      for (int i = 0; i < n; i++) {
        if (i == n - k - 1) {
          newTail = current;
        }
        if (i == n - k) {
          newHead = current;
        }
        if (i == n - 1) {
          oldTail = current;
        }
        current = current.next;
      }
      oldTail.next = head;
      newTail.next = null;
      return newHead;
    }
  }
}
