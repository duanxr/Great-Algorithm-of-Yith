package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/11
 */
public class ShuDeZiJieGouLcof {

  /**
   * English description is not available for the problem.
   *
   * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
   *
   * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
   *
   * 例如:
   * 给定的树 A:
   *
   *      3
   *     / \
   *    4   5
   *   / \
   *  1   2
   * 给定的树 B：
   *
   *    4 
   *   /
   *  1
   * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
   *
   * 示例 1：
   *
   * 输入：A = [1,2,3], B = [3,1]
   * 输出：false
   * 示例 2：
   *
   * 输入：A = [3,4,5,1,2], B = [4,1]
   * 输出：true
   * 限制：
   *
   * 0 <= 节点个数 <= 10000
   *
   */
  class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
      if (A == null || B == null) {
        return false;
      }
      return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode a, TreeNode b) {
      if (a == null && b != null) {
        return false;
      } else if (b == null) {
        return true;
      }
      return a.val == b.val && recur(a.left, b.left) && recur(a.right, b.right);
    }
  }
}
