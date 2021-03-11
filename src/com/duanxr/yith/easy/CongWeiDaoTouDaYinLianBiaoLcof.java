package com.duanxr.yith.easy;

import com.duanxr.yith.define.listNode.ListNode;
import java.util.Arrays;

/**
 * @author 段然 2021/3/11
 */
public class CongWeiDaoTouDaYinLianBiaoLcof {

  /**
   * English description is not available for the problem.
   *
   * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：head = [1,3,2]
   * 输出：[2,3,1]
   *  
   *
   * 限制：
   *
   * 0 <= 链表长度 <= 10000
   *
   */
  class Solution {

    public int[] reversePrint(ListNode head) {
      int l = 10000;
      int[] result = new int[10000];
      while (head != null) {
        result[--l] = head.val;
        head = head.next;
      }
      return Arrays.copyOfRange(result, l, 10000);
    }
  }
}
