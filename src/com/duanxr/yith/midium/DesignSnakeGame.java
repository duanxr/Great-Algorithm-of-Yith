package com.duanxr.yith.midium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 段然 2021/10/21
 */
public class DesignSnakeGame {

  /**
   * Design a Snake game that is played on a device with screen size height x width. Play the game online if you are not familiar with the game.
   *
   * The snake is initially positioned at the top left corner (0, 0) with a length of 1 unit.
   *
   * You are given an array food where food[i] = (ri, ci) is the row and column position of a piece of food that the snake can eat. When a snake eats a piece of food, its length and the game's score both increase by 1.
   *
   * Each piece of food appears one by one on the screen, meaning the second piece of food will not appear until the snake eats the first piece of food.
   *
   * When a piece of food appears on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
   *
   * The game is over if the snake goes out of bounds (hits a wall) or if its head occupies a space that its body occupies after moving (i.e. a snake of length 4 cannot run into itself).
   *
   * Implement the SnakeGame class:
   *
   * SnakeGame(int width, int height, int[][] food) Initializes the object with a screen of size height x width and the positions of the food.
   * int move(String direction) Returns the score of the game after applying one direction move by the snake. If the game is over, return -1.
   *  
   *
   * Example 1:
   *
   *
   * Input
   * ["SnakeGame", "move", "move", "move", "move", "move", "move"]
   * [[3, 2, [[1, 2], [0, 1]]], ["R"], ["D"], ["R"], ["U"], ["L"], ["U"]]
   * Output
   * [null, 0, 0, 1, 1, 2, -1]
   *
   * Explanation
   * SnakeGame snakeGame = new SnakeGame(3, 2, [[1, 2], [0, 1]]);
   * snakeGame.move("R"); // return 0
   * snakeGame.move("D"); // return 0
   * snakeGame.move("R"); // return 1, snake eats the first piece of food. The second piece of food appears at (0, 1).
   * snakeGame.move("U"); // return 1
   * snakeGame.move("L"); // return 2, snake eats the second food. No more food appears.
   * snakeGame.move("U"); // return -1, game over because snake collides with border
   *  
   *
   * Constraints:
   *
   * 1 <= width, height <= 104
   * 1 <= food.length <= 50
   * food[i].length == 2
   * 0 <= ri < height
   * 0 <= ci < width
   * direction.length == 1
   * direction is 'U', 'D', 'L', or 'R'.
   * At most 104 calls will be made to move.
   *
   * 请你设计一个 贪吃蛇游戏，该游戏将会在一个 屏幕尺寸 = 宽度 x 高度 的屏幕上运行。如果你不熟悉这个游戏，可以 点击这里 在线试玩。
   *
   * 起初时，蛇在左上角的 (0, 0) 位置，身体长度为 1 个单位。
   *
   * 你将会被给出一个数组形式的食物位置序列 food ，其中 food[i] = (ri, ci) 。当蛇吃到食物时，身子的长度会增加 1 个单位，得分也会 +1 。
   *
   * 食物不会同时出现，会按列表的顺序逐一显示在屏幕上。比方讲，第一个食物被蛇吃掉后，第二个食物才会出现。
   *
   * 当一个食物在屏幕上出现时，保证 不会 出现在被蛇身体占据的格子里。
   *
   * 如果蛇越界（与边界相撞）或者头与 移动后 的身体相撞（即，身长为 4 的蛇无法与自己相撞），游戏结束。
   *
   * 实现 SnakeGame 类：
   *
   * SnakeGame(int width, int height, int[][] food) 初始化对象，屏幕大小为 height x width ，食物位置序列为 food
   * int move(String direction) 返回蛇在方向 direction 上移动后的得分。如果游戏结束，返回 -1 。
   *  
   * 示例 1：
   *
   *
   * 输入：
   * ["SnakeGame", "move", "move", "move", "move", "move", "move"]
   * [[3, 2, [[1, 2], [0, 1]]], ["R"], ["D"], ["R"], ["U"], ["L"], ["U"]]
   * 输出：
   * [null, 0, 0, 1, 1, 2, -1]
   *
   * 解释：
   * SnakeGame snakeGame = new SnakeGame(3, 2, [[1, 2], [0, 1]]);
   * snakeGame.move("R"); // 返回 0
   * snakeGame.move("D"); // 返回 0
   * snakeGame.move("R"); // 返回 1 ，蛇吃掉了第一个食物，同时第二个食物出现在 (0, 1)
   * snakeGame.move("U"); // 返回 1
   * snakeGame.move("L"); // 返回 2 ，蛇吃掉了第二个食物，没有出现更多食物
   * snakeGame.move("U"); // 返回 -1 ，蛇与边界相撞，游戏结束
   *  
   *
   * 提示：
   *
   * 1 <= width, height <= 104
   * 1 <= food.length <= 50
   * food[i].length == 2
   * 0 <= ri < height
   * 0 <= ci < width
   * direction.length == 1
   * direction is 'U', 'D', 'L', or 'R'.
   * 最多调用 104 次 move 方法
   *
   */
  class SnakeGame {

    int[][] food;
    Deque<int[]> snake;
    int width, height, foodIndex;


    public SnakeGame(int width, int height, int[][] food) {
      this.food = food;
      this.width = width;
      this.height = height;
      this.foodIndex = 0;
      this.snake = new ArrayDeque<>();
      snake.offer(new int[]{0, 0});
    }

