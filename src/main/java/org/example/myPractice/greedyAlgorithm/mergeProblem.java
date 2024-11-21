package org.example.myPractice.greedyAlgorithm;

public class mergeProblem {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};
        int[] mergedArray = merge(nums1, nums2);
        // 打印合并后的数组
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }
    public static int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] mergedArray = new int[m + n];
        int i = 0, j = 0, k = 0;
        // 合并两个数组
        while (i < m && j < n) {
            if(nums1[i]<=nums1[j]){
                mergedArray[k]=nums1[i];
                i++;
                k++;
            }else{
                mergedArray[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<m){
            mergedArray[k]=nums1[i];
            k++;
            i++;
        }
        while(j<n){
            mergedArray[k]=nums2[j];
            k++;
            j++;

        }

        return mergedArray;
    }
}
