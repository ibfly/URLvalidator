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

    public List<String> getData() throws BackingStoreException {
        List<String> list = new ArrayList<>();
        for (String key : userPrefs.keys()){
            list.add(userPrefs.get(key,null));
        }
        // экспорт данных из реестра в xml.
        try {
            userPrefs.exportNode(new FileOutputStream("config.xml"));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void putData(List<String> list) {
        try {
            userPrefs.clear();
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++){
            userPrefs.put(Integer.toString(i), list.get(i));
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


