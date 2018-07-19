package com.example.xw3278.networktest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2018/7/18.
 */

public class HttpUtil {
    //example: String address = "http://www.baidu.com";
    //         String response = HttpUtil.sendHttpRequest(address);
    public static String sendHttpRequest(String address) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
            return response.toString();
        }catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
