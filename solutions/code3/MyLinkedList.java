package solutions.code3;

public class MyLinkedList {

    public class Node {
        int data;
        Node next = null;
        public Node(int d) {
        data = d;
        }
    }

    Node head = null;

    public void add(int ... d) {
        for (int i = d.length - 1; i > -1; i--) {
            Node newNode = new Node(d[i]);
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    public void insert(int d) {
        Node tmp = this.head;
        Node prev = null;
        while(tmp != null) {
            if (tmp.data > d) break;
            prev = tmp;
            tmp = tmp.next;
        }
        Node n = new Node(d);
        if (tmp != null) { // emty data or last check 
            n.next = tmp;
            if (prev != null) { // first index check 
                prev.next = n;
            } else {
                this.head = n;
            }
        } else if (tmp == null && prev != null) {
            prev.next = new Node(d);
        } else {
            this.head = n;
        }
    }

    public void insert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    public int find(int d) {
        int i = 0;
        Node tmp = head;
        while (tmp != null) {
            if (tmp.data == d) break;
            i++;
            tmp = tmp.next;
        }
        if (tmp.data == d) return i;
        return -1;
    }

    public void delete(int d) {
        if (head.data == d) {
            head = head.next;
            return;
        }
        Node prev = null;
        Node tmp = head;
        while (tmp != null) {
            prev = tmp;
            tmp = tmp.next;
            if (tmp != null && tmp.data == d) {
                prev.next = tmp.next;
                return;
            }
        }

    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("head ");
        Node p = head;
        while(p!=null) {
        sb.append("--> [");
        sb.append(p.data);
        sb.append("] ");
        p = p.next;
        }
        sb.append("-> null");
        return new String(sb);
        }

    static void demo1() {
        MyLinkedList list = new MyLinkedList();
        list.add(5);
        list.add(1);
        list.insert(4);
        list.insert(3);
        System.out.println(list);
        list.delete(2);
        System.out.println("5 is at " + list.find(5));
        System.out.println(list);
    }

    static void demo2() {
        int [] arr = {50,40,30,20,10};
        MyLinkedList mList = new MyLinkedList();
        mList.insert(arr);
        System.out.println(mList);
    }

    public static void main(String[] args) {
        System.out.println("----------demo1----------");
        demo1();
        System.out.println("----------demo2----------");
        demo2();
    }
}