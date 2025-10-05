package metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long accesses = 0;
    private long allocations = 0;
    private long startNs = 0;
    private long elapsedMs = 0;

    public void start() {
        startNs = System.nanoTime();
    }

    public void stop() {
        elapsedMs = (System.nanoTime() - startNs) / 1_000_000;
    }

    public void reset() {
        comparisons = swaps = accesses = allocations = elapsedMs = 0;
    }

    // === Increment methods ===
    public void incComparisons() { comparisons++; }
    public void incSwaps() { swaps++; }
    public void incAccesses(int count) { accesses += count; }
    public void incAllocations() { allocations++; }

    // === Getters ===
    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getAccesses() { return accesses; }
    public long getElapsedMs() { return elapsedMs; }
}
