package com.duanxr.yith.midium;

import java.util.Arrays;

/**
 * @author 段然 2021/5/18
 */
public class VerifyPreorderSequenceInBinarySearchTree {

  /**
   * Given an array of unique integers preorder, return true if it is the correct preorder traversal sequence of a binary search tree.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: preorder = [5,2,1,3,6]
   * Output: true
   * Example 2:
   *
   * Input: preorder = [5,2,6,1,3]
   * Output: false
   *  
   *
   * Constraints:
   *
   * 1 <= preorder.length <= 104
   * 1 <= preorder[i] <= 104
   * All the elements of preorder are unique.
   *  
   *
   * Follow up: Could you do it using only constant space complexity?
   *
   * 给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。
   *
   * 你可以假定该序列中的数都是不相同的。
   *
   * 参考以下这颗二叉搜索树：
   *
   *      5
   *     / \
   *    2   6
   *   / \
   *  1   3
   * 示例 1：
   *
   * 输入: [5,2,6,1,3]
   * 输出: false
   * 示例 2：
   *
   * 输入: [5,2,1,3,6]
   * 输出: true
   * 进阶挑战：
   *
   * 您能否使用恒定的空间复杂度来完成此题？
   *
   */
  class Solution {

    public boolean verifyPreorder(int[] preorder) {
      return verifyPreorder(preorder, 0, preorder.length);
    }

    public boolean verifyPreorder(int[] preorder, int le, int ri) {
      if (ri - le <= 1) {
        return true;
      }
      int r = preorder[le];
      int p = ri;
      boolean fp = false;
      for (int i = le; i < ri; i++) {
        if (!fp && preorder[i] > r) {
          p = i;
          fp = true;
        } else if (fp && preorder[i] < r) {
          return false;
        }
      }
      return verifyPreorder(preorder, le + 1, p) && verifyPreorder(preorder, p, ri);
    }
  }


  class Solution1 {

    public boolean verifyPreorder(int[] preorder) {
      if (preorder.length <= 1) {
        return true;
      }
      int r = preorder[0];
      int p = preorder.length;
      boolean fp = false;
      for (int i = 0; i < preorder.length; i++) {
        if (!fp && preorder[i] > r) {
          p = i;
          fp = true;
        } else if (fp && preorder[i] < r) {
          return false;
        }
      }
      return verifyPreorder(Arrays.copyOfRange(preorder, 1, p)) && verifyPreorder(
          Arrays.copyOfRange(preorder, p, preorder.length));
    }
  }
}
