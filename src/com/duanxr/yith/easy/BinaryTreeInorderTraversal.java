package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/7/28
 */
public class BinaryTreeInorderTraversal {

  /**
   * Given the root of a binary tree, return the inorder traversal of its nodes' values.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [1,null,2,3]
   * Output: [1,3,2]
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
   * Output: [2,1]
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
   * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：root = [1,null,2,3]
   * 输出：[1,3,2]
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
   * 输出：[2,1]
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
   * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
   *
   */
  class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> list = new ArrayList<>();
      find(root, list);
      return list;
    }

    private void find(TreeNode root, List<Integer> list) {
      if (root == null) {
        return;
      }
      list.add(root.val);
      find(root.left, list);
      find(root.right, list);
    }
  }
}
