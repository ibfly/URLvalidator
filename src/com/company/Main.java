package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



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

        UIManager.put("swing.boldMetal", Boolean.FALSE);
        //Schedule a job for the event-dispatching thread:
        //adding TrayIcon.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

            for (String adr: data) {
                if(isUrlValid(adr))
                    System.out.println(adr + " - Доступен");
                else
                    System.out.println(adr + " - Не доступен");
            }

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
    static void createAndShowGUI() {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray не поддерживается");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon = new TrayIcon(createImage("icon32.png", "tray icon"));
        final SystemTray tray = SystemTray.getSystemTray();

        // Create a popup menu components
        MenuItem aboutItem = new MenuItem("О программе");
//
        MenuItem exitItem = new MenuItem("Выход");

        //Add components to popup menu
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(exitItem);

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon не может быть добавлен");
            return;
        }

        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Шо ты наделал");
            }
        });

        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Дуже крута прога");
            }
        });
        // Моя вставка, установка авторазмера иконки
        trayIcon.setImageAutoSize(true);
        //
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
    }
    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = Main.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}



