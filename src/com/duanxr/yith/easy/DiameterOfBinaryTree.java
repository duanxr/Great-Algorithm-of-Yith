package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/8
 */
public class DiameterOfBinaryTree {

  /**
   * Given the root of a binary tree, return the length of the diameter of the tree.
   *
   * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
   *
   * The length of a path between two nodes is represented by the number of edges between them.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [1,2,3,4,5]
   * Output: 3
   * Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].
   * Example 2:
   *
   * Input: root = [1,2]
   * Output: 1
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [1, 104].
   * -100 <= Node.val <= 100
   *
   * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
   *
   *  
   *
   * 示例 :
   * 给定二叉树
   *
   *           1
   *          / \
   *         2   3
   *        / \
   *       4   5
   * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
   *
   *  
   *
   * 注意：两结点之间的路径长度是以它们之间边的数目表示。
   *
   */
  class Solution {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
      find(root);
      return diameter;
    }

    private int find(TreeNode treeNode) {
      if (treeNode == null) {
        return 0;
      }
      int l = find(treeNode.left);
      int r = find(treeNode.right);
      int d = l + r;
      diameter = Math.max(d, diameter);
      return Math.max(l, r) + 1;
    }
  }
}
