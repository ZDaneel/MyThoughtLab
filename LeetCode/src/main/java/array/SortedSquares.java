package array;

import java.util.Arrays;

/**
 * @author leenadz
 * @since 2024-09-27 11:50
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-5, -3, -2, -1};
        int[] ints = new SortedSquares().sortedSquares(nums);
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortedSquares(int[] nums) {
        int[] sortedNums = new int[nums.length];
        if (1 == nums.length) {
            sortedNums[0] = getSquare(nums[0]);
            return sortedNums;
        }
        int right = 0;
        while (nums[right] < 0) {
            right++;
            if (right == nums.length - 1) {
                break;
            }
        }
        int left = right - 1;
        for (int i = 0; i < sortedNums.length; i++) {
            if (left == -1) {
                sortedNums[i] = getSquare(nums[right]);
                right++;
                continue;
            }
            if (right == nums.length) {
                sortedNums[i] = getSquare(nums[left]);
                left--;
                continue;
            }
            int leftSquare = getSquare(nums[left]);
            int rightSquare = getSquare(nums[right]);
            if (leftSquare < rightSquare) {
                sortedNums[i] = leftSquare;
                left--;
            } else {
                sortedNums[i] = rightSquare;
                right++;
            }
        }
        return sortedNums;
    }

    public static int getSquare(int number) {
        return number * number;
    }

    public int[] sortedSquares2(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 正数的相对位置是不变的， 需要调整的是负数平方后的相对位置
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }
}
