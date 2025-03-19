package array;

import java.util.Arrays;

/**
 * @author leenadz
 * @since 2024-09-28 13:07
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        int[][] ints = new GenerateMatrix().generateMatrix2(5);
        System.out.println(Arrays.deepToString(ints));
    }


    public int[][] generateMatrix2(int n){
        // 边界条件判断太复杂，并且实际上应该变化边界条件，否则无法合并
        int[][] res = new int[n][n];
        int num = 1;
        int row = 0;
        int col = 0;
        int direction = 0; // 0-right, 1-down, 2-left, 3-up
        while (num <= (n * n)) {
            switch (direction) {
                case 0: {
                    while ((col + 1 < n)) {
                        if (col + 2 != n) {
                            if (res[row][col+2] != 0) break;
                        }
                        res[row][col++] = num++;
                    }
                    direction = 1;
                    break;
                }
                case 1: {
                    while ((row + 1 < n)) {
                        if (row + 2 != n) {
                            if (res[row+2][col] != 0) break;
                        }
                        res[row++][col] = num++;
                    }
                    direction = 2;
                    break;
                }
                case 2: {
                    while ((col > 0)) {
                        if (col - 2 >= 0) {
                            if (res[row][col-2] != 0) break;
                        }
                        res[row][col--] = num++;
                    }
                    direction = 3;
                    break;
                }
                case 3: {
                    while ((row > 0)) {
                        if (row - 1 > 0) {
                            if (res[row-1][col] != 0) break;
                        }
                        res[row--][col] = num++;
                    }
                    direction = 0;
                    break;
                }
            }
        }
        return res;
    }

    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int[][] res = new int[n][n];
        int num = 1;
        while (num <= n * n) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            ++top;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            --right;
            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            --bottom;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            ++left;
        }
        return res;
    }
}
