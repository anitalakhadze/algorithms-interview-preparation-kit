package org.example.array;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums)); // 6
    }

    private static int maxProduct(int[] nums) {
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int max = nums[0];

        for (int num : nums) {
            int temp = Math.max(Math.max(num, max_so_far * num), min_so_far * num);
            min_so_far = Math.min(Math.min(num, max_so_far * num), min_so_far * num);
            max_so_far = temp;
            max = Math.max(max, max_so_far);
        }

        return max;
    }

}
