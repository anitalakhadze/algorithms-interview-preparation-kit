package org.example.array;

import java.util.ArrayList;
import java.util.List;

public class FindArrayLeaders {

    public static void main(String[] args) {
        int[] nums = {16, 17, 4, 3, 5, 2};
        List<Integer> arrayLeaders = findArrayLeaders(nums);
        assert !arrayLeaders.isEmpty();
        for (int num : List.of(17, 5, 2)) {
            assert arrayLeaders.contains(num);
        }
    }

    private static List<Integer> findArrayLeaders(int[] nums) {
        List<Integer> arrayLeaders = new ArrayList<>();

        int lastElement = nums[nums.length - 1];
        arrayLeaders.add(lastElement);
        int maxFromRight = lastElement;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= maxFromRight) {
                arrayLeaders.add(nums[i]);
                maxFromRight = nums[i];
            }
        }

        return arrayLeaders;
    }

}
