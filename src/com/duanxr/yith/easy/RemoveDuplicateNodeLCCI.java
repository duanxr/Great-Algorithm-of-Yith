package com.duanxr.yith.easy;

import com.duanxr.yith.define.listNode.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 段然 2021/3/16
 */
public class RemoveDuplicateNodeLCCI {

  /**
   * Write code to remove duplicates from an unsorted linked list.
   *
   * Example1:
   *
   *  Input: [1, 2, 3, 3, 2, 1]
   *  Output: [1, 2, 3]
   * Example2:
   *
   *  Input: [1, 1, 1, 1, 2]
   *  Output: [1, 2]
   * Note:
   *
   * The length of the list is within the range[0, 20000].
   * The values of the list elements are within the range [0, 20000].
   * Follow Up:
   *
   * How would you solve this problem if a temporary buffer is not allowed?
   *
   * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
   *
   * 示例1:
   *
   *  输入：[1, 2, 3, 3, 2, 1]
   *  输出：[1, 2, 3]
   * 示例2:
   *
   *  输入：[1, 1, 1, 1, 2]
   *  输出：[1, 2]
   * 提示：
   *
   * 链表长度在[0, 20000]范围内。
   * 链表元素在[0, 20000]范围内。
   * 进阶：
   *
   * 如果不得使用临时缓冲区，该怎么解决？
   *
   */
  class Solution {

    Set<Integer> set = new HashSet<>();

    public ListNode removeDuplicateNodes(ListNode node) {
      if (node == null) {
        return null;
      }
      boolean contains = set.contains(node.val);
      set.add(node.val);
      if (contains) {
        return removeDuplicateNodes(node.next);
      } else {
        node.next = removeDuplicateNodes(node.next);
        return node;
      }

    }
  }
}
