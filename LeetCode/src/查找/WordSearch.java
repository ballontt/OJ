package 查找;

/**
 * Created by ballontt on 2017/9/11.
 *
 * Question:
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * [
 * ["ABCE"],
 * ["SFCS"],
 * ["ADEE"]
 * ]
 * word ="ABCCED", -> returnstrue,
 * word ="SEE", -> returnstrue,
 * word ="ABCB", -> returnsfalse.
 *
 * Answer:
 *
 */
public class WordSearch {
    public static boolean[][] visted;
    public static boolean exist(char[][] board, String word) {
        visted = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {

                if(word.charAt(0) == board[i][j] &&  getPath(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean getPath(char[][] board, int i, int j, String word, int index) {
        if(index == word.length()){
            return true;
        }

        if( i < 0 || i >= board.length || j < 0 || j >= board[i].length || visted[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visted[i][j] = true;
        if(getPath(board, i - 1, j, word, index+1) ||
                getPath(board, i + 1, j, word, index+1) ||
                getPath(board, i, j - 1, word, index + 1) ||
                getPath(board, i, j + 1, word, index + 1)
                ) {
            return true;
        }
        visted[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a'}};
        exist(board, "a");
    }
}
