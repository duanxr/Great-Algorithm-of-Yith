package com.duanxr.yith.midium;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/9/22
 */
public class SplitLinkedListInParts {

  /**
   * Given the head of a singly linked list and an integer k, split the linked list into k
   * consecutive linked list parts.
   *
   * The length of each part should be as equal as possible: no two parts should have a size
   * differing by more than one. This may lead to some parts being null.
   *
   * The parts should be in the order of occurrence in the input list, and parts occurring earlier
   * should always have a size greater than or equal to parts occurring later.
   *
   * Return an array of the k parts.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: head = [1,2,3], k = 5 Output: [[1],[2],[3],[],[]] Explanation: The first element
   * output[0] has output[0].val = 1, output[0].next = null. The last element output[4] is null, but
   * its string representation as a ListNode is []. Example 2:
   *
   *
   * Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3 Output: [[1,2,3,4],[5,6,7],[8,9,10]] Explanation:
   * The input has been split into consecutive parts with size difference at most 1, and earlier
   * parts are a larger size than the later parts.  
   *
   * Constraints:
   *
   * The number of nodes in the list is in the range [0, 1000]. 0 <= Node.val <= 1000 1 <= k <= 50
   *
   * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
   *
   * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
   *
   * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
   *
   * 返回一个由上述 k 部分组成的数组。
   *
   *   示例 1：
   *
   *
   * 输入：head = [1,2,3], k = 5 输出：[[1],[2],[3],[],[]] 解释： 第一个元素 output[0] 为 output[0].val = 1
   * ，output[0].next = null 。 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。 示例 2：
   *
   *
   * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3 输出：[[1,2,3,4],[5,6,7],[8,9,10]] 解释：
   * 输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。  
   *
   * 提示：
   *
   * 链表中节点的数目在范围 [0, 1000] 0 <= Node.val <= 1000 1 <= k <= 50
   */
  class Solution {

    public ListNode[] splitListToParts(ListNode head, int k) {
      ListNode[] listNodes = new ListNode[k];
      int length = 0;
      ListNode node = head;
      while (node != null) {
        length++;
        node = node.next;
      }
      int size = length / k;
      int remainder = length % k;
      for (int i = 0; i < k; i++) {
        listNodes[i] = head;
        int size1 = size;
        if (remainder > 0) {
          remainder--;
          size1++;
        }
        for (int j = 0; j < size1; j++) {
          ListNode next = head.next;
          if (j == size1 - 1 && i != k - 1) {
            head.next = null;
          }
          head = next;
        }
      }
      return listNodes;
    }
  }
}