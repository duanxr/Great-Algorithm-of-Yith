package com.duanxr.yith.hard;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.Arrays;

/**
 * @author 段然 2021/9/26
 */
public class MaximumSumBSTInBinaryTree {

  /**
   * Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
   *
   * Assume a BST is defined as follows:
   *
   * The left subtree of a node contains only nodes with keys less than the node's key.
   * The right subtree of a node contains only nodes with keys greater than the node's key.
   * Both the left and right subtrees must also be binary search trees.
   *  
   *
   * Example 1:
   *
   *
   *
   * Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
   * Output: 20
   * Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.
   * Example 2:
   *
   *
   *
   * Input: root = [4,3,null,1,2]
   * Output: 2
   * Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.
   * Example 3:
   *
   * Input: root = [-4,-2,-5]
   * Output: 0
   * Explanation: All values are negatives. Return an empty BST.
   * Example 4:
   *
   * Input: root = [2,1,3]
   * Output: 6
   * Example 5:
   *
   * Input: root = [5,4,8,3,null,6,3]
   * Output: 7
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [1, 4 * 104].
   * -4 * 104 <= Node.val <= 4 * 104
   *
   * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
   *
   * 二叉搜索树的定义如下：
   *
   * 任意节点的左子树中的键值都 小于 此节点的键值。
   * 任意节点的右子树中的键值都 大于 此节点的键值。
   * 任意节点的左子树和右子树都是二叉搜索树。
   *  
   *
   * 示例 1：
   *
   *
   *
   * 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
   * 输出：20
   * 解释：键值为 3 的子树是和最大的二叉搜索树。
   * 示例 2：
   *
   *
   *
   * 输入：root = [4,3,null,1,2]
   * 输出：2
   * 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
   * 示例 3：
   *
   * 输入：root = [-4,-2,-5]
   * 输出：0
   * 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
   * 示例 4：
   *
   * 输入：root = [2,1,3]
   * 输出：6
   * 示例 5：
   *
   * 输入：root = [5,4,8,3,null,6,3]
   * 输出：7
   *  
   *
   * 提示：
   *
   * 每棵树有 1 到 40000 个节点。
   * 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。
   *
   */
  class Solution {

    public int maxSumBST(TreeNode root) {
      return Math.max(0, maxSumBST0(root)[4]);
    }

    public int[] maxSumBST0(TreeNode root) {
      if (root == null) {
        return null;
      }
      int[] re = new int[5];
      re[0] = root.val;
      re[1] = root.val;
      re[2] = root.val;
      re[3] = 0;
      re[4] = 0;
      int[] le = maxSumBST0(root.left);
      int[] ri = maxSumBST0(root.right);
      if (le != null) {
        if (le[0] > re[0]) {
          re[0] = le[0];
        }
        if (le[1] < re[1]) {
          re[1] = le[1];
        }
      }
      if (ri != null) {
        if (ri[0] > re[0]) {
          re[0] = ri[0];
        }
        if (ri[1] < re[1]) {
          re[1] = ri[1];
        }
      }
      boolean lb = le == null || (le[0] < root.val && le[3] == 1);
      boolean rb = ri == null || (ri[1] > root.val && ri[3] == 1);
      if (lb && rb) {
        re[3] = 1;
        re[2] += le == null ? 0 : le[2];
        re[2] += ri == null ? 0 : ri[2];
        if (le != null && le[4] > re[2]) {
          re[4] = le[4];
        } else if (ri != null && ri[4] > re[2]) {
          re[4] = ri[4];
        } else {
          re[4] = re[2];
        }
      } else {
        if (le != null && ri != null) {
          re[4] = Math.max(le[4], ri[4]);
        } else if (le != null) {
          re[4] = le[4];
        } else {
          re[4] = ri[4];
        }
      }
      return re;
    }
  }


  class Solution1 {

    public int maxSumBST(TreeNode root) {
      return Math.max(0, maxSumBST0(root)[4]);
    }

