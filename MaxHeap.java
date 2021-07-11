import java.util.ArrayList;

public class MaxHeap {

    private ArrayList<Integer> heap;
    private int heapSize;

    public MaxHeap(ArrayList<Integer> array) {
        heap = array;
        heapSize = array.size();
    }

    public int parent(int i) {
        return Math.floorDiv(i, 2);
    }

    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return 2 * i + 1;
    }

    /**
     * Assume the binary tree rooted at left(i) and right(i) are max-heaps
     * @param i: index of the number to be heapified
     * 
     * run-time: O(log(n))
     */
    public void maxHeapify(int i) {
        int leftChildIndex = left(i);
        int rightChildIndex = right(i);
        int largest;

        // avoid index out of bound
        if (leftChildIndex < heapSize && heap.get(leftChildIndex) > heap.get(i)) {
            largest = leftChildIndex;
        }
        else {
            largest = i;
        }
        if (rightChildIndex < heapSize && heap.get(rightChildIndex) > heap.get(largest)) {
            largest = rightChildIndex;
        }
        if (largest != i) {
            // exchange heap[i] with heap[largest]
            int temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap() {
        for (int i = Math.floorDiv(heapSize, 2) - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }


    public void heapSort() {
        buildMaxHeap();
        int localMax;
        for (int i = heapSize - 1; i > 0; i--) {
            localMax = heap.get(0); // root is always the max in max heap
            heap.set(0, heap.get(i));
            heap.set(i, localMax);
            heapSize = heapSize - 1;
            maxHeapify(0);
        }
    }

    public void printHeap() {
        System.out.println(heap.toString());
    }
}
