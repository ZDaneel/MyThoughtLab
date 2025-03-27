package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-03-26 19:25
 */
public class MinHeap<T extends Comparable<T>> {
    private final T[] heap;
    private final int maxSize;
    private int heapSize;

    public MinHeap(int maxSize) {
        @SuppressWarnings("unchecked")
        T[] tempHeap = (T[]) new Comparable[maxSize];
        this.heap = tempHeap;
        this.maxSize = maxSize;
        heapSize = 0;
    }

    public boolean isFull() {
        return heapSize == maxSize;
    }

    public boolean isEmpty() {
        return 0 == heapSize;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        return heap[0];
    }

    public void push(T value) {
        if (isFull()) {
            throw new RuntimeException("heap is full");
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize++);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        T res = heap[0];
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return res;
    }

    public List<T> getAllElements() {
        return new ArrayList<>(Arrays.asList(heap).subList(0, heapSize));
    }

    // 实际插入元素的封装操作
    private void heapInsert(T[] arr, int index) {
        while ((index > 0 && arr[index].compareTo(arr[(index - 1) / 2]) < 0)) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 删除元素后维护堆特性的封装
    private void heapify(T[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        while (left < heapSize) {
            if (arr[left].compareTo(arr[smallest]) < 0) {
                smallest = left;
            }
            if (right < heapSize && arr[right].compareTo(arr[smallest]) < 0) {
                smallest = right;
            }
            if (smallest != index) {
                swap(arr, index, smallest);
                index = smallest;
                left = 2 * index + 1;
                right = 2 * index + 2;
            } else {
                break;
            }
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
