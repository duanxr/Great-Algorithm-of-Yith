package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 段然 2021/3/8
 */
public class BinaryTreePaths {

  /**
   * Given a binary tree, return all root-to-leaf paths.
   *
   * Note: A leaf is a node with no children.
   *
   * Example:
   *
   * Input:
   *
   *    1
   *  /   \
   * 2     3
   *  \
   *   5
   *
   * Output: ["1->2->5", "1->3"]
   *
   * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
   *
   * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
   *
   * 说明: 叶子节点是指没有子节点的节点。
   *
   * 示例:
   *
   * 输入:
   *
   *    1
   *  /   \
   * 2     3
   *  \
   *   5
   *
   * 输出: ["1->2->5", "1->3"]
   *
   * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
   *
   */
  class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
      LinkedList<String> strings = new LinkedList<>();
      stringBuilder = new StringBuilder();
      findPath(strings, root, "");
      return strings;
    }

    private StringBuilder stringBuilder;

    private void findPath(LinkedList<String> strings, TreeNode root, String rootPath) {
      if (root == null) {
        return;
      }
      stringBuilder.setLength(0);
      if (rootPath.length() != 0) {
        stringBuilder.append(rootPath).append("->");
      }
      stringBuilder.append(root.val);
      String nowPath = stringBuilder.toString();
      if (root.left == null && root.right == null) {
        strings.add(nowPath);
      }
      findPath(strings, root.right, nowPath);
      findPath(strings, root.left, nowPath);
    }
  }
}
