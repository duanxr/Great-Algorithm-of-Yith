package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 段然 2021/10/13
 */
public class KillProcess {

  /**
   * You have n processes forming a rooted tree structure. You are given two integer arrays pid and ppid, where pid[i] is the ID of the ith process and ppid[i] is the ID of the ith process's parent process.
   *
   * Each process has only one parent process but may have multiple children processes. Only one process has ppid[i] = 0, which means this process has no parent process (the root of the tree).
   *
   * When a process is killed, all of its children processes will also be killed.
   *
   * Given an integer kill representing the ID of a process you want to kill, return a list of the IDs of the processes that will be killed. You may return the answer in any order.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
   * Output: [5,10]
   * Explanation: The processes colored in red are the processes that should be killed.
   * Example 2:
   *
   * Input: pid = [1], ppid = [0], kill = 1
   * Output: [1]
   *  
   *
   * Constraints:
   *
   * n == pid.length
   * n == ppid.length
   * 1 <= n <= 5 * 104
   * 1 <= pid[i] <= 5 * 104
   * 0 <= ppid[i] <= 5 * 104
   * Only one process has no parent.
   * All the values of pid are unique.
   * kill is guaranteed to be in pid.
   *
   * 系统中存在 n 个进程，形成一个有根树结构。给你两个整数数组 pid 和 ppid ，其中 pid[i] 是第 i 个进程的 ID ，ppid[i] 是第 i 个进程的父进程 ID 。
   *
   * 每一个进程只有 一个父进程 ，但是可能会有 一个或者多个子进程 。只有一个进程的 ppid[i] = 0 ，意味着这个进程 没有父进程 。
   *
   * 当一个进程 被杀掉 的时候，它所有的子进程和后代进程都要被杀掉。
   *
   * 给你一个整数 kill 表示要杀掉​​进程的 ID ，返回杀掉该进程后的所有进程 ID 的列表。可以按 任意顺序 返回答案。
   *
   *  
   * 示例 1：
   *
   *
   * 输入：pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
   * 输出：[5,10]
   * 解释：涂为红色的进程是应该被杀掉的进程。
   * 示例 2：
   *
   * 输入：pid = [1], ppid = [0], kill = 1
   * 输出：[1]
   *  
   *
   * 提示：
   *
   * n == pid.length
   * n == ppid.length
   * 1 <= n <= 5 * 104
   * 1 <= pid[i] <= 5 * 104
   * 0 <= ppid[i] <= 5 * 104
   * 仅有一个进程没有父进程
   * pid 中的所有值 互不相同
   * 题目数据保证 kill 在 pid 中
   *
   */
  class Solution {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
      int size = pid.size();
      Map<Integer, List<Integer>> map = new HashMap<>(size);
      for (int i = 0; i < size; i++) {
        if (ppid.get(i) != 0) {
          map.computeIfAbsent(ppid.get(i), k -> new ArrayList<>()).add(pid.get(i));
        }
      }
      List<Integer> ntk = new ArrayList<>();
      add(ntk, map, kill);
      return ntk;
    }

    private void add(List<Integer> ntk, Map<Integer, List<Integer>> map, int kill) {
      List<Integer> list = map.get(kill);
      ntk.add(kill);
      if (list != null && !list.isEmpty()) {
        for (Integer k : list) {
          add(ntk, map, k);
        }
      }
    }
  }
}
