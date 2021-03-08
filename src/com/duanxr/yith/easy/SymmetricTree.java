package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/8
 */
public class SymmetricTree {

  /**
   * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [1,2,2,3,4,4,3]
   * Output: true
   * Example 2:
   *
   *
   * Input: root = [1,2,2,null,3,null,3]
   * Output: false
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [1, 1000].
   * -100 <= Node.val <= 100
   *  
   *
   * Follow up: Could you solve it both recursively and iteratively?
   *
   * 给定一个二叉树，检查它是否是镜像对称的。
   *
   *  
   *
   * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
   *
   *     1
   *    / \
   *   2   2
   *  / \ / \
   * 3  4 4  3
   *  
   *
   * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
   *
   *     1
   *    / \
   *   2   2
   *    \   \
   *    3    3
   *  
   *
   * 进阶：
   *
   * 你可以运用递归和迭代两种方法解决这个问题吗？
   *
   */
  class Solution {

    public boolean isSymmetric(TreeNode root) {
      return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode l, TreeNode r) {
      return l == null && r == null || l != null && r != null && l.val == r.val && isSymmetric(
          l.left, r.right) && isSymmetric(l.right, r.left);
    }
  }
}
