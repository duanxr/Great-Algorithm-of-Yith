package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/8
 */
public class SumOfLeftLeaves {

  /**
   * Find the sum of all left leaves in a given binary tree.
   *
   * Example:
   *
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   *
   * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
   *
   * 计算给定二叉树的所有左叶子之和。
   *
   * 示例：
   *
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   *
   * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
   *
   */
  class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
      return sum(root, false);
    }

    private int sum(TreeNode root, boolean isLeft) {
      if (root == null) {
        return 0;
      }
      if (root.left == null && root.right == null && isLeft) {
        return root.val;
      }
      return sum(root.left, true) + sum(root.right, false);
    }
  }
}
