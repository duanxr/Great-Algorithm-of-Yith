package com.duanxr.yith.midium;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/5/26
 */
public class PartitionList {

  /**
   * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
   *
   * You should preserve the original relative order of the nodes in each of the two partitions.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: head = [1,4,3,2,5,2], x = 3
   * Output: [1,2,2,4,3,5]
   * Example 2:
   *
   * Input: head = [2,1], x = 2
   * Output: [1,2]
   *  
   *
   * Constraints:
   *
   * The number of nodes in the list is in the range [0, 200].
   * -100 <= Node.val <= 100
   * -200 <= x <= 200
   *
   * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
   *
   * 你应当 保留 两个分区中每个节点的初始相对位置。
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：head = [1,4,3,2,5,2], x = 3
   * 输出：[1,2,2,4,3,5]
   * 示例 2：
   *
   * 输入：head = [2,1], x = 2
   * 输出：[1,2]
   *  
   *
   * 提示：
   *
   * 链表中节点的数目在范围 [0, 200] 内
   * -100 <= Node.val <= 100
   * -200 <= x <= 200
   *
   */
  class Solution {

    public ListNode partition(ListNode head, int x) {
      ListNode current = head;
      ListNode sh = null;
      ListNode bh = null;
      ListNode st = null;
      ListNode bt = null;
      while (current != null) {
        if (current.val < x) {
          if (sh == null) {
            sh = current;
            st = current;
          } else {
            st.next = current;
            st = current;
          }
        } else {
          if (bh == null) {
            bh = current;
            bt = current;
          } else {
            bt.next = current;
            bt = current;
          }
        }
        current = current.next;
      }
      if (st != null) {
        st.next = bh;
      }
      if (bt != null) {
        bt.next = null;
      }
      return sh == null ? bh : sh;
    }
  }
}
