package solutions.pack3_ArrAndList;

public class MyArray extends MyArrayBasic {
    
    
    public MyArray() {
        this.MAX_SIZE = 100_000;
        this.data = new int[MAX_SIZE];
    }

    public MyArray(int max) {
        this.MAX_SIZE = max;
        this.data = new int[MAX_SIZE];
    }

    public boolean isFull() { 
        return this.MAX_SIZE == this.size ? true : false;
    }

    public boolean isEmty() {
        return this.size == 0 ? true : false;
    }

    public void expandByK(int k) {
        this.data = new int[k * MAX_SIZE];
        this.MAX_SIZE = k * this.MAX_SIZE;
    }

    public void expand() {
        expandByK(2);
    }

    @Override
    public void add(int d) {
        if (isFull()) expand();
        super.add(d);
    }

    @Override
    public void insert(int d, int index) {
        if (isFull()) expand();
        super.insert(d, index);
    }

    @Override
    public void delete(int index) {
        if (this.size != 0) super.delete(index);
    }
}
