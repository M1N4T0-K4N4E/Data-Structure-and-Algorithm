package solutions.pack7_Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets_660859 {
    public static void printAllSubsets_Recurse(List<Integer> set) {
        printAllSubsets_Recurse(set,0);
    }

    public static void printAllSubsets_Recurse(List<Integer> set, int n) {
        System.out.print(set.toString() + " ");
        for (int i = set.size() - 1; i >= n; i--) {
            List<Integer> copy = new ArrayList<>(set);
            copy.remove(i);
            printAllSubsets_Recurse(copy, i);
        }
    }
    
    public static void printAllSubsets_DP(List<Integer> set) {
        int n = set.size();
        for (int i = 0; i < (int)(Math.pow(2, n)); i++) {
            List<Integer> copy = new ArrayList<>(set);
            for (int j = 0; j < )
        }
    }
}
