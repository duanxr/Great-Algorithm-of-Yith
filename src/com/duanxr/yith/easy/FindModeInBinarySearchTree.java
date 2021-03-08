package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 段然 2021/3/8
 */
public class FindModeInBinarySearchTree {

  /**
   * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
   *
   * Assume a BST is defined as follows:
   *
   * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
   * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
   * Both the left and right subtrees must also be binary search trees.
   *  
   *
   * For example:
   * Given BST [1,null,2,2],
   *
   *    1
   *     \
   *      2
   *     /
   *    2
   *  
   *
   * return [2].
   *
   * Note: If a tree has more than one mode, you can return them in any order.
   *
   * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
   *
   * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
   *
   * 假定 BST 有如下定义：
   *
   * 结点左子树中所含结点的值小于等于当前结点的值
   * 结点右子树中所含结点的值大于等于当前结点的值
   * 左子树和右子树都是二叉搜索树
   * 例如：
   * 给定 BST [1,null,2,2],
   *
   *    1
   *     \
   *      2
   *     /
   *    2
   * 返回[2].
   *
   * 提示：如果众数超过1个，不需考虑输出顺序
   *
   * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
   *
   */
  class Solution {

    private Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
      find(root);
      List<Integer> list = new ArrayList<>();
      int max = Integer.MIN_VALUE;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() > max) {
          list.clear();
          max = entry.getValue();
        }
        if (entry.getValue() == max) {
          list.add(entry.getKey());
        }
      }
      return list.stream().mapToInt(i -> i).toArray();
    }


    private void find(TreeNode root) {
      if (root == null) {
        return;
      }
      add(root.val);
      find(root.left);
      find(root.right);
    }

    private void add(int val) {
      if (map.containsKey(val)) {
        map.put(val, map.get(val) + 1);
      } else {
        map.put(val, 1);
      }
    }
  }
}