    public int[] maxSumBST0(TreeNode root) {
      if (root == null) {
        return null;
      }
      int[] re = new int[5];
      re[0] = root.val;
      re[1] = root.val;
      re[2] = root.val;
      re[3] = 0;
      re[4] = 0;
      int[] le = maxSumBST0(root.left);
      int[] ri = maxSumBST0(root.right);
      if (le != null) {
        if (le[0] > re[0]) {
          re[0] = le[0];
        }
        if (le[1] < re[1]) {
          re[1] = le[1];
        }
      }
      if (ri != null) {
        if (ri[0] > re[0]) {
          re[0] = ri[0];
        }
        if (ri[1] < re[1]) {
          re[1] = ri[1];
        }
      }

      boolean lb = le == null || (le[0] < root.val && le[3] == 1);
      boolean rb = ri == null || (ri[1] > root.val && ri[3] == 1);
      boolean isBalanced = lb && rb;
      if (isBalanced) {
        re[3] = 1;
        re[2] += le == null ? 0 : le[2];
        re[2] += ri == null ? 0 : ri[2];
        re[4] = Math.max(Math.max(le != null ? le[4] : Integer.MIN_VALUE,
            ri != null ? ri[4] : Integer.MIN_VALUE), re[2]);
      } else {
        if (le != null && ri != null) {
          re[4] = Math.max(le[4], ri[4]);
        } else if (le != null) {
          re[4] = le[4];
        } else {
          re[4] = ri[4];
        }
      }
      System.out.println(root.val);
      System.out.println(Arrays.toString(re));
      return re;
    }
  }


  class Solution_2 {

    public int maxSumBST(TreeNode root) {
      return maxSumBST0(root)[4];
    }

    public int[] maxSumBST0(TreeNode root) {
      int[] re = new int[5];
      re[0] = root.val;
      re[1] = root.val;
      re[2] = root.val;
      re[3] = 1;
      re[4] = 0;
      if (root.left != null) {
        int[] le = maxSumBST0(root.left);
        if (le[0] > re[0]) {
          re[0] = le[0];
        }
        if (le[1] < re[1]) {
          re[1] = le[1];
        }
        re[2] += le[2];
        if (le[0] < root.val && le[3] == 1) {
          re[4] = le[2] + root.val;
        } else {
          re[3] = 1;
          re[4] = le[4];
        }
      }
      if (root.right != null) {
        int[] ri = maxSumBST0(root.right);
        if (ri[0] > re[0]) {
          re[0] = ri[0];
        }
        if (ri[1] < re[1]) {
          re[1] = ri[1];
        }
        re[2] += ri[2];
        if (ri[1] > root.val && ri[3] == 1) {
          re[4] = ri[2] + root.val;
        } else {
          re[3] = 1;
          re[4] = Math.max(re[4], ri[4]);
          return re;
        }
      }
      System.out.println(Arrays.toString(re));
      return re;
    }
  }


  class Solution_1 {

    public int maxSumBST(TreeNode root) {
      return maxSumBST0(root)[4];
    }

    public int[] maxSumBST0(TreeNode root) {
      int[] re = new int[5];
      re[0] = root.val;
      re[1] = root.val;
      re[2] = root.val;
      re[3] = 0;
      re[4] = root.val;
      if (root.left != null && root.right != null) {
        int[] le = maxSumBST0(root.left);
        if (le[0] > re[0]) {
          re[0] = le[0];
        }
        if (le[1] < re[1]) {
          re[1] = le[1];
        }
        re[2] += le[2];
        if (le[0] < root.val) {
          re[4] += le[2];
          re[3] = le[3];
        } else {
          re[4] = le[4];
          return re;
        }
        int[] ri = maxSumBST0(root.right);
        if (ri[0] > re[0]) {
          re[0] = ri[0];
        }
        if (ri[1] < re[1]) {
          re[1] = ri[1];
        }
        re[2] += ri[2];
        if (ri[1] > root.val) {
          re[4] += ri[2];
          re[3] = ri[3];
        } else {
          re[4] = ri[4];
          return re;
        }
      } else if (root.left != null) {
        int[] le = maxSumBST0(root.left);
        if (le[0] > re[0]) {
          re[0] = le[0];
        }
        if (le[1] < re[1]) {
          re[1] = le[1];
        }
        re[2] += le[2];
        if (le[0] < root.val) {
          re[4] += le[2];
          re[3] = le[3];
        } else {
          re[4] = le[4];
          return re;
        }
      } else if (root.right != null) {
        int[] ri = maxSumBST0(root.right);
        if (ri[0] > re[0]) {
          re[0] = ri[0];
        }
        if (ri[1] < re[1]) {
          re[1] = ri[1];
        }
        re[2] += ri[2];
        if (ri[1] > root.val) {
          re[4] += ri[2];
          re[3] = ri[3];
        } else {
          re[4] = ri[4];
          return re;
        }
      }

      return re;
    }
  }
}
