package solutions.code5_Postfix;

import java.util.Iterator;

public class MyQueueL_660859<T> extends MyQueueListWrap_660859<T>{
    private Node<T> Head;
    private Node<T> Tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T d) {
            this.data = d;
            this.next = null;
        }

        @Override
        public String toString() {
            return (String)this.data;
        }
    }
    MyQueueL_660859() {
        this.Head = null;
        this.Tail = null;
        this.size = 0;
    }

    public void enqueue(T item) {
        add(item);
    }

    public T dequeue() {
        if (Head == null) return null;
        T data = Head.data;
        Head = Head.next;
        if (Head == null) Tail = null;
        size--;
        return data;
    }

    public T peak() {
        return Head == null ? null : Head.data;
    }

    public boolean isEmpty() {
        return Head == null;
    }

    public int size() {
        return size;
    }
    
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> n = Head;

            public boolean hasNext() {
                return n != null;
            }

            public T next() {
                T data = n.data;
                n = n.next;
                return data;
            }
        };
    }

    @Override
    public String dumpToString() {
        StringBuilder sb = new StringBuilder();
        Node<T> n = Head;
        while (n != null) {
            sb.append(n).append(" ");
            n = n.next;
        }
        return sb.toString().trim();
    }
}
