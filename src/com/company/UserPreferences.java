package com.company;

import java.io.FileOutputStream;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class UserPreferences {
    private Preferences userPrefs;
    private String adr = "http://chuviha.ua";
    public UserPreferences()
    {
        userPrefs = Preferences.userRoot().node("prefs");

    }

    public String getUrl()
    {
        String u = userPrefs.get("key",adr);
        return u;
    }

    public void putData()
    {
         userPrefs.put("key", adr);
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


