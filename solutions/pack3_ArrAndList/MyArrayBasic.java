package solutions.pack3_ArrAndList;

public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;

    public MyArrayBasic() {}

    public MyArrayBasic(int ... a) {
        this.MAX_SIZE = a.length;
        this.size = MAX_SIZE;
        this.data = new int[MAX_SIZE];
        for (int i = 0; i < a.length; i++) {
            this.data[i] = a[i];
        }
    }
    
    public void add(int d) {
        this.data[size] = d;
        this.size++;
    }

    public void insert(int d, int index) {
        for (int i = MAX_SIZE - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = d;
    }

    public int find(int d) {
        for (int i = 0; i < this.MAX_SIZE; i++) {
            if (this.data[i] == d) return i;
        }
        return -1;
    }

    public int binarySearch(int d) {
        int rangeLeft = 0;
        int rangeRight = this.MAX_SIZE - 1;
        while (rangeLeft <= rangeRight) {
            int middle = rangeLeft + (rangeRight - rangeLeft) / 2;
            if (this.data[middle] == d) return this.data[middle];

            if (this.data[middle] > d) rangeRight = middle;
            else rangeLeft = middle;
        }
        return -1;
    }

    public void delete(int index) {
        for (int i = index; i < this.MAX_SIZE - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
    }

    @Override
    public String toString() {
        String tmp = "";
        tmp += "[";
        for (int i = 0; i < size; i++) {
            if (i != size - 1) tmp += String.format("%s, ", this.data[i]);
            else tmp += String.format("%s", this.data[i]);
        }
        tmp += "]";
        return tmp;
    }
}