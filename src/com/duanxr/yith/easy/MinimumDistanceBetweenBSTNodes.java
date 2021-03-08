package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/3/8
 */
public class MinimumDistanceBetweenBSTNodes {

  /**
   * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
   *
   * Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [4,2,6,1,3]
   * Output: 1
   * Example 2:
   *
   *
   * Input: root = [1,0,48,null,null,12,49]
   * Output: 1
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [2, 100].
   * 0 <= Node.val <= 105
   *
   * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
   *
   *  
   *
   * 示例：
   *
   * 输入: root = [4,2,6,1,3,null,null]
   * 输出: 1
   * 解释:
   * 注意，root是树节点对象(TreeNode object)，而不是数组。
   *
   * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
   *
   *           4
   *         /   \
   *       2      6
   *      / \
   *     1   3
   *
   * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
   *  
   *
   * 注意：
   *
   * 二叉树的大小范围在 2 到 100。
   * 二叉树总是有效的，每个节点的值都是整数，且不重复。
   * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
   *
   */
  class Solution {

    public int minDiffInBST(TreeNode root) {
      int min = Integer.MAX_VALUE;
      List<Integer> array = new ArrayList<>();
      find(root, array);
      for (int i = 1; i < array.size(); i++) {
        min = Math.min(min, array.get(i) - array.get(i - 1));
      }
      return min;
    }

    private void find(TreeNode root, List<Integer> array) {
      if (root == null) {
        return;
      }
      find(root.left, array);
      array.add(root.val);
      find(root.right, array);
    }
  }
}
