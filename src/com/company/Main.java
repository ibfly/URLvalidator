package com.company;

import javax.swing.*;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import static com.company.HideToSystemTray.createAndShowGUI;

//     Задача от НИКИТИНА
public class Main {
    static UserPreferences up = new UserPreferences();

    public static void main(String[] args) throws Exception {

         for (String x :up.getData()){
                if(isUrlValid(x)){
                    System.out.println(x + " - Доступен");
                }
                else {
                    System.out.println(x + " - Не доступен");

                }
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static boolean isUrlValid(String u) {
        boolean valid = false;
        try {
            URL url = new URL(u);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setInstanceFollowRedirects(false);
            int responseCode = huc.getResponseCode();

            if (responseCode < 400 )
                valid = true;
        }
        catch (MalformedURLException e){
        }
        catch (UnknownHostException e) {
        }
        catch (Exception e) {
        }
        return valid;
    }
}



