package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.LinkedList;

/**
 * @author 段然 2021/3/8
 */
public class SameTree {

  /**
   * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
   *
   * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: p = [1,2,3], q = [1,2,3]
   * Output: true
   * Example 2:
   *
   *
   * Input: p = [1,2], q = [1,null,2]
   * Output: false
   * Example 3:
   *
   *
   * Input: p = [1,2,1], q = [1,1,2]
   * Output: false
   *  
   *
   * Constraints:
   *
   * The number of nodes in both trees is in the range [0, 100].
   * -104 <= Node.val <= 104
   *
   * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
   *
   * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：p = [1,2,3], q = [1,2,3]
   * 输出：true
   * 示例 2：
   *
   *
   * 输入：p = [1,2], q = [1,null,2]
   * 输出：false
   * 示例 3：
   *
   *
   * 输入：p = [1,2,1], q = [1,1,2]
   * 输出：false
   *  
   *
   * 提示：
   *
   * 两棵树上的节点数目都在范围 [0, 100] 内
   * -104 <= Node.val <= 104
   *
   */
  class Solution {

    private boolean nullCheck(Object a, Object b) {
      if (a == null) {
        return b == null;
      }
      return b != null;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
      LinkedList<TreeNode> ql = new LinkedList<>();
      LinkedList<TreeNode> pl = new LinkedList<>();
      ql.push(q);
      pl.push(p);
      while (!ql.isEmpty() && !pl.isEmpty()) {
        TreeNode qq = ql.pop();
        TreeNode pp = pl.pop();
        if (!nullCheck(qq, pp)) {
          return false;
        }
        if (qq != null) {
          if (qq.val != pp.val) {
            return false;
          }
          ql.push(qq.left);
          pl.push(pp.left);
          ql.push(qq.right);
          pl.push(pp.right);
        }
      }
      return true;
    }
  }
}
