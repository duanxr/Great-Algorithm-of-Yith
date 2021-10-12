package com.duanxr.yith.midium;

import java.util.Iterator;

/**
 * @author 段然 2021/10/12
 */
public class PeekingIterator implements Iterator<Integer> {

  /**
   * Design an iterator that supports the peek operation on a list in addition to the hasNext and the next operations.
   *
   * Implement the PeekingIterator class:
   *
   * PeekingIterator(int[] nums) Initializes the object with the given integer array nums.
   * int next() Returns the next element in the array and moves the pointer to the next element.
   * bool hasNext() Returns true if there are still elements in the array.
   * int peek() Returns the next element in the array without moving the pointer.
   *  
   *
   * Example 1:
   *
   * Input
   * ["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
   * [[[1, 2, 3]], [], [], [], [], []]
   * Output
   * [null, 1, 2, 2, 3, false]
   *
   * Explanation
   * PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
   * peekingIterator.next();    // return 1, the pointer moves to the next element [1,2,3].
   * peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
   * peekingIterator.next();    // return 2, the pointer moves to the next element [1,2,3]
   * peekingIterator.next();    // return 3, the pointer moves to the next element [1,2,3]
   * peekingIterator.hasNext(); // return False
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 1000
   * 1 <= nums[i] <= 1000
   * All the calls to next and peek are valid.
   * At most 1000 calls will be made to next, hasNext, and peek.
   *  
   *
   * Follow up: How would you extend your design to be generic and work with all types, not just integer?
   *
   * 请你设计一个迭代器，除了支持 hasNext 和 next 操作外，还支持 peek 操作。
   *
   * 实现 PeekingIterator 类：
   *
   * PeekingIterator(int[] nums) 使用指定整数数组 nums 初始化迭代器。
   * int next() 返回数组中的下一个元素，并将指针移动到下个元素处。
   * bool hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。
   * int peek() 返回数组中的下一个元素，但 不 移动指针。
   *  
   *
   * 示例：
   *
   * 输入：
   * ["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
   * [[[1, 2, 3]], [], [], [], [], []]
   * 输出：
   * [null, 1, 2, 2, 3, false]
   *
   * 解释：
   * PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
   * peekingIterator.next();    // 返回 1 ，指针移动到下一个元素 [1,2,3]
   * peekingIterator.peek();    // 返回 2 ，指针未发生移动 [1,2,3]
   * peekingIterator.next();    // 返回 2 ，指针移动到下一个元素 [1,2,3]
   * peekingIterator.next();    // 返回 3 ，指针移动到下一个元素 [1,2,3]
   * peekingIterator.hasNext(); // 返回 False
   *  
   *
   * 提示：
   *
   * 1 <= nums.length <= 1000
   * 1 <= nums[i] <= 1000
   * 对 next 和 peek 的调用均有效
   * next、hasNext 和 peek 最多调用  1000 次
   *  
   *
   * 进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？
   *
   */
  private Integer peek = null;
  private final Iterator<Integer> iterator;

  public PeekingIterator(Iterator<Integer> iterator) {
    this.iterator = iterator;
    if (iterator.hasNext()) {
      this.peek = iterator.next();
    }
  }

  public Integer peek() {
    return peek;
  }

  @Override
  public Integer next() {
    Integer integer = this.peek;
    this.peek = iterator.hasNext() ? iterator.next() : null;
    return integer;
  }

  @Override
  public boolean hasNext() {
    return peek != null;
  }
}
