package SettingsData;
import java.io.*;
import java.nio.file.*;

public class SettingsManager {
    public static final File DataBase = new File("Settings.txt");
    public static void load(){
        if(Files.notExists(DataBase.toPath())) SaveSettings.Save();
        else ReedSettings.reed();
    }

}
