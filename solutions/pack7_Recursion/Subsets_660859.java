package solutions.pack7_Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets_660859 {
    public static void printAllSubsets_Recurse(List<Integer> set) {
        printAllSubsets_Recurse(set,0);
        System.out.println();
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

        // loop 2 to the pow n
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> copy = new ArrayList<>();

            // bit traverse
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    copy.add(set.get(j));
                }
            }
            System.out.print(copy + " ");
        }
        System.out.println();
    }
}
