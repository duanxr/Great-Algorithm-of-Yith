package com.duanxr.yith.middle;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/3/11
 */
public class FanZhuanLianBiaoLcof {

  /**
   * English description is not available for the problem.
   *
   * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
   *
   *  
   *
   * 示例:
   *
   * 输入: 1->2->3->4->5->NULL
   * 输出: 5->4->3->2->1->NULL
   *  
   *
   * 限制：
   *
   * 0 <= 节点个数 <= 5000
   *
   *  
   *
   * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
   *
   */
  class Solution {

    public ListNode reverseList(ListNode head) {
      return reverseList(head, null);
    }

    public ListNode reverseList(ListNode current, ListNode last) {
      if (current == null) {
        return last;
      }
      ListNode next = current.next;
      current.next = last;
      return reverseList(next,current);
    }
  }

}
