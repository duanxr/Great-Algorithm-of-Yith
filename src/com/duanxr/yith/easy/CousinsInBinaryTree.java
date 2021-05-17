package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/5/17
 */
public class CousinsInBinaryTree {

  /**
   * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
   *
   * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
   *
   * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
   *
   * Return true if and only if the nodes corresponding to the values x and y are cousins.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [1,2,3,4], x = 4, y = 3
   * Output: false
   * Example 2:
   *
   *
   * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
   * Output: true
   * Example 3:
   *
   *
   *
   * Input: root = [1,2,3,null,4], x = 2, y = 3
   * Output: false
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree will be between 2 and 100.
   * Each node has a unique integer value from 1 to 100.
   *
   * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
   *
   * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
   *
   * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
   *
   * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：root = [1,2,3,4], x = 4, y = 3
   * 输出：false
   * 示例 2：
   *
   *
   * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
   * 输出：true
   * 示例 3：
   *
   *
   *
   * 输入：root = [1,2,3,null,4], x = 2, y = 3
   * 输出：false
   *  
   *
   * 提示：
   *
   * 二叉树的节点数介于 2 到 100 之间。
   * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
   *
   */
  class Solution {

    private TreeNode f;
    private int d = -1;

    public boolean isCousins(TreeNode root, int x, int y) {
      return find(root, x, y, 0, null);
    }

    private boolean find(TreeNode root, int x, int y, int deep, TreeNode father) {
      if (root == null) {
        return false;
      }
      if (root.val == x || root.val == y) {
        if (d != -1) {
          return father != null && f != null && f != father && d == deep;
        }
        d = deep;
        f = father;
        return false;
      }
      return find(root.left, x, y, deep + 1, root) || find(root.right, x, y, deep + 1, root);
    }

  }

  class Solution1 {

    private class CousinsFinder {

      private TreeNode xf;
      private TreeNode yf;
      private Integer xd;
      private Integer yd;

      public CousinsFinder(TreeNode root, int x, int y) {
        this.find(root, x, y, 0, null);
      }

      private void find(TreeNode root, int x, int y, int deep, TreeNode father) {
        if (root == null || isBothFound()) {
          return;
        }
        System.out.println("f " + root.val + "  d " + deep);
        if (root.val == x) {
          System.out.println("x " + root.val + "  d " + deep);

          this.xf = father;
          this.xd = deep;
        } else if (root.val == y) {
          System.out.println("y " + root.val + "  d " + deep);

          this.yf = father;
          this.yd = deep;
        }
        find(root.left, x, y, deep + 1, root);
        find(root.right, x, y, deep + 1, root);
      }

      public boolean isCousins() {
        return yf != null && xf != null && xf != yf && xd.equals(yd);
      }

      private boolean isBothFound() {
        return xd != null && yd != null;
      }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
      CousinsFinder cousinsFinder = new CousinsFinder(root, x, y);
      return cousinsFinder.isCousins();
    }
  }
}
