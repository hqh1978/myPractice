package org.example.myPractice.sort;

public class bubbleSort {
    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 7, 89, 21, 32, 45, 77};
        int size = arr1.length - 1;
        boolean swapped;
        //冒泡排序的外循环负责逐轮将最大的未排序元素“冒泡”到正确的位置。
        for (int i = 0; i < size; i++) {
            swapped = false;
            for (int k = 0; k < size - i; k++) {
                //最大的往下沉 第一轮沉到size-0,第二轮沉到size-1.
                if (arr1[k] > arr1[k + 1]) { //大的往下沉
                    int temp = arr1[k];
                    arr1[k] = arr1[k + 1];
                    arr1[k + 1] = temp;
                    swapped = true;
                }
            }
            //如果在某一轮没有发生任何交换，那么可以确定剩下的元素已经有序，这时就可以直接跳出外循环，结束排序过程。
            if(!swapped){
                break;
            }
        }
        for (Integer a : arr1) {
            System.out.println(a);
        }
    }
}
