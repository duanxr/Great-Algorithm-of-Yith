package com.duanxr.yith.midium;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/3/16
 */
public class SumListsLCCI {

  /**
   * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
   *
   *  
   *
   * Example:
   *
   * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
   * Output: 2 -> 1 -> 9. That is, 912.
   * Follow Up: Suppose the digits are stored in forward order. Repeat the above problem.
   *
   * Example:
   *
   * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
   * Output: 9 -> 1 -> 2. That is, 912.
   *
   * 给定两个用链表表示的整数，每个节点包含一个数位。
   *
   * 这些数位是反向存放的，也就是个位排在链表首部。
   *
   * 编写函数对这两个整数求和，并用链表形式返回结果。
   *
   *  
   *
   * 示例：
   *
   * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
   * 输出：2 -> 1 -> 9，即912
   * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
   *
   * 示例：
   *
   * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
   * 输出：9 -> 1 -> 2，即912
   *
   */
  class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int up = 0;
      ListNode head = null;
      ListNode current = null;

      while (l1 != null || l2 != null || up != 0) {
        int n1 = l1 == null ? 0 : l1.val;
        int n2 = l2 == null ? 0 : l2.val;

        int n = n1 + n2 + up;
        up = n / 10;
        n = n % 10;

        if (head == null) {
          head = new ListNode(n);
          current = head;
        } else {
          ListNode node = new ListNode(n);
          current.next = node;
          current = node;
        }

        if (l1 != null) {
          l1 = l1.next;
        }
        if (l2 != null) {
          l2 = l2.next;
        }
      }
      return head;
    }
  }
}
