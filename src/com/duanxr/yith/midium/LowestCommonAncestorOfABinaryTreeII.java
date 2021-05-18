package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author 段然 2021/5/18
 */
public class LowestCommonAncestorOfABinaryTreeII {

  /**
   * Given the root of a binary tree, return the lowest common ancestor (LCA) of two given nodes, p and q. If either node p or q does not exist in the tree, return null. All values of the nodes in the tree are unique.
   *
   * According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a binary tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)". A descendant of a node x is a node y that is on the path from node x to some leaf node.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
   * Output: 3
   * Explanation: The LCA of nodes 5 and 1 is 3.
   * Example 2:
   *
   *
   *
   * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
   * Output: 5
   * Explanation: The LCA of nodes 5 and 4 is 5. A node can be a descendant of itself according to the definition of LCA.
   * Example 3:
   *
   *
   *
   * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 10
   * Output: null
   * Explanation: Node 10 does not exist in the tree, so return null.
   *  
   *
   * Constraints:
   *
   * The number of nodes in the tree is in the range [1, 104].
   * -109 <= Node.val <= 109
   * All Node.val are unique.
   * p != q
   *  
   *
   * Follow up: Can you find the LCA traversing the tree, without checking nodes existence?
   *
   * 给定一棵二叉树的根节点 root，返回给定节点 p 和 q 的最近公共祖先（LCA）节点。如果 p 或 q 之一不存在于该二叉树中，返回 null。树中的每个节点值都是互不相同的。
   *
   * 根据维基百科中对最近公共祖先节点的定义：“两个节点 p 和 q 在二叉树 T 中的最近公共祖先节点是后代节点中既包括 p 又包括 q 的最深节点（我们允许一个节点为自身的一个后代节点）”。一个节点 x 的后代节点是节点 x 到某一叶节点间的路径中的节点 y。
   *
   *  
   *
   * 示例 1:
   *
   *
   * 输入： root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
   * 输出： 3
   * 解释： 节点 5 和 1 的共同祖先节点是 3。
   * 示例 2:
   *
   *
   *
   * 输入： root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
   * 输出： 5
   * 解释： 节点 5 和 4 的共同祖先节点是 5。根据共同祖先节点的定义，一个节点可以是自身的后代节点。
   * 示例 3:
   *
   *
   *
   * 输入： root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 10
   * 输出： null
   * 解释： 节点 10 不存在于树中，所以返回 null。
   *  
   *
   * 提示:
   *
   * 树中节点个数的范围是 [1, 104]。
   * -109 <= Node.val <= 109
   * 所有节点的值 Node.val 是互不相同的。
   * p != q
   *
   */
  class Solution1 {

    private Stack<TreeNode> stack = new Stack<>();
    private List<TreeNode> list = null;
    private TreeNode target = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      find(root, p, q, stack);
      return target;
    }

    private void find(TreeNode root, TreeNode p, TreeNode q, Stack<TreeNode> stack) {
      if (root == null || target != null) {
        return;
      }
      stack.push(root);
      if (root == p || root == q) {
        if (list == null) {
          list = new ArrayList<>(stack);
        } else {
          Iterator<TreeNode> l = list.iterator();
          Iterator<TreeNode> s = stack.iterator();
          while (l.hasNext() && s.hasNext()) {
            TreeNode nodeL = l.next();
            TreeNode nodeS = s.next();
            if (nodeL != nodeS) {
              return;
            }
            target = nodeL;
          }
        }
      }
      find(root.left, p, q, stack);
      find(root.right, p, q, stack);
      stack.pop();
    }
  }
}
