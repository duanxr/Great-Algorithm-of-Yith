package com.duanxr.yith.easy;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/3/8
 */
public class MiddleOfTheLinkedList {

  /**
   * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
   *
   * If there are two middle nodes, return the second middle node.
   *
   *  
   *
   * Example 1:
   *
   * Input: [1,2,3,4,5]
   * Output: Node 3 from this list (Serialization: [3,4,5])
   * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
   * Note that we returned a ListNode object ans, such that:
   * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
   * Example 2:
   *
   * Input: [1,2,3,4,5,6]
   * Output: Node 4 from this list (Serialization: [4,5,6])
   * Since the list has two middle nodes with values 3 and 4, we return the second one.
   *  
   *
   * Note:
   *
   * The number of nodes in the given list will be between 1 and 100.
   *
   * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
   *
   * 如果有两个中间结点，则返回第二个中间结点。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：[1,2,3,4,5]
   * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
   * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
   * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
   * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
   * 示例 2：
   *
   * 输入：[1,2,3,4,5,6]
   * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
   * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
   *  
   *
   * 提示：
   *
   * 给定链表的结点数介于 1 和 100 之间。
   *
   */
  class Solution {

    public ListNode middleNode(ListNode head) {
      int count = 1;
      ListNode node = head;
      while (node.next != null) {
        count++;
        node = node.next;
      }
      node = head;
      count /= 2;
      while (count != 0) {
        node = node.next;
        count--;
      }
      return node;
    }
  }
}
