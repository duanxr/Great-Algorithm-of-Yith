package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/8
 */
public class LongestUnivaluePath {

  /**
   * Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
   *
   * The length of the path between two nodes is represented by the number of edges between them.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [5,4,5,1,1,5]
   * Output: 2
   * Example 2:
   *
   *
   * Input: root = [1,4,5,4,4,5]
   * Output: 2
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [0, 104].
   * -1000 <= Node.val <= 1000
   * The depth of the tree will not exceed 1000.
   *
   * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
   *
   * 注意：两个节点之间的路径长度由它们之间的边数表示。
   *
   * 示例 1:
   *
   * 输入:
   *
   *               5
   *              / \
   *             4   5
   *            / \   \
   *           1   1   5
   * 输出:
   *
   * 2
   * 示例 2:
   *
   * 输入:
   *
   *               1
   *              / \
   *             4   5
   *            / \   \
   *           4   4   5
   * 输出:
   *
   * 2
   * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
   *
   */
  class Solution {

    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
      find(root, Integer.MIN_VALUE);
      return max;
    }

    public int find(TreeNode node, int fatherVal) {
      if (node == null) {
        return 0;
      }
      int leftPath = find(node.left, node.val);
      int rightPath = find(node.right, node.val);
      int count = leftPath + rightPath;
      if (count > max) {
        max = count;
      }
      if (fatherVal != node.val) {
        return 0;
      }
      return Math.max(leftPath, rightPath) + 1;
    }
  }
}
