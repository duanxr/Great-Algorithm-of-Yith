package com.duanxr.yith.midium;

import java.util.Arrays;

/**
 * @author 段然 2021/3/17
 */
public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {

  /**
   * English description is not available for the problem.
   *
   * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
   *
   *  
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
   * 输入: [1,6,3,2,5]
   * 输出: false
   * 示例 2：
   *
   * 输入: [1,3,2,6,5]
   * 输出: true
   *  
   *
   * 提示：
   *
   * 数组长度 <= 1000
   *
   */
  class Solution {

    public boolean verifyPostorder(int[] postorder) {
      if (postorder.length <= 1) {
        return true;
      }
      int root = postorder[postorder.length - 1];
      int index = -1;
      for (int i = postorder.length - 2; i >= 0; i--) {
        if (index == -1) {
          if (postorder[i] < root) {
            index = i;
          }
        } else {
          if (postorder[i] > root) {
            return false;
          }
        }
      }
      return verifyPostorder(Arrays.copyOfRange(postorder, 0, index + 1)) & verifyPostorder(
          Arrays.copyOfRange(postorder, index + 1, postorder.length - 1));

    }
  }
}