    public int move(String direction) {
      int[] head = snake.peekLast();
      int[] next = null;
      switch (direction) {
        case "R":
          next = new int[]{head[0] + 1, head[1]};
          if (next[0] == width) {
            return -1;
          }
          break;
        case "D":
          next = new int[]{head[0], head[1] + 1};
          if (next[1] == height) {
            return -1;
          }
          break;
        case "L":
          next = new int[]{head[0] - 1, head[1]};
          if (next[0] == -1) {
            return -1;
          }
          break;
        default:
          next = new int[]{head[0], head[1] - 1};
          if (next[1] == -1) {
            return -1;
          }
      }
      if (foodIndex < food.length && food[foodIndex][0] == next[1]
          && food[foodIndex][1] == next[0]) {
        foodIndex++;
      } else {
        snake.poll();
      }
      for (int[] body : snake) {
        if (body[0] == next[0] && body[1] == next[1]) {
          return -1;
        }
      }
      snake.offer(next);
      return foodIndex;
    }
  }


  class SnakeGame3 {

    int[][] food;
    Deque<int[]> snake;
    int width, height, foodIndex;


    public SnakeGame3(int width, int height, int[][] food) {
      this.food = food;
      this.width = width;
      this.height = height;
      this.foodIndex = 0;
      this.snake = new ArrayDeque<>();
      snake.offer(new int[]{0, 0});
    }

    public int move(String direction) {
      int[] head = snake.peekLast();
      int[] next = null;
      switch (direction) {
        case "R":
          next = new int[]{head[0] + 1, head[1]};
          if (next[0] == width) {
            return -1;
          }
          break;
        case "D":
          next = new int[]{head[0], head[1] + 1};
          if (next[1] == height) {
            return -1;
          }
          break;
        case "L":
          next = new int[]{head[0] - 1, head[1]};
          if (next[0] == -1) {
            return -1;
          }
          break;
        default:
          next = new int[]{head[0], head[1] - 1};
          if (next[1] == -1) {
            return -1;
          }
      }
      if (foodIndex < food.length && food[foodIndex][0] == next[1]
          && food[foodIndex][1] == next[0]) {
        foodIndex++;
      } else {
        snake.poll();
      }
      for (int[] body : snake) {
        if (body[0] == next[0] && body[1] == next[1]) {
          return -1;
        }
      }
      snake.offer(next);
      return foodIndex;
    }
  }


  class SnakeGame2 {

    int[][] food;
    int fi;
    int p;
    ArrayDeque<int[]> s;
    int width, height;


    public SnakeGame2(int width, int height, int[][] food) {
      this.food = food;
      this.fi = 0;
      this.p = 0;
      this.s = new ArrayDeque<>();
      s.offer(new int[]{0, 0});
      this.width = width;
      this.height = height;
    }

    public int move(String direction) {
      int[] peek = s.peekLast();
      int[] n = null;
      switch (direction) {
        case "R":
          n = new int[]{peek[0] + 1, peek[1]};
          if (n[0] == width) {
            return -1;
          }
          break;
        case "D":
          n = new int[]{peek[0], peek[1] + 1};
          if (n[1] == height) {
            return -1;
          }
          break;
        case "L":
          n = new int[]{peek[0] - 1, peek[1]};
          if (n[0] == -1) {
            return -1;
          }
          break;
        default:
          n = new int[]{peek[0], peek[1] - 1};
          if (n[1] == -1) {
            return -1;
          }
      }
      if (fi < food.length && food[fi][0] == n[1] && food[fi][1] == n[0]) {
        fi++;
      } else {
        int[] poll = s.poll();
      }
      for (int[] ints : s) {
        if (ints[0] == n[0] && ints[1] == n[1]) {
          return -1;
        }
      }
      s.offer(n);
      return s.size() - 1;
    }
  }


  class SnakeGame1 {

    int[][] food;
    int fi;
    int p;
    ArrayDeque<int[]> s;
    int width, height;
    Set<String> body;


    public SnakeGame1(int width, int height, int[][] food) {
      this.food = food;
      this.fi = 0;
      this.p = 0;
      this.s = new ArrayDeque<>();
      s.offer(new int[]{0, 0});
      this.width = width;
      this.height = height;
      this.body = new HashSet<>();

    }

    public int move(String direction) {
      int[] peek = s.peekLast();
      int[] n = null;
      switch (direction) {
        case "R":
          n = new int[]{peek[0] + 1, peek[1]};
          if (n[0] == width) {
            return -1;
          }
          break;
        case "D":
          n = new int[]{peek[0], peek[1] + 1};
          if (n[1] == height) {
            return -1;
          }
          break;
        case "L":
          n = new int[]{peek[0] - 1, peek[1]};
          if (n[0] == -1) {
            return -1;
          }
          break;
        default:
          n = new int[]{peek[0], peek[1] - 1};
          if (n[1] == -1) {
            return -1;
          }
      }
      if (fi < food.length && food[fi][0] == n[1] && food[fi][1] == n[0]) {
        fi++;
      } else {
        int[] poll = s.poll();
        body.remove(poll[0] + "-" + poll[1]);
      }
      s.offer(n);
      if (!body.add(n[0] + "-" + n[1])) {
        return -1;
      }
      return s.size() - 1;
    }
  }

}
