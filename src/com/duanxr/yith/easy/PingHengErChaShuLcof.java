package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/12
 */
public class PingHengErChaShuLcof {

  /**
   * English description is not available for the problem.
   *
   * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
   *
   *  
   *
   * 示例 1:
   *
   * 给定二叉树 [3,9,20,null,null,15,7]
   *
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   * 返回 true 。
   *
   * 示例 2:
   *
   * 给定二叉树 [1,2,2,3,3,null,null,4,4]
   *
   *        1
   *       / \
   *      2   2
   *     / \
   *    3   3
   *   / \
   *  4   4
   * 返回 false 。
   *
   *  
   *
   * 限制：
   *
   * 0 <= 树的结点个数 <= 10000
   * 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
   *
   */
  class Solution {

    public boolean isBalanced(TreeNode root) {
      return findDepth(root) >= 0;
    }

    private int findDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int depthL = findDepth(root.left);
      int depthR = findDepth(root.right);
      return depthL == -1 || depthR == -1 ? -1
          : Math.abs(depthL - depthR) > 1 ? -1 : Math.max(depthL, depthR) + 1;
    }
  }
}
