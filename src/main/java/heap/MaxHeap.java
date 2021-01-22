package heap;

import java.util.Arrays;

public class MaxHeap {
    public void create(int[] array) {
        for (int i = array.length / 2; i >= 0; i--)
            maxHeapify(array, i);
    }

    private void maxHeapify(int[] array, int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;

        if (left < array.length && array[left] > array[largest])
            largest = left;
        if (right < array.length && array[right] > array[largest])
            largest = right;

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeapify(array, largest);
        }
    }

    private int left(int i) {
        return (i << 1) + 1;
    }

    private int right(int i) {
        return (i + 1) << 1;
    }
}
