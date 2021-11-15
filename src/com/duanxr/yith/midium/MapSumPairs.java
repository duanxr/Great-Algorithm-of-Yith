package com.duanxr.yith.midium;

/**
 * @author 段然 2021/11/15
 */
public class MapSumPairs {

  /**
   * Design a map that allows you to do the following:
   *
   * Maps a string key to a given value.
   * Returns the sum of the values that have a key with a prefix equal to a given string.
   * Implement the MapSum class:
   *
   * MapSum() Initializes the MapSum object.
   * void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
   * int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
   *  
   *
   * Example 1:
   *
   * Input
   * ["MapSum", "insert", "sum", "insert", "sum"]
   * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
   * Output
   * [null, null, 3, null, 5]
   *
   * Explanation
   * MapSum mapSum = new MapSum();
   * mapSum.insert("apple", 3);
   * mapSum.sum("ap");           // return 3 (apple = 3)
   * mapSum.insert("app", 2);
   * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
   *  
   *
   * Constraints:
   *
   * 1 <= key.length, prefix.length <= 50
   * key and prefix consist of only lowercase English letters.
   * 1 <= val <= 1000
   * At most 50 calls will be made to insert and sum.
   *
   * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
   *
   * MapSum() 初始化 MapSum 对象
   * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
   * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
   *  
   *
   * 示例：
   *
   * 输入：
   * ["MapSum", "insert", "sum", "insert", "sum"]
   * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
   * 输出：
   * [null, null, 3, null, 5]
   *
   * 解释：
   * MapSum mapSum = new MapSum();
   * mapSum.insert("apple", 3);
   * mapSum.sum("ap");           // return 3 (apple = 3)
   * mapSum.insert("app", 2);
   * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
   *  
   *
   * 提示：
   *
   * 1 <= key.length, prefix.length <= 50
   * key 和 prefix 仅由小写英文字母组成
   * 1 <= val <= 1000
   * 最多调用 50 次 insert 和 sum
   *
   */
  class MapSum {

    Node root;

    public MapSum() {
      root = new Node();
    }

    public void insert(String key, int val) {
      insert(root, 0, key, val);
    }

    private int insert(Node root, int i, String key, int val) {
      int ni = key.charAt(i) - 'a';
      if (root.nodes[ni] == null) {
        root.nodes[ni] = new Node();
      }
      if (i == key.length() - 1) {
        int sub = val - root.nodes[ni].val;
        root.nodes[ni].val = val;
        root.nodes[ni].sum += sub;
        return sub;
      } else {
        int insert = insert(root.nodes[ni], i + 1, key, val);
        root.nodes[ni].sum += insert;
        return insert;
      }
    }

    public int sum(String prefix) {
      Node node = root;
      for (int i = 0; i < prefix.length(); i++) {
        node = node.nodes[prefix.charAt(i) - 'a'];
        if (node == null) {
          return 0;
        }
        if (i == prefix.length() - 1) {
          return node.sum;
        }
      }
      return 0;
    }

    class Node {

      Node[] nodes = new Node[26];
      int sum = 0;
      int val = 0;
    }
  }
}
