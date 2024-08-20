package solutions.code5_Postfix;

public class MyStackL {
    private Node top;
    public MyStackL() {
        top = null;
    }
    public void push(String d) {
        Node n = new Node(d);
        n.next = this.top;
        this.top = n;
    }
    public String pop() {
        String data = this.top.value;
        this.top = this.top.next;
        return data;
    }

    public String peek() {
    return this.top.value;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        return top == null;
    }
        
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Top->");
        Node temp = top;
        while (temp != null) {
            sb.append(temp.value).append("->");
            temp = temp.next;
        }
        sb.append("Bottom");
        return sb.toString();
    }
}  