package com.duanxr.yith.midium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToDoubleFunction;
import javafx.util.Pair;

/**
 * @author 段然 2021/7/12
 */
public class MaximumAveragePassRatio {

  /**
   * There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.
   *
   * You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.
   *
   * The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.
   *
   * Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.
   *
   *  
   *
   * Example 1:
   *
   * Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
   * Output: 0.78333
   * Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
   * Example 2:
   *
   * Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
   * Output: 0.53485
   *  
   *
   * Constraints:
   *
   * 1 <= classes.length <= 105
   * classes[i].length == 2
   * 1 <= passi <= totali <= 105
   * 1 <= extraStudents <= 105
   *
   * 一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。
   *
   * 给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。
   *
   * 一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。
   *
   * 请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10-5 以内的结果都会视为正确结果。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
   * 输出：0.78333
   * 解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
   * 示例 2：
   *
   * 输入：classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
   * 输出：0.53485
   *  
   *
   * 提示：
   *
   * 1 <= classes.length <= 105
   * classes[i].length == 2
   * 1 <= passi <= totali <= 105
   * 1 <= extraStudents <= 105
   *
   */
  class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
      PriorityQueue<double[]> maxQ = new PriorityQueue<>(Comparator.comparingDouble(o -> o[0]));
      PriorityQueue<double[]> minQ = new PriorityQueue<>((o1, o2) -> Double.compare(o2[0], o1[0]));
      double sum = 0D;
      for (int[] aClass : classes) {
        double[] doubles = new double[4];
        doubles[2] = aClass[0];
        doubles[3] = aClass[1];
        toDouble(doubles);
        if (maxQ.size() < extraStudents || maxQ.peek()[0] < doubles[0]) {
          maxQ.offer(doubles);
        } else {
          sum += doubles[1];
        }
        if (maxQ.size() > extraStudents) {
          sum += maxQ.poll()[1];
        }
      }
      minQ.addAll(maxQ);
      for (int i = 0; i < extraStudents; i++) {
        double[] doubles = minQ.poll();
        doubles[2]++;
        doubles[3]++;
        toDouble(doubles);
        minQ.offer(doubles);
      }
      for (double[] doubles : minQ) {
        sum += doubles[1];
      }
      return sum / classes.length;
    }

    private void toDouble(double[] doubles) {
      doubles[1] = doubles[2] / doubles[3];
      doubles[0] = (doubles[2] + 1D) / (doubles[3] + 1D) - doubles[1];
    }
  }


  class Solution7 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
      PriorityQueue<Pair<Double, Pair<Double, Double>>> minQ = new PriorityQueue<>(
          (o1, o2) -> o2.getKey().compareTo(o1.getKey()));
      PriorityQueue<Pair<Double, Pair<Double, Double>>> maxQ = new PriorityQueue<>(
          Comparator.comparingDouble(Pair::getKey));
      double sum = 0D;
      for (int[] aClass : classes) {
        double v = toDouble(aClass[0], aClass[1]);
        if (maxQ.size() < extraStudents || maxQ.peek().getKey() < v) {
          Pair<Double, Double> pair = new Pair<>((double) aClass[0], (double) aClass[1]);
          Pair<Double, Pair<Double, Double>> pp = new Pair<>(v, pair);
          maxQ.offer(pp);
        } else {
          sum += aClass[0] / (double) aClass[1];
        }

        if (maxQ.size() > extraStudents) {
          Pair<Double, Pair<Double, Double>> pair1 = maxQ.poll();
          sum += pair1.getValue().getKey() / pair1.getValue().getValue();
        }
      }
      minQ.addAll(maxQ);
      for (int i = 0; i < extraStudents; i++) {
        Pair<Double, Pair<Double, Double>> pair1 = minQ.poll();
        Pair<Double, Double> pair = new Pair<>(pair1.getValue().getKey() + 1,
            pair1.getValue().getValue() + 1);
        double v = toDouble(pair.getKey(), pair.getValue());
        Pair<Double, Pair<Double, Double>> pp = new Pair<>(v, pair);
        minQ.offer(pp);
      }

      for (Pair<Double, Pair<Double, Double>> pair1 : minQ) {
        sum += pair1.getValue().getKey() / pair1.getValue().getValue();
      }
      return sum / classes.length;
    }

    private double toDouble(double d1, double d2) {
      return (d1 + 1D) / (d2 + 1D) - (d1 / d2);
    }
  }


  class Solution6 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
      PriorityQueue<Pair<Pair<Double, Double>, Pair<Double, Double>>> minQ = new PriorityQueue<>(
          (o1, o2) -> o2.getKey().getKey().compareTo(o1.getKey().getKey()));
      PriorityQueue<Pair<Pair<Double, Double>, Pair<Double, Double>>> maxQ = new PriorityQueue<>(
          Comparator.comparing(o -> o.getKey().getKey()));
      double sum = 0D;
      for (int[] aClass : classes) {
        Pair<Double, Double> v = toDouble(aClass[0], aClass[1]);
        if (maxQ.size() < extraStudents || maxQ.peek().getKey().getKey() < v.getKey()) {
          Pair<Double, Double> pair = new Pair<>((double) aClass[0], (double) aClass[1]);
          Pair<Pair<Double, Double>, Pair<Double, Double>> pp = new Pair<>(v, pair);
          maxQ.offer(pp);
        } else {
          sum += v.getValue();
        }

        if (maxQ.size() > extraStudents) {
          Pair<Pair<Double, Double>, Pair<Double, Double>> pair1 = maxQ.poll();
          sum += pair1.getValue().getKey() / pair1.getValue().getValue();
        }
      }
      minQ.addAll(maxQ);
      for (int i = 0; i < extraStudents; i++) {
        Pair<Pair<Double, Double>, Pair<Double, Double>> pair1 = minQ.poll();
        Pair<Double, Double> pair = new Pair<>(pair1.getValue().getKey() + 1,
            pair1.getValue().getValue() + 1);
        Pair<Double, Double> v = toDouble(pair.getKey(), pair.getValue());
        Pair<Pair<Double, Double>, Pair<Double, Double>> pp = new Pair<>(v, pair);
        minQ.offer(pp);
      }

      for (Pair<Pair<Double, Double>, Pair<Double, Double>> pair1 : minQ) {
        sum += pair1.getKey().getValue();
      }
      return sum / classes.length;
    }

    private Pair<Double, Double> toDouble(double d1, double d2) {
      double cd = d1 / d2;
      double sd = (d1 + 1D) / (d2 + 1D) - cd;
      return new Pair<>(sd, cd);
    }
  }


  class Solution5 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
      PriorityQueue<Pair<Double, Pair<Double, Double>>> minQ = new PriorityQueue<>(
          Comparator.comparingDouble(p -> -p.getKey()));
      PriorityQueue<Pair<Double, Pair<Double, Double>>> maxQ = new PriorityQueue<>(
          Comparator.comparingDouble(Pair::getKey));
      double sum = 0D;
      for (int[] aClass : classes) {
        Pair<Double, Double> pair = new Pair<>((double) aClass[0], (double) aClass[1]);
        double v = toDouble(pair);
        Pair<Double, Pair<Double, Double>> pp = new Pair<>(v, pair);
        if (maxQ.size() < extraStudents || maxQ.peek().getKey() < v) {
          maxQ.offer(pp);
        } else {
          sum += pair.getKey() / pair.getValue();
        }
        if (maxQ.size() > extraStudents) {
          Pair<Double, Pair<Double, Double>> pair1 = maxQ.poll();
          sum += pair1.getValue().getKey() / pair1.getValue().getValue();
        }
      }
      minQ.addAll(maxQ);
      for (int i = 0; i < extraStudents; i++) {
        Pair<Double, Pair<Double, Double>> pair1 = minQ.poll();
        Pair<Double, Double> pair = new Pair<>(pair1.getValue().getKey() + 1,
            pair1.getValue().getValue() + 1);
        double v = toDouble(pair);
        Pair<Double, Pair<Double, Double>> pp = new Pair<>(v, pair);
        minQ.offer(pp);
      }

      for (Pair<Double, Pair<Double, Double>> pair1 : minQ) {
        sum += pair1.getValue().getKey() / pair1.getValue().getValue();
      }
      return sum / classes.length;
    }

    private double toDouble(Pair<Double, Double> pair) {
      return (pair.getKey() + 1D) / (pair.getValue() + 1D) - (pair.getKey() / pair.getValue());
    }
  }

  class Solution4 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
      PriorityQueue<Pair<Double, Double>> queue = new PriorityQueue<>(
          Comparator.comparingDouble(this::toDouble));
      for (int[] aClass : classes) {
        queue.offer(new Pair<>((double) aClass[0], (double) aClass[1]));
      }

      for (int i = 0; i < extraStudents; i++) {
        Pair<Double, Double> poll = queue.poll();
        queue.offer(new Pair<>(poll.getKey() + 1D, poll.getValue() + 1D));
      }

      double sum = 0D;
      for (Pair<Double, Double> pair : queue) {
        sum += pair.getKey() / pair.getValue();
      }
      return sum / classes.length;
    }

    private double toDouble(Pair<Double, Double> pair) {
      return (pair.getKey() / pair.getValue()) - (pair.getKey() + 1D) / (pair.getValue() + 1D);
    }
  }


  class Solution3 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
      PriorityQueue<Pair<Double, Double>> queue = new PriorityQueue<>(Comparator.comparingDouble(
          value -> (value.getKey() / value.getValue()) - ((value.getKey() + 1D) / (value.getValue()
              + 1D))));
      for (int[] aClass : classes) {
        queue.offer(new Pair<>((double) aClass[0], (double) aClass[1]));
      }
      for (int i = 0; i < extraStudents; i++) {
        Pair<Double, Double> poll = queue.poll();
        queue.offer(new Pair<>(poll.getKey() + 1D, poll.getValue() + 1D));
      }
      double sum = 0D;
      for (Pair<Double, Double> pair : queue) {
        sum += pair.getKey() / pair.getValue();
      }
      return sum / classes.length;
    }
  }


  class Solution2 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
      ToDoubleFunction<Pair<Double, Double>> toDoubleFunction = value ->
          (value.getKey() / value.getValue()) - ((value.getKey() + 1D) / (value.getValue()
              + 1D));

      PriorityQueue<Pair<Double, Double>> queue = new PriorityQueue<>(Comparator.comparingDouble(
          toDoubleFunction));
      for (int[] aClass : classes) {
        Pair<Double, Double> e = new Pair<>((double) aClass[0], (double) aClass[1]);
        queue.offer(e);
      }
      for (int i = 0; i < extraStudents; i++) {
        System.out.println(queue);
        Pair<Double, Double> poll = queue.poll();
        queue.offer(new Pair<>(poll.getKey() + 1D, poll.getValue() + 1D));
      }
      double sum = 0D;
      for (Pair<Double, Double> pair : queue) {
        sum += pair.getKey() / pair.getValue();
      }
      return sum / classes.length;
    }
  }


  class Solution1 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
      ToDoubleFunction<Pair<Double, Double>> toDoubleFunction = value ->
          (value.getKey() / value.getValue()) - ((value.getKey() + 1D) / (value.getValue()
              + 1D));
      PriorityQueue<Pair<Double, Double>> queue = new PriorityQueue<>(Comparator.comparingDouble(
          toDoubleFunction));
      for (int[] aClass : classes) {
        Pair<Double, Double> e = new Pair<>((double) aClass[0], (double) aClass[1]);
        queue.offer(e);
      }
      for (int i = 0; i < extraStudents; i++) {
        System.out.println(queue);
        Pair<Double, Double> poll = queue.poll();
        queue.offer(new Pair<>(poll.getKey() + 1D, poll.getValue() + 1D));
      }
      double sum = 0D;
      for (Pair<Double, Double> pair : queue) {
        sum += pair.getKey() / pair.getValue();
      }
      return sum / classes.length;
    }
  }
}
