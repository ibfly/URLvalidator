package com.company;

import java.awt.*;
import java.net.URL;
import java.util.prefs.BackingStoreException;
import javax.swing.*;

import static com.company.Main.UrlValidCheck;

public class TrayGUI {
    public static WindowSettings window;

    static void trayGUI() throws BackingStoreException {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray не поддерживается");
            return;
        }

        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon =
                new TrayIcon(iconImage("icon/icon.png", "tray icon"));
        final SystemTray tray = SystemTray.getSystemTray();

        // Create a popup menu components

        MenuItem settingsItem = new MenuItem("Настройки...");
        Menu urlsList = new Menu("Статус адресов ");
        MenuItem exitItem = new MenuItem("Выход");

        //Add components to popup menu
        popup.add(settingsItem);
        popup.addSeparator();
        popup.add(urlsList);
        popup.addSeparator();
        popup.add(exitItem);

        for (String x: UrlValidCheck()) {
            MenuItem statusList = new MenuItem(x);
            urlsList.add(statusList);
        }

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon не может быть добавлен");
            return;
        }

        settingsItem.addActionListener(e -> window = new WindowSettings());

//        urlsList.addActionListener(e -> System.out.println("Реализовать!!!"));

        // Моя вставка, установка авторазмера иконки
        trayIcon.setImageAutoSize(true);
        //
        exitItem.addActionListener(e -> {
            tray.remove(trayIcon);
            System.exit(0);
        });
    }
    //Obtain the image URL
    protected static Image iconImage(String path, String description) {
        URL imageURL = TrayGUI.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Файл иконки не найден: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}

