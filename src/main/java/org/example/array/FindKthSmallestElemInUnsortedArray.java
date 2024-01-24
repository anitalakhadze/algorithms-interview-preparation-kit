package org.example.array;

import java.util.PriorityQueue;

public class FindKthSmallestElemInUnsortedArray {

    public static void main(String[] args) {
        int[] nums = {7, 10, 4, 3, 20, 15};
        assert findKthSmallestElem(nums, 3) == 7; // 7
    }

    private static int findKthSmallestElem(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            pq.offer(num);

            if (pq.size() > k) {
                // if the size exceeds k, we are no longer interested in the largest elements,
                // so we remove them
                pq.poll();
            }
        }

        return pq.peek();
    }

}
