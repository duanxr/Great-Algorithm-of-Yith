package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 段然 2021/3/18
 */
public class CongShangDaoXiaDaYinErChaShuIILcof {

  /**
   * English description is not available for the problem.
   *
   * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
   *   [9,20],
   *   [15,7]
   * ]
   *  
   *
   * 提示：
   *
   * 节点总数 <= 1000
   * 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
   *
   */
  class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) {
        return Collections.emptyList();
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      List<List<Integer>> lists = new ArrayList<>();
      while (!queue.isEmpty())
      {
        ArrayList<Integer> list = new ArrayList<>();
        lists.add(list);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          list.add(node.val);
          if(node.left!=null)
          {
            queue.offer(node.left);
          }
          if(node.right!=null)
          {
            queue.offer(node.right);
          }
        }
      }
      return lists;
    }
  }
}
