package com.duanxr.leetcode.easy;

import com.duanxr.leetcode.define.treeNode.TreeNode;

/**
 * @author Duanran 2019/2/26 0026
 */
public class MergeTwoBinaryTrees {

  /**
   * Given two binary trees and imagine that when you put one of them to cover the other, some nodes
   * of the two trees are overlapped while the others are not.
   *
   * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
   * then sum node values up as the new value of the merged node. Otherwise, the NOT null node will
   * be used as the node of new tree.
   *
   * Example 1:
   *
   * Input:
   *
   * Tree 1                     Tree 2
   *
   *     1                         2
   *    / \                       / \
   *   3   2                     1   3
   *  /                           \   \
   * 5                             4   7
   *
   * Output:
   *
   * Merged tree:
   *
   *     3
   *    / \
   *   4   5
   *  / \   \
   * 5   4   7
   *
   * Note: The merging process must start from the root nodes of both trees.
   *
   * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
   *
   * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
   *
   * 示例 1:
   *
   * 输入:
   *
   * Tree 1                     Tree 2
   *
   *     1                         2
   *    / \                       / \
   *   3   2                     1   3
   *  /                           \   \
   * 5                             4   7
   *
   * 输出:
   *
   * 合并后的树:
   *
   *     3
   *    / \
   *   4   5
   *  / \   \
   * 5   4   7
   */
  class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
      TreeNode treeNode;
      if (t1 == null && t2 == null) {
        return null;
      } else if (t1 == null) {
        treeNode = t2;
      } else if (t2 == null) {
        treeNode = t1;
      } else {
        treeNode = new TreeNode(t1.val + t2.val);
        treeNode.left = mergeTrees(t1.left, t2.left);
        treeNode.right = mergeTrees(t1.right, t2.right);
      }
      return treeNode;
    }
  }
}
