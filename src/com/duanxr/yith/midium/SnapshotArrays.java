package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javafx.util.Pair;

/**
 * @author 段然 2021/9/10
 */
public class SnapshotArrays {

  /**
   * Implement a SnapshotArray that supports the following interface:
   *
   * SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
   * void set(index, val) sets the element at the given index to be equal to val.
   * int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
   * int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
   *  
   *
   * Example 1:
   *
   * Input: ["SnapshotArray","set","snap","set","get"]
   * [[3],[0,5],[],[0,6],[0,0]]
   * Output: [null,null,0,null,5]
   * Explanation:
   * SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
   * snapshotArr.set(0,5);  // Set array[0] = 5
   * snapshotArr.snap();  // Take a snapshot, return snap_id = 0
   * snapshotArr.set(0,6);
   * snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
   *  
   *
   * Constraints:
   *
   * 1 <= length <= 50000
   * At most 50000 calls will be made to set, snap, and get.
   * 0 <= index < length
   * 0 <= snap_id < (the total number of times we call snap())
   * 0 <= val <= 10^9
   *
   * 实现支持下列接口的「快照数组」- SnapshotArray：
   *
   * SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
   * void set(index, val) - 会将指定索引 index 处的元素设置为 val。
   * int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
   * int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
   *  
   *
   * 示例：
   *
   * 输入：["SnapshotArray","set","snap","set","get"]
   *      [[3],[0,5],[],[0,6],[0,0]]
   * 输出：[null,null,0,null,5]
   * 解释：
   * SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
   * snapshotArr.set(0,5);  // 令 array[0] = 5
   * snapshotArr.snap();  // 获取快照，返回 snap_id = 0
   * snapshotArr.set(0,6);
   * snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5
   *  
   *
   * 提示：
   *
   * 1 <= length <= 50000
   * 题目最多进行50000 次set，snap，和 get的调用 。
   * 0 <= index < length
   * 0 <= snap_id < 我们调用 snap() 的总次数
   * 0 <= val <= 10^9
   *
   */
  class SnapshotArray {

    Set<Integer> changed;
    int[] array;
    Map<Integer, List<int[]>> snaps;
    int version;

    public SnapshotArray(int length) {
      changed = new HashSet<>();
      array = new int[length];
      snaps = new HashMap<>();
      version = 0;
    }

    public void set(int index, int val) {
      array[index] = val;
      changed.add(index);
    }

    public int snap() {
      for (Integer i : changed) {
        snaps.computeIfAbsent(i, integer -> new ArrayList<>()).add(new int[]{version, array[i]});
      }
      changed.clear();
      return version++;
    }

    public int get(int index, int snap_id) {
      List<int[]> snap = snaps.get(index);
      if (snap == null) {
        return 0;
      }
      return search(snap_id, snap);
    }

    public int search(int value, List<int[]> list) {
      if (value < list.get(0)[0]) {
        return 0;
      }
      int lo = 0;
      int size = list.size();
      int hi = size - 1;
      while (lo <= hi) {
        int mid = (hi + lo) / 2;
        int[] val = list.get(mid);
        if (value < val[0]) {
          hi = mid - 1;
        } else if (value > val[0]) {
          lo = mid + 1;
        } else {
          return val[1];
        }
      }
      return lo >= size ? list.get(size - 1)[1] : list.get(hi)[1];
    }
  }


  class SnapshotArray7 {

    Set<Integer> changed;
    int[] array;
    List<int[]>[] snaps;
    int version;

    public SnapshotArray7(int length) {
      changed = new HashSet<>();
      array = new int[length];
      snaps = new List[length];
      version = 0;
    }

    public void set(int index, int val) {
      array[index] = val;
      changed.add(index);
    }

    public int snap() {
      for (Integer i : changed) {
        List<int[]> snap = snaps[i];
        if (snap == null) {
          snap = new ArrayList<>();
          snaps[i] = snap;
        }
        snap.add(new int[]{version, array[i]});
      }
      changed.clear();
      return version++;
    }

