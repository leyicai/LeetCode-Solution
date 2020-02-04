import java.util.List;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word))
                res.add(word);
        }
        return res;
    }

    private boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && search(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx))
            return false;
        board[i][j] ^= 256;
        boolean found = search(board, word, i - 1, j, idx + 1) || search(board, word, i + 1, j, idx + 1)
                || search(board, word, i, j - 1, idx + 1) || search(board, word, i, j + 1, idx + 1);
        board[i][j] ^= 256;
        return found;
    }

    // with Trie
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;

        TrieNode() {
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtracking(board, i, j, root, res);
            }
        }
        return res;
    }

    private void backtracking(char[][] board, int i, int j, TrieNode curr, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        char c = board[i][j];
        if (c == '#' || curr.children[c - 'a'] == null) {
            // not found
            return;
        }
        curr = curr.children[c - 'a'];
        if (curr.word != null) {
            // word found
            res.add(curr.word);
            curr.word = null; // de-duplicate
        }
        board[i][j] = '#'; // mark visited position
        // explore on four directions
        backtracking(board, i - 1, j, curr, res);
        backtracking(board, i + 1, j, curr, res);
        backtracking(board, i, j - 1, curr, res);
        backtracking(board, i, j + 1, curr, res);
        board[i][j] = c; // resume visited mark
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.word = word;
        }
        return root;
    }

}
// @lc code=end
