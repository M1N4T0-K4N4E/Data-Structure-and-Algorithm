package Labs;

import solutions.pack10_BST.*;

public class Lab10_BST_Main {
	public static void main(String[] args) {
		System.out.println("Example output:");
<<<<<<< HEAD
		task1();
=======
//		task1();
>>>>>>> 09e1f91291f0e11b368704e522ea97ab89d7b50f
		task2();
		task3();
	}
	public static void task1() {
		System.out.println("--- task 1 ---");
		int data[] = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
		
		BST_660859 bst = new BST_660859();
		for (int i=0; i<data.length; i++)
			bst.insert(data[i]);

		bst.printInOrder();
		System.out.println(bst.search(20));
		System.out.println(bst.search(25));
		System.out.println(bst.search(12));
		System.out.println(bst.search(1));
		bst.delete(12);
		bst.delete(25);
		bst.delete(100);
		System.out.println(bst.search(12));
		System.out.println(bst.search(20));
	}
	public static void task2() {
		System.out.println("--- task 2 ---");
		int data[] = {60, 41, 65, 63, 70, 53,
					  16, 46, 55, 62, 64, 42};
		
		BST_660859 bst = new BST_660859();
		for (int i=0; i<data.length; i++)
			bst.insert(data[i]);

		bst.printPreOrder();
		bst.printInOrder();
		bst.printPostOrder();
		System.out.println(bst.findMin());
		System.out.println(bst.findMax());
		System.out.println(bst.height());
		System.out.println(bst.count());
		bst.delete(53);
		System.out.println(bst.height());
		System.out.println(bst.count());
	}
	public static void task3() {
		System.out.println("--- task 3 ---");
		median();
		rank();
	}
	public static void median() {
		System.out.println("-- test find median --");
		int data[] = { 20, 22, 8, 12, 4, 10, 14 };
		
		BST_660859 bst = new BST_660859();
		for (int i=0; i<data.length; i++)
			bst.insert(data[i]);
		System.out.println(bst.findMedian()); // 12.0
		bst.insert(16);
		System.out.println(bst.findMedian()); // 13.0
		bst.insert(25);
		System.out.println(bst.findMedian()); // 14.0
	}
	public static void rank() {
		System.out.println("-- test find rank --");
		int data[] = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
		
		BST_660859 bst = new BST_660859();
		for (int i=0; i<data.length; i++)
			bst.insert(data[i]);
		System.out.println(bst.findRank(12)); // 3
		System.out.println(bst.findRank(20)); // 8
		System.out.println(bst.findRank(13)); // -1
		System.out.println(bst.findRank(31)); // -1
	}
}