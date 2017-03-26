package com.company;

import javax.swing.*;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.HideToSystemTray.createAndShowGUI;

//     Задача от НИКИТИНА
public class Main {

        private static List<String> data = new ArrayList<>();
        private static final String FILE_PATH = "/JAVA/URLvalidator/config.txt";

    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String urlString = reader.readLine();    /JAVA/URLvalidator/icon32.png
        try {
            readConfig();
        }
        catch (Exception e){
            System.out.println("Файл config.txt не найден");
            return;
        }
            for (String adr: data) {
                if(isUrlValid(adr))
                    System.out.println(adr + " - Доступен");
                else
                    System.out.println(adr + " - Не доступен");
            }
        UIManager.put("swing.boldMetal", Boolean.FALSE);
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
    private static void readConfig() throws Exception {
        Scanner scanner = new Scanner(new File(FILE_PATH));
        while (scanner.hasNext()){
            data.add(scanner.next());
        }
    }
}