    public int get(int index, int snap_id) {
      List<int[]> snap = snaps[index];
      if (snap == null) {
        return 0;
      }
      return search(snap_id, snap);
    }

    public int search(int value, List<int[]> list) {
      if (value < list.get(0)[0]) {
        return 0;
      }
      int lo = 0;
      int size = list.size();
      int hi = size - 1;
      while (lo <= hi) {
        int mid = (hi + lo) / 2;
        int[] val = list.get(mid);
        if (value < val[0]) {
          hi = mid - 1;
        } else if (value > val[0]) {
          lo = mid + 1;
        } else {
          return val[1];
        }
      }
      return lo >= size ? list.get(size - 1)[1] : list.get(hi)[1];
    }
  }


  class SnapshotArray6 {

    Set<Integer> changed;
    int[] array;
    List<Pair<Integer, Integer>>[] snaps;
    int version;

    public SnapshotArray6(int length) {
      changed = new HashSet<>();
      array = new int[length];
      snaps = new List[length];
      version = 0;
    }

    public void set(int index, int val) {
      array[index] = val;
      changed.add(index);
    }

    public int snap() {
      for (Integer i : changed) {
        List<Pair<Integer, Integer>> snap = snaps[i];
        if (snap == null) {
          snap = new ArrayList<>();
          snaps[i] = snap;
        }
        snap.add(new Pair<>(version, array[i]));
      }
      changed.clear();
      return version++;
    }

    public int get(int index, int snap_id) {
      List<Pair<Integer, Integer>> snap = snaps[index];
      if (snap == null) {
        return 0;
      }
      return search(snap_id, snap);
    }

    public int search(int value, List<Pair<Integer, Integer>> list) {
      if (value < list.get(0).getKey()) {
        return 0;
      }
      int lo = 0;
      int size = list.size();
      int hi = size - 1;
      while (lo <= hi) {
        int mid = (hi + lo) / 2;
        Pair<Integer, Integer> val = list.get(mid);
        if (value < val.getKey()) {
          hi = mid - 1;
        } else if (value > val.getKey()) {
          lo = mid + 1;
        } else {
          return val.getValue();
        }
      }
      return lo >= size ? list.get(size - 1).getValue() : list.get(hi).getValue();
    }
  }


  class SnapshotArray5 {

    Set<Integer> changed;
    int[] array;
    Pair<List<Integer>, Map<Integer, Integer>>[] snaps;
    int version;

    public SnapshotArray5(int length) {
      changed = new HashSet<>();
      array = new int[length];
      snaps = new Pair[length];
      version = 0;
    }

    public void set(int index, int val) {
      array[index] = val;
      changed.add(index);
    }

    public int snap() {
      for (Integer i : changed) {
        Pair<List<Integer>, Map<Integer, Integer>> snap = snaps[i];
        if (snap == null) {
          snap = new Pair<>(new ArrayList<>(), new TreeMap<>());
          snaps[i] = snap;
        }
        snap.getKey().add(version);
        snap.getValue().put(version, array[i]);
      }
      changed.clear();

      return version++;
    }

    public int get(int index, int snap_id) {
      Pair<List<Integer>, Map<Integer, Integer>> snap = snaps[index];
      if (snap == null) {
        return 0;
      }
      return snap.getValue().getOrDefault(search(snap_id, snap.getKey()), 0);
    }

    public int search(int value, List<Integer> list) {
      if (value < list.get(0)) {
        return 0;
      }
      int lo = 0;
      int size = list.size();
      int hi = size - 1;
      while (lo <= hi) {
        int mid = (hi + lo) / 2;
        int val = list.get(mid);
        if (value < val) {
          hi = mid - 1;
        } else if (value > val) {
          lo = mid + 1;
        } else {
          return val;
        }
      }
      return lo >= size ? list.get(size - 1) : list.get(hi);
    }
  }


  class SnapshotArray4 {

    Set<Integer> changed;
    int[] array;
    TreeMap<Integer, Integer>[] snaps;
    int version;

    public SnapshotArray4(int length) {
      changed = new HashSet<>();
      array = new int[length];
      snaps = new TreeMap[length];
      version = 0;
    }

