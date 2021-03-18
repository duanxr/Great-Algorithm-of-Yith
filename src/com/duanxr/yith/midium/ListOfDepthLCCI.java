package com.duanxr.yith.midium;

import com.duanxr.yith.define.listNode.ListNode;
import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 段然 2021/3/17
 */
public class ListOfDepthLCCI {

  /**
   * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists). Return a array containing all the linked lists.
   *
   *  
   *
   * Example:
   *
   * Input: [1,2,3,4,5,null,7,8]
   *
   *         1
   *        /  \
   *       2    3
   *      / \    \
   *     4   5    7
   *    /
   *   8
   *
   * Output: [[1],[2,3],[4,5,7],[8]]
   *
   * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
   *
   *  
   *
   * 示例：
   *
   * 输入：[1,2,3,4,5,null,7,8]
   *
   *         1
   *        /  \
   *       2    3
   *      / \    \
   *     4   5    7
   *    /
   *   8
   *
   * 输出：[[1],[2,3],[4,5,7],[8]]
   *
   */
  class Solution {

    public ListNode[] listOfDepth(TreeNode tree) {
      if (tree == null) {
        return new ListNode[0];
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(tree);
      List<List<ListNode>> nodes = new ArrayList<>();
      while (!queue.isEmpty()) {
        int size = queue.size();
        ArrayList<ListNode> list = new ArrayList<>();
        nodes.add(list);
        for (int i = 0; i < size; i++) {
          TreeNode poll = queue.poll();
          ListNode listNode = new ListNode(poll.val);
          if (!list.isEmpty()) {
            list.get(list.size() - 1).next = listNode;
          }
          list.add(listNode);
          if (poll.left != null) {
            queue.offer(poll.left);
          }
          if (poll.right != null) {
            queue.offer(poll.right);
          }
        }
      }
      ListNode[] result = new ListNode[nodes.size()];
      for (int i = 0; i < result.length; i++) {
        result[i] = nodes.get(i).get(0);
      }
      return result;
    }
  }
}
