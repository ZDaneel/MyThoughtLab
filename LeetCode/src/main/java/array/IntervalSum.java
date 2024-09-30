package array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leenadz
 * @since 2024-09-29 09:33
 */
public class IntervalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] vec = new int[n];
        int[] preVec = new int[n];
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            vec[i] = scanner.nextInt();
            preSum += vec[i];
            preVec[i] = preSum;
        }
        System.out.println(Arrays.toString(vec));
        System.out.println(Arrays.toString(preVec));
        while (scanner.hasNextInt()) {
            int leftIndex = scanner.nextInt();
            int rightIndex = scanner.nextInt();

            int res = leftIndex == 0 ? preVec[rightIndex] :
                    preVec[rightIndex] - preVec[leftIndex - 1];
            System.out.println(res);
        }
        scanner.close();
    }
}
