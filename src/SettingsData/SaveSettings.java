package SettingsData;

import java.io.*;
import java.nio.file.Files;

public class SaveSettings {
//  Save Data From SettingsModel
    public static void Save() {
        try {
            SettingsManager.DataBase.delete();
            SettingsManager.DataBase.createNewFile();
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(SettingsManager.DataBase.toPath()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            SettingsModel.loadModel();
            writer.write(SettingsModel.NumberOfChances);
            writer.newLine();

            writer.write(SettingsModel.Theme);
            writer.newLine();

            writer.write(SettingsModel.Language);
            writer.newLine();

            writer.write(SettingsModel.Music);
            writer.newLine();

            writer.write(SettingsModel.Sounds);
            writer.newLine();

            writer.flush();
            writer.close();
        } catch (IOException ignored){}
    }
}
