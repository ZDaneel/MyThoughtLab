package array;

import java.util.Arrays;

/**
 * @author leenadz
 * @since 2024-09-28 13:07
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        int[][] ints = new GenerateMatrix().generateMatrix(3);
        System.out.println(Arrays.deepToString(ints));
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
