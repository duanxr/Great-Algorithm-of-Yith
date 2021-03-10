package com.duanxr.yith.middle;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 段然 2021/3/10
 */
public class BinaryTreePreorderTraversal {

  /**
   * Given the root of a binary tree, return the preorder traversal of its nodes' values.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [1,null,2,3]
   * Output: [1,2,3]
   * Example 2:
   *
   * Input: root = []
   * Output: []
   * Example 3:
   *
   * Input: root = [1]
   * Output: [1]
   * Example 4:
   *
   *
   * Input: root = [1,2]
   * Output: [1,2]
   * Example 5:
   *
   *
   * Input: root = [1,null,2]
   * Output: [1,2]
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [0, 100].
   * -100 <= Node.val <= 100
   *  
   *
   * Follow up: Recursive solution is trivial, could you do it iteratively?
   *
   * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：root = [1,null,2,3]
   * 输出：[1,2,3]
   * 示例 2：
   *
   * 输入：root = []
   * 输出：[]
   * 示例 3：
   *
   * 输入：root = [1]
   * 输出：[1]
   * 示例 4：
   *
   *
   * 输入：root = [1,2]
   * 输出：[1,2]
   * 示例 5：
   *
   *
   * 输入：root = [1,null,2]
   * 输出：[1,2]
   *  
   *
   * 提示：
   *
   * 树中节点数目在范围 [0, 100] 内
   * -100 <= Node.val <= 100
   *  
   *
   * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
   *
   */
  class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> list = new ArrayList<>();
      if (root == null) {
        return list;
      }
      Stack<TreeNode> stack = new Stack<>();
      stack.add(root);
      while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        list.add(node.val);
        if (node.right != null) {
          stack.push(node.right);

        }
        if (node.left != null) {
          stack.push(node.left);

        }

      }
      return list;
    }
  }
}
