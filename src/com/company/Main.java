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
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String url = reader.readLine();

            while (true) {
                if(isUrlValid(up.getUrl())){
                    System.out.println(up.getUrl() + " - Доступен");
                    break;
                }
                else {
                    System.out.println(up.getUrl() + " - Не доступен");
                    break;
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



