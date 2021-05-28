package com.duanxr.yith.midium;

/**
 * @author 段然 2021/5/27
 */
public class StatisticsFromALargeSample {

  /**
   * You are given a large sample of integers in the range [0, 255]. Since the sample is so large, it is represented by an array count where count[k] is the number of times that k appears in the sample.
   *
   * Calculate the following statistics:
   *
   * minimum: The minimum element in the sample.
   * maximum: The maximum element in the sample.
   * mean: The average of the sample, calculated as the total sum of all elements divided by the total number of elements.
   * median:
   * If the sample has an odd number of elements, then the median is the middle element once the sample is sorted.
   * If the sample has an even number of elements, then the median is the average of the two middle elements once the sample is sorted.
   * mode: The number that appears the most in the sample. It is guaranteed to be unique.
   * Return the statistics of the sample as an array of floating-point numbers [minimum, maximum, mean, median, mode]. Answers within 10-5 of the actual answer will be accepted.
   *
   *  
   *
   * Example 1:
   *
   * Input: count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
   * Output: [1.00000,3.00000,2.37500,2.50000,3.00000]
   * Explanation: The sample represented by count is [1,2,2,2,3,3,3,3].
   * The minimum and maximum are 1 and 3 respectively.
   * The mean is (1+2+2+2+3+3+3+3) / 8 = 19 / 8 = 2.375.
   * Since the size of the sample is even, the median is the average of the two middle elements 2 and 3, which is 2.5.
   * The mode is 3 as it appears the most in the sample.
   * Example 2:
   *
   * Input: count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
   * Output: [1.00000,4.00000,2.18182,2.00000,1.00000]
   * Explanation: The sample represented by count is [1,1,1,1,2,2,2,3,3,4,4].
   * The minimum and maximum are 1 and 4 respectively.
   * The mean is (1+1+1+1+2+2+2+3+3+4+4) / 11 = 24 / 11 = 2.18181818... (for display purposes, the output shows the rounded number 2.18182).
   * Since the size of the sample is odd, the median is the middle element 2.
   * The mode is 1 as it appears the most in the sample.
   *  
   *
   * Constraints:
   *
   * count.length == 256
   * 0 <= count[i] <= 109
   * 1 <= sum(count) <= 109
   * The mode of the sample that count represents is unique.
   *
   *
   * 我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 的采样个数。
   *
   * 我们以 浮点数 数组的形式，分别返回样本的最小值、最大值、平均值、中位数和众数。其中，众数是保证唯一的。
   *
   * 我们先来回顾一下中位数的知识：
   *
   * 如果样本中的元素有序，并且元素数量为奇数时，中位数为最中间的那个元素；
   * 如果样本中的元素有序，并且元素数量为偶数时，中位数为中间的两个元素的平均值。
   *  
   *
   * 示例 1：
   *
   * 输入：count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
   * 输出：[1.00000,3.00000,2.37500,2.50000,3.00000]
   * 示例 2：
   *
   * 输入：count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
   * 输出：[1.00000,4.00000,2.18182,2.00000,1.00000]
   *  
   *
   * 提示：
   *
   * count.length == 256
   * 1 <= sum(count) <= 10^9
   * 计数表示的众数是唯一的
   * 答案与真实值误差在 10^-5 以内就会被视为正确答案
   *
   */
  class Solution {

    public double[] sampleStats(int[] count) {

      double min = -1;
      double max = 0;
      double mode = 0;
      double median = 0;

      int modeVote = 0;
      int numberCount = 0;

      long sum = 0;

      for (int n = 0; n < count.length; n++) {
        int c = count[n];
        if (c != 0) {
          sum += (long) c * n;
          numberCount += c;
          if (min == -1) {
            min = n;
          }
          max = n;
          if (c > modeVote) {
            modeVote = c;
            mode = n;
          }
        }
      }
      int median1 = numberCount / 2 + 1;
      int median2 = (numberCount - 1) / 2 + 1;

      for (int n = 0; n < count.length; n++) {
        int c = count[n];
        if (median1 >= 0) {
          if (median1 <= c) {
            median += n;
            median1 = -1;
            if (median2 == -1) {
              break;
            }
          } else {
            median1 -= c;
          }
        }
        if (median2 >= 0) {
          if (median2 <= c) {
            median += n;
            median2 = -1;
            if (median1 == -1) {
              break;
            }
          } else {
            median2 -= c;
          }
        }
      }

      double mean = sum / (double) numberCount;
      median /= 2;
      return new double[]{min, max, mean, median, mode};
    }
  }


  class Solution1 {

    public double[] sampleStats(int[] count) {

      double min = -1;
      double max = -1;
      long sum = 0;
      double mode = 0;
      double median = 0;

      int modeVote = 0;
      int numberTotal = 0;

      for (int n = 0; n < count.length; n++) {
        int c = count[n];
        if (c != 0) {
          sum += (long) c * n;
          numberTotal += c;
          if (min == -1) {
            min = n;
          }
          max = n;
          if (c > modeVote) {
            modeVote = c;
            mode = n;
          }
        }
      }
      int median1 = numberTotal / 2 + 1;
      int median2 = (numberTotal - 1) / 2 + 1;

      for (int n = 0; n < count.length; n++) {
        int c = count[n];
        if (median1 >= 0) {
          if (median1 <= c) {
            median += n;
            median1 = -1;
          } else {
            median1 -= c;
          }
        }
        if (median2 >= 0) {
          if (median2 <= c) {
            median += n;
            median2 = -1;
          } else {
            median2 -= c;
          }
        }
      }

      double mean = sum / (double) numberTotal;
      median /= 2;
      return new double[]{min, max, mean, median, mode};
    }
  }
}
