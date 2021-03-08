package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author Duanran 2019/8/7 0007
 */
public class SumOfRootToLeafBinaryNumbers {

  /**
   * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary
   * number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 ->
   * 1, then this could represent 01101 in binary, which is 13.
   *
   * For all leaves in the tree, consider the numbers represented by the path from the root to that
   * leaf.
   *
   * Return the sum of these numbers.
   *
   * Example 1:
   *
   * Input: [1,0,1,0,1,0,1] Output: 22 Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 =
   * 22   Note:
   *
   * The number of nodes in the tree is between 1 and 1000. node.val is 0 or 1. The answer will not
   * exceed 2^31 - 1.
   *
   * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。 例如，如果路径为 0 -> 1 -> 1 -> 0 ->
   * 1，那么它表示二进制数 01101，也就是 13 。
   *
   * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
   *
   * 以 10^9 + 7 为模，返回这些数字之和。
   *
   *  
   *
   * 示例：
   *
   *
   *
   * 输入：[1,0,1,0,1,0,1] 输出：22 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22  
   *
   * 提示：
   *
   * 树中的结点数介于 1 和 1000 之间。 node.val 为 0 或 1 。
   */
  class Solution {

    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
      sum = 0;
      countSum(root, 0);
      return sum;
    }

    private void countSum(TreeNode root, int i) {
      if (root == null) {
        return;
      }
      i = i * 2 + root.val;
      if (root.left == null && root.right == null) {
        sum += i;
      } else {
        countSum(root.left,i);
        countSum(root.right,i);
      }
    }
  }
}
