package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//     Задача от НИКИТИНА
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String urlString = reader.readLine();

        URL url = new URL(urlString);
        HttpURLConnection huc = (HttpURLConnection) url.openConnection();
        int responseCode = huc.getResponseCode();

        if (responseCode != 404) {
            System.out.println("Сайт существует");
        } else {
            System.out.println("Такого сайта нет");
        }
    }
}



