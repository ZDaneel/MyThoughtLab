package array;

/**
 * @author leenadz
 * @since 2024-09-26 19:20
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int res = new BinarySearch().search(nums, target);
        System.out.println(res);
        int res2 = new BinarySearch().my_search(nums, target);
        System.out.println(res2);
    }

    public int search(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        while (l + 1 != r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target)
                l = mid;
            else
                r = mid;
        }
        if (r == nums.length) return -1;
        return nums[r] == target ? r : -1;
    }

    public int my_search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        // 左闭右闭
        while (l <= r) {
            int mid = l + ((r - l ) / 2);
            if (nums[mid] < target)
                l = mid + 1;
            else if (nums[mid] > target)
                r = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
