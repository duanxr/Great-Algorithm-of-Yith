package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/3/8
 */
public class MinimumAbsoluteDifferenceInBST {

  /**
   * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
   *
   * Example:
   *
   * Input:
   *
   *    1
   *     \
   *      3
   *     /
   *    2
   *
   * Output:
   * 1
   *
   * Explanation:
   * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
   *  
   *
   * Note:
   *
   * There are at least two nodes in this BST.
   * This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
   *
   * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
   *
   *  
   *
   * 示例：
   *
   * 输入：
   *
   *    1
   *     \
   *      3
   *     /
   *    2
   *
   * 输出：
   * 1
   *
   * 解释：
   * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
   *  
   *
   * 提示：
   *
   * 树中至少有 2 个节点。
   * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
   *
   */
  class Solution {

    public int getMinimumDifference(TreeNode root) {
      int min = Integer.MAX_VALUE;
      List<Integer> array = new ArrayList<>();
      find(root, array);
      for (int i = 1; i < array.size(); i++) {
        min = Math.min(min, Math.abs(array.get(i) - array.get(i - 1)));
      }
      return min;
    }

    private void find(TreeNode root, List<Integer> array) {
      if (root == null) {
        return;
      }
      find(root.left, array);
      array.add(root.val);
      find(root.right, array);
    }
  }
}
