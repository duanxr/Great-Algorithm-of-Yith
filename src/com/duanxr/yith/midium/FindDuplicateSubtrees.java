package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 段然 2021/5/19
 */
public class FindDuplicateSubtrees {

  /**
   * Given the root of a binary tree, return all duplicate subtrees.
   *
   * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
   *
   * Two trees are duplicate if they have the same structure with the same node values.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: root = [1,2,3,4,null,2,4,null,null,4]
   * Output: [[2,4],[4]]
   * Example 2:
   *
   *
   * Input: root = [2,1,1]
   * Output: [[1]]
   * Example 3:
   *
   *
   * Input: root = [2,2,2,3,null,3,null]
   * Output: [[2,3],[3]]
   *  
   *
   * Constraints:
   *
   * The number of the nodes in the tree will be in the range [1, 10^4]
   * -200 <= Node.val <= 200
   *
   * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
   *
   * 两棵树重复是指它们具有相同的结构以及相同的结点值。
   *
   * 示例 1：
   *
   *         1
   *        / \
   *       2   3
   *      /   / \
   *     4   2   4
   *        /
   *       4
   * 下面是两个重复的子树：
   *
   *       2
   *      /
   *     4
   * 和
   *
   *     4
   * 因此，你需要以列表的形式返回上述重复子树的根结点。
   *
   */
  class Solution {

    StringBuilder sb = new StringBuilder();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      List<TreeNode> list = new ArrayList<>();
      find(root, new HashMap<>(), list);
      return list;
    }

    private String find(TreeNode root, HashMap<String, Integer> map, List<TreeNode> list) {
      if (root == null) {
        return "";
      }
      String stl = find(root.left, map, list);
      String str = find(root.right, map, list);
      String sign = sb.append(root.val).append(' ').append(stl).append(' ').append(str).toString();
      sb.setLength(0);
      Integer in = map.compute(sign, (s, i) -> i == null ? 1 : 1 + i);
      if (in == 2) {
        list.add(root);
      }
      return sign;
    }
  }


  class Solution2 {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      List<TreeNode> list = new ArrayList<>();
      find(root, new HashMap<>(), list);
      return list;
    }

    private String find(TreeNode root, HashMap<String, Integer> map, List<TreeNode> list) {
      if (root == null) {
        return "-";
      }
      String sign = new StringBuilder().append(root.val).append(' ')
          .append(find(root.left, map, list))
          .append(' ').append(find(root.right, map, list)).toString();
      //String sign = root.val + " " + find(root.left, map, list)
      //    + ' ' + find(root.right, map, list);
      Integer in = map.compute(sign, (s, i) -> i == null ? 1 : 1 + i);
      if (in == 2) {
        list.add(root);
      }
      return sign;
    }
  }


  class Solution1 {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      List<TreeNode> list = new ArrayList<>();
      find(root, new HashMap<>(), list);
      return list;
    }

    private String find(TreeNode root, HashMap<String, Integer> map, List<TreeNode> list) {
      if (root == null) {
        return "-";
      }
      //String sign = new StringBuilder(root.val).append(' ').append(find(root.left, map, list))
      //  .append(' ').append(find(root.right, map, list)).toString();
      String sign = root.val + " " + find(root.left, map, list)
          + ' ' + find(root.right, map, list);
      Integer in = map.compute(sign, (s, i) -> i == null ? 1 : 1 + i);
      if (in == 2) {
        list.add(root);
      }
      return sign;
    }
  }
}
