package com.duanxr.yith.easy;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/5/17
 */
public class FindAllTheLonelyNodes {

  /**
   * In a binary tree, a lonely node is a node that is the only child of its parent node. The root of the tree is not lonely because it does not have a parent node.
   *
   * Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree. Return the list in any order.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [1,2,3,null,4]
   * Output: [4]
   * Explanation: Light blue node is the only lonely node.
   * Node 1 is the root and is not lonely.
   * Nodes 2 and 3 have the same parent and are not lonely.
   * Example 2:
   *
   *
   * Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2]
   * Output: [6,2]
   * Explanation: Light blue nodes are lonely nodes.
   * Please remember that order doesn't matter, [2,6] is also an acceptable answer.
   * Example 3:
   *
   *
   *
   * Input: root = [11,99,88,77,null,null,66,55,null,null,44,33,null,null,22]
   * Output: [77,55,33,66,44,22]
   * Explanation: Nodes 99 and 88 share the same parent. Node 11 is the root.
   * All other nodes are lonely.
   * Example 4:
   *
   * Input: root = [197]
   * Output: []
   * Example 5:
   *
   * Input: root = [31,null,78,null,28]
   * Output: [78,28]
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [1, 1000].
   * Each node's value is between [1, 10^6].
   *
   * 二叉树中，如果一个节点是其父节点的唯一子节点，则称这样的节点为 “独生节点” 。二叉树的根节点不会是独生节点，因为它没有父节点。
   *
   * 给定一棵二叉树的根节点 root ，返回树中 所有的独生节点的值所构成的数组 。数组的顺序 不限 。
   *
   *  
   *
   * 示例 1：
   *
   *
   *
   * 输入：root = [1,2,3,null,4]
   * 输出：[4]
   * 解释：浅蓝色的节点是唯一的独生节点。
   * 节点 1 是根节点，不是独生的。
   * 节点 2 和 3 有共同的父节点，所以它们都不是独生的。
   * 示例 2：
   *
   *
   *
   * 输入：root = [7,1,4,6,null,5,3,null,null,null,null,null,2]
   * 输出：[6,2]
   * 输出：浅蓝色的节点是独生节点。
   * 请谨记，顺序是不限的。 [2,6] 也是一种可接受的答案。
   * 示例 3：
   *
   *
   *
   * 输入：root = [11,99,88,77,null,null,66,55,null,null,44,33,null,null,22]
   * 输出：[77,55,33,66,44,22]
   * 解释：节点 99 和 88 有共同的父节点，节点 11 是根节点。
   * 其他所有节点都是独生节点。
   * 示例 4：
   *
   * 输入：root = [197]
   * 输出：[]
   * 示例 5：
   *
   * 输入：root = [31,null,78,null,28]
   * 输出：[78,28]
   *  
   *
   * 提示：
   *
   *  tree 中节点个数的取值范围是 [1, 1000]。
   * 每个节点的值的取值范围是 [1, 10^6]。
   *
   */
  class Solution {

    public List<Integer> getLonelyNodes(TreeNode root) {
      List<Integer> list = new ArrayList<>();

      find(root, root, list);

      return list;
    }

    private void find(TreeNode root, TreeNode brother, List<Integer> list) {
      if (root == null) {
        return;
      }
      if (brother == null) {
        list.add(root.val);
      }
      find(root.left, root.right, list);
      find(root.right, root.left, list);
    }
  }
}
