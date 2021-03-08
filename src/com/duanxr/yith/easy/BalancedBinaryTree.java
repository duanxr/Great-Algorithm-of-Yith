package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/8
 */
public class BalancedBinaryTree {

  /**
   * Given a binary tree, determine if it is height-balanced.
   *
   * For this problem, a height-balanced binary tree is defined as:
   *
   * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [3,9,20,null,null,15,7]
   * Output: true
   * Example 2:
   *
   *
   * Input: root = [1,2,2,3,3,null,null,4,4]
   * Output: false
   * Example 3:
   *
   * Input: root = []
   * Output: true
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [0, 5000].
   * -104 <= Node.val <= 104
   *
   * 给定一个二叉树，判断它是否是高度平衡的二叉树。
   *
   * 本题中，一棵高度平衡二叉树定义为：
   *
   * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：root = [3,9,20,null,null,15,7]
   * 输出：true
   * 示例 2：
   *
   *
   * 输入：root = [1,2,2,3,3,null,null,4,4]
   * 输出：false
   * 示例 3：
   *
   * 输入：root = []
   * 输出：true
   *  
   *
   * 提示：
   *
   * 树中的节点数在范围 [0, 5000] 内
   * -104 <= Node.val <= 104
   *
   */
  class Solution {

    public boolean isBalanced(TreeNode root) {
      try {
        findBalanced(root);
      } catch (Exception e) {
        return false;
      }
      return true;
    }

    public int findBalanced(TreeNode root) throws Exception {
      if (root == null) {
        return 0;
      }
      int l = findBalanced(root.left);
      int r = findBalanced(root.right);
      if (Math.abs(l - r) > 1) {
        throw new Exception();
      }
      return Math.max(l, r) + 1;
    }
  }
}
