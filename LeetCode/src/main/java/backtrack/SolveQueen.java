package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-04-23 13:26
 */
public class SolveQueen {
    public static void main(String[] args) {
        SolveQueen solveQueen = new SolveQueen();
        System.out.println(solveQueen.solveNQueens(3));
        System.out.println(solveQueen.solveNQueens(4));
    }

    // 该方案中 'Q' 和 '.' 分别代表了皇后和空位
    List<List<String>> resList;

    public List<List<String>> solveNQueens(int n) {
        resList = new ArrayList<>();
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        findQueen(n, 0, chessboard);
        return resList;
    }

    private void findQueen(int n, int row, char[][] chessboard) {
        if (row == n) {
            resList.add(Array2List(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                findQueen(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    // 难点，如何判断是否能够放置
    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}
