package org.example.myPractice;

import java.util.Arrays;

public class Packaging {
    public static void main(String[] args) {
        int amount = 100;
        int result = packaging(1L, 5L, 13);
        System.out.println("凑成金额 " + amount + " 所需的最少硬币数量: " + result); // 输出: 3 (11 = 5 + 5 + 1)
    }
    public static int packaging(long small,long big,int items){// 13,1,5
        // 14个元素的数组，如果放0,1,2,3...13个item，分别需要多少个package
        // 用数组下标来表示共有多少个行李,数组中的值来表示当前index个行李可以放几个包裹，大包裹和小包裹。
        int[] dp=new int[(int)items+1];
        Arrays.fill(dp,items+1);
        int[] types=new int[2];
        types[0]=(int)small;
        types[1]=(int)big;
//        for(int i=1;i<=items;i++){
//
//            dp[i]=
//        }

        return -1;
    }
}
