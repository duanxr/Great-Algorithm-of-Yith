package com.duanxr.yith.easy;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/3/8
 */
public class RemoveDuplicatesFromSortedList {

  /**
   * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: head = [1,1,2]
   * Output: [1,2]
   * Example 2:
   *
   *
   * Input: head = [1,1,2,3,3]
   * Output: [1,2,3]
   *  
   *
   * Constraints:
   *
   * The number of nodes in the list is in the range [0, 300].
   * -100 <= Node.val <= 100
   * The list is guaranteed to be sorted in ascending order.
   *
   * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
   *
   * 示例 1:
   *
   * 输入: 1->1->2
   * 输出: 1->2
   * 示例 2:
   *
   * 输入: 1->1->2->3->3
   * 输出: 1->2->3
   *
   */
  class Solution {

    public ListNode deleteDuplicates(ListNode head) {
      if (head != null) {
        if (head.next != null && head.val == head.next.val) {
          head.next = head.next.next;
          deleteDuplicates(head);
        } else {
          deleteDuplicates(head.next);
        }

      }
      return head;
    }
  }
}
