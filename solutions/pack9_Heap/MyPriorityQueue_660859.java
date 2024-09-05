package solutions.pack9_Heap;

public class MyPriorityQueue_660859 extends MyMinHeap_660859 implements MyQueueInterface {

    @Override
    public void enqueue(int d) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        super.insert(d);
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return 0;
        }
        int tmp = super.peek();
        super.remove();
        return tmp;
    }

    @Override
    public int front() {
        return super.peek();
    }

    @Override
    public boolean isFull() {
        return super.isFull();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
    
}
