package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/12
 */
public class ErChaShuDeJingXiangLcof {

  /**
   * English description is not available for the problem.
   *
   * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
   *
   * 例如输入：
   *
   *      4
   *    /   \
   *   2     7
   *  / \   / \
   * 1   3 6   9
   * 镜像输出：
   *
   *      4
   *    /   \
   *   7     2
   *  / \   / \
   * 9   6 3   1
   *
   *  
   *
   * 示例 1：
   *
   * 输入：root = [4,2,7,1,3,6,9]
   * 输出：[4,7,2,9,6,3,1]
   *  
   *
   * 限制：
   *
   * 0 <= 节点个数 <= 1000
   *
   * 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
   *
   */
  class Solution {

    public TreeNode mirrorTree(TreeNode root) {
      if (root == null) {
        return null;
      }
      TreeNode node = new TreeNode(root.val);
      node.right = mirrorTree(root.left);
      node.left = mirrorTree(root.right);
      return node;
    }
  }
}
