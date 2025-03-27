package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-03-26 16:14
 */
public class MaxHeap {
    private final int[] heap;
    private final int maxSize;
    private int heapSize;

    public MaxHeap(int maxSize) {
        heap = new int[maxSize];
        this.maxSize = maxSize;
        heapSize = 0;
    }

    public boolean isFull() {
        return heapSize == maxSize;
    }

    public boolean isEmpty() {
        return 0 == heapSize;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        return heap[0];
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("heap is full");
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize++);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        int res = heap[0];
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return res;
    }

    public List<Integer> getAllElements() {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < heapSize; i++) {
            ans.add(heap[i]);
        }
        return ans;
    }

    // 实际插入元素的封装操作
    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 删除元素后维护堆特性的封装
    private void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        while (left < heapSize) {
            if (arr[left] > arr[largest]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(arr, index, largest);
                // 更新index到largest，继续循环
                index = largest;
                left = 2 * index + 1;
                right = 2 * index + 2;
            } else {
                // 如果index就是最大值，则停止循环
                break;
            }
        }


//        if (indexLeftChild >= heapSize) {
//            return;
//        }
//        // 父节点和左右子节点比较
//        if (arr[index] < arr[indexLeftChild]) {
//            swap(arr, index, indexLeftChild);
//            heapify(arr, indexLeftChild, heapSize);
//        }
//        if (indexRightChild <= heapSize && arr[index] < arr[indexRightChild]) {
//            swap(arr, index, indexRightChild);
//            heapify(arr, indexRightChild, heapSize);
//        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
