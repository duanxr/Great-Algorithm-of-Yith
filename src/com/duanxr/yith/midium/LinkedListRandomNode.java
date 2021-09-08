package com.duanxr.yith.midium;

import com.duanxr.yith.define.listNode.ListNode;

/**
 * @author 段然 2021/9/7
 */
public class LinkedListRandomNode {

  /**
   * Given a singly linked list, return a random node's value from the linked list. Each node must
   * have the same probability of being chosen.
   *
   * Implement the Solution class:
   *
   * Solution(ListNode head) Initializes the object with the integer array nums. int getRandom()
   * Chooses a node randomly from the list and returns its value. All the nodes of the list should
   * be equally likely to be choosen.  
   *
   * Example 1:
   *
   *
   * Input ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"] [[[1, 2,
   * 3]], [], [], [], [], []] Output [null, 1, 3, 2, 2, 3]
   *
   * Explanation Solution solution = new Solution([1, 2, 3]); solution.getRandom(); // return 1
   * solution.getRandom(); // return 3 solution.getRandom(); // return 2 solution.getRandom(); //
   * return 2 solution.getRandom(); // return 3 // getRandom() should return either 1, 2, or 3
   * randomly. Each element should have equal probability of returning.  
   *
   * Constraints:
   *
   * The number of nodes in the linked list will be in the range [1, 104]. -104 <= Node.val <= 104
   * At most 104 calls will be made to getRandom.  
   *
   * Follow up:
   *
   * What if the linked list is extremely large and its length is unknown to you? Could you solve
   * this efficiently without using extra space?
   *
   * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
   *
   * 进阶: 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
   *
   * 示例:
   *
   * // 初始化一个单链表 [1,2,3]. ListNode head = new ListNode(1); head.next = new ListNode(2);
   * head.next.next = new ListNode(3); Solution solution = new Solution(head);
   *
   * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。 solution.getRandom();
   */
  class Solution {

    private final int[] map;

    public Solution(ListNode head) {
      int l = 0;
      ListNode node = head;
      while (node != null) {
        node = node.next;
        l++;
      }
      map = new int[l];
      l = 0;
      while (head != null) {
        map[l++] = head.val;
        head = head.next;
      }
    }

    public int getRandom() {
      return map[(int) (Math.random() * (map.length))];
    }
  }

  class Solution1 {

    private final ListNode head;

    public Solution1(ListNode head) {
      this.head = head;
    }

    public int getRandom() {
      int num = head.val;
      int index = 1;
      ListNode node = head;
      while (node != null) {
        index++;
        node = node.next;
        if (node!=null && Math.random() < (1D / index)) {
          num = node.val;
        }
      }
      return num;
    }
  }

}
