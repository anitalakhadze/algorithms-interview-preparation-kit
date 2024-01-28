package org.example.sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { 5, 3, 2, 4, 1 };
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
