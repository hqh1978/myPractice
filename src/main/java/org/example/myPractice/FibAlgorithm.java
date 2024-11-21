package org.example.myPractice;

import java.util.Arrays;

public class FibAlgorithm {
    public static void main(String[] args) {
        //最大能算到46,超界
        int k = 30;
        int result = fib(k);
        System.out.println("fib of " + k + " is " + result); // Output: 6
    }

    private static int fib(int k) {
        int[] dp = new int[k + 1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=k; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            if (dp[i]  < 0) { // When overflow occurs, next will be negative
                System.out.println("The index of Fibonacci number exceeding int max value is: " + (i-1));
                return -1;
            }
        }
        return dp[k];
    }

}
