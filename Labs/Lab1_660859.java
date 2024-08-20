package Labs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import solutions.pack1.*;

public class Lab1_660859 {
    public static void task1() {
        System.out.println("--task1---");
        ArrayList<String> lis1a = new ArrayList<>(Arrays.asList("Lily","Daisy"));
        ArrayList<String> lis1b = new ArrayList<>(Arrays.asList("Tulip","Daisy"));
        ArrayList<String> lis1c;
        lis1c = new ArrayList<>(lis1a);
        lis1c.addAll(lis1b);
        System.out.println(lis1c); 
        System.out.println(lis1a);
    }
    public static void task2() {
        System.out.println("--task2---");
        ArrayList<StringBuilder> lis1a = new ArrayList<>(Arrays.asList(new StringBuilder("Lily"), new StringBuilder( "Daisy")));
        ArrayList<StringBuilder> lis1b = new ArrayList<>(lis1a);
        lis1b.add(new StringBuilder("30"));        
        System.out.println(lis1b); 
        System.out.println(lis1a);  // Original data seems not affected
        StringBuilder sb = lis1a.get(0);
        sb.append("mySuffix");
        // Does lis2b.get(0) object change? Or it is not affected. Check it yourself.
        // complete the task by display "shallow copy" if lis2b first element is affected.
        System.out.println(lis1b); 
        System.out.println(lis1a);  // It affected
    }
    public static void task3() {
        System.out.println("--task3---");
        List<String> lis3 = new ArrayList<>(Arrays.asList("Lily","Daisy","Tulip","Daisy"));
        /* your code */
        lis3 = lis3.subList(0, 1);
        System.out.println(lis3);
    }
    public static void task4() { // show unique elements
        System.out.println("--task4---");
        // ArrayList<String> lis1 = new ArrayList<>(Arrays.asList("Lily","Daisy","Tulip","Daisy"));
        List<String> lis4a = Arrays.asList("Lily","Daisy","Tulip","Daisy");
        HashSet<String> flowers = new HashSet<>(lis4a);
        for (String ele : flowers) {
            System.out.print(ele + " ");
        }
        System.out.println();
        ArrayList<Dog_660859> lis4b = new ArrayList<>(Arrays.asList(new Dog_660859(Breed.pomeranian,1200), new Dog_660859(Breed.beagle, 2300), new Dog_660859(Breed.jack, 1440), new Dog_660859(Breed.beagle,2300)));
        HashSet<Dog_660859> dogs = new HashSet<>(lis4b);
        for (Dog_660859 ele : dogs) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
    static void task5() { // dog breed frequency 
        System.out.println("--task5---");
        ArrayList<Dog_660859> lis5 = new ArrayList<>(Arrays.asList(new Dog_660859(Breed.pomeranian,1200), new Dog_660859(Breed.beagle, 2300), new Dog_660859(Breed.jack, 1440), new Dog_660859(Breed.beagle,2300)));
        HashMap<Breed,Integer> map = new HashMap<>();
        for (Dog_660859 d : lis5) {
            if (map.get(d.getB()) == null) {
                map.put(d.getB(), 1);
            } else {
                map.put(d.getB(), map.get(d.getB()) + 1);
            }
        }
        for (Entry<Breed, Integer> ele : map.entrySet()) {
            System.out.println(ele.getKey() + "\t" + ele.getValue());
        }
    }
    static void task6() { // number of unique elements
        System.out.println("--task6---");
        System.out.print("The number of unique element is ");
        ArrayList<Dog_660859> lis6 = new ArrayList<>(Arrays.asList(new Dog_660859(Breed.pomeranian,1200), new Dog_660859(Breed.beagle, 2300), new Dog_660859(Breed.jack, 1440), new Dog_660859(Breed.beagle,2300)));        
        /* your code */
        System.out.println(lis6.stream().collect(Collectors.groupingBy(Dog_660859::getB)).size());
    }
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task4a();
    }
    static int N = 10_000;
    static Integer [] arr = new Integer [N];
    static int num_iter = 100_000 * 10;
    static ArrayList<Integer> lis = new ArrayList<>();
    static LinkedList<Integer> llis;
    static {
        for (int i = 0; i < N; i++) {
            lis.add(i);
        }
        Collections.shuffle(lis);
        lis.toArray(arr);
        llis = new LinkedList<>(lis);
    }
    static void demo_arrayList(int idx) {
        int value;
        // long start = System.currentTimeMillis();
        long start = System.nanoTime();
        for (int iter = 0; iter < num_iter; iter++) {
            value = lis.get(idx);
        }
        long time = (System.nanoTime() - start);
        System.out.printf("%-15s", time);
    }
    static void demo_linkedList(int idx) {
        int value;
        long start = System.nanoTime();
        for (int iter = 0; iter < num_iter; iter++) {
            value = llis.get(idx);
        }
        long time = (System.nanoTime() - start);
        System.out.printf("%-15s", time);
    }
    static void demo_array(int idx) {
        int value;
        long start = System.nanoTime();
        for (int iter = 0; iter < num_iter; iter++) {
            value = arr[idx];
        }
        long time = (System.nanoTime() - start);
        System.out.printf("%-15s", time);
    }
    static void task4a() {
        System.out.printf("%-15s%-15s%-15s%-15s\n","Index", "ArrayList", "LinkedList", "Array");
        for (int index = 0; index < arr.length; index += arr.length/4) {
            System.out.printf("%-15s", index);
            demo_arrayList(index);
            demo_linkedList(index);
            demo_array(index);
            System.out.println();
        }
    }
}
