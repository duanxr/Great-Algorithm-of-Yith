package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/8
 */
public class SubtreeOfAnotherTree {

  /**
   * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
   *
   * Example 1:
   * Given tree s:
   *
   *      3
   *     / \
   *    4   5
   *   / \
   *  1   2
   * Given tree t:
   *    4
   *   / \
   *  1   2
   * Return true, because t has the same structure and node values with a subtree of s.
   *  
   *
   * Example 2:
   * Given tree s:
   *
   *      3
   *     / \
   *    4   5
   *   / \
   *  1   2
   *     /
   *    0
   * Given tree t:
   *    4
   *   / \
   *  1   2
   * Return false.
   *  
   *
   * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
   *
   * 示例 1:
   * 给定的树 s:
   *
   *      3
   *     / \
   *    4   5
   *   / \
   *  1   2
   * 给定的树 t：
   *
   *    4
   *   / \
   *  1   2
   * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
   *
   * 示例 2:
   * 给定的树 s：
   *
   *      3
   *     / \
   *    4   5
   *   / \
   *  1   2
   *     /
   *    0
   * 给定的树 t：
   *
   *    4
   *   / \
   *  1   2
   * 返回 false。
   *
   */
  class Solution {

    public boolean isSubtree(TreeNode s, TreeNode t) {
      if (s == null || t == null) {
        return t == s;
      }
      if (s.val == t.val) {
        return find(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
      }
      return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean find(TreeNode s, TreeNode t) {
      if (s == null || t == null) {
        return t == s;
      }
      return s.val == t.val && find(s.left, t.left) && find(s.right, t.right);
    }
  }
}
