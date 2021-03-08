package com.duanxr.yith.easy;

import com.duanxr.yith.define.nAryTree.Node;

/**
 * @author 段然 2021/3/8
 */
public class MaximumDepthOfNAryTree {

  /**
   * Given a n-ary tree, find its maximum depth.
   *
   * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
   *
   * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
   *
   *  
   *
   * Example 1:
   *
   *
   *
   * Input: root = [1,null,3,2,4,null,5,6]
   * Output: 3
   * Example 2:
   *
   *
   *
   * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
   * Output: 5
   *  
   *
   * Constraints:
   *
   * The depth of the n-ary tree is less than or equal to 1000.
   * The total number of nodes is between [0, 104].
   *
   * 给定一个 N 叉树，找到其最大深度。
   *
   * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
   *
   * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
   *
   *  
   *
   * 示例 1：
   *
   *
   *
   * 输入：root = [1,null,3,2,4,null,5,6]
   * 输出：3
   * 示例 2：
   *
   *
   *
   * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
   * 输出：5
   *  
   *
   * 提示：
   *
   * 树的深度不会超过 1000 。
   * 树的节点数目位于 [0, 104] 之间。
   *
   */
  class Solution {

    public int maxDepth(Node root) {
      if (root == null) {
        return 0;
      }
      int d = 0;
      for (Node node : root.children) {
        d = Math.max(d, maxDepth(node));
      }
      return d + 1;
    }
  }
}
