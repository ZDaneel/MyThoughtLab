package array;

import java.util.Scanner;

/**
 * @author leenadz
 * @since 2024-09-29 09:57
 */
public class PurchaseLand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sum = 0;
        int[][] vec = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vec[i][j] = scanner.nextInt();
                sum += vec[i][j];
            }
        }
        int[] horizontal = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                horizontal[i] += vec[i][j];
            }
        }
        int[] vertical = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vertical[i] += vec[j][i];
            }
        }
        int minRes = Integer.MAX_VALUE;
        int horizontalCut = 0;
        for (int i = 0; i < n-1; i++) {
            horizontalCut += horizontal[i];
            minRes = Math.min(minRes, Math.abs(sum - 2 * horizontalCut));
        }
        int verticalCut = 0;
        for (int j = 0; j < m; j++) {
            verticalCut += vertical[j];
            minRes = Math.min(minRes, Math.abs(sum - 2 * verticalCut));
        }

        System.out.println(minRes);
        scanner.close();
    }
}
