package com.personal.controller;

import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;


/**
 * Created by Zhouyang on 2017/4/16.
 */
public class WeatherUtil {

    private static final String URL="http://120.24.64.3/getJson?cityname=";

    public static JSONObject getWeather(String cityname){
        JSONObject jsonObject = null;

        try {
            Document doc = Jsoup.connect(URL+cityname)
                    .data("query", "Java")
                    .userAgent("Mozilla")
                    .timeout(3000)
                    .get();

            System.out.println(doc.html());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static void main(String args[]){
        getWeather("武汉");

    }
}
