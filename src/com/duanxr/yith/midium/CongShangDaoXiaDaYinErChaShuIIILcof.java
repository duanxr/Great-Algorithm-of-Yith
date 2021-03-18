package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author 段然 2021/3/18
 */
public class CongShangDaoXiaDaYinErChaShuIIILcof {

  /**
   * English description is not available for the problem.
   *
   * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
   *
   *  
   *
   * 例如:
   * 给定二叉树: [3,9,20,null,null,15,7],
   *
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   * 返回其层次遍历结果：
   *
   * [
   *   [3],
   *   [20,9],
   *   [15,7]
   * ]
   *  
   *
   * 提示：
   *
   * 节点总数 <= 1000
   */
  class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) {
        return Collections.emptyList();
      }
      List<List<Integer>> lists = new ArrayList<>();
      Stack<TreeNode> stackA = new Stack<>();
      Stack<TreeNode> stackB = new Stack<>();
      stackA.push(root);
      while (!stackA.isEmpty() || !stackB.isEmpty()) {
        if (!stackA.isEmpty()) {
          List<Integer> list = new ArrayList<>(stackA.size());
          while (!stackA.isEmpty()) {
            TreeNode node = stackA.pop();
            list.add(node.val);
            if (node.left != null) {
              stackB.push(node.left);
            }
            if (node.right != null) {
              stackB.push(node.right);
            }
          }
          lists.add(list);
        }
        if (!stackB.isEmpty()) {
          List<Integer> list = new ArrayList<>(stackB.size());
          while (!stackB.isEmpty()) {
            TreeNode node = stackB.pop();
            list.add(node.val);
            if (node.right != null) {
              stackA.push(node.right);
            }
            if (node.left != null) {
              stackA.push(node.left);
            }
          }
          lists.add(list);
        }
      }
      return lists;
    }
  }
}
