package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.Arrays;

/**
 * @author 段然 2021/9/16
 */
public class ConstructBinaryTreefromInorderAndPostorderTraversal {

  /**
   * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
   * Output: [3,9,20,null,null,15,7]
   * Example 2:
   *
   * Input: inorder = [-1], postorder = [-1]
   * Output: [-1]
   *  
   *
   * Constraints:
   *
   * 1 <= inorder.length <= 3000
   * postorder.length == inorder.length
   * -3000 <= inorder[i], postorder[i] <= 3000
   * inorder and postorder consist of unique values.
   * Each value of postorder also appears in inorder.
   * inorder is guaranteed to be the inorder traversal of the tree.
   * postorder is guaranteed to be the postorder traversal of the tree.
   *
   * 根据一棵树的中序遍历与后序遍历构造二叉树。
   *
   * 注意:
   * 你可以假设树中没有重复的元素。
   *
   * 例如，给出
   *
   * 中序遍历 inorder = [9,3,15,20,7]
   * 后序遍历 postorder = [9,15,7,20,3]
   * 返回如下的二叉树：
   *
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   *
   */
  class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
      int length = inorder.length;
      return buildTree0(inorder, 0, length, postorder, 0, length);
    }

    private TreeNode buildTree0(int[] inorder, int il, int ir, int[] postorder, int pl,
        int pr) {
      int pr_1 = pr - 1;
      int val = postorder[pr_1];
      TreeNode treeNode = new TreeNode(val);
      int n = il;
      for (int i = il; i < ir; i++) {
        if (inorder[i] == val) {
          n = i;
          break;
        }
      }
      int offset = pl - il;
      int n__o = n + offset;
      if (n > il) {
        treeNode.left = buildTree0(inorder, il, n, postorder, pl, n__o);
      }
      if (n != ir - 1) {
        treeNode.right = buildTree0(inorder, n + 1, ir, postorder, n__o, pr_1);
      }
      return treeNode;
    }
  }

  class Solution_1 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
      int length = inorder.length;
      return buildTree0(inorder, 0, length, postorder, 0, length);
    }

    private TreeNode buildTree0(int[] inorder, int il, int ir, int[] postorder, int pl,
        int pr) {
      System.out.println(Arrays.toString(Arrays.copyOfRange(inorder,il,ir)));
      System.out.println(Arrays.toString(Arrays.copyOfRange(postorder,pl,pr)));
      System.out.println("+++++++++++++");
      int val = postorder[pr - 1];
      TreeNode treeNode = new TreeNode(val);
      int offset = pl - il;
      int n = search(inorder, postorder, il, ir, offset, val);
      if (n > il) {
        treeNode.left = buildTree0(inorder, il, n, postorder, pl, n + offset);
      }
      if (n != ir - 1) {
        treeNode.right = buildTree0(inorder, n + 1, ir, postorder, n + offset, pr - 1);
      }
      return treeNode;
    }

    private int search(int[] inorder, int[] postorder, int il, int ir, int offset, int val) {
      int low = il;
      int high = ir - 1;
      while (low <= high) {
        int mid = (low + high) >>> 1;
        int midVal = inorder[mid];
        if (val == midVal) {
          return mid;
        } else if (val == postorder[mid + offset]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      return -(low + 1);
    }
  }


  class Solution1 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
      /*System.out.println(Arrays.toString(inorder));
      System.out.println(Arrays.toString(postorder));
      System.out.println("+++++++++++++");*/
      if (postorder.length == 0) {
        return null;
      }
      int val = postorder[postorder.length - 1];
      TreeNode treeNode = new TreeNode(val);
      int n = 0;
      for (int i = 0; i < inorder.length; i++) {
        if (inorder[i] == val) {
          n = i;
          break;
        }
      }
      if (n > 0) {
        int[] inorderL = Arrays.copyOfRange(inorder, 0, n);
        int[] postorderL = Arrays.copyOfRange(postorder, 0, n);
        treeNode.left = buildTree(inorderL, postorderL);
      }
      if (n != inorder.length - 1) {
        int[] inorderR = Arrays.copyOfRange(inorder, n + 1, inorder.length);
        int[] postorderR = Arrays.copyOfRange(postorder, n, postorder.length - 1);
        treeNode.right = buildTree(inorderR, postorderR);
      }
      return treeNode;
    }
  }
}
