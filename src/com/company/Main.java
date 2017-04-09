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
        up.resetTimes();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();

            while (true) {
                if(isUrlValid(url)){
                    System.out.println(url + " - Доступен");
                    break;
                }
                else {
                    System.out.println(url + " - Не доступен");
                    break;
                }
            }
//        UIManager.put("swing.boldMetal", Boolean.FALSE);
        //Schedule a job for the event-dispatching thread:
        //adding TrayIcon.
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



