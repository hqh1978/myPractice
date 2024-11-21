package org.example.myPractice.greedyAlgorithm;

import java.util.Arrays;

public class shippingProblem {
    static class Goods {
        int id;
        int profit;
        int weight;
        double profitPerWeight;

        Goods(int id, int profit, int weight) {
            this.id = id;
            this.profit = profit;
            this.weight = weight;
            //  使用浮点除法来确保 profitPerWeight 为小数
            this.profitPerWeight = (double) profit / weight;
        }
    }

    public static void main(String[] args) {
        Goods[] goods = {
                new Goods(1, 10, 2),
                new Goods(2, 5, 3),
                new Goods(3, 15, 5),
                new Goods(4, 7, 7),
                new Goods(5, 6, 1),
                new Goods(6, 8, 4),
                new Goods(7, 3, 1)
        };
        int maxWeight = 15;
        int avaliableWeight = maxWeight;
        int maxProfit = 0;
        Arrays.sort(goods, (a, b) -> {
            return Double.compare(b.profitPerWeight, a.profitPerWeight);
        });

        for (Goods goods1 : goods) {
            if (avaliableWeight > 0) {
                maxProfit += goods1.profit * goods1.weight;
                avaliableWeight = avaliableWeight - goods1.weight;
            }
        }
        System.out.println("maxProfit=" + maxProfit);
    }
}
