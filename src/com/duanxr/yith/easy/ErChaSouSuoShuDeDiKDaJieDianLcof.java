package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/18
 */
public class ErChaSouSuoShuDeDiKDaJieDianLcof {

  /**
   * English description is not available for the problem.
   *
   * 给定一棵二叉搜索树，请找出其中第k大的节点。
   *
   *  
   *
   * 示例 1:
   *
   * 输入: root = [3,1,4,null,2], k = 1
   *    3
   *   / \
   *  1   4
   *   \
   *    2
   * 输出: 4
   * 示例 2:
   *
   * 输入: root = [5,3,6,2,4,null,null,1], k = 3
   *        5
   *       / \
   *      3   6
   *     / \
   *    2   4
   *   /
   *  1
   * 输出: 4
   *  
   *
   * 限制：
   *
   * 1 ≤ k ≤ 二叉搜索树元素个数
   *
   */
  class Solution {

    int k = 0;

    public int kthLargest(TreeNode root, int k) {
      this.k = k;
      return findK(root);
    }

    private int findK(TreeNode root) {
      if (root == null || k == 0) {
        return Integer.MIN_VALUE;
      }
      return Math.max(findK(root.right), Math.max(checkK(root), findK(root.left)));

    }

    private int checkK(TreeNode root) {
      if (k-- == 1) {
        return root.val;
      }
      return Integer.MIN_VALUE;
    }
  }
}
