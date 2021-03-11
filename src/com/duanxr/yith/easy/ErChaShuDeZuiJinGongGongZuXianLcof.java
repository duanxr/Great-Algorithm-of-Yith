package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.Stack;

/**
 * @author 段然 2021/3/11
 */
public interface ErChaShuDeZuiJinGongGongZuXianLcof {

  /**
   * English description is not available for the problem.
   *
   * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
   *
   * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
   *
   * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
   *
   *
   *
   *  
   *
   * 示例 1:
   *
   * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
   * 输出: 3
   * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
   * 示例 2:
   *
   * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
   * 输出: 5
   * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
   *  
   *
   * 说明:
   *
   * 所有节点的值都是唯一的。
   * p、q 为不同节点且均存在于给定的二叉树中。
   * 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
   *
   */
  class Solution1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      Stack<TreeNode> sp = new Stack<>();
      Stack<TreeNode> sq = new Stack<>();
      findNode(root, p, q, sp, sq);
      while (sp.size() > sq.size()) {
        sp.pop();
      }
      while (sq.size() > sp.size()) {
        sq.pop();
      }
      while (!sq.isEmpty()) {
        TreeNode sqn = sq.pop();
        TreeNode spn = sp.pop();
        if (isEqual(spn, sqn)) {
          return spn;
        }
      }
      return null;
    }

    private void findNode(TreeNode root, TreeNode p, TreeNode q, Stack<TreeNode> sp,
        Stack<TreeNode> sq) {
      if (isFound(p, sp) && isFound(q, sq)) {
        return;
      }
      if (!isFound(p, sp)) {
        sp.push(root);
      }
      if (!isFound(q, sq)) {
        sq.push(root);
      }
      if (root.left != null) {
        findNode(root.left, p, q, sp, sq);
      }
      if (root.right != null) {
        findNode(root.right, p, q, sp, sq);
      }
      if (!isFound(p, sp)) {
        sp.pop();
      }
      if (!isFound(q, sq)) {
        sq.pop();
      }
    }

    private boolean isFound(TreeNode target, Stack<TreeNode> s) {
      return !s.isEmpty() && isEqual(s.peek(), target);
    }

    private boolean isEqual(TreeNode a, TreeNode b) {
      return a.val == b.val;
    }
  }
}
