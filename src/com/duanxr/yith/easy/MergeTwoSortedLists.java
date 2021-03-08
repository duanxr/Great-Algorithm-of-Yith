package com.duanxr.yith.easy;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/3/8
 */
public class MergeTwoSortedLists {

  /**
   * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: l1 = [1,2,4], l2 = [1,3,4]
   * Output: [1,1,2,3,4,4]
   * Example 2:
   *
   * Input: l1 = [], l2 = []
   * Output: []
   * Example 3:
   *
   * Input: l1 = [], l2 = [0]
   * Output: [0]
   *  
   *
   * Constraints:
   *
   * The number of nodes in both lists is in the range [0, 50].
   * -100 <= Node.val <= 100
   * Both l1 and l2 are sorted in non-decreasing order.
   *
   * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：l1 = [1,2,4], l2 = [1,3,4]
   * 输出：[1,1,2,3,4,4]
   * 示例 2：
   *
   * 输入：l1 = [], l2 = []
   * 输出：[]
   * 示例 3：
   *
   * 输入：l1 = [], l2 = [0]
   * 输出：[0]
   *  
   *
   * 提示：
   *
   * 两个链表的节点数目范围是 [0, 50]
   * -100 <= Node.val <= 100
   * l1 和 l2 均按 非递减顺序 排列
   *
   */
  class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null && l2 == null) {
        return null;
      } else if (l1 == null) {
        return l2;
      } else if (l2 == null) {
        return l1;
      } else {
        if (l1.val < l2.val) {
          l1.next = mergeTwoLists(l1.next, l2);
          return l1;
        } else {
          l2.next = mergeTwoLists(l1, l2.next);
          return l2;
        }
      }
    }
  }
}
