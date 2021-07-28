package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 段然 2021/7/28
 */
public class AllNodesDistanceKInBinaryTree {

  /**
   * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
   *
   * You can return the answer in any order.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
   * Output: [7,4,1]
   * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
   * Example 2:
   *
   * Input: root = [1], target = 1, k = 3
   * Output: []
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [1, 500].
   * 0 <= Node.val <= 500
   * All the values Node.val are unique.
   * target is the value of one of the nodes in the tree.
   * 0 <= k <= 1000
   *
   * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
   *
   * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
   * 输出：[7,4,1]
   * 解释：
   * 所求结点为与目标结点（值为 5）距离为 2 的结点，
   * 值分别为 7，4，以及 1
   *
   *
   *
   * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
   * 上面的输入仅仅是对这些对象进行了序列化描述。
   *  
   *
   * 提示：
   *
   * 给定的树是非空的。
   * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
   * 目标结点 target 是树上的结点。
   * 0 <= K <= 1000.
   *
   */
  class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      List<Integer> list = new ArrayList<>();
      if (k == 0) {
        list.add(target.val);
      } else {
        Stack<TreeNode> stack = new Stack<>();
        findPath(root, target, stack);
        int ik = 0;
        int[] visited = new int[501];
        while (!stack.isEmpty()) {
          TreeNode treeNode = stack.pop();
          findLower(treeNode, k - (ik++), list, visited);
        }
      }
      return list;
    }

    private boolean findPath(TreeNode root, TreeNode target, Stack<TreeNode> stack) {
      if (root == null) {
        return false;
      }
      stack.push(root);
      if (target == root) {
        return true;
      }
      boolean isFind = findPath(root.left, target, stack) || findPath(root.right, target, stack);
      if (!isFind) {
        stack.pop();
      }
      return isFind;
    }


    private void findLower(TreeNode root, int k, List<Integer> list, int[] visited) {
      if (root != null && visited[root.val] == 0) {
        visited[root.val] = 1;
        if (k == 0) {
          list.add(root.val);
        } else {
          int k1 = k - 1;
          findLower(root.left, k1, list, visited);
          findLower(root.right, k1, list, visited);
        }
      }
    }
  }
}
