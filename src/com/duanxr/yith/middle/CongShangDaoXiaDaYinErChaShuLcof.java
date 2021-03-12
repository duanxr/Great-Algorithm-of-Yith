package com.duanxr.yith.middle;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author 段然 2021/3/12
 */
public class CongShangDaoXiaDaYinErChaShuLcof {

  /**
   * English description is not available for the problem.
   *
   * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
   * 返回：
   *
   * [3,9,20,15,7]
   *  
   *
   * 提示：
   *
   * 节点总数 <= 1000
   *
   */
  class Solution {

    public int[] levelOrder(TreeNode root) {
      if (root == null) {
        return new int[0];
      }
      List<Integer> list = new ArrayList<>();
      TreeNode current = root;
      Queue<TreeNode> queue = new ArrayDeque<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode poll = queue.poll();
          list.add(poll.val);
          if (poll.left != null) {
            queue.offer(poll.left);
          }
          if (poll.right != null) {
            queue.offer(poll.right);
          }
        }
      }

      int[] result = new int[list.size()];
      for (int i = 0; i < list.size(); i++) {
        result[i] = list.get(i);
      }
      return result;
    }
  }
}
