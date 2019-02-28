package com.duanxr.yith.easy;

/**
 * @author Duanran 2019/2/27 0027
 */
public class NumberOfSegmentsInAString {

  class Solution {

    public int countSegments(String s) {
      char[] chars = s.toCharArray();
      int count = 0;
      boolean crossLetter = false;
      for (int i = chars.length - 1; i >= 0; i--) {
        if (chars[i] == ' ') {
          if (crossLetter) {
            count++;
          }
          crossLetter = false;
        } else {
          crossLetter = true;
        }
      }
      return crossLetter ? count + 1 : count;
    }
  }
}
