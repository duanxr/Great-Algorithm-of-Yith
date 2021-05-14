package com.duanxr.yith.midium;


import com.duanxr.yith.define.nextTreeNode.Node;

/**
 * @author 段然 2021/5/14
 */
public class PopulatingNextRightPointersInEachNodeA {


  /**
   * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
   *
   * struct Node {
   *   int val;
   *   Node *left;
   *   Node *right;
   *   Node *next;
   * }
   * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
   *
   * Initially, all next pointers are set to NULL.
   *
   *  
   *
   * Follow up:
   *
   * You may only use constant extra space.
   * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
   *  
   *
   * Example 1:
   *
   *
   *
   * Input: root = [1,2,3,4,5,6,7]
   * Output: [1,#,2,3,#,4,5,6,7,#]
   * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
   *  
   *
   * Constraints:
   *
   * The number of nodes in the given tree is less than 4096.
   * -1000 <= node.val <= 1000
   *
   * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
   *
   * struct Node {
   *   int val;
   *   Node *left;
   *   Node *right;
   *   Node *next;
   * }
   * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
   *
   * 初始状态下，所有 next 指针都被设置为 NULL。
   *
   *  
   *
   * 进阶：
   *
   * 你只能使用常量级额外空间。
   * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
   *  
   *
   * 示例：
   *
   *
   *
   * 输入：root = [1,2,3,4,5,6,7]
   * 输出：[1,#,2,3,#,4,5,6,7,#]
   * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
   *  
   *
   * 提示：
   *
   * 树中节点的数量少于 4096
   * -1000 <= node.val <= 1000
   *
   */
  class Solution {

    Node[] nodes = new Node[4096];

    public Node connect(Node root) {
      connect(root, 0);
      return root;
    }

    private void connect(Node root, int i) {
      if (root == null) {
        return;
      }
      root.next = nodes[i];
      nodes[i] = root;
      connect(root.right, i + 1);
      connect(root.left, i + 1);
    }
  }
}
