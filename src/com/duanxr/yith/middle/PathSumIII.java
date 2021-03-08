package com.duanxr.yith.middle;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;

/**
 * @author 段然 2021/3/8
 */
public class PathSumIII {
  /**
   * You are given a binary tree in which each node contains an integer value.
   *
   * Find the number of paths that sum to a given value.
   *
   * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
   *
   * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
   *
   * Example:
   *
   * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
   *
   *       10
   *      /  \
   *     5   -3
   *    / \    \
   *   3   2   11
   *  / \   \
   * 3  -2   1
   *
   * Return 3. The paths that sum to 8 are:
   *
   * 1.  5 -> 3
   * 2.  5 -> 2 -> 1
   * 3. -3 -> 11
   *
   * 给定一个二叉树，它的每个结点都存放着一个整数值。
   *
   * 找出路径和等于给定数值的路径总数。
   *
   * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
   *
   * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
   *
   * 示例：
   *
   * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
   *
   *       10
   *      /  \
   *     5   -3
   *    / \    \
   *   3   2   11
   *  / \   \
   * 3  -2   1
   *
   * 返回 3。和等于 8 的路径有:
   *
   * 1.  5 -> 3
   * 2.  5 -> 2 -> 1
   * 3.  -3 -> 11
   *
   */
  class Solution {

    public int pathSum(TreeNode root, int sum) {
      return sum(root,sum,new ArrayList<>());
    }

    int sum(TreeNode treeNode, int sum, ArrayList<Integer> integers)
    {
      if(treeNode==null)
      {
        return 0;
      }
      int v = treeNode.val;
      int r = v==sum?1:0;
      for (int i = integers.size()-1; i >=0 ; i--) {
        v+=integers.get(i);
        if(v==sum)
        {
          r++;
        }
      }
      integers.add(treeNode.val);
      r+=sum(treeNode.left,sum,integers);
      r+=sum(treeNode.right,sum,integers);
      integers.remove(integers.size()-1);
      return r;
    }
  }
}
