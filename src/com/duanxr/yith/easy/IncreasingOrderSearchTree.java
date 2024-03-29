package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/3/8
 */
public class IncreasingOrderSearchTree {

  /**
   * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
   * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
   * Example 2:
   *
   *
   * Input: root = [5,1,7]
   * Output: [1,null,5,null,7]
   *  
   *
   * Constraints:
   *
   * The number of nodes in the given tree will be in the range [1, 100].
   * 0 <= Node.val <= 1000
   *
   * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
   *
   *  
   *
   * 示例 ：
   *
   * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
   *
   *        5
   *       / \
   *     3    6
   *    / \    \
   *   2   4    8
   *  /        / \
   * 1        7   9
   *
   * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
   *
   *  1
   *   \
   *    2
   *     \
   *      3
   *       \
   *        4
   *         \
   *          5
   *           \
   *            6
   *             \
   *              7
   *               \
   *                8
   *                 \
   *                  9
   *  
   *
   * 提示：
   *
   * 给定树中的结点数介于 1 和 100 之间。
   * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
   *
   */

  class Solution {

    public TreeNode increasingBST(TreeNode root) {
      if (root == null) {
        return null;
      }
      List<TreeNode> list = new ArrayList<>();
      increasing(root, list);
      TreeNode last = null;
      for (int i = list.size() - 1; i >= 0; i--) {
        TreeNode node = list.get(i);
        node.left = null;
        node.right = last;
        last = node;
      }
      return last;
    }

    private void increasing(TreeNode root, List<TreeNode> list) {
      if (root == null) {
        return;
      }
      increasing(root.left, list);
      list.add(root);
      increasing(root.right, list);
    }
  }


  class Solution1 {

    public class TreeAppender {

      TreeNode root;
      TreeNode leaf;

      public TreeAppender() {
        root = new TreeNode(0);
        leaf = root;
      }

      public void append(int val) {
        TreeNode node = new TreeNode(val);
        leaf.right = node;
        leaf = node;
      }

      public TreeNode getRoot() {
        return root.right;
      }
    }

    public TreeNode increasingBST(TreeNode root) {
      TreeAppender treeAppender = new TreeAppender();
      find(root, treeAppender);
      return treeAppender.getRoot();
    }

    private void find(TreeNode treeNode, TreeAppender treeAppender) {
      if (treeNode == null) {
        return;
      }
      find(treeNode.left, treeAppender);
      treeAppender.append(treeNode.val);
      find(treeNode.right, treeAppender);
    }
  }
}
