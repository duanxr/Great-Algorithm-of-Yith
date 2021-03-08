package com.duanxr.yith.easy;

import com.duanxr.yith.define.nAryTree.Node;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 段然 2021/3/8
 */
public class NaryTreePostorderTraversal {

  /**
   * Given an n-ary tree, return the postorder traversal of its nodes' values.
   *
   * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
   *
   *  
   *
   * Follow up:
   *
   * Recursive solution is trivial, could you do it iteratively?
   *
   *  
   *
   * Example 1:
   *
   *
   *
   * Input: root = [1,null,3,2,4,null,5,6]
   * Output: [5,6,3,2,4,1]
   * Example 2:
   *
   *
   *
   * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
   * Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
   *  
   *
   * Constraints:
   *
   * The height of the n-ary tree is less than or equal to 1000
   * The total number of nodes is between [0, 10^4]
   *
   * 给定一个 N 叉树，返回其节点值的 后序遍历 。
   *
   * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
   *
   *  
   *
   * 进阶：
   *
   * 递归法很简单，你可以使用迭代法完成此题吗?
   *
   *  
   *
   * 示例 1：
   *
   *
   *
   * 输入：root = [1,null,3,2,4,null,5,6]
   * 输出：[5,6,3,2,4,1]
   * 示例 2：
   *
   *
   *
   * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
   * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
   *  
   *
   * 提示：
   *
   * N 叉树的高度小于或等于 1000
   * 节点总数在范围 [0, 10^4] 内
   *
   */
  class Solution {

    public List<Integer> postorder(Node root) {
      LinkedList<Node> stack = new LinkedList<>();
      LinkedList<Integer> result = new LinkedList<>();
      stack.push(root);
      while (!stack.isEmpty()) {
        Node node = stack.pop();
        if (node == null) {
          continue;
        }
        result.push(node.val);
        for (int i = 0; i < node.children.size(); i++) {
          Node n = node.children.get(i);
          if (n != null) {
            stack.push(n);
          }
        }
      }
      return result;
    }


  }
}
