package com.duanxr.yith.middle;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 段然 2021/3/12
 */
public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {

  /**
   * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
   *
   *  
   *
   * 示例:
   * 给定如下二叉树，以及目标和 target = 22，
   *
   *               5
   *              / \
   *             4   8
   *            /   / \
   *           11  13  4
   *          /  \    / \
   *         7    2  5   1
   * 返回:
   *
   * [
   *    [5,4,11,2],
   *    [5,8,4,5]
   * ]
   *  
   *
   * 提示：
   *
   * 节点总数 <= 10000
   * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
   *
   */
  class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
      if (root == null) {
        return Collections.emptyList();
      }
      List<List<Integer>> lists = new ArrayList<>();
      LinkedList<TreeNode> linkedList = new LinkedList<>();
      findPath(root, 0, target, lists, linkedList);
      return lists;
    }

    private void findPath(TreeNode root, int currentSum, int target, List<List<Integer>> lists,
        LinkedList<TreeNode> linkedList) {
      if (root == null) {
        return;
      }
      linkedList.push(root);
      currentSum += root.val;
      if (currentSum == target && root.left == null && root.right == null) {
        List<Integer> list = new ArrayList<>(linkedList.size());
        for (int i = linkedList.size() - 1; i >= 0; i--) {
          TreeNode node = linkedList.get(i);
          list.add(node.val);
        }
        lists.add(list);
      }
      findPath(root.left, currentSum, target, lists, linkedList);
      findPath(root.right, currentSum, target, lists, linkedList);
      linkedList.pop();
    }
  }
}
