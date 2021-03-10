package com.duanxr.yith.middle;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 段然 2021/3/10
 */
public class BinaryTreeZigzagLevelOrderTraversal {

  /**
   * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [3,9,20,null,null,15,7]
   * Output: [[3],[20,9],[15,7]]
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
   * -100 <= Node.val <= 100
   *
   * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
   *
   * 例如：
   * 给定二叉树 [3,9,20,null,null,15,7],
   *
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   * 返回锯齿形层序遍历如下：
   *
   * [
   *   [3],
   *   [20,9],
   *   [15,7]
   * ]
   */
  class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> list = new ArrayList<>();
      if (root == null) {
        return list;
      }
      Stack<TreeNode> stack = new Stack<>();
      Stack<TreeNode> oddStack = new Stack<>();
      oddStack.push(root);
      int deep = 0;
      while (!stack.isEmpty() || !oddStack.isEmpty()) {
        while (!oddStack.isEmpty()) {
          TreeNode treeNode = oddStack.pop();
          getList(list, deep).add(treeNode.val);
          if (treeNode.left != null) {
            stack.push(treeNode.left);
          }
          if (treeNode.right != null) {
            stack.push(treeNode.right);
          }
        }
        deep++;
        while (!stack.isEmpty()) {
          TreeNode treeNode = stack.pop();
          getList(list, deep).add(treeNode.val);
          if (treeNode.right != null) {
            oddStack.push(treeNode.right);
          }
          if (treeNode.left != null) {
            oddStack.push(treeNode.left);
          }
        }
        deep++;
      }
      return list;
    }

    private List<Integer> getList(List<List<Integer>> list, int deep) {
      if (list.size() < deep + 1) {
        list.add(new ArrayList<>());
      }
      return list.get(deep);
    }
  }
}
