package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/17
 */
public class PathsWithSumLCCI {

  /**
   * You are given a binary tree in which each node contains an integer value (which might be positive or negative). Design an algorithm to count the number of paths that sum to a given value. The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
   *
   * Example:
   * Given the following tree and  sum = 22,
   *
   *               5
   *              / \
   *             4   8
   *            /   / \
   *           11  13  4
   *          /  \    / \
   *         7    2  5   1
   * Output:
   *
   * 3
   * Explanation: Paths that have sum 22 are: [5,4,11,2], [5,8,4,5], [4,11,7]
   * Note:
   *
   * node number <= 10000
   *
   * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
   *
   * 示例:
   * 给定如下二叉树，以及目标和 sum = 22，
   *
   *               5
   *              / \
   *             4   8
   *            /   / \
   *           11  13  4
   *          /  \    / \
   *         7    2  5   1
   * 返回:
   *
   * 3
   * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
   * 提示：
   *
   * 节点总数 <= 10000
   *
   */
  class Solution {

    public int pathSum(TreeNode root, int sum) {
      return findSum(root, sum, new int[0]);
    }

    private int findSum(TreeNode root, int sum, int[] ints) {
      if (root == null) {
        return 0;
      }
      int n = 0;
      if (root.val == sum) {
        n++;
      }
      int[] sums = new int[ints.length + 1];
      for (int i = 0; i < ints.length; i++) {
        if (ints[i] == root.val) {
          n++;
        }
        sums[i] = ints[i] - root.val;
      }
      sums[ints.length] = sum - root.val;
      int l = findSum(root.left, sum, sums);
      int r = findSum(root.right, sum, sums);
      return n + l + r;
    }

  }
}
