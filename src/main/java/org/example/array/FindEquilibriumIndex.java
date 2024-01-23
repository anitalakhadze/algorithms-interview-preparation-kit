package org.example.array;

public class FindEquilibriumIndex {

    public static void main(String[] args) {
        int[] nums = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(findEquilibriumIndex(nums)); // 3
    }

    private static int findEquilibriumIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;

        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];

            if (leftSum == sum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }

}
