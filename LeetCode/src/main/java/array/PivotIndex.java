package array;

/**
 * @author leenadz
 * @since 2024-09-26 11:30
 */
public class PivotIndex {
    public static void main(String[] args) {
        int res;
        int[] arr = {-1, -1, -1, -1, 0, 1};
        PivotIndex pivotIndex = new PivotIndex();
        int i = pivotIndex.pivotIndex(arr);
        System.out.println(i);
    }

    public int pivotIndex(int[] nums) {
        // 满足 leftSum = sum - nums[pivot] - leftSum
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int leftSum = 0;
        for (int pivot = 0; pivot < nums.length; pivot++) {
            if (2 * leftSum == sum - nums[pivot]) {
                return pivot;
            }
            leftSum += nums[pivot];
        }
        return -1;
    }
}
