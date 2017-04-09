package com.company;

import java.io.FileOutputStream;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class UserPreferences {
    private Preferences userPrefs;
    public UserPreferences()
    {
        userPrefs = Preferences.userRoot().node("prefs");

    }

//    public void putData()
//    {
//        userPrefs.put("key", url);
//    }

    public void resetTimes()
    {
        for (int i = 0; i < 5; i++) {
            // «засыпаем»
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // экспорт данных из реестра в xml.
        try {
            userPrefs.exportNode(new FileOutputStream("config.xml"));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void clearPreferences()
    {
        try {
            userPrefs.clear();
        }
        catch (BackingStoreException e) {
            e.printStackTrace();
        }
    }
}


