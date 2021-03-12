package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.Stack;

/**
 * @author 段然 2021/3/12
 */
public class DuiChengDeErChaShuLcof {

  /**
   * English description is not available for the problem.
   *
   * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
   *
   * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
   *
   *     1
   *    / \
   *   2   2
   *  / \ / \
   * 3  4 4  3
   * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
   *
   *     1
   *    / \
   *   2   2
   *    \   \
   *    3    3
   *
   *  
   *
   * 示例 1：
   *
   * 输入：root = [1,2,2,3,4,4,3]
   * 输出：true
   * 示例 2：
   *
   * 输入：root = [1,2,2,null,3,null,3]
   * 输出：false
   *  
   *
   * 限制：
   *
   * 0 <= 节点个数 <= 1000
   *
   * 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
   */

  class Solution {

    public boolean isSymmetric(TreeNode root) {
      Stack<TreeNode> preorder = new Stack<>();
      Stack<TreeNode> postorder = new Stack<>();
      preorder.push(root);
      postorder.push(root);
      while (!preorder.isEmpty() || !postorder.isEmpty()) {
        if (preorder.isEmpty() ^ postorder.isEmpty()) {
          return false;
        }
        TreeNode pr = preorder.pop();
        TreeNode po = postorder.pop();
        if (po == null && pr == null) {
          continue;
        }
        if (po == null || pr == null) {
          return false;
        }
        if (po.val != pr.val) {
          return false;
        }
        preorder.push(pr.left);
        preorder.push(pr.right);
        postorder.push(po.right);
        postorder.push(po.left);
      }
      return true;
    }
  }
}
