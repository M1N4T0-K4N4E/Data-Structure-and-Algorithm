package solutions.code5_Postfix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MyQueueExtendsLinkedList<T> implements Iterable<T> {
    private ArrayList<T> items =new ArrayList<>();
     private int count;
 
     public void enqueue(T item) {
         items.add(item);
         count++;
     }
     
     public T dequeue() {
         T ans = this.top();
         items.remove(0);
         count--;
         return ans;
     }
 
     public T top() {
         return items.get(0);
     }
 
     public T getLast() {
         return items.get(items.size()-1);
     }
     
     public T get(int index) {
         return items.get(index);
     }
 
     public String dumpToString() {
         String result = "";
         Iterator<T> iter = this.iterator();
         while (iter.hasNext()) {
             result += iter.next() + " ";
         }
         return result;
     }
 
     public String toString() {
         return this.dumpToString();
     }
 
     @Override
     public Iterator<T> iterator() {
         return new AnyItemsIterator(this);
     }
 
     private class AnyItemsIterator implements Iterator<T> {
         private MyQueueExtendsLinkedList<T> lis;
         private int idx;
 
         public AnyItemsIterator(MyQueueExtendsLinkedList<T> arg) {
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
