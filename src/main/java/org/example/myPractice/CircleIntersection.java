package org.example.myPractice;

public class CircleIntersection {
    public static void main(String[] args) {
        double r1 = 3.0; // 第一个圆的半径
        double r2 = 4.0; // 第二个圆的半径
        double d = 5.0;  // 两个圆心的距离

        double intersectionArea = calculateIntersectionArea(r1, r2, d);
        System.out.println("两个圆相交的面积: " + intersectionArea);
    }
    public static double calculateIntersectionArea(double r1, double r2, double d) {
        // 检查两个圆是否有交集
        if (d >= r1 + r2) {
            return 0.0; // 两个圆没有交集
        }
        if (d <= Math.abs(r1 - r2)) {
            // 一个圆完全包含另一个圆
            double r = Math.min(r1, r2);
            return Math.PI * r * r; // 返回较小圆的面积
        }

        // 使用公式计算相交面积
        double part1 = r1 * r1 * Math.acos((d * d + r1 * r1 - r2 * r2) / (2 * d * r1));
        double part2 = r2 * r2 * Math.acos((d * d + r2 * r2 - r1 * r1) / (2 * d * r2));
        double part3 = 0.5 * Math.sqrt((-d + r1 + r2) * (d + r1 - r2) * (d - r1 + r2) * (d + r1 + r2));

        return part1 + part2 - part3;
    }
}
