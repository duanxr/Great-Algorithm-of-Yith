package com.duanxr.yith.midium;

import com.duanxr.yith.define.treeNode.TreeNode;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 段然 2021/5/28
 */
public class FindElementsInAContaminatedBinaryTree {

  /**
   * Given a binary tree with the following rules:
   *
   * root.val == 0
   * If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
   * If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
   * Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.
   *
   * You need to first recover the binary tree and then implement the FindElements class:
   *
   * FindElements(TreeNode* root) Initializes the object with a contamined binary tree, you need to recover it first.
   * bool find(int target) Return if the target value exists in the recovered binary tree.
   *  
   *
   * Example 1:
   *
   *
   *
   * Input
   * ["FindElements","find","find"]
   * [[[-1,null,-1]],[1],[2]]
   * Output
   * [null,false,true]
   * Explanation
   * FindElements findElements = new FindElements([-1,null,-1]);
   * findElements.find(1); // return False
   * findElements.find(2); // return True
   * Example 2:
   *
   *
   *
   * Input
   * ["FindElements","find","find","find"]
   * [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
   * Output
   * [null,true,true,false]
   * Explanation
   * FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
   * findElements.find(1); // return True
   * findElements.find(3); // return True
   * findElements.find(5); // return False
   * Example 3:
   *
   *
   *
   * Input
   * ["FindElements","find","find","find","find"]
   * [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
   * Output
   * [null,true,false,false,true]
   * Explanation
   * FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
   * findElements.find(2); // return True
   * findElements.find(3); // return False
   * findElements.find(4); // return False
   * findElements.find(5); // return True
   *  
   *
   * Constraints:
   *
   * TreeNode.val == -1
   * The height of the binary tree is less than or equal to 20
   * The total number of nodes is between [1, 10^4]
   * Total calls of find() is between [1, 10^4]
   * 0 <= target <= 10^6
   *
   * 给出一个满足下述规则的二叉树：
   *
   * root.val == 0
   * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
   * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
   * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
   *
   * 请你先还原二叉树，然后实现 FindElements 类：
   *
   * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
   * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
   *  
   *
   * 示例 1：
   *
   *
   *
   * 输入：
   * ["FindElements","find","find"]
   * [[[-1,null,-1]],[1],[2]]
   * 输出：
   * [null,false,true]
   * 解释：
   * FindElements findElements = new FindElements([-1,null,-1]);
   * findElements.find(1); // return False
   * findElements.find(2); // return True
   * 示例 2：
   *
   *
   *
   * 输入：
   * ["FindElements","find","find","find"]
   * [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
   * 输出：
   * [null,true,true,false]
   * 解释：
   * FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
   * findElements.find(1); // return True
   * findElements.find(3); // return True
   * findElements.find(5); // return False
   * 示例 3：
   *
   *
   *
   * 输入：
   * ["FindElements","find","find","find","find"]
   * [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
   * 输出：
   * [null,true,false,false,true]
   * 解释：
   * FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
   * findElements.find(2); // return True
   * findElements.find(3); // return False
   * findElements.find(4); // return False
   * findElements.find(5); // return True
   *  
   *
   * 提示：
   *
   * TreeNode.val == -1
   * 二叉树的高度不超过 20
   * 节点的总数在 [1, 10^4] 之间
   * 调用 find() 的总次数在 [1, 10^4] 之间
   * 0 <= target <= 10^6
   *
   */
  class FindElements {

    private final Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
      push(root, -1, false);
    }

    private void push(TreeNode root, int x, boolean l) {
      if (root == null) {
        return;
      }
      int nx = x * 2 + (l ? 1 : 2);
      set.add(nx);
      push(root.left, nx, true);
      push(root.right, nx, false);
    }

    public boolean find(int target) {
      return set.contains(target);
    }
  }


  class FindElements1 {

    private final byte[] set = new byte[2000001];

    public FindElements1(TreeNode root) {
      push(root, -1, false);
    }

    private void push(TreeNode root, int x, boolean l) {
      if (root == null) {
        return;
      }
      int nx = x * 2 + (l ? 1 : 2);
      System.out.println(nx);
      set[nx]=1;
      push(root.left, nx, true);
      push(root.right, nx, false);
    }

    public boolean find(int target) {
      return set[target]==1;
    }
  }


}
