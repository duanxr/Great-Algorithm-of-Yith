package com.duanxr.yith.midium;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/3/16
 */
public class PartitionListLCCI {

  /**
   * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after the elements less than x (see below). The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.
   *
   * Example:
   *
   * Input: head = 3->5->8->5->10->2->1, x = 5
   * Output: 3->1->2->10->5->5->8
   *
   * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
   *
   * 示例:
   *
   * 输入: head = 3->5->8->5->10->2->1, x = 5
   * 输出: 3->1->2->10->5->5->8
   *
   */
  class Solution {

    public ListNode partition(ListNode head, int x) {
      if (head == null) {
        return null;
      }
      ListNode sHead = null;
      ListNode bHead = null;
      ListNode sTail = null;
      ListNode bTail = null;
      ListNode current = head;
      while (current != null) {
        if (current.val < x) {
          if (sHead == null) {
            sHead = current;
            sTail = sHead;
          } else {
            sTail.next = current;
            sTail = current;
          }
        } else {
          if (bHead == null) {
            bHead = current;
            bTail = bHead;
          } else {
            bTail.next = current;
            bTail = current;
          }
        }
        current = current.next;
      }
      if (bTail != null) {
        bTail.next = null;
      }
      if (sTail != null) {
        sTail.next = bHead;
      }
      return sHead == null ? bHead : sHead;
    }
  }
}
