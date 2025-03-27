package stack;

import tree.MinHeap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author leenadz
 * @since 2025-03-26 15:44
 */
public class TopKFreq {

    public static void main(String[] args) {
        TopKFreq topKFreq = new TopKFreq();
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(topKFreq.topKFrequent(nums1, k1)));
        System.out.println(Arrays.toString(topKFreq.topKFrequent(nums2, k2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] node = new int[2];
            node[0] = entry.getKey();
            node[1] = entry.getValue();
            pq.add(node);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.remove()[0];
        }
        return res;
    }
}
