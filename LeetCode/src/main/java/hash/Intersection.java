package hash;

import java.util.*;

/**
 * @author leenadz
 * @since 2025-03-22 19:20
 */
public class Intersection {

    public static void main(String[] args) {
        Intersection intersection = new Intersection();

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection.intersection(nums1, nums2)));

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection.intersection(nums3, nums4)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int num1 : nums1) {
            map.putIfAbsent(num1, 1);
        }

        for (int num2 : nums2) {
            if (map.get(num2) != null && map.get(num2) == 1) {
                map.put(num2, 0);
                res.add(num2);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }

        //方法1：将结果集合转为数组
        // return res.stream().mapToInt(Integer::intValue).toArray();
        /**
         * 将 Set<Integer> 转换为 int[] 数组：
         * 1. stream() : Collection 接口的方法，将集合转换为 Stream<Integer>
         * 2. mapToInt(Integer::intValue) :
         *    - 中间操作，将 Stream<Integer> 转换为 IntStream
         *    - 使用方法引用 Integer::intValue，将 Integer 对象拆箱为 int 基本类型
         * 3. toArray() : 终端操作，将 IntStream 转换为 int[] 数组。
         */

        //方法2：另外申请一个数组存放setRes中的元素,最后返回数组
        int[] arr = new int[resSet.size()];
        int j = 0;
        for(int i : resSet){
            arr[j++] = i;
        }

        return arr;
    }

}
