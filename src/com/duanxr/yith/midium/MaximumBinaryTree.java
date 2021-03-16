package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/3/10
 */
public class MaximumBinaryTree {

  /**
   * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
   *
   * Create a root node whose value is the maximum value in nums.
   * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
   * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
   * Return the maximum binary tree built from nums.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: nums = [3,2,1,6,0,5]
   * Output: [6,3,5,null,2,0,null,null,1]
   * Explanation: The recursive calls are as follow:
   * - The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
   *     - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
   *         - Empty array, so no child.
   *         - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
   *             - Empty array, so no child.
   *             - Only one element, so child is a node with value 1.
   *     - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
   *         - Only one element, so child is a node with value 0.
   *         - Empty array, so no child.
   * Example 2:
   *
   *
   * Input: nums = [3,2,1]
   * Output: [3,null,2,null,1]
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 1000
   * 0 <= nums[i] <= 1000
   * All integers in nums are unique.
   *
   * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
   *
   * 二叉树的根是数组 nums 中的最大元素。
   * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
   * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
   * 返回有给定数组 nums 构建的 最大二叉树 。
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：nums = [3,2,1,6,0,5]
   * 输出：[6,3,5,null,2,0,null,null,1]
   * 解释：递归调用如下所示：
   * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
   *     - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
   *         - 空数组，无子节点。
   *         - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
   *             - 空数组，无子节点。
   *             - 只有一个元素，所以子节点是一个值为 1 的节点。
   *     - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
   *         - 只有一个元素，所以子节点是一个值为 0 的节点。
   *         - 空数组，无子节点。
   * 示例 2：
   *
   *
   * 输入：nums = [3,2,1]
   * 输出：[3,null,2,null,1]
   *  
   *
   * 提示：
   *
   * 1 <= nums.length <= 1000
   * 0 <= nums[i] <= 1000
   * nums 中的所有整数 互不相同
   *
   */
  class Solution {

    class Num {
      private int value;
      private int point;
    }

    class PointTreeNode extends TreeNode {

      public int point;
      public int val;
      public PointTreeNode left;
      public PointTreeNode right;

      public PointTreeNode(int x) {
        super(x);
      }

      public PointTreeNode(int x, int p) {
        super(x);
        this.point = p;
      }

      public PointTreeNode findSubNode(PointTreeNode newNode) {
        return newNode.point > this.point ? right : left;
      }

      public void setSubNode(PointTreeNode newNode) {
        if (newNode.point > this.point) {
          right = newNode;
          super.right = newNode;
        } else {
          left = newNode;
          super.left = newNode;
        }
      }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
      List<Num> list = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        Num n = new Num();
        n.value = num;
        n.point = i;
        list.add(n);
      }
      list.sort((o1, o2) -> o2.value-o1.value);
      Num firstNum = list.get(0);
      PointTreeNode root = new PointTreeNode(firstNum.value, firstNum.point);
      for (int i = 1; i < list.size(); i++) {
        Num num = list.get(i);
        PointTreeNode currentNode = root;
        PointTreeNode numNode = new PointTreeNode(num.value, num.point);
        while (true) {
          PointTreeNode nextNode = currentNode.findSubNode(numNode);
          if (nextNode == null) {
            currentNode.setSubNode(numNode);
            break;
          }
          currentNode = nextNode;
        }
      }
      return root;
    }
  }
}
