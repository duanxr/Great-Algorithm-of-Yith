package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/17
 */
public class FirstCommonAncestorLCCI {

  /**
   * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
   *
   * For example, Given the following tree: root = [3,5,1,6,2,0,8,null,null,7,4]
   *
   *     3
   *    / \
   *   5   1
   *  / \ / \
   * 6  2 0  8
   *   / \
   *  7   4
   * Example 1:
   *
   * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
   * Input: 3
   * Explanation: The first common ancestor of node 5 and node 1 is node 3.
   * Example 2:
   *
   * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
   * Output: 5
   * Explanation: The first common ancestor of node 5 and node 4 is node 5.
   * Notes:
   *
   * All node values are pairwise distinct.
   * p, q are different node and both can be found in the given tree.
   *
   * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
   *
   * 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
   *
   *     3
   *    / \
   *   5   1
   *  / \ / \
   * 6  2 0  8
   *   / \
   *  7   4
   * 示例 1:
   *
   * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
   * 输出: 3
   * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
   * 示例 2:
   *
   * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
   * 输出: 5
   * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
   * 说明:
   *
   * 所有节点的值都是唯一的。
   * p、q 为不同节点且均存在于给定的二叉树中。
   *
   */
  class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null) {
        return null;
      }
      TreeNode l = lowestCommonAncestor(root.left, p, q);
      TreeNode m = check(root, p, q);
      if (l != null && m != null) {
        return m;
      }
      TreeNode r = lowestCommonAncestor(root.right, p, q);
      if (r != null) {
        if (m != null) {
          return m;
        }
        if (l != null) {
          return root;
        }
      }
      if (l != null) {
        return l;
      }
      if (m != null) {
        return m;
      }
      return r;
    }

    private TreeNode check(TreeNode root, TreeNode p, TreeNode q) {
      if (root == p) {
        return root;
      }
      if (root == q) {
        return root;
      }
      return null;
    }
  }
}
