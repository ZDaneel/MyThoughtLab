package hash;

import java.util.*;

/**
 * @author leenadz
 * @since 2025-03-23 14:20
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();

        int[] nums0 = {-1, 0, 1, 2, -1, -4};
        int[] nums1 = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        int[] nums2 = {-5, 14, 1, -2, 11, 11, -10, 3, -6, 0, 3, -4, -9, -13, -8, -7, 9, 8, -7, 11, 12, -7, 4, -7, -1, -5, 13, 1, -2, 8, -13, 0, -1, 3, 13, -13, -1, 10, 5, 1, -13, -15, 12, -7, -13, -11, -7, 3, 13, 1, 0, 2, 1, 11, 10, 8, -8, 1, -14, -3, -6, -12, 12, 0, 6, 2, 2, -9, -3, 14, -1, -9, 14, -4, -1, 8, -8, 7, -4, 12, -14, 3, -9, 2, 0, -13, -13, -1, 3, -12, 11, 4, -9, 8, 11, 5, -5, -10, 3, -1, -11, -13, 5, -12, -10, 11, 11, -3, -5, 14, -13, -4, -5, -7, 6, 2, -13, 0, 8, -3, 4, 4, -14, 2};
        int[] nums3 = {0, 0, 0, 0};

        System.out.println(threeSum.threeSum(nums0));
        System.out.println(threeSum.threeSum(nums1));
        System.out.println(threeSum.threeSum(nums2));
        System.out.println(threeSum.threeSum(nums3));
    }

    // 超时
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        Set<Set<Integer>> resSet = new HashSet<>();
        Map<Integer, List<Set<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int twoSum = nums[i] + nums[j];
                List<Set<Integer>> setList = map.get(twoSum);
                if (setList == null) {
                    List<Set<Integer>> twoIndexList = new ArrayList<>();
                    Set<Integer> indexSet = new HashSet<>();
                    indexSet.add(i);
                    indexSet.add(j);
                    twoIndexList.add(indexSet);
                    map.put(twoSum, twoIndexList);
                } else {
                    Set<Integer> indexSet = new HashSet<>();
                    indexSet.add(i);
                    indexSet.add(j);
                    setList.add(indexSet);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            List<Set<Integer>> setList = map.get(target);
            if (setList != null) {
                for (Set<Integer> indexSet : setList) {
                    if (!indexSet.contains(i)) {
                        if (indexSet.size() != 3) {
                            indexSet.add(i);
                        }
                        resSet.add(indexSet);
                    }
                }
            }
        }
        for (Set<Integer> integerSet : resSet) {
            List<Integer> numList = new ArrayList<>();
            for (Integer index : integerSet) {
                numList.add(nums[index]);
            }
            if (!isRepeat(numList, resList)) {
                resList.add(numList);
            }
        }
        return resList;
    }

    private boolean isRepeat(List<Integer> numList, List<List<Integer>> resList) {
        List<Map<Integer, Integer>> numCountList = new ArrayList<>();
        for (List<Integer> integerList : resList) {
            Map<Integer, Integer> numCountMap = new HashMap<>();
            for (Integer num : integerList) {
                numCountMap.merge(num, 1, Integer::sum);
            }
            numCountList.add(numCountMap);
        }
        for (Map<Integer, Integer> numCountMap : numCountList) {
            int counter = 0;
            for (Integer num : numList) {
                Integer count = numCountMap.get(num);
                if (count != null && count > 0) {
                    numCountMap.put(num, --count);
                    counter += 1;
                }
            }
            if (counter == 3) {
                return true;
            }
        }
        return false;
    }

    // 双指针法-使用Set去重，低效
    public List<List<Integer>> threeSum4(int[] nums) {
        Set<List<Integer>> resSet = new HashSet<>();
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = sortedNums[i] + sortedNums[left] + sortedNums[right];
                if (0 == sum) {
                    List<Integer> numList = new ArrayList<>();
                    numList.add(sortedNums[i]);
                    numList.add(sortedNums[left]);
                    numList.add(sortedNums[right]);
                    resSet.add(numList);
                    left++;
                } else if (0 > sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(resSet);
    }

    // 去重
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> resList = new ArrayList<>();
//        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
//        for (int i = 0; i < nums.length; i++) {
//            int left = i + 1;
//            int right = nums.length - 1;
//            while (left < right) {
//                int sum = sortedNums[i] + sortedNums[left] + sortedNums[right];
//                if (0 == sum) {
//                    List<Integer> numList = new ArrayList<>();
//                    numList.add(sortedNums[i]);
//                    numList.add(sortedNums[left]);
//                    numList.add(sortedNums[right]);
//                    resList.add(numList);
//                    left++;
//                } else if (0 > sum) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
//        return resList;
//    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> resSet = new HashSet<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int twoSum = nums[i] + nums[j];
                List<List<Integer>> lists = map.get(twoSum);
                List<Integer> twoList = new ArrayList<>();
                twoList.add(nums[i]);
                twoList.add(nums[j]);
                if (lists == null) {
                    List<List<Integer>> initLists = new ArrayList<>();
                    initLists.add(twoList);
                    map.put(twoSum, initLists);
                } else {
                    lists.add(twoList);
                }
            }
        }
        for (int num : nums) {
            int target = -num;
            List<List<Integer>> lists = map.get(target);
            if (lists != null) {
                for (List<Integer> twoList : lists) {
                    if (twoList.size() <= 3) {
                        twoList.add(num);
                        resSet.add(twoList);
                    }
                }
            }
        }
        return new ArrayList<>(resSet);
    }
}
