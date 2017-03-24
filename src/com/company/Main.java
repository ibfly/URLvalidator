package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

//     Задача от НИКИТИНА
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String urlString = reader.readLine();

        System.out.println(valid(urlString));

    }
    private static boolean valid(String u) {
        boolean valid = false;
        try {
            URL url = new URL(u);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setInstanceFollowRedirects(false);
            int responseCode = huc.getResponseCode();

            if (responseCode >= 400 && responseCode < 600 ) {
                System.out.println(" Не доступен");
            }
            else {
                valid = true;
                System.out.println("Доступен");
            }
        }
        catch (MalformedURLException e){
            System.out.println("Ошибка протокола");
        }
        catch (UnknownHostException e) {
            System.out.println("Сервер не доступен");
        }
        catch (Exception e) {
            System.out.println("Ошибка");
        }
        return valid;
    }
}



