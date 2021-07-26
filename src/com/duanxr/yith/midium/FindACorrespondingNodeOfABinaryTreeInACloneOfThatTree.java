package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/7/26
 */
public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

  /**
   * Given two binary trees original and cloned and given a reference to a node target in the original tree.
   *
   * The cloned tree is a copy of the original tree.
   *
   * Return a reference to the same node in the cloned tree.
   *
   * Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
   *
   * Follow up: Solve the problem if repeated values on the tree are allowed.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: tree = [7,4,3,null,null,6,19], target = 3
   * Output: 3
   * Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.
   * Example 2:
   *
   *
   * Input: tree = [7], target =  7
   * Output: 7
   * Example 3:
   *
   *
   * Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
   * Output: 4
   * Example 4:
   *
   *
   * Input: tree = [1,2,3,4,5,6,7,8,9,10], target = 5
   * Output: 5
   * Example 5:
   *
   *
   * Input: tree = [1,2,null,3], target = 2
   * Output: 2
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [1, 10^4].
   * The values of the nodes of the tree are unique.
   * target node is a node from the original tree and is not null.
   *
   * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。
   *
   * 其中，克隆树 cloned 是原始树 original 的一个 副本 。
   *
   * 请找出在树 cloned 中，与 target 相同 的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
   *
   *  
   *
   * 注意：
   *
   * 你 不能 对两棵二叉树，以及 target 节点进行更改。
   * 只能 返回对克隆树 cloned 中已有的节点的引用。
   * 进阶：如果树中允许出现值相同的节点，你将如何解答？
   *
   *  
   *
   * 示例 1:
   *
   *
   *
   * 输入: tree = [7,4,3,null,null,6,19], target = 3
   * 输出: 3
   * 解释: 上图画出了树 original 和 cloned。target 节点在树 original 中，用绿色标记。答案是树 cloned 中的黄颜色的节点（其他示例类似）。
   * 示例 2:
   *
   *
   *
   * 输入: tree = [7], target =  7
   * 输出: 7
   * 示例 3:
   *
   *
   *
   * 输入: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
   * 输出: 4
   * 示例 4:
   *
   *
   *
   * 输入: tree = [1,2,3,4,5,6,7,8,9,10], target = 5
   * 输出: 5
   * 示例 5:
   *
   *
   *
   * 输入: tree = [1,2,null,3], target = 2
   * 输出: 2
   *  
   *
   * 提示：
   *
   * 树中节点的数量范围为 [1, 10^4] 。
   * 同一棵树中，没有值相同的节点。
   * target 节点是树 original 中的一个节点，并且不会是 null 。
   *
   */
  class Solution {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned,
        final TreeNode target) {
      return find(cloned, target);
    }

    private TreeNode find(TreeNode cloned, TreeNode target) {
      if (cloned == null) {
        return null;
      }
      if (cloned.val == target.val) {
        return cloned;
      }
      TreeNode treeNode = find(cloned.left, target);
      if (treeNode == null) {
        treeNode = find(cloned.right, target);
      }
      return treeNode;
    }
  }
}
