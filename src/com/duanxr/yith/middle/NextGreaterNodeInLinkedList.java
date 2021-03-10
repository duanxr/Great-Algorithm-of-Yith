package com.duanxr.yith.middle;

import com.duanxr.yith.define.listNode.ListNode;
import java.util.Stack;

/**
 * @author 段然 2021/3/10
 */
public class NextGreaterNodeInLinkedList {

  /**
   * We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
   *
   * Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.
   *
   * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
   *
   * Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.
   *
   *  
   *
   * Example 1:
   *
   * Input: [2,1,5]
   * Output: [5,5,0]
   * Example 2:
   *
   * Input: [2,7,4,3,5]
   * Output: [7,0,5,5,0]
   * Example 3:
   *
   * Input: [1,7,5,1,9,2,5,1]
   * Output: [7,9,9,9,0,5,0,0]
   *  
   *
   * Note:
   *
   * 1 <= node.val <= 10^9 for each node in the linked list.
   * The given list has length in the range [0, 10000].
   *
   * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
   *
   * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
   *
   * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
   *
   * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：[2,1,5]
   * 输出：[5,5,0]
   * 示例 2：
   *
   * 输入：[2,7,4,3,5]
   * 输出：[7,0,5,5,0]
   * 示例 3：
   *
   * 输入：[1,7,5,1,9,2,5,1]
   * 输出：[7,9,9,9,0,5,0,0]
   *  
   *
   * 提示：
   *
   * 对于链表中的每个节点，1 <= node.val <= 10^9
   * 给定列表的长度在 [0, 10000] 范围内
   *
   */
  class Solution {

    public int[] nextLargerNodes(ListNode head) {
      Stack<Integer> nodeValues = new Stack<>();
      ListNode currentNode = head;
      while (currentNode != null) {
        nodeValues.push(currentNode.val);
        currentNode = currentNode.next;
      }
      int[] result = new int[nodeValues.size()];
      Stack<Integer> maxValues = new Stack<>();
      maxValues.push(Integer.MIN_VALUE);
      for (int i = result.length - 1; i >= 0; i--) {
        int n = nodeValues.pop();
        while (!maxValues.isEmpty() && n >= maxValues.peek()) {
          maxValues.pop();
        }
        if (maxValues.isEmpty()) {
          result[i] = 0;
        } else {
          result[i] = maxValues.peek();
        }
        maxValues.push(n);
      }
      return result;
    }
  }
}
