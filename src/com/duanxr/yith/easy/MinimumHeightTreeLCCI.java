package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.Arrays;

/**
 * @author 段然 2021/3/17
 */
public class MinimumHeightTreeLCCI {

  /**
   * Given a sorted (increasing order) array with unique integer elements, write an algo­rithm to create a binary search tree with minimal height.
   *
   * Example:
   *
   * Given sorted array: [-10,-3,0,5,9],
   *
   * One possible answer is: [0,-3,9,-10,null,5]，which represents the following tree:
   *
   *           0
   *          / \
   *        -3   9
   *        /   /
   *      -10  5
   *
   * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
   *
   * 示例:
   * 给定有序数组: [-10,-3,0,5,9],
   *
   * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
   *
   *           0
   *          / \
   *        -3   9
   *        /   /
   *      -10  5
   */
  class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
      if (nums.length == 0) {
        return null;
      }
      int l = 0;
      int r = nums.length - 1;
      int i = r / 2;
      TreeNode treeNode = new TreeNode(nums[i]);
      if (i > 0) {
        treeNode.left = sortedArrayToBST(Arrays.copyOfRange(nums, l, i));
      }
      if (i < nums.length - 1) {
        treeNode.right = sortedArrayToBST(Arrays.copyOfRange(nums, i + 1, nums.length));
      }
      return treeNode;
    }
  }
}
