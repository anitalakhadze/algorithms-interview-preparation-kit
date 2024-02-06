package org.example.sorting;

public class QuickSort {

    /**
     * Time Complexity:
     * Best Case: Ω (N log (N))
     * The best-case scenario for quicksort occur when the pivot chosen at each step divides the array into roughly equal halves.
     * In this case, the algorithm will make balanced partitions, leading to efficient Sorting.
     * Average Case: θ ( N log (N))
     * Quicksort’s average-case performance is usually very good in practice, making it one of the fastest sorting Algorithm.
     * Worst Case: O(N2)
     * The worst-case Scenario for Quicksort occur when the pivot at each step consistently results in highly unbalanced
     * partitions. When the array is already sorted and the pivot is always chosen as the smallest or largest element.
     * To mitigate the worst-case Scenario, various techniques are used such as choosing a good pivot (e.g., median of three)
     * and using Randomized algorithm (Randomized Quicksort ) to shuffle the element before sorting.
     * Auxiliary Space: O(1), if we don’t consider the recursive stack space. If we consider the recursive stack space
     * then, in the worst case quicksort could make O(N).
     * Advantages of Quick Sort:
     * It is a divide-and-conquer algorithm that makes it easier to solve problems.
     * It is efficient on large data sets.
     * It has a low overhead, as it only requires a small amount of memory to function.
     * Disadvantages of Quick Sort:
     * It has a worst-case time complexity of O(N2), which occurs when the pivot is chosen poorly.
     * It is not a good choice for small data sets.
     * It is not a stable sort, meaning that if two elements have the same key, their relative order will not be preserved
     * in the sorted output in case of quick sort, because here we are swapping elements according to the pivot’s
     * position (without considering their original positions).
     */
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        quickSort(arr, 0, arr.length - 1);
        assert arr[0] == 1;
        assert arr[1] == 2;
        assert arr[2] == 3;
        assert arr[3] == 4;
        assert arr[4] == 5;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++; // increment index of smaller element
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

}
