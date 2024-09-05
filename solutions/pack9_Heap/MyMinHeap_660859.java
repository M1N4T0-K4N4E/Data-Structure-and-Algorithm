import java.util.Arrays;

public class MyMinHeap_660859 {
    int MAX_SIZE = 100;
    int heap[] = new int[MAX_SIZE];
    int size = 0;
    
    public void insert(int d) {
        heap[size++] = d;
        int p = size;
        int parent = (size - 1) / 2;
        while ( (p > 0) && (heap[p] < heap[parent]) ) {
            swap(p, parent);
            p = parent;
            parent = (p - 1) / 2;
        }
    }

    public int remove() {
        int tmp = heap[0];
        heap[0] = heap[size - 1];
        heap[--size] = 0;
        int p = 0;
        while (true) {
            int left = 2 * p + 1;
            if (left >= size) break; // no child
            int right =  2 * p + 2;
            if (right == size) { // has 1 child
                if (heap[p] > heap[left]) swap(p, left);
                break;
            } else { //has 2 child
                int q = heap[left] < heap[right] ? left : right;
                if (heap[p] > heap[q]) swap(p, q);
                p = q;
            }
        }
        return tmp;
    }

    public int peek() {
        return heap[0];
    }

    public boolean isFull() {
        return MAX_SIZE == size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void swap(int idx1, int idx2) {
        int tmp = heap[idx2];
        heap[idx2] = heap[idx1];
        heap[idx1] = tmp;
    }

    public String toString() {
        return Arrays.toString(heap);
    }
}
