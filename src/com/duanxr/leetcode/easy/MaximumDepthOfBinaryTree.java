package com.duanxr.leetcode.easy;

import com.duanxr.leetcode.define.treeNode.TreeNode;
import java.util.LinkedList;

/**
 * @author Duanran 2019/2/26 0026
 */
public class MaximumDepthOfBinaryTree {

  /**
   * Given a binary tree, find its maximum depth.
   *
   * The maximum depth is the number of nodes along the longest path from the root node down to the
   * farthest leaf node.
   *
   * Note: A leaf is a node with no children.
   *
   * Example:
   *
   * Given binary tree [3,9,20,null,null,15,7],
   *
   *     3
   *    / \
   *   9  20
   *  /  \
   * 15   7
   *
   * return its depth = 3.
   *
   * 给定一个二叉树，找出其最大深度。
   *
   * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
   *
   * 说明: 叶子节点是指没有子节点的节点。
   *
   * 示例：
   *
   * 给定二叉树 [3,9,20,null,null,15,7]，
   *
   *     3
   *    / \
   *   9  20
   *  /  \
   * 15   7
   *
   * 返回它的最大深度 3 。
   */
  class Solution {

    public int maxDepth(TreeNode root) {
      int max = 0;
      LinkedList<TreeNode> stack = new LinkedList<>();
      stack.push(root);
      return findDepth(stack, 0);
    }

    private int findDepth(LinkedList<TreeNode> stack, int max) {
      TreeNode treeNode = stack.peek();
      if (treeNode == null) {
        stack.pop();
        return max;
      } else {
        max++;
        stack.push(treeNode.left);
        int left = findDepth(stack, max);
        stack.push(treeNode.right);
        int right = findDepth(stack, max);
        return Math.max(left, right);
      }
    }
  }
}
