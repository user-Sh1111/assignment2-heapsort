package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HeapSortTest {

    @Test
    public void testHeapSortSimple() {
        int[] arr = {5, 3, 8, 4, 2};
        int[] expected = {2, 3, 4, 5, 8};
        PerformanceTracker tracker = new PerformanceTracker();

        HeapSort.sort(arr, tracker);

        assertArrayEquals(expected, arr);

        // Print metrics (for learning purposes)
        System.out.println("Comparisons: " + tracker.getComparisons());
        System.out.println("Swaps: " + tracker.getSwaps());
        System.out.println("Accesses: " + tracker.getAccesses());
        System.out.println("Time (ms): " + tracker.getElapsedMs());
    }

    @Test
    public void testHeapSortWithDuplicates() {
        int[] arr = {4, 1, 3, 4, 2, 1};
        int[] expected = {1, 1, 2, 3, 4, 4};
        PerformanceTracker tracker = new PerformanceTracker();

        HeapSort.sort(arr, tracker);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testHeapSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        PerformanceTracker tracker = new PerformanceTracker();

        HeapSort.sort(arr, tracker);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testHeapSortSingleElement() {
        int[] arr = {42};
        int[] expected = {42};
        PerformanceTracker tracker = new PerformanceTracker();

        HeapSort.sort(arr, tracker);

        assertArrayEquals(expected, arr);
    }
}
