package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/17
 */
public class SuccessorLCCI {

  /**
   * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
   *
   * Return null if there's no "next" node for the given node.
   *
   * Example 1:
   *
   * Input: root = [2,1,3], p = 1
   *
   *   2
   *  / \
   * 1   3
   *
   * Output: 2
   * Example 2:
   *
   * Input: root = [5,3,6,2,4,null,null,1], p = 6
   *
   *       5
   *      / \
   *     3   6
   *    / \
   *   2   4
   *  /
   * 1
   *
   * Output: null
   *
   * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
   *
   * 如果指定节点没有对应的“下一个”节点，则返回null。
   *
   * 示例 1:
   *
   * 输入: root = [2,1,3], p = 1
   *
   *   2
   *  / \
   * 1   3
   *
   * 输出: 2
   * 示例 2:
   *
   * 输入: root = [5,3,6,2,4,null,null,1], p = 6
   *
   *       5
   *      / \
   *     3   6
   *    / \
   *   2   4
   *  /
   * 1
   *
   * 输出: null
   *
   */
  class Solution {

    boolean flag = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      if (root == null) {
        return null;
      }
      TreeNode l = inorderSuccessor(root.left, p);
      if (l != null) {
        return l;
      }
      TreeNode m = check(root, p);
      if (m != null) {
        return m;
      }
      return inorderSuccessor(root.right, p);
    }

    private TreeNode check(TreeNode root, TreeNode p) {
      if (flag) {
        return root;
      }
      if (root == p) {
        flag = true;
      }
      return null;

    }

  }
}
