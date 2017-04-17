package com.company;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class UserPreferences {
    Preferences userPrefs;
    public UserPreferences()
    {
        userPrefs = Preferences.userRoot().node("prefs");
    }

    public List<String> getData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            list.add(userPrefs.get(Integer.toString(i),null));
        }
        return list;
    }

    public void putData()
    {
         userPrefs.put("0","https://youtube.com/" );
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


