package org.example.myPractice.Urls;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UrlProcessor {
    private static final int THREAD_POOL_SIZE = 100;
    private static final int TIMEOUT = 5000; //毫秒

    public static void main(String[] args) {
        //read
        String filePath = "urls.txt"; // URL 文件路径
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String url = "";
            while ((url = br.readLine()) != null) {
                final String requestUrl = url;
                executorService.submit(() -> {
                    callURl(requestUrl);
                });
            }
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        //关闭线程池
        executorService.shutdown();
        // 等待线程池中的任务完成
        try {
            if (!executorService.awaitTermination(60, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }


    }

    private static void callURl(String requestUrl) {
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET"); // 设置请求方法
            connection.setConnectTimeout(TIMEOUT); // 设置连接超时
            connection.setReadTimeout(TIMEOUT);    // 设置读取超时
            // 添加请求头（可选）
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            //对于 GET 请求，你可以直接调用 getResponseCode() 来发送请求并获取响应代码。
            int responseCode = connection.getResponseCode();

            //对于 POST 请求或其他需要发送请求体的请求，你需要获取输出流并写入数据。
            connection.setRequestMethod("POST");
            connection.setDoOutput(true); // 需要输出流

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = "param1=value1&param2=value2".getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            //读取响应
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line.trim());
                }
                System.out.println("Response: " + response.toString());
            }

            System.out.println("URL: " + requestUrl + " | Response Code: " + responseCode);
            // 处理响应...
        } catch (IOException e) {
            System.err.println("Error processing URL: " + requestUrl);
            e.printStackTrace();
        }
    }
}
