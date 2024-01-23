package org.example.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumNumberOfPlatforms {

    private record TrainSchedule(int arrivalTime, int departureTime) {
    }

    private static class SortByArrival implements Comparator<TrainSchedule> {
        @Override
        public int compare(TrainSchedule o1, TrainSchedule o2) {
            return o1.arrivalTime - o2.arrivalTime;
        }
    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findMinimumNumberOfPlatforms(arr, dep)); // 3
    }

    private static int findMinimumNumberOfPlatforms(int[] arr, int[] dep)  {
        TrainSchedule[] trainSchedules = new TrainSchedule[arr.length];

        for (int i = 0; i < arr.length; i++) {
            trainSchedules[i] = new TrainSchedule(arr[i], dep[i]);
        }

        Arrays.sort(trainSchedules, new SortByArrival());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(trainSchedules[0].departureTime);
        int platforms = 1;

        for (int i = 1; i < arr.length; i++) {
            TrainSchedule curr = trainSchedules[i];
            if (curr.arrivalTime <= pq.peek()) {
                platforms++;
            } else {
                pq.poll();
            }
            pq.add(curr.departureTime);
        }

        return platforms;
    }

}
