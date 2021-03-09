package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/9
 */
public class CheckBalanceLCCI {

  /**
   * Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
   *
   *
   * Example 1:
   *
   * Given tree [3,9,20,null,null,15,7]
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   * return true.
   * Example 2:
   *
   * Given [1,2,2,3,3,null,null,4,4]
   *       1
   *      / \
   *     2   2
   *    / \
   *   3   3
   *  / \
   * 4   4
   * return false.
   *  
   *
   * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
   *
   *
   * 示例 1:
   * 给定二叉树 [3,9,20,null,null,15,7]
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   * 返回 true 。
   * 示例 2:
   * 给定二叉树 [1,2,2,3,3,null,null,4,4]
   *       1
   *      / \
   *     2   2
   *    / \
   *   3   3
   *  / \
   * 4   4
   * 返回 false 。
   *
   */
  class Solution {

    private boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
      balanced = true;
      isBalanced1(root);
      return balanced;
    }

    public int isBalanced1(TreeNode root) {
      if (!balanced || root == null) {
        return 0;
      }
      int ld = isBalanced1(root.left);
      int rd = isBalanced1(root.right);
      if (Math.abs(ld - rd) > 1) {
        balanced = false;
      }
      return Math.max(ld, rd) + 1;
    }

    /*public boolean isBalanced(TreeNode root) {
      try {
        isBalanced1(root);
      } catch (Exception e) {
        return false;
      }
      return true;
    }

    public int isBalanced1(TreeNode root) throws Exception {
      if (root == null) {
        return 0;
      }
      int ld = isBalanced1(root.left);
      int rd = isBalanced1(root.right);
      if (Math.abs(ld - rd) > 1) {
        throw new Exception();
      }
      return Math.max(ld, rd) + 1;
    }*/
  }
}
