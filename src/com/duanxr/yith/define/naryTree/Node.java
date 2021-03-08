package com.duanxr.yith.define.naryTree;

import java.util.List;

/**
 * @author Duanran 2019/1/22 0022
 */
public class Node {

  public int val;
  public List<Node> children;

  public Node() {
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
}