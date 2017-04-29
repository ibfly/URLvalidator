package com.company;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

import static com.company.Main.up;

public class HideToSystemTray {
    public static WindowSettings ws;

    static void createAndShowGUI() {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray не поддерживается");
            return;
        }

        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon =
                new TrayIcon(createImage("icon.png", "tray icon"));
        final SystemTray tray = SystemTray.getSystemTray();

        // Create a popup menu components

        MenuItem aboutItem = new MenuItem("О программе");
        MenuItem settingsItem = new MenuItem("Настройки");
        MenuItem clearList = new MenuItem("Очистить список");
        MenuItem exitItem = new MenuItem("Выход");

        //Add components to popup menu

        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(settingsItem);
        popup.addSeparator();
        popup.add(clearList);
        popup.addSeparator();
        popup.add(exitItem);

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon не может быть добавлен");
            return;
        }

        trayIcon.addActionListener(e ->
                JOptionPane.showMessageDialog(null, "Шо ты наделал"));

        settingsItem.addActionListener(e -> ws = new WindowSettings());

        clearList.addActionListener(e -> up.clearPreferences());

        aboutItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,"Дуже крута прога");
        });
        // Моя вставка, установка авторазмера иконки
        trayIcon.setImageAutoSize(true);
        //
        exitItem.addActionListener(e -> {
            tray.remove(trayIcon);
            System.exit(0);
        });

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

