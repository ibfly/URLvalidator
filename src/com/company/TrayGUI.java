package com.company;

import java.awt.*;
import java.net.URL;
import java.util.prefs.BackingStoreException;
import javax.swing.*;
import static com.company.Main.UrlValidCheck;

public class TrayGUI {
    public static WindowSettings window;
    public static Menu urlsList;

    static void trayGUI() throws BackingStoreException {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray не поддерживается");
            return;
        }

        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon = new TrayIcon(iconImage("icon/icon.png", "tray icon"));
        final SystemTray tray = SystemTray.getSystemTray();

        // Create a popup menu components
        MenuItem settingsItem = new MenuItem("Настройки...");
        urlsList = new Menu("Статус адресов ");
        MenuItem exitItem = new MenuItem("Выход");

        //Add components to popup menu
        popup.add(settingsItem);
        popup.addSeparator();
        popup.add(urlsList);
        popup.addSeparator();
        popup.add(exitItem);

        Status();

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon не может быть добавлен");
            return;
        }

        settingsItem.addActionListener(e -> window = new WindowSettings());

        exitItem.addActionListener(e -> {
            tray.remove(trayIcon);
            System.exit(0);
        });

        trayIcon.setImageAutoSize(true); // Авторазмер иконки
    }
    // Обработка статуса
    public static void Status() throws BackingStoreException {
        urlsList.removeAll();
        for (String x: UrlValidCheck()) {
            MenuItem statusList = new MenuItem(x);
            urlsList.add(statusList);
        }
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

