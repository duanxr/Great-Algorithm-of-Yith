package com.duanxr.yith.easy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Duanran 2019/3/11 0011
 */
public class RevealCardsInIncreasingOrder {

  /**
   * The first entry in the answer is considered to be the top of the deck.
   *
   * Example 1:
   *
   * Input: [17,13,11,2,3,5,7]
   *
   * Output: [2,13,3,11,5,17,7]
   *
   * Explanation:
   *
   * We get the deck in the order [17,13,11,2,3,5,7] (this order doesn't matter), and reorder it.
   *
   * After reordering, the deck starts as [2,13,3,11,5,17,7], where 2 is the top of the deck.
   *
   * We reveal 2, and move 13 to the bottom.  The deck is now [3,11,5,17,7,13].
   *
   * We reveal 3, and move 11 to the bottom.  The deck is now [5,17,7,13,11].
   *
   * We reveal 5, and move 17 to the bottom.  The deck is now [7,13,11,17].
   *
   * We reveal 7, and move 13 to the bottom.  The deck is now [11,17,13].
   *
   * We reveal 11, and move 17 to the bottom.  The deck is now [13,17].
   *
   * We reveal 13, and move 17 to the bottom.  The deck is now [17].
   *
   * We reveal 17.
   *
   * Since all the cards revealed are in increasing order, the answer is correct.
   *
   *
   * Note:
   *
   * 1 <= A.length <= 1000
   *
   * 1 <= A[i] <= 10^6
   *
   * A[i] != A[j] for all i != j
   *
   * 牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。
   *
   * 最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。
   *
   * 现在，重复执行以下步骤，直到显示所有卡牌为止：
   *
   * 从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
   *
   * 如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
   *
   * 如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
   *
   * 返回能以递增顺序显示卡牌的牌组顺序。
   *
   * 答案中的第一张牌被认为处于牌堆顶部。
   *
   *
   *
   * 示例：
   *
   * 输入：[17,13,11,2,3,5,7]
   *
   * 输出：[2,13,3,11,5,17,7]
   *
   * 解释：
   *
   * 我们得到的牌组顺序为 [17,13,11,2,3,5,7]（这个顺序不重要），然后将其重新排序。
   *
   * 重新排序后，牌组以 [2,13,3,11,5,17,7] 开始，其中 2 位于牌组的顶部。
   *
   * 我们显示 2，然后将 13 移到底部。牌组现在是 [3,11,5,17,7,13]。
   *
   * 我们显示 3，并将 11 移到底部。牌组现在是 [5,17,7,13,11]。
   *
   * 我们显示 5，然后将 17 移到底部。牌组现在是 [7,13,11,17]。
   *
   * 我们显示 7，并将 13 移到底部。牌组现在是 [11,17,13]。
   *
   * 我们显示 11，然后将 17 移到底部。牌组现在是 [13,17]。
   *
   * 我们展示 13，然后将 17 移到底部。牌组现在是 [17]。
   *
   * 我们显示 17。
   *
   * 由于所有卡片都是按递增顺序排列显示的，所以答案是正确的。
   *
   *
   * 提示：
   *
   * 1 <= A.length <= 1000
   *
   * 1 <= A[i] <= 10^6
   *
   * 对于所有的 i != j，A[i] != A[j]
   */
  class Solution {

    public int[] deckRevealedIncreasing(int[] deck) {
      Arrays.sort(deck);
      LinkedList<Integer> stack = new LinkedList<>();
      for (int i = deck.length - 1; i >= 0; i--) {
        if (!stack.isEmpty()) {
          stack.addFirst(stack.removeLast());
        }
        stack.addFirst(deck[i]);
      }
      for (int i = 0; i < deck.length; i++) {
        deck[i] = stack.removeFirst();
      }
      return deck;
    }
  }
}
