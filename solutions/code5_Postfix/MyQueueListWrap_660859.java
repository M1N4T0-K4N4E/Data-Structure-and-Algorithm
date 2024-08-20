package solutions.code5_Postfix;

import java.util.Iterator;
import java.util.LinkedList;

public class MyQueueListWrap_660859<T> implements Iterable<T>{
    private LinkedList<T> items;
    private int count;

    MyQueueListWrap_660859() {
        items = new LinkedList<>();
    }

    public void add(T item) {
        items.add(item);
        count++;
    }

    public T get(int index) {
        return items.get(index);
    }

    public void enqueue(T d) {
        items.add(d);
    }
    
    public T dequeue() {
        if (items.isEmpty()) return null;
        return items.pop();

    }

    public String dumpToString() {
        return "";
    }
    
    @Override
    public Iterator<T> iterator() {
        return new AnyItemsIterator(this);
    }
    private class AnyItemsIterator implements Iterator <T> {
        private MyQueueListWrap_660859<T> lis;
        private int idx;
        
        public AnyItemsIterator(MyQueueListWrap_660859<T> arg) {
            this.lis = arg;
        }

        @Override
        public boolean hasNext() {
            return (idx < lis.count);
        }

        @Override
        public T next() {
            return lis.items.get(idx++);
        }
    }
}
