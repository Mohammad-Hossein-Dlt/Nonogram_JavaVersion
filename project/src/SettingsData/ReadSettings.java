package SettingsData;

import java.io.*;
import java.nio.file.Files;

public class ReadSettings {
    public static void read(){
        try {
            InputStream input = new BufferedInputStream(Files.newInputStream(SettingsManager.DataBase.toPath()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String temp = "";

            temp = reader.readLine();
            SettingsData.NumberOfChances = temp.substring(temp.indexOf(" ")+1);

            temp = reader.readLine();
            SettingsData.Theme = temp.substring(temp.indexOf(" ")+1);

            temp = reader.readLine();
            SettingsData.Language = temp.substring(temp.indexOf(" ")+1);

            temp = reader.readLine();
            SettingsData.Music = temp.substring(temp.indexOf(" ")+1);

            temp = reader.readLine();
            SettingsData.Sounds = temp.substring(temp.indexOf(" ")+1);

        } catch (IOException ignored){}
    }
}
