package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;

/**
 * @author 段然 2021/3/8
 */
public class SecondMinimumNodeInABinaryTree {

  /**
   * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
   *
   * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
   *
   * If no such second minimum value exists, output -1 instead.
   *
   *  
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [2,2,5,null,null,5,7]
   * Output: 5
   * Explanation: The smallest value is 2, the second smallest value is 5.
   * Example 2:
   *
   *
   * Input: root = [2,2,2]
   * Output: -1
   * Explanation: The smallest value is 2, but there isn't any second smallest value.
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [1, 25].
   * 1 <= Node.val <= 231 - 1
   * root.val == min(root.left.val, root.right.val) for each internal node of the tree.
   *
   * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
   *
   * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
   *
   * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：root = [2,2,5,null,null,5,7]
   * 输出：5
   * 解释：最小的值是 2 ，第二小的值是 5 。
   * 示例 2：
   *
   *
   * 输入：root = [2,2,2]
   * 输出：-1
   * 解释：最小的值是 2, 但是不存在第二小的值。
   *  
   *
   * 提示：
   *
   * 树中节点数目在范围 [1, 25] 内
   * 1 <= Node.val <= 231 - 1
   * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
   *
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  class Solution {

    int min;
    int smin;

    public int findSecondMinimumValue(TreeNode root) {
      min = Integer.MAX_VALUE;
      smin = Integer.MAX_VALUE;
      find(root);
      if (smin == Integer.MAX_VALUE) {
        return -1;
      }
      return smin;
    }

    void find(TreeNode root) {
      if (root == null) {
        return;
      }
      if (root.val < min) {
        smin = min;
        min = root.val;
      } else if (root.val != min && root.val < smin) {
        smin = root.val;

      }
      find(root.left);
      find(root.right);
    }
  }
}
