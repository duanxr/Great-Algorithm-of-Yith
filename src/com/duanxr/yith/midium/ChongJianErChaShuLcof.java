package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.Arrays;

/**
 * @author 段然 2021/3/15
 */
public class ChongJianErChaShuLcof {

  /**
   * English description is not available for the problem.
   *
   * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
   *
   *  
   *
   * 例如，给出
   *
   * 前序遍历 preorder = [3,9,20,15,7]
   * 中序遍历 inorder = [9,3,15,20,7]
   * 返回如下的二叉树：
   *
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   *  
   *
   * 限制：
   *
   * 0 <= 节点个数 <= 5000
   *
   *  
   *
   * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
   *
   */
  class Solution {

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
      if (preorder.length == 0) {
        return null;
      }
      TreeNode root = new TreeNode(preorder[0]);
      int i = findRoot(inorder, preorder[0]);
      if (i > 0) {
        root.left = buildTree1(Arrays.copyOfRange(preorder, 1, i + 1),
            Arrays.copyOfRange(inorder, 0, i));
      }
      if (i != -1 && inorder.length - 1 != i) {
        root.right = buildTree1(Arrays.copyOfRange(preorder, i + 1, preorder.length),
            Arrays.copyOfRange(inorder, i + 1, inorder.length));
      }
      return root;
    }

    private int findRoot(int[] inorder, int key) {
      for (int i = 0; i < inorder.length; i++) {
        if (inorder[i] == key) {
          return i;
        }
      }
      return -1;
    }

  }
}
