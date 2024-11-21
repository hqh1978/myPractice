package org.example.myPractice.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();
        // 使用不同的区域设置创建 DateTimeFormatter
        DateTimeFormatter formatterUS = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.US);
        DateTimeFormatter formatterFR = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.FRANCE);

        DateTimeFormatter formatterUS2 = DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm:ss", Locale.US);
        String formattedUS2 = dateTime.format(formatterUS2);

        // 使用法国区域设置格式化日期和时间
        DateTimeFormatter formatterFR2 = DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm:ss", Locale.FRANCE);
        String formattedFR2 = dateTime.format(formatterFR2);


        // 使用中国区域设置格式化日期和时间
        DateTimeFormatter formatterCN = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss", Locale.CHINA);
        String formattedCN = dateTime.format(formatterCN);
        // 打印格式化结果
        System.out.println("US Format: " + formattedUS2);
        System.out.println("French Format: " + formattedFR2);
        System.out.println("Chinese Format: " + formattedCN);

    }
}
