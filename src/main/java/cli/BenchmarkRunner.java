package cli;

import algorithms.HeapSort;
import metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 50000, 100000}; // input sizes
        Random rand = new Random();

        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(n); // fill array with random numbers
            }

            PerformanceTracker tracker = new PerformanceTracker();
            HeapSort.sort(arr, tracker);

            System.out.printf("n=%d, time=%d ms, comps=%d, swaps=%d, accesses=%d%n",
                    n, tracker.getElapsedMs(),
                    tracker.getComparisons(),
                    tracker.getSwaps(),
                    tracker.getAccesses());
        }
    }
}
