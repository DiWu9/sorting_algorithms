import java.util.Arrays;
import java.util.ArrayList;

public class Tests {

    public static void main(String args[]) {

        ArrayList<Integer> toSort = new ArrayList<>(Arrays.asList(111, 5, 53, 17, 84, -2, -76));
        Sorter sorter = new Sorter(toSort);
        // sorter.insertionSort();
        // sorter.bubbleSort();
        // sorter.mergeSort(0, toSort.size() - 1);
        // sorter.selectionSort();
        // sorter.heapSort();
        sorter.quickSort(0, toSort.size() - 1);
        sorter.printArray();
    }

}