package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class DesignHashSet {

  /**
   * Design a HashSet without using any built-in hash table libraries.
   *
   * Implement MyHashSet class:
   *
   * void add(key) Inserts the value key into the HashSet.
   * bool contains(key) Returns whether the value key exists in the HashSet or not.
   * void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
   *  
   *
   * Example 1:
   *
   * Input
   * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
   * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
   * Output
   * [null, null, null, true, false, null, true, null, false]
   *
   * Explanation
   * MyHashSet myHashSet = new MyHashSet();
   * myHashSet.add(1);      // set = [1]
   * myHashSet.add(2);      // set = [1, 2]
   * myHashSet.contains(1); // return True
   * myHashSet.contains(3); // return False, (not found)
   * myHashSet.add(2);      // set = [1, 2]
   * myHashSet.contains(2); // return True
   * myHashSet.remove(2);   // set = [1]
   * myHashSet.contains(2); // return False, (already removed)
   *  
   *
   * Constraints:
   *
   * 0 <= key <= 106
   * At most 104 calls will be made to add, remove, and contains.
   *  
   *
   * Follow up: Could you solve the problem without using the built-in HashSet library?
   *
   * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
   *
   * 实现 MyHashSet 类：
   *
   * void add(key) 向哈希集合中插入值 key 。
   * bool contains(key) 返回哈希集合中是否存在这个值 key 。
   * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
   *  
   * 示例：
   *
   * 输入：
   * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
   * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
   * 输出：
   * [null, null, null, true, false, null, true, null, false]
   *
   * 解释：
   * MyHashSet myHashSet = new MyHashSet();
   * myHashSet.add(1);      // set = [1]
   * myHashSet.add(2);      // set = [1, 2]
   * myHashSet.contains(1); // 返回 True
   * myHashSet.contains(3); // 返回 False ，（未找到）
   * myHashSet.add(2);      // set = [1, 2]
   * myHashSet.contains(2); // 返回 True
   * myHashSet.remove(2);   // set = [1]
   * myHashSet.contains(2); // 返回 False ，（已移除）
   *  
   *
   * 提示：
   *
   * 0 <= key <= 106
   * 最多调用 104 次 add、remove 和 contains 。
   *
   */
  class MyHashSet {

    Entry[] array;

    private class Entry {

      int key;
      Entry next;
    }

    public MyHashSet() {
      array = new Entry[16];
    }

    public void add(int key) {
      Entry entry = new Entry();
      entry.key = key;
      int index = key % 16;
      if (array[index] == null) {
        array[index] = entry;
      } else {
        Entry now = array[index];
        while (now != null) {
          if (now.key == key) {
            return;
          } else {
            now = now.next;
          }
        }
        entry.next = array[index];
        array[index] = entry;
      }
    }

    public void remove(int key) {
      int index = key % 16;
      if (array[index] == null) {
        return;
      } else {
        array[index] = remove(array[index], key);
      }
    }

    private Entry remove(Entry entry, int key) {
      if (entry == null) {
        return null;
      }
      if (entry.key == key) {
        return entry.next;
      } else {
        entry.next = remove(entry.next, key);
        return entry;
      }

    }

    public boolean contains(int key) {
      int index = key % 16;
      if (array[index] == null) {
        return false;
      } else {
        if (array[index].key == key) {
          return true;
        } else {
          Entry entry = array[index].next;
          while (entry != null) {
            if (entry.key == key) {
              return true;
            } else {
              entry = entry.next;
            }

          }
          return false;
        }
      }
    }
  }
}
