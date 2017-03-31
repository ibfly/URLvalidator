package com.company;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

import static com.company.Main.isUrlValid;

public class HideToSystemTray {

    static void createAndShowGUI() {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray не поддерживается");
            return;
        }

        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon =
                new TrayIcon(createImage("icon32.png", "tray icon"));
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

        /////////

//        while (true){
//            if (isUrlValid(url))
//                System.out.println(url + " - Доступен");
//            else
//                trayIcon.displayMessage(url, " - Не доступен",
//                        TrayIcon.MessageType.INFO);
//        }

    }
    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = HideToSystemTray.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}

