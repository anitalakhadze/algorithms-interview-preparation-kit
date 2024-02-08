package org.example.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] actual = {5, 1, 6, 2, 3, 4};
        insertionSort(actual);
        assert actual[0] == 1;
        assert actual[1] == 2;
        assert actual[2] == 3;
        assert actual[3] == 4;
        assert actual[4] == 5;
        assert actual[5] == 6;
    }

    private static void insertionSort(int[] actual) {
        int n = actual.length;
        for (int i = 1; i < n; i++) {
            int key = actual[i];
            int j = i - 1;
            while (j >= 0 && actual[j] > key) {
                actual[j + 1] = actual[j];
                j = j - 1;
            }
            actual[j + 1] = key;
        }
    }

}
