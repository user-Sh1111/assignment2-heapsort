package algorithms;

import metrics.PerformanceTracker;

public class HeapSort {

    public static void sort(int[] arr, PerformanceTracker tracker) {
        tracker.reset();
        tracker.start();

        int n = arr.length;

        // Build the heap (bottom-up heapify)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, tracker);
        }

        // Extract elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i, tracker); // Move current root to the end
            heapify(arr, i, 0, tracker);
        }

        tracker.stop();
    }

    // Heapify a subtree rooted at index i
    private static void heapify(int[] arr, int n, int i, PerformanceTracker tracker) {
        int largest = i;       // Assume root is the largest
        int left = 2 * i + 1;  // Left child
        int right = 2 * i + 2; // Right child

        // If left child is greater than root
        if (left < n) {
            tracker.incComparisons();
            tracker.incAccesses(2);
            if (arr[left] > arr[largest]) {
                largest = left;
            }
        }

        // If right child is greater than the largest so far
        if (right < n) {
            tracker.incComparisons();
            tracker.incAccesses(2);
            if (arr[right] > arr[largest]) {
                largest = right;
            }
        }

        // If the largest is not root
        if (largest != i) {
            swap(arr, i, largest, tracker);
            // Recursively heapify the affected subtree
            heapify(arr, n, largest, tracker);
        }
    }

    // Swap two elements and track metrics
    private static void swap(int[] arr, int i, int j, PerformanceTracker tracker) {
        tracker.incSwaps();
        tracker.incAccesses(4); // Two reads and two writes
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
