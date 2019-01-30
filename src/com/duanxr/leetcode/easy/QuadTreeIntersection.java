package com.duanxr.leetcode.easy;

import com.duanxr.leetcode.define.quadTree.Node;

/**
 * @author Duanran 2019/1/22 0022
 */
public class QuadTreeIntersection {

  /**
   * A quadtree is a tree data in which each internal node has exactly four children: topLeft,
   * topRight, bottomLeft and bottomRight. Quad trees are often used to partition a two-dimensional
   * space by recursively subdividing it into four quadrants or regions.
   *
   * We want to store True/False information in our quad tree. The quad tree is used to represent a
   * N * N boolean grid. For each node, it will be subdivided into four children nodes until the
   * values in the region it represents are all the same. Each node has another two boolean
   * attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val
   * attribute for a leaf node contains the value of the region it represents.
   *
   * For example, below are two quad trees A and B:
   *
   * A:
   *
   * +-------+-------+   T: true
   * |       |       |   F: false
   * |   T   |   T   |
   * |       |       |
   * +-------+-------+
   * |       |       |
   * |   F   |   F   |
   * |       |       |
   * +-------+-------+
   *
   * topLeft: T
   *
   * topRight: T
   *
   * bottomLeft: F
   *
   * bottomRight: F
   *
   * B:
   * +-------+---+---+
   * |       | F | F |
   * |   T   +---+---+
   * |       | T | T |
   * +-------+---+---+
   * |       |       |
   * |   T   |   F   |
   * |       |       |
   * +-------+-------+
   *
   * topLeft: T
   *
   * topRight:
   *
   * topLeft: F
   *
   * topRight: F
   *
   * bottomLeft: T
   *
   * bottomRight: T
   *
   * bottomLeft: T
   *
   * bottomRight: F
   *
   *
   *
   * Your task is to implement a function that will take two quadtrees and return a quadtree that
   * represents the logical OR (or union) of the two trees.
   *
   * A:                 B:                 C (A or B):
   * +-------+-------+  +-------+---+---+  +-------+-------+
   * |       |       |  |       | F | F |  |       |       |
   * |   T   |   T   |  |   T   +---+---+  |   T   |   T   |
   * |       |       |  |       | T | T |  |       |       |
   * +-------+-------+  +-------+---+---+  +-------+-------+
   * |       |       |  |       |       |  |       |       |
   * |   F   |   F   |  |   T   |   F   |  |   T   |   F   |
   * |       |       |  |       |       |  |       |       |
   * +-------+-------+  +-------+-------+  +-------+-------+
   *
   * Note:
   *
   *
   * Both A and B represent grids of size N * N.
   *
   * N is guaranteed to be a power of 2.
   *
   * If you want to know more about the quad tree, you can refer to its wiki.
   *
   * The logic OR operation is defined as this: "A or B" is true if A is true, or if B is true, or
   * if both A and B are true.
   *
   * 四叉树是一种树数据，其中每个结点恰好有四个子结点：topLeft、topRight、bottomLeft 和 bottomRight。四叉树通常被用来划分一个二维空间，递归地将其细分为四个象限或区域。
   *
   * 我们希望在四叉树中存储 True/False 信息。四叉树用来表示 N * N 的布尔网格。对于每个结点, 它将被等分成四个孩子结点直到这个区域内的值都是相同的。每个节点都有另外两个布尔属性：isLeaf
   * 和 isLeaf。当这个节点是一个叶子结点时 isLeaf 为真。val 变量储存叶子结点所代表的区域的值。
   *
   * 例如，下面是两个四叉树 A 和 B：
   *
   * A:
   *
   * +-------+-------+   T: true
   * |       |       |   F: false
   * |   T   |   T   |
   * |       |       |
   * +-------+-------+
   * |       |       |
   * |   F   |   F   |
   * |       |       |
   * +-------+-------+
   *
   * topLeft: T
   *
   * topRight: T
   *
   * bottomLeft: F
   *
   * bottomRight: F
   *
   * B:
   * +-------+---+---+
   * |       | F | F |
   * |   T   +---+---+
   * |       | T | T |
   * +-------+---+---+
   * |       |       |
   * |   T   |   F   |
   * |       |       |
   * +-------+-------+
   *
   * topLeft: T
   *
   * topRight:
   *
   * topLeft: F
   *
   * topRight: F
   *
   * bottomLeft: T
   *
   * bottomRight: T
   *
   * bottomLeft: T
   *
   * bottomRight: F
   *
   *
   * 你的任务是实现一个函数，该函数根据两个四叉树返回表示这两个四叉树的逻辑或(或并)的四叉树。
   *
   * A:                 B:                 C (A or B):
   * +-------+-------+  +-------+---+---+  +-------+-------+
   * |       |       |  |       | F | F |  |       |       |
   * |   T   |   T   |  |   T   +---+---+  |   T   |   T   |
   * |       |       |  |       | T | T |  |       |       |
   * +-------+-------+  +-------+---+---+  +-------+-------+
   * |       |       |  |       |       |  |       |       |
   * |   F   |   F   |  |   T   |   F   |  |   T   |   F   |
   * |       |       |  |       |       |  |       |       |
   * +-------+-------+  +-------+-------+  +-------+-------+
   *
   *
   * 提示：
   *
   * A 和 B 都表示大小为 N * N 的网格。
   *
   * N 将确保是 2 的整次幂。
   *
   * 如果你想了解更多关于四叉树的知识，你可以参考这个 wiki 页面。
   *
   * 逻辑或的定义如下：如果 A 为 True ，或者 B 为 True ，或者 A 和 B 都为 True，则 "A 或 B" 为 True。
   */
  class Solution {

    public Node intersect(Node quadTree1, Node quadTree2) {
      if (quadTree1 == null) {
        return quadTree2;
      }
      if (quadTree2 == null) {
        return quadTree1;
      }
      if (quadTree1.isLeaf && quadTree2.isLeaf) {
        Node node = new Node();
        node.val = quadTree1.val || quadTree2.val;
        node.isLeaf = true;
        return node;
      }
      if (quadTree1.isLeaf && quadTree1.val) {
        return quadTree1;
      }
      if (quadTree2.isLeaf && quadTree2.val) {
        return quadTree2;
      }
      Node node = new Node();
      node.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
      node.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
      node.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
      node.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
      if (node.topLeft.val && node.bottomLeft.val && node.topRight.val && node.bottomRight.val) {
        Node tnode = new Node();
        tnode.val = true;
        tnode.isLeaf = true;
        return tnode;
      }
      return node;
    }
  }
}
