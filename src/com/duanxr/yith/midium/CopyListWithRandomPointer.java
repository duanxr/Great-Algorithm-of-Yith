package com.duanxr.yith.midium;

import com.duanxr.yith.define.randomNode.Node;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 段然 2021/7/22
 */
public class CopyListWithRandomPointer {

  /**
   * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
   *
   * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
   *
   * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
   *
   * Return the head of the copied linked list.
   *
   * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
   *
   * val: an integer representing Node.val
   * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
   * Your code will only be given the head of the original linked list.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
   * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
   * Example 2:
   *
   *
   * Input: head = [[1,1],[2,1]]
   * Output: [[1,1],[2,1]]
   * Example 3:
   *
   *
   *
   * Input: head = [[3,null],[3,0],[3,null]]
   * Output: [[3,null],[3,0],[3,null]]
   * Example 4:
   *
   * Input: head = []
   * Output: []
   * Explanation: The given linked list is empty (null pointer), so return null.
   *  
   *
   * Constraints:
   *
   * 0 <= n <= 1000
   * -10000 <= Node.val <= 10000
   * Node.random is null or is pointing to some node in the linked list.
   *
   * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
   *
   * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
   *
   * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
   *
   * 返回复制链表的头节点。
   *
   * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
   *
   * val：一个表示 Node.val 的整数。
   * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
   * 你的代码 只 接受原链表的头节点 head 作为传入参数。
   *
   *  
   *
   * 示例 1：
   *
   *
   *
   * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
   * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
   * 示例 2：
   *
   *
   *
   * 输入：head = [[1,1],[2,1]]
   * 输出：[[1,1],[2,1]]
   * 示例 3：
   *
   *
   *
   * 输入：head = [[3,null],[3,0],[3,null]]
   * 输出：[[3,null],[3,0],[3,null]]
   * 示例 4：
   *
   * 输入：head = []
   * 输出：[]
   * 解释：给定的链表为空（空指针），因此返回 null。
   *  
   *
   * 提示：
   *
   * 0 <= n <= 1000
   * -10000 <= Node.val <= 10000
   * Node.random 为空（null）或指向链表中的节点。
   *
   */
  class Solution {

    public Node copyRandomList(Node oh) {
      if (oh == null) {
        return null;
      }
      Map<Node, Node> map = new HashMap<>();
      Node co = oh;
      Node nh = null;
      Node cn = null;
      while (co != null) {
        Node node = new Node(co.val);
        node.random = co.random;
        map.put(co, node);
        if (nh == null) {
          nh = node;
        } else {
          cn.next = node;
        }
        cn = node;
        co = co.next;
      }
      cn = nh;
      while (cn != null) {
        if (cn.random != null) {
          cn.random = map.get(cn.random);
        }
        cn = cn.next;
      }
      return nh;
    }
  }
}
