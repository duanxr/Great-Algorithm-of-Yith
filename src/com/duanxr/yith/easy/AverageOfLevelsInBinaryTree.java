package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 段然 2021/3/8
 */
public class AverageOfLevelsInBinaryTree {

  /**
   * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
   * Example 1:
   * Input:
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   * Output: [3, 14.5, 11]
   * Explanation:
   * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
   * Note:
   * The range of node's value is in the range of 32-bit signed integer.
   *
   * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   * 输出：[3, 14.5, 11]
   * 解释：
   * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
   *  
   *
   * 提示：
   *
   * 节点值的范围在32位有符号整数范围内。
   *
   */
  class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
      LinkedList<LinkedList<Integer>> sumList = new LinkedList<>();
      find(root, sumList, 0);
      List<Double> result = new ArrayList<>(sumList.size());
      for (int i = 0; i < sumList.size(); i++) {
        List<Integer> floor = sumList.get(i);
        double sum = 0;
        double size = floor.size();
        for (int v : floor) {
          sum += v;
        }
        result.add(sum / size);
      }
      return result;
    }

    private void find(TreeNode root, LinkedList<LinkedList<Integer>> sumList, int i) {
      if (root == null) {
        return;
      }
      int deep = i + 1;
      LinkedList<Integer> nowFloor;
      if (sumList.size() < deep) {
        nowFloor = new LinkedList<>();
        nowFloor.add(root.val);
        sumList.add(nowFloor);
      } else {
        nowFloor = sumList.get(deep - 1);
        nowFloor.add(root.val);
      }
      find(root.left, sumList, deep);
      find(root.right, sumList, deep);
    }

  }
}
