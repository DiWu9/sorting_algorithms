import java.util.ArrayList;

public class Sorter {

    private ArrayList<Integer> numArray;

    public Sorter(ArrayList<Integer> toSortArray) {
        numArray = toSortArray;
    }

    /**
     * invariant: numArray[0, j] is sorted 
     * run-time: O(n^2) worst & average
     */
    public void insertionSort() {
        int i, j;
        for (j = 1; j < numArray.size(); j++) {
            int key = numArray.get(j);
            i = j - 1;
            while (i >= 0 && numArray.get(i) > key) {
                numArray.set(i + 1, numArray.get(i));
                i = i - 1;
            }
            numArray.set(i + 1, key);
        }
    }


    /**
     * repeatedly swapping adjacent elements that are out of order 
     * invariance: numArray[0, i] is sorted
     * run-time: O(n^2) worst and avg (popular but inefficient)
     */
    public void bubbleSort() {
        int i, j, temp;
        int arraySize = numArray.size();
        for (i = 0; i < arraySize - 1; i++) {
            for (j = arraySize - 1; j > i; j--) {
                if (numArray.get(j) < numArray.get(j - 1)) {
                    temp = numArray.get(j);
                    numArray.set(j, numArray.get(j - 1));
                    numArray.set(j - 1, temp);
                }
            }
        }
    }


    /**
     * find the least number in the subarray and place it at the first place
     * run-time: O(n^2) worst and avg 
     */
    public void selectionSort() {
        int minIndex, localMin;
        for (int i = 0; i < numArray.size() - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < numArray.size(); j++) {
                minIndex = numArray.get(j) < numArray.get(minIndex) ? j : minIndex;
            }
            localMin = numArray.get(minIndex);
            numArray.set(minIndex, numArray.get(i));
            numArray.set(i, localMin);
        }
    }


    private void merge(int p, int q, int r) {
        ArrayList<Integer> left = new ArrayList<Integer>(numArray.subList(p, q + 1));
        ArrayList<Integer> right = new ArrayList<Integer>(numArray.subList(q + 1, r + 1));
        left.add(Integer.MAX_VALUE);
        right.add(Integer.MAX_VALUE);
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (left.get(i) <= right.get(j)) {
                numArray.set(k, left.get(i));
                i = i + 1;
            } else {
                numArray.set(k, right.get(j));
                j = j + 1;
            }
        }
    }

    /**
     * divide-and-conquer: recurrence (equation) 
     * recursion 
     * first divide and then merge sequentially 
     * run-time: O(nlog(n))
     */
    public void mergeSort(int p, int r) {
        if (p < r) {
            int q = Math.floorDiv(p + r, 2);
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }


    /**
     * max heap (p.151) for sorting, min heap for priority queue
     * in-place, run-time: O(nlog(n)) 
     * see class MaxHeap
     */
    public void heapSort() {
        MaxHeap maxHeap = new MaxHeap(numArray);
        maxHeap.heapSort();
        maxHeap.printHeap();
    }


    /**
     * swap the elements smaller than the pivot to the left 
     * so that the pivot can be in the correct position
     * 
     * @param p start
     * @param r end (pivot)
     * @return
     */
    private int partition(int p, int r) {
        int x = numArray.get(r);
        int i = p - 1;
        int temp;
        for (int j = p; j < r; j++) {
            if (numArray.get(j) <= x) {
                i = i + 1;
                temp = numArray.get(i);
                numArray.set(i, numArray.get(j));
                numArray.set(j, temp);
            }
        }
        temp = numArray.get(i+1);
        numArray.set(i+1, numArray.get(r));
        numArray.set(r, temp);
        return i + 1;
    }

    /**
     * divide and conquer
     */
    public void quickSort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            quickSort(p, q-1);
            quickSort(q+1, r);
        }
    }

    public void bucketSort() {

    }

    public void radixSort() {

    }

    public void printArray() {
        System.out.println(numArray.toString());
    }

}