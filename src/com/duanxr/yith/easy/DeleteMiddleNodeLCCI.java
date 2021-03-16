package com.duanxr.yith.easy;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/3/16
 */
public class DeleteMiddleNodeLCCI {

  /**
   * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
   *
   *  
   *
   * Example:
   *
   * Input: the node c from the linked list a->b->c->d->e->f
   * Output: nothing is returned, but the new linked list looks like a->b->d->e->f
   *
   * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
   *
   *  
   *
   * 示例：
   *
   * 输入：单向链表a->b->c->d->e->f中的节点c
   * 结果：不返回任何数据，但该链表变为a->b->d->e->f
   *
   */
  class Solution {

    public void deleteNode(ListNode node) {
      if (node != null && node.next != null) {
        node.val = node.next.val;
        node.next = node.next.next;
      }
    }
  }
}
