package com.duanxr.yith.midium;

/**
 * @author 段然 2021/5/13
 */
public class DesignBrowserHistory {

  /**
   * You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.
   *
   * Implement the BrowserHistory class:
   *
   * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
   * void visit(string url) Visits url from the current page. It clears up all the forward history.
   * string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
   * string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
   *  
   *
   * Example:
   *
   * Input:
   * ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
   * [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
   * Output:
   * [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
   *
   * Explanation:
   * BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
   * browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
   * browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
   * browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
   * browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
   * browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
   * browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
   * browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
   * browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
   * browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
   * browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
   *  
   *
   * Constraints:
   *
   * 1 <= homepage.length <= 20
   * 1 <= url.length <= 20
   * 1 <= steps <= 100
   * homepage and url consist of  '.' or lower case English letters.
   * At most 5000 calls will be made to visit, back, and forward.
   *
   * 你有一个只支持单个标签页的 浏览器 ，最开始你浏览的网页是 homepage ，你可以访问其他的网站 url ，也可以在浏览历史中后退 steps 步或前进 steps 步。
   *
   * 请你实现 BrowserHistory 类：
   *
   * BrowserHistory(string homepage) ，用 homepage 初始化浏览器类。
   * void visit(string url) 从当前页跳转访问 url 对应的页面  。执行此操作会把浏览历史前进的记录全部删除。
   * string back(int steps) 在浏览历史中后退 steps 步。如果你只能在浏览历史中后退至多 x 步且 steps > x ，那么你只后退 x 步。请返回后退 至多 steps 步以后的 url 。
   * string forward(int steps) 在浏览历史中前进 steps 步。如果你只能在浏览历史中前进至多 x 步且 steps > x ，那么你只前进 x 步。请返回前进 至多 steps步以后的 url 。
   *  
   *
   * 示例：
   *
   * 输入：
   * ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
   * [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
   * 输出：
   * [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
   *
   * 解释：
   * BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
   * browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
   * browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
   * browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
   * browserHistory.back(1);                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
   * browserHistory.back(1);                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
   * browserHistory.forward(1);                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
   * browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
   * browserHistory.forward(2);                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
   * browserHistory.back(2);                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
   * browserHistory.back(7);                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
   *  
   *
   * 提示：
   *
   * 1 <= homepage.length <= 20
   * 1 <= url.length <= 20
   * 1 <= steps <= 100
   * homepage 和 url 都只包含 '.' 或者小写英文字母。
   * 最多调用 5000 次 visit， back 和 forward 函数。
   *
   */
  class BrowserHistory {

    private String[] histories;

    private int size;

    private int index;

    public BrowserHistory(String homepage) {
      histories = new String[5000];
      histories[0] = homepage;
      size = 0;
      index = 0;
    }

    public void visit(String url) {
      histories[++index] = url;
      size = index;
    }

    public String back(int steps) {
      index -= steps;
      if (index < 0) {
        index = 0;
      }
      return histories[index];
    }

    public String forward(int steps) {
      index += steps;
      if (index > size) {
        index = size;
      }
      return histories[index];
    }
  }

}
