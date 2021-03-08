package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/8
 */
public class PathSum {

  /**
   * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
   *
   * A leaf is a node with no children.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
   * Output: true
   * Example 2:
   *
   *
   * Input: root = [1,2,3], targetSum = 5
   * Output: false
   * Example 3:
   *
   * Input: root = [1,2], targetSum = 0
   * Output: false
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [0, 5000].
   * -1000 <= Node.val <= 1000
   * -1000 <= targetSum <= 1000
   *
   * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
   *
   * 叶子节点 是指没有子节点的节点。
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
   * 输出：true
   * 示例 2：
   *
   *
   * 输入：root = [1,2,3], targetSum = 5
   * 输出：false
   * 示例 3：
   *
   * 输入：root = [1,2], targetSum = 0
   * 输出：false
   *  
   *
   * 提示：
   *
   * 树中节点的数目在范围 [0, 5000] 内
   * -1000 <= Node.val <= 1000
   * -1000 <= targetSum <= 1000
   *
   */
  class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
      if (root == null) {
        return false;
      }
      if (root.left == null && root.right == null) {
        return root.val == sum;
      }
      int n = sum - root.val;
      return hasPathSum(root.left, n) || hasPathSum(root.right, n);
    }
  }
}
