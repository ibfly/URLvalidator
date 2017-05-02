package com.company;

import javax.swing.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;
import static com.company.TrayGUI.trayGUI;

//     Задача от НИКИТИНА
public class Main {
    public static UserPreferences preferences = new UserPreferences();

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(() -> trayGUI());
    }

    public static List<String> UrlValidCheck () throws BackingStoreException {
        List<String> list = new ArrayList<>();
        for (String x :preferences.getData()){
            if(isUrlValid(x))
                list.add(x + " - Доступен");
                    else
                        list.add(x + " - Доступен");
        }
        return list;
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



