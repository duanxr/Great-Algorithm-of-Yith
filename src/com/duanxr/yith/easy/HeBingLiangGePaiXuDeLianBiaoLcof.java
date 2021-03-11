package com.duanxr.yith.easy;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/3/11
 */
public class HeBingLiangGePaiXuDeLianBiaoLcof {

  /**
   * English description is not available for the problem.
   *
   * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
   *
   * 示例1：
   *
   * 输入：1->2->4, 1->3->4
   * 输出：1->1->2->3->4->4
   * 限制：
   *
   * 0 <= 链表长度 <= 1000
   *
   * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
   *
   */
  class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) {
        return l2;
      }
      if (l2 == null) {
        return l1;
      }
      ListNode root = new ListNode(0);
      ListNode current = root;
      while (l1 != null || l2 != null) {
        if (l1 == null) {
          current.next = l2;
          break;
        } else if (l2 == null) {
          current.next = l1;
          break;
        } else if (l1.val > l2.val) {
          current.next = l2;
          l2 = l2.next;
        } else {
          current.next = l1;
          l1 = l1.next;
        }
        current = current.next;
      }
      return root.next;
    }
  }
}
