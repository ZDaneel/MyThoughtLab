package backtrack;

import java.util.Arrays;

/**
 * @author leenadz
 * @since 2025-04-24 15:57
 */
public class Sudoku {

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(Arrays.deepToString(board));
        sudoku.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    private boolean backtracking(char[][] board) {
        int length = board.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k;
                        if (backtracking(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, char num, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (num == board[row][i]) return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (num == board[i][col]) return false;
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (num == board[i][j]) return false;
            }
        }
        return true;
    }
}
