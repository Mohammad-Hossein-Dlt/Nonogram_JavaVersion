package SettingsData;

public class SettingsModel {
//  The Values Save In Database
    public static String NumberOfChances;
    public static String Theme;
    public static String Language;
    public static String Music;
    public static String Sounds;
    public static void loadModel(){
        NumberOfChances = "NumberOfChances: "+ SettingsData.NumberOfChances;
        Theme = "Theme: "+ SettingsData.Theme;
        Language = "Language: "+ SettingsData.Language;
        Music = "Music: "+ SettingsData.Music;
        Sounds = "Sounds: "+ SettingsData.Sounds;
    }
}