    public void set(int index, int val) {
      array[index] = val;
      changed.add(index);
    }

    public int snap() {
      for (Integer i : changed) {
        TreeMap<Integer, Integer> snap = snaps[i];
        if (snap == null) {
          snap = new TreeMap<>();
          snaps[i] = snap;
        }
        snap.put(version, array[i]);
      }
      changed.clear();
      return version++;
    }

    public int get(int index, int snap_id) {
      TreeMap<Integer, Integer> snap = snaps[index];
      if (snap == null) {
        return 0;
      }
      java.util.Map.Entry<Integer, Integer> floorEntry = snap.floorEntry(snap_id);
      return floorEntry == null ? 0 : floorEntry.getValue();
    }

  }


  class SnapshotArray3 {

    int[] changed;
    int[] array;
    TreeMap<Integer, Integer>[] snaps;
    int version;

    public SnapshotArray3(int length) {
      changed = new int[length];
      array = new int[length];
      snaps = new TreeMap[length];
      version = 0;
    }

    public void set(int index, int val) {
      array[index] = val;
      changed[index] = val;
    }

    public int snap() {
      for (int i = 0; i < changed.length; i++) {
        int n = changed[i];
        if (n != 0) {
          changed[i] = 0;
          TreeMap<Integer, Integer> snap = snaps[i];
          if (snap == null) {
            snap = new TreeMap<>();
            snaps[i] = snap;
          }
          snap.put(version, n);
        }
      }
      return version++;
    }

    public int get(int index, int snap_id) {
      TreeMap<Integer, Integer> snap = snaps[index];
      if (snap == null) {
        return 0;
      }
      java.util.Map.Entry<Integer, Integer> floorEntry = snap.floorEntry(snap_id);
      return floorEntry == null ? 0 : floorEntry.getValue();
    }

  }


  class SnapshotArray2 {

    boolean[] changed;
    int[] array;
    Pair<List<Integer>, Map<Integer, Integer>>[] snaps;
    int version;

    public SnapshotArray2(int length) {
      changed = new boolean[length];
      array = new int[length];
      snaps = new Pair[length];
      version = 0;
    }

    public void set(int index, int val) {
      array[index] = val;
      changed[index] = true;
    }

    public int snap() {
      for (int i = 0; i < changed.length; i++) {
        if (changed[i]) {
          changed[i] = false;
          Pair<List<Integer>, Map<Integer, Integer>> snap = snaps[i];
          if (snap == null) {
            snap = new Pair<>(new ArrayList<>(), new TreeMap<>());
            snaps[i] = snap;
          }
          snap.getKey().add(version);
          snap.getValue().put(version, array[i]);
        }
      }
      return version++;
    }

    public int get(int index, int snap_id) {
      Pair<List<Integer>, Map<Integer, Integer>> snap = snaps[index];
      if (snap == null) {
        return 0;
      }
      return snap.getValue().getOrDefault(search(snap_id, snap.getKey()), 0);
    }

    public int search(int value, List<Integer> list) {
      if (value < list.get(0)) {
        return 0;
      }
      int lo = 0;
      int size = list.size();
      int hi = size - 1;
      while (lo <= hi) {
        int mid = (hi + lo) / 2;
        int val = list.get(mid);
        if (value < val) {
          hi = mid - 1;
        } else if (value > val) {
          lo = mid + 1;
        } else {
          return val;
        }
      }
      return lo >= size ? list.get(size - 1) : list.get(hi);
    }
  }

  class SnapshotArray1 {

    int[] array;
    List<int[]> snaps;

    public SnapshotArray1(int length) {
      array = new int[length];
      snaps = new ArrayList<>();
    }

    public void set(int index, int val) {
      array[index] = val;
    }

    public int snap() {
      int[] ints = Arrays.copyOf(array, array.length);
      snaps.add(ints);
      return snaps.size() - 1;
    }

    public int get(int index, int snap_id) {
      return snaps.get(snap_id)[index];
    }
  }
}
