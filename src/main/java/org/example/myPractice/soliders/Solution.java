package org.example.myPractice.soliders;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {4, 3, 2, 1};
        System.out.println("Minimum swaps for nums1: " + minSwaps(nums1)); // Output: 2

        // Test case 2
        int[] nums2 = {1, 5, 4, 3, 2};
        System.out.println("Minimum swaps for nums2: " + minSwaps(nums2)); // Output: 2

        // Test case 3
        int[] nums3 = {1, 2, 3, 4};
        System.out.println("Minimum swaps for nums3: " + minSwaps(nums3)); // Output: 0
    }
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);

        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(nums[i], i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || indexMap.get(arr[i]) == i) continue;

            int cycleSize = 0;
            int x = i;
            while (!visited[x]) {
                visited[x] = true;
                x = indexMap.get(arr[x]);
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }
}
