package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 段然 2021/3/8
 */
public class TwoSumIVInputIsABST {

  /**
   * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [5,3,6,2,4,null,7], k = 9
   * Output: true
   * Example 2:
   *
   *
   * Input: root = [5,3,6,2,4,null,7], k = 28
   * Output: false
   * Example 3:
   *
   * Input: root = [2,1,3], k = 4
   * Output: true
   * Example 4:
   *
   * Input: root = [2,1,3], k = 1
   * Output: false
   * Example 5:
   *
   * Input: root = [2,1,3], k = 3
   * Output: true
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [1, 104].
   * -104 <= Node.val <= 104
   * root is guaranteed to be a valid binary search tree.
   * -105 <= k <= 105
   *
   * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
   *
   * 案例 1:
   *
   * 输入:
   *     5
   *    / \
   *   3   6
   *  / \   \
   * 2   4   7
   *
   * Target = 9
   *
   * 输出: True
   *  
   *
   * 案例 2:
   *
   * 输入:
   *     5
   *    / \
   *   3   6
   *  / \   \
   * 2   4   7
   *
   * Target = 28
   *
   * 输出: False
   *  
   */
  class Solution {

    public boolean findTarget(TreeNode root, int k) {
      Set<Integer> set = new HashSet<>();
      return find(root, set, k);
    }

    private boolean find(TreeNode root, Set<Integer> set, int k) {
      if (root == null) {
        return false;
      }
      boolean isThis = set.contains(root.val);
      int c = k - root.val;
      set.add(c);
      return isThis || find(root.left, set, k) || find(root.right, set, k);
    }
  }
}
