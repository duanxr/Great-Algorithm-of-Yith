package com.duanxr.leetcode.easy;

import com.duanxr.leetcode.define.treeNode.TreeNode;

/**
 * @author Duanran 2019/1/18 0018
 */
public class UnivaluedBinaryTree {

  /**
   * A binary tree is univalued if every node in the tree has the same value.
   *
   * Return true if and only if the given tree is univalued.
   *
   *
   *
   * Example 1:
   *
   *
   * Input: [1,1,1,1,1,null,1]
   *
   * Output: true
   *
   * Example 2:
   *
   *
   * Input: [2,2,2,5,2]
   *
   * Output: false
   *
   *
   * Note:
   *
   * The number of nodes in the given tree will be in the range [1, 100].
   *
   * Each node's value will be an integer in the range [0, 99].
   *
   * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
   *
   * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
   *
   *
   *
   * 示例 1：
   *
   *
   *
   * 输入：[1,1,1,1,1,null,1]
   *
   * 输出：true
   *
   * 示例 2：
   *
   *
   *
   * 输入：[2,2,2,5,2]
   *
   * 输出：false
   *
   *
   * 提示：
   *
   * 给定树的节点数范围是 [1, 100]。
   *
   * 每个节点的值都是整数，范围为 [0, 99] 。
   */
  class Solution {

    public boolean isUnivalTree(TreeNode root) {
      if (root == null) {
        return true;
      }
      return find(root, root.val);
    }

    private boolean find(TreeNode root, int val) {
      return root == null || (root.val == val && find(root.left, val) && find(root.right, val));
    }
  }
}
