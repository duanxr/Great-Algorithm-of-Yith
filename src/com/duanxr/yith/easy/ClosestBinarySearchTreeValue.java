package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/7/30
 */
public class ClosestBinarySearchTreeValue {

  /**
   * Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [4,2,5,1,3], target = 3.714286
   * Output: 4
   * Example 2:
   *
   * Input: root = [1], target = 4.428571
   * Output: 1
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [1, 104].
   * 0 <= Node.val <= 109
   * -109 <= target <= 109
   *
   * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
   *
   * 注意：
   *
   * 给定的目标值 target 是一个浮点数
   * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
   * 示例：
   *
   * 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
   *
   *     4
   *    / \
   *   2   5
   *  / \
   * 1   3
   *
   * 输出: 4
   *
   */
  class Solution {

    public int closestValue(TreeNode root, double target) {
      int closest = 0;
      double diff = Double.MAX_VALUE;
      while (root != null) {
        double newDiff = root.val - target;
        double absNewDiff = Math.abs(newDiff);
        if (absNewDiff < diff) {
          diff = absNewDiff;
          closest = root.val;
        }
        if (root.left == null) {
          root = root.right;
        } else if (root.right == null) {
          root = root.left;
        } else {
          root = newDiff > 0 ? root.left : root.right;
        }
      }
      return closest;
    }

  }


  class Solution1 {

    public int closestValue(TreeNode root, double target) {
      int closest = 0;
      double diff = Double.MAX_VALUE;
      while (root != null) {
        double newDiff = root.val - target;
        if (Math.abs(newDiff) < Math.abs(diff)) {
          diff = newDiff;
          closest = root.val;
        }
        if (root.left == null) {
          root = root.right;
        } else if (root.right == null) {
          root = root.left;
        } else {
          root = newDiff > 0 ? root.left : root.right;
        }
      }
      return closest;
    }

  }
}
