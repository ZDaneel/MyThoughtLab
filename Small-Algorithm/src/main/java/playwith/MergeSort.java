package playwith;

import java.util.Arrays;
import java.util.Random;

/**
 * @author leenadz
 * @since 2024-09-24 13:26
 */
public class MergeSort {

    public static void mergeSort(int[] array) {
        int n = array.length;
        int[] aux = new int[n];

        // Compound pass lengths from 1, 2, 4, 8, etc.
        // log(n) passes
        for (int size = 1; size < n; size = 2 * size) {
            for (int leftStart = 0; leftStart < n - size; leftStart += 2 * size) {
                int mid = leftStart + size - 1;
                int rightEnd = Math.min(leftStart + 2 * size - 1, n - 1);
//                System.out.println("left: " + leftStart + ", mid: " + mid + ", right: " + rightEnd);
                merge(array, aux, leftStart, mid, rightEnd);
            }
        }
    }

    private static void merge(int[] arr, int[] aux, int left, int mid, int right) {
        // 将每次需要排序的数组内容复制到辅助数组中
        for (int k = left; k <= right; k++) {
            aux[k] = arr[k];
        }
//        System.out.println("arr: " + Arrays.toString(arr));
//        System.out.println("aux: " + Arrays.toString(aux));
        int i = left;        // 左子数组的起始索引
        int j = mid + 1;     // 右子数组的起始索引
//        System.out.println("i: " + i + ", j: " + j);

        for (int k = left; k <= right; k++) { // 代表需要排序的数组的索引
            // 边界，随着子数组的消耗，i 和 j 会越界
            if (i > mid) {
                arr[k] = aux[j++]; // Left subarray is consumed
            } else if (j > right) {
                arr[k] = aux[i++]; // Right subarray is consumed
            } // 因为子数组已经有序，所以只需要比较子数组的第一个元素即可
            else if (aux[j] < aux[i]) {
                arr[k] = aux[j++]; // Right subarray's current element is smaller
            } else {
                arr[k] = aux[i++]; // Left subarray's current element is smaller or equal
            }
        }
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }
        return array;
    }

    public static void main(String[] args) {
        int size = 100000;
        int maxTimesToIncrease = 10;
        for (int i = 0; i < maxTimesToIncrease; i++) {
            int[] array = generateRandomArray(size);
            long startTime = System.nanoTime();
            mergeSort(array);
            long endTime = System.nanoTime();
            System.out.println("Array size: " + size + ", Time taken (seconds): " + (endTime - startTime) / 1e9);
            size *= 2;
        }
    }
}
