package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/17
 */
public class LegalBinarySearchTreeLCCI {

  /**
   * Implement a function to check if a binary tree is a binary search tree.
   *
   * Example 1:
   *
   * Input:
   *     2
   *    / \
   *   1   3
   * Output: true
   * Example 2:
   *
   * Input:
   *     5
   *    / \
   *   1   4
   *      / \
   *     3   6
   * Output: false
   * Explanation: Input: [5,1,4,null,null,3,6].
   *      the value of root node is 5, but its right child has value 4.
   *
   * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
   *
   * 示例 1:
   * 输入:
   *     2
   *    / \
   *   1   3
   * 输出: true
   * 示例 2:
   * 输入:
   *     5
   *    / \
   *   1   4
   *      / \
   *     3   6
   * 输出: false
   * 解释: 输入为: [5,1,4,null,null,3,6]。
   *      根节点的值为 5 ，但是其右子节点值为 4 。
   *
   */
  class Solution {

    int min = 0;
    boolean flag = false;

    public boolean isValidBST(TreeNode root) {
      if (root == null) {
        return true;
      }
      return isValidBST(root.left) && checkValue(root) && isValidBST(root.right);
    }

    private boolean checkValue(TreeNode root) {
      if (flag && root.val <= min) {
        return false;
      }
      flag = true;
      min = root.val;
      return true;
    }

  }
}
