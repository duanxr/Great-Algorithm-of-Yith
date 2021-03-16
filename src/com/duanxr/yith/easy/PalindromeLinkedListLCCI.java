package com.duanxr.yith.easy;

import com.duanxr.yith.define.listNode.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/3/16
 */
public class PalindromeLinkedListLCCI {

  /**
   * Implement a function to check if a linked list is a palindrome.
   *
   * Example 1:
   *
   * Input:  1->2
   * Output:  false
   * Example 2:
   *
   * Input:  1->2->2->1
   * Output:  true
   *  
   *
   * Follow up:
   * Could you do it in O(n) time and O(1) space?
   *
   * 编写一个函数，检查输入的链表是否是回文的。
   *
   *  
   *
   * 示例 1：
   *
   * 输入： 1->2
   * 输出： false
   * 示例 2：
   *
   * 输入： 1->2->2->1
   * 输出： true
   *  
   *
   * 进阶：
   * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
   *
   */
  class Solution {

    public boolean isPalindrome(ListNode head) {
      if (head == null) {
        return true;
      }
      List<Integer> list = new ArrayList<>();
      while (head != null) {
        list.add(head.val);
        head = head.next;
      }
      int l = 0;
      int r = list.size() - 1;
      while (l < r) {
        if (!list.get(l++).equals(list.get(r--))) {
          return false;
        }
      }
      return true;
    }
  }
}
