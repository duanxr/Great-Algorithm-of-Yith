package com.duanxr.yith.easy;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/3/8
 */
public class RemoveLinkedListElements {

  /**
   * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: head = [1,2,6,3,4,5,6], val = 6
   * Output: [1,2,3,4,5]
   * Example 2:
   *
   * Input: head = [], val = 1
   * Output: []
   * Example 3:
   *
   * Input: head = [7,7,7,7], val = 7
   * Output: []
   *  
   *
   * Constraints:
   *
   * The number of nodes in the list is in the range [0, 104].
   * 1 <= Node.val <= 50
   * 0 <= k <= 50
   *
   * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
   *  
   *
   * 示例 1：
   *
   *
   * 输入：head = [1,2,6,3,4,5,6], val = 6
   * 输出：[1,2,3,4,5]
   * 示例 2：
   *
   * 输入：head = [], val = 1
   * 输出：[]
   * 示例 3：
   *
   * 输入：head = [7,7,7,7], val = 7
   * 输出：[]
   *  
   *
   * 提示：
   *
   * 列表中的节点在范围 [0, 104] 内
   * 1 <= Node.val <= 50
   * 0 <= k <= 50
   */
  class Solution {

    public ListNode removeElements(ListNode head, int val) {
      if (head == null) {
        return head;
      }
      if (head.val == val) {
        return removeElements(head.next, val);
      } else {
        head.next = removeElements(head.next, val);
        return head;
      }
    }
  }
}
