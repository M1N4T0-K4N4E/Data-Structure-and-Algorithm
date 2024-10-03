package solutions.pack7_Recursion;

import java.util.Arrays;

public class EqualSubsets_660859 {


    public static boolean canPartition_Recurse(int [] arr) {
        int sum = 0;
        for (int i : arr) {
            sum+= i;
        }
        if (sum%2!=0) 
            return false;

        int target = sum / 2;
        System.out.println(Arrays.toString(arr));
        return (Partition(arr, target, 0));
    }

    static boolean Partition(int[] arr, int target, int index) {
        if (target == 0) {
            return true;
        }

        if (index >= arr.length || target < 0) {
            return false;
        } 

        if (Partition(arr, target - arr[index], index + 1)) {
            return true;
        }
        return Partition(arr, target, index + 1);
    }

    public static boolean canPartition_Memoiz(int [] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        return Memoiz(arr, target, 0);
    }

    private static boolean Memoiz(int[] arr, int target, int index) {
        if (target == 0) {
            return true;
        }
        if (index >= arr.length || target < 0) {
            return false;
        }
        return Memoiz(arr, target - arr[index], index + 1) || Memoiz(arr, target, index + 1);
    }
    
    public static boolean canPartition_DP(int [] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; 

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
