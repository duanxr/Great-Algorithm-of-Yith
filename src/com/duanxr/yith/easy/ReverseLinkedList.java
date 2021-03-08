package com.duanxr.yith.easy;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/3/8
 */
public class ReverseLinkedList {

  /**
   * Given the head of a singly linked list, reverse the list, and return the reversed list.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: head = [1,2,3,4,5]
   * Output: [5,4,3,2,1]
   * Example 2:
   *
   *
   * Input: head = [1,2]
   * Output: [2,1]
   * Example 3:
   *
   * Input: head = []
   * Output: []
   *  
   *
   * Constraints:
   *
   * The number of nodes in the list is the range [0, 5000].
   * -5000 <= Node.val <= 5000
   *  
   *
   * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
   *
   * 反转一个单链表。
   *
   * 示例:
   *
   * 输入: 1->2->3->4->5->NULL
   * 输出: 5->4->3->2->1->NULL
   * 进阶:
   * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
   *
   */
  class Solution {

    public ListNode reverseList(ListNode head) {
      return reverse(head, null);
    }

    public ListNode reverse(ListNode head, ListNode next) {
      if (head == null) {
        return next;
      }
      ListNode node = new ListNode(head.val);
      node.next = next;
      return reverse(head.next, node);
    }
  }
}
