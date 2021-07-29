package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 段然 2021/7/29
 */
public class PathInZigzagLabelledBinaryTree {

  /**
   * In an infinite binary tree where every node has two children, the nodes are labelled in row order.
   *
   * In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.
   *
   *
   *
   * Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.
   *
   *  
   *
   * Example 1:
   *
   * Input: label = 14
   * Output: [1,3,4,14]
   * Example 2:
   *
   * Input: label = 26
   * Output: [1,2,6,10,26]
   *  
   *
   * Constraints:
   *
   * 1 <= label <= 10^6
   *
   * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
   *
   * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
   *
   * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
   *
   *
   *
   * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：label = 14
   * 输出：[1,3,4,14]
   * 示例 2：
   *
   * 输入：label = 26
   * 输出：[1,2,6,10,26]
   *  
   *
   * 提示：
   *
   * 1 <= label <= 10^6
   *
   */
  class Solution {

    public List<Integer> pathInZigZagTree(int label) {
      List<Integer> list = new ArrayList<>();
      List<Integer> sizeList = new ArrayList<>();

      int size = 1;
      while (size <= label) {
        sizeList.add(size);
        size *= 2;
      }

      list.add(label);

      for (int i = sizeList.size() - 1; i > 1; i--) {
        size = sizeList.get(i);
        int index = (label - size) / 2;
        int offsetIndex = size - 1 - index;
        label = offsetIndex;
        list.add(offsetIndex);
      }

      Collections.reverse(list);

      return list;
    }
  }
}
