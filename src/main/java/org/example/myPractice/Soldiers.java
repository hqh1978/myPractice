package org.example.myPractice;

public class Soldiers {
    public static void main(String[] args) {
        char[] soldiers = {'A', 'B', 'A', 'B', 'A', 'B'};
        swapSoldiers(soldiers);
        System.out.println(soldiers);
    }

    public static void swapSoldiers(char[] soldiers) {
        //双指针
        int left = 0;
        int right = soldiers.length - 1;
        while (left < right) {
            if (soldiers[left] == 'B' && soldiers[right] == 'A') {
                char temp = soldiers[left];
                soldiers[left] = soldiers[right];
                soldiers[right] = temp;
                left++;
                right--;
            }
            if(soldiers[left] == 'A'){
                left++;
            }
            if(soldiers[right]=='B'){
                right--;
            }

        }
    }
}
