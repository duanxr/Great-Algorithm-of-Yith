package com.duanxr.yith.middle;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 段然 2021/3/8
 */
public class BinaryTreeLevelOrderTraversalII {

  /**
   * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [3,9,20,null,null,15,7]
   * Output: [[15,7],[9,20],[3]]
   * Example 2:
   *
   * Input: root = [1]
   * Output: [[1]]
   * Example 3:
   *
   * Input: root = []
   * Output: []
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [0, 2000].
   * -1000 <= Node.val <= 1000
   *
   * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
   *
   * 例如：
   * 给定二叉树 [3,9,20,null,null,15,7],
   *
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   * 返回其自底向上的层序遍历为：
   *
   * [
   *   [15,7],
   *   [9,20],
   *   [3]
   * ]
   *
   */
  class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      LinkedList<List<Integer>> result = new LinkedList<>();
      find(root, result, 0);
      return result;
    }

    private void find(TreeNode treeNode, LinkedList<List<Integer>> list, int d) {
      int deep = d;
      if (treeNode == null) {
        return;
      }
      deep++;
      List<Integer> thisFloor;
      if (list.size() < deep) {
        thisFloor = new LinkedList<>();
        list.push(thisFloor);
      } else {
        thisFloor = list.get(list.size() - deep);
      }
      thisFloor.add(treeNode.val);
      find(treeNode.left, list, deep);
      find(treeNode.right, list, deep);
    }
  }
}
