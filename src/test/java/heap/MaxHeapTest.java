package heap;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MaxHeapTest {
    private MaxHeap heap = new MaxHeap();

    @Test
    public void shouldCreateMaxHeap() {
        int[] array = {1, 2, 3, 4, 5};
        heap.create(array);
        assertArrayEquals(new int[]{5, 4, 3, 1, 2}, array);
    }
}
