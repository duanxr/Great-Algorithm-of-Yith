package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 段然 2021/3/8
 */
public class LeafSimilarTrees {

  /**
   * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
   *
   *
   *
   * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
   *
   * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
   *
   * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
   * Output: true
   * Example 2:
   *
   * Input: root1 = [1], root2 = [1]
   * Output: true
   * Example 3:
   *
   * Input: root1 = [1], root2 = [2]
   * Output: false
   * Example 4:
   *
   * Input: root1 = [1,2], root2 = [2,2]
   * Output: true
   * Example 5:
   *
   *
   * Input: root1 = [1,2,3], root2 = [1,3,2]
   * Output: false
   *  
   *
   * Constraints:
   *
   * The number of nodes in each tree will be in the range [1, 200].
   * Both of the given trees will have values in the range [0, 200].
   *
   * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
   *
   *
   *
   * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
   *
   * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
   *
   * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
   *
   *  
   *
   * 示例 1：
   *
   *
   *
   * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
   * 输出：true
   * 示例 2：
   *
   * 输入：root1 = [1], root2 = [1]
   * 输出：true
   * 示例 3：
   *
   * 输入：root1 = [1], root2 = [2]
   * 输出：false
   * 示例 4：
   *
   * 输入：root1 = [1,2], root2 = [2,2]
   * 输出：true
   * 示例 5：
   *
   *
   *
   * 输入：root1 = [1,2,3], root2 = [1,3,2]
   * 输出：false
   *  
   *
   * 提示：
   *
   * 给定的两棵树可能会有 1 到 200 个结点。
   * 给定的两棵树上的值介于 0 到 200 之间。
   *
   */
  class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      List<Integer> leaf1 = getLeaf(root1, new ArrayList<>());
      List<Integer> leaf2 = getLeaf(root2, new ArrayList<>());
      return leaf1.equals(leaf2);
    }

    private List<Integer> getLeaf(TreeNode root, ArrayList<Integer> list) {
      if (root == null) {
        return list;
      }
      if (root.left == null && root.right == null) {
        list.add(root.val);
      }
      getLeaf(root.left,list);
      getLeaf(root.right,list);
      return list;
    }
  }


  class Solution1 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      LinkedList<Integer> r1 = new LinkedList<>();
      LinkedList<Integer> r2 = new LinkedList<>();
      find(root1, r1);
      find(root2, r2);
      if (r1.size() != r2.size()) {
        return false;
      }
      Iterator i1 = r1.iterator();
      Iterator i2 = r2.iterator();
      while (i1.hasNext()) {
        if (i1.next() != i2.next()) {
          return false;
        }
      }
      return true;
    }

    public void find(TreeNode root, List<Integer> list) {
      if (root == null) {
        return;
      }
      if (root.left == null && root.right == null) {
        list.add(root.val);
        return;
      }
      find(root.left, list);
      find(root.right, list);
    }
  }
}
