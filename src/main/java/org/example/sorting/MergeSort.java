package org.example.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] actual = {5, 1, 6, 2, 3, 4};
        mergeSort(actual, actual.length);
        assert actual[0] == 1;
        assert actual[1] == 2;
        assert actual[2] == 3;
        assert actual[3] == 4;
        assert actual[4] == 5;
        assert actual[5] == 6;
    }

    /**
     * As merge sort is a recursive algorithm, the time complexity can be expressed as the following recursive relation:
     * T(n) = 2T(n/2) + O(n)
     * Copy
     * 2T(n/2) corresponds to the time required to sort the sub-arrays, and O(n) is the time to merge the entire array.
     * When solved, the time complexity will come to O(nLogn).
     * This is true for the worst, average, and best cases, since it’ll always divide the array into two and then merge.
     * The space complexity of the algorithm is O(n), as we’re creating temporary arrays in every recursive call.
     */
    private static void mergeSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }

        int middle = n / 2;
        int[] left = new int[middle];
        int[] right = new int[n - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = arr[i];
        }
        for (int i = middle; i < n; i++) {
            right[i - middle] = arr[i];
        }

        mergeSort(left, middle);
        mergeSort(right, n - middle);

        merge(arr, left, right, middle, n - middle);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }


}
