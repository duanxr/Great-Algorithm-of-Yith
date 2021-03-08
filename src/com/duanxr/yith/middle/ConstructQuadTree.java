package com.duanxr.yith.middle;

import com.duanxr.yith.define.quadTree.Node;

/**
 * @author 段然 2021/3/8
 */
public class ConstructQuadTree {

  /**
   * Given a n * n matrix grid of 0's and 1's only. We want to represent the grid with a Quad-Tree.
   *
   * Return the root of the Quad-Tree representing the grid.
   *
   * Notice that you can assign the value of a node to True or False when isLeaf is False, and both are accepted in the answer.
   *
   * A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:
   *
   * val: True if the node represents a grid of 1's or False if the node represents a grid of 0's. 
   * isLeaf: True if the node is leaf node on the tree or False if the node has the four children.
   * class Node {
   *     public boolean val;
   *     public boolean isLeaf;
   *     public Node topLeft;
   *     public Node topRight;
   *     public Node bottomLeft;
   *     public Node bottomRight;
   * }
   * We can construct a Quad-Tree from a two-dimensional area using the following steps:
   *
   * If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and set val to the value of the grid and set the four children to Null and stop.
   * If the current grid has different values, set isLeaf to False and set val to any value and divide the current grid into four sub-grids as shown in the photo.
   * Recurse for each of the children with the proper sub-grid.
   *
   * If you want to know more about the Quad-Tree, you can refer to the wiki.
   *
   * Quad-Tree format:
   *
   * The output represents the serialized format of a Quad-Tree using level order traversal, where null signifies a path terminator where no node exists below.
   *
   * It is very similar to the serialization of the binary tree. The only difference is that the node is represented as a list [isLeaf, val].
   *
   * If the value of isLeaf or val is True we represent it as 1 in the list [isLeaf, val] and if the value of isLeaf or val is False we represent it as 0.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: grid = [[0,1],[1,0]]
   * Output: [[0,1],[1,0],[1,1],[1,1],[1,0]]
   * Explanation: The explanation of this example is shown below:
   * Notice that 0 represnts False and 1 represents True in the photo representing the Quad-Tree.
   *
   * Example 2:
   *
   *
   *
   * Input: grid = [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]
   * Output: [[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
   * Explanation: All values in the grid are not the same. We divide the grid into four sub-grids.
   * The topLeft, bottomLeft and bottomRight each has the same value.
   * The topRight have different values so we divide it into 4 sub-grids where each has the same value.
   * Explanation is shown in the photo below:
   *
   * Example 3:
   *
   * Input: grid = [[1,1],[1,1]]
   * Output: [[1,1]]
   * Example 4:
   *
   * Input: grid = [[0]]
   * Output: [[1,0]]
   * Example 5:
   *
   * Input: grid = [[1,1,0,0],[1,1,0,0],[0,0,1,1],[0,0,1,1]]
   * Output: [[0,1],[1,1],[1,0],[1,0],[1,1]]
   *  
   *
   * Constraints:
   *
   * n == grid.length == grid[i].length
   * n == 2^x where 0 <= x <= 6
   *
   * 给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
   *
   * 你需要返回能表示矩阵的 四叉树 的根结点。
   *
   * 注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
   *
   * 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
   *
   * val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False；
   * isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
   * class Node {
   *     public boolean val;
   *     public boolean isLeaf;
   *     public Node topLeft;
   *     public Node topRight;
   *     public Node bottomLeft;
   *     public Node bottomRight;
   * }
   * 我们可以按以下步骤为二维区域构建四叉树：
   *
   * 如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
   * 如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
   * 使用适当的子网格递归每个子节点。
   *
   *
   * 如果你想了解更多关于四叉树的内容，可以参考 wiki 。
   *
   * 四叉树格式：
   *
   * 输出为使用层序遍历后四叉树的序列化形式，其中 null 表示路径终止符，其下面不存在节点。
   *
   * 它与二叉树的序列化非常相似。唯一的区别是节点以列表形式表示 [isLeaf, val] 。
   *
   * 如果 isLeaf 或者 val 的值为 True ，则表示它在列表 [isLeaf, val] 中的值为 1 ；如果 isLeaf 或者 val 的值为 False ，则表示值为 0 。
   *
   *  
   *
   * 示例 1：
   *
   *
   *
   * 输入：grid = [[0,1],[1,0]]
   * 输出：[[0,1],[1,0],[1,1],[1,1],[1,0]]
   * 解释：此示例的解释如下：
   * 请注意，在下面四叉树的图示中，0 表示 false，1 表示 True 。
   *
   * 示例 2：
   *
   *
   *
   * 输入：grid = [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]
   * 输出：[[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
   * 解释：网格中的所有值都不相同。我们将网格划分为四个子网格。
   * topLeft，bottomLeft 和 bottomRight 均具有相同的值。
   * topRight 具有不同的值，因此我们将其再分为 4 个子网格，这样每个子网格都具有相同的值。
   * 解释如下图所示：
   *
   * 示例 3：
   *
   * 输入：grid = [[1,1],[1,1]]
   * 输出：[[1,1]]
   * 示例 4：
   *
   * 输入：grid = [[0]]
   * 输出：[[1,0]]
   * 示例 5：
   *
   * 输入：grid = [[1,1,0,0],[1,1,0,0],[0,0,1,1],[0,0,1,1]]
   * 输出：[[0,1],[1,1],[1,0],[1,0],[1,1]]
   *  
   *
   * 提示：
   *
   * n == grid.length == grid[i].length
   * n == 2^x 其中 0 <= x <= 6
   *
   */
  class Solution {

    public Node construct(int[][] grid) {
      boolean isLeaf = true;
      int v = grid[0][0];
      O:
      for (int[] row : grid) {
        for (int i : row) {
          if (i != v) {
            isLeaf = false;
            break O;
          }
        }
      }
      Node node = new Node();
      if (isLeaf) {
        node.isLeaf = true;
        node.val = v == 1;
      } else {
        int[][][] sub = cut(grid);
        node.isLeaf = false;
        node.val = true;
        node.topLeft = construct(sub[0]);
        node.topRight = construct(sub[2]);
        node.bottomLeft = construct(sub[1]);
        node.bottomRight = construct(sub[3]);
      }
      return node;
    }

    public int[][][] cut(int[][] grid) {
      int h = grid.length / 2;
      int[][][] r = new int[4][h][h];
      for (int i = 0; i < h; i++) {
        System.arraycopy(grid[i], 0, r[0][i], 0, h);
      }
      for (int i = 0; i < h; i++) {
        System.arraycopy(grid[i + h], 0, r[1][i], 0, h);
      }
      for (int i = 0; i < h; i++) {
        System.arraycopy(grid[i], h, r[2][i], 0, h);
      }
      for (int i = 0; i < h; i++) {
        System.arraycopy(grid[i + h], h, r[3][i], 0, h);
      }
      return r;
    }

  }
}
