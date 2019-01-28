package com.duanxr.leetcode.easy;

import com.duanxr.leetcode.definition.treeNode.TreeNode;

/**
 * @author Duanran 2019/1/28 0028
 */
public class MinimumDepthofBinaryTree {

  /**
   * Given a binary tree, find its minimum depth.
   *
   * The minimum depth is the number of nodes along the shortest path from the root node down to the
   * nearest leaf node.
   *
   * Note: A leaf is a node with no children.
   *
   * Example:
   *
   * Given binary tree [3,9,20,null,null,15,7],
   *
   *   3
   *  / \
   * 9  20
   *   /  \
   *  15   7
   *
   * return its minimum depth = 2.
   *
   * 给定一个二叉树，找出其最小深度。
   *
   * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
   *
   * 说明: 叶子节点是指没有子节点的节点。
   *
   * 示例:
   *
   * 给定二叉树 [3,9,20,null,null,15,7],
   *
   *   3
   *  / \
   * 9  20
   *   /  \
   *  15   7
   *
   * 返回它的最小深度  2.
   */
  class Solution {

    public int minDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int l = minDepth(root.left);
      int r = minDepth(root.right);
      if (l == 0) {
        return ++r;
      }
      if (r == 0) {
        return ++l;
      }
      if (l > r) {
        return ++r;
      }
      return ++l;
    }
  }
}
