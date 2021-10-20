package com.duanxr.yith.midium;

/**
 * @author 段然 2021/10/20
 */
public class DesignAddAndSearchWordsDataStructure {

  /**
   * Design a data structure that supports adding new words and finding if a string matches any previously added string.
   *
   * Implement the WordDictionary class:
   *
   * WordDictionary() Initializes the object.
   * void addWord(word) Adds word to the data structure, it can be matched later.
   * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
   *  
   *
   * Example:
   *
   * Input
   * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
   * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
   * Output
   * [null,null,null,null,false,true,true,true]
   *
   * Explanation
   * WordDictionary wordDictionary = new WordDictionary();
   * wordDictionary.addWord("bad");
   * wordDictionary.addWord("dad");
   * wordDictionary.addWord("mad");
   * wordDictionary.search("pad"); // return False
   * wordDictionary.search("bad"); // return True
   * wordDictionary.search(".ad"); // return True
   * wordDictionary.search("b.."); // return True
   *  
   *
   * Constraints:
   *
   * 1 <= word.length <= 500
   * word in addWord consists lower-case English letters.
   * word in search consist of  '.' or lower-case English letters.
   * At most 50000 calls will be made to addWord and search.
   *
   * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
   *
   * 实现词典类 WordDictionary ：
   *
   * WordDictionary() 初始化词典对象
   * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
   * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
   *  
   *
   * 示例：
   *
   * 输入：
   * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
   * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
   * 输出：
   * [null,null,null,null,false,true,true,true]
   *
   * 解释：
   * WordDictionary wordDictionary = new WordDictionary();
   * wordDictionary.addWord("bad");
   * wordDictionary.addWord("dad");
   * wordDictionary.addWord("mad");
   * wordDictionary.search("pad"); // return False
   * wordDictionary.search("bad"); // return True
   * wordDictionary.search(".ad"); // return True
   * wordDictionary.search("b.."); // return True
   *  
   *
   * 提示：
   *
   * 1 <= word.length <= 500
   * addWord 中的 word 由小写英文字母组成
   * search 中的 word 由 '.' 或小写英文字母组成
   * 最多调用 50000 次 addWord 和 search
   *
   */
  class WordDictionary {

    class Word {

      Word[] next = new Word[26];

      boolean endHere = false;

      Word() {
      }

    }

    Word root = new Word();

    public WordDictionary() {

    }

    public void addWord(String word) {
      Word w = null;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        int ci = c - 'a';
        if (i == 0) {
          w = root.next[ci];
          if (w == null) {
            w = new Word();
            root.next[ci] = w;
          }
        } else {
          Word wn = w.next[ci];
          if (wn == null) {
            wn = new Word();
            w.next[ci] = wn;
          }
          w = wn;
        }
      }
      w.endHere = true;
    }


    public boolean search(String word) {
      return find(root, word, 0);
    }

    private boolean find(Word root, String word, int i) {
      if (root == null) {
        return false;
      }
      if (i == word.length()) {
        return root.endHere;
      }
      char c = word.charAt(i);
      if (c == '.') {
        for (Word w : root.next) {
          if (find(w, word, i + 1)) {
            return true;
          }
        }
        return false;
      } else {
        return find(root.next[c - 'a'], word, i + 1);
      }
    }
  }
}
