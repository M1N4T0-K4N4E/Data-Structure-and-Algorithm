package solutions.code3;

public class MyLinkedListTricky_660859 extends MyLinkedList {
    public void q1_rotate_clockwise(int k) {
        for (int i = 0; i < k; i++) {
            Node tmp = this.head;
            Node tmphead = this.head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            this.head = tmphead.next;
            tmphead.next = null;
            tmp.next = tmphead;
        }
    }
    
    public void q2_reverse() {
        Node tmpNode = this.head;
        this.head = null;
        while (tmpNode != null) {
            this.add(tmpNode.data);
            tmpNode = tmpNode.next;
        }
    }
    
    public void q3_remove_dup() {
        Node tmp = this.head;
        while (tmp != null) {
            Node tmp2 = tmp.next;
            Node tmp2Prev = tmp;
            while (tmp2 != null) {
                if (tmp.data == tmp2.data) tmp2Prev.next = tmp2Prev.next.next;
                tmp2Prev = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
    }

    public void q4_add_one() {
        Node tmp = this.head;
        int sum = 0;
        int r = 0;
        while (tmp != null) {
            sum *= 10;
            sum += tmp.data;
            tmp =  tmp.next;
            r++;
        }
        sum++;
        this.head = null;
        int [] sumSplit = new int[r];
        for (int i = 0; i < r; i++) {
            sumSplit[i] = (String.valueOf(sum).charAt(i) - '0');
        }
        add(sumSplit);
    }
    
    public boolean q5_isPalindrome() {
        int size = 0;
        Node tmp = this.head;
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }
        tmp = this.head;
        for (int i = 0; i < size/2; i++) {
            Node tmpNode = tmp;
            int r = size - 1 - i*2;
            while (r > 0) {
                tmpNode = tmpNode.next;
                r--;
            }
            if (tmpNode.data != tmp.data) {
                return false;
            }
            tmp = tmp.next;
        }
        return true;
    }
    
    static void q1() {
        int [] d = {10,20,30,40,50};
        MyLinkedListTricky_660859 mList = new MyLinkedListTricky_660859();
        mList.add(d);
        System.out.println("before -> " + mList);
        mList.q1_rotate_clockwise(1);
        System.out.println("(k = " + 1 + ") -> " + mList);
        mList.q1_rotate_clockwise(3);
        System.out.println("(k = " + 3 + ") -> " +mList);
        mList.q1_rotate_clockwise(7);
        System.out.println("(k = " + 7 + ") -> " +mList);
    }

    static void q2() {
        int [] d = {1,2,3,4,5,6,7,8};
        MyLinkedListTricky_660859 mList = new MyLinkedListTricky_660859();
        mList.add(d);
        System.out.println("before -> " + mList);
        mList.q2_reverse();
        System.out.println("after -> " + mList);
    }

    static void q3() {
        int [] d = {13, 11, 4, 15, 4};
        MyLinkedListTricky_660859 mList = new MyLinkedListTricky_660859();
        mList.add(d);
        System.out.println("before -> " + mList);
        mList.q3_remove_dup();
        System.out.println("after -> " + mList);
        
        int [] e = {13, 11, 15, 4};
        mList = new MyLinkedListTricky_660859();
        mList.insert(e);
        System.out.println("before -> " + mList);
        mList.q3_remove_dup();
        System.out.println("after -> " + mList);
    }
    
    static void q4() {
        int [] d = {1, 9, 9, 9};
        MyLinkedListTricky_660859 mList = new MyLinkedListTricky_660859();
        mList.add(d);
        System.out.println("before -> " + mList);
        mList.q4_add_one();
        System.out.println("after -> " + mList);
    }
    

    static void q5() {
        int [] d = {21, 33, 33, 21};
        boolean isPalind;
        MyLinkedListTricky_660859 mList = new MyLinkedListTricky_660859();
        mList.add(d);
        isPalind = mList.q5_isPalindrome();
        System.out.println(mList + " isPalindrome() = " + isPalind);
        int [] e = {21, 33, 44, 33, 21};
        mList = new MyLinkedListTricky_660859();
        mList.add(e);
        isPalind = mList.q5_isPalindrome();
        System.out.println(mList + " isPalindrome() = " + isPalind);
        int [] f = {1, 9, 9, 9};
        mList = new MyLinkedListTricky_660859();
        mList.add(f);
        isPalind = mList.q5_isPalindrome();
        System.out.println(mList + " isPalindrome() = " + isPalind);
    }


    public static void main(String[] args) {
        System.out.println("----------q1----------");
        q1();
        System.out.println("----------q2----------");
        q2();
        System.out.println("----------q3----------");
        q3();
        System.out.println("----------q4----------");
        q4();
        System.out.println("----------q5----------");
        q5();
    }
}
