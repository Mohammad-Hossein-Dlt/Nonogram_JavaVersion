package Frame;

import Settings.Settings;
import SettingsData.SettingsData;
import SettingsData.SaveSettings;
import SoundEffect.PlaySound;

import javax.swing.*;

public class SettingsButtonsActionListener {
    public static void saveData(JFrame mainWindow){
        PlaySound.play("MenuButton.wav");
//      ------------------------------
        SettingsData.NumberOfChances = Settings.number.getValue().toString();
//      ------------------------------
        if(Settings.light.isSelected()) SettingsData.Theme = "Light";
        if(Settings.dark.isSelected()) SettingsData.Theme = "Dark";
//      ------------------------------
        if(Settings.english.isSelected()) SettingsData.Language = "En";
        if(Settings.persian.isSelected()) SettingsData.Language = "Fa";
//      ------------------------------
        SettingsData.Music = Settings.musicOnOff.getText();
        SettingsData.Sounds = Settings.soundsOnOff.getText();
//      ------------------------------
        SaveSettings.Save();
//      ------------------------------
        MainFrame.reload(mainWindow,new Settings());
    }
    public static void MusicSoundsControl(JButton button){
        if(button.getText().equals("On")) button.setText("Off");
        else if(button.getText().equals("Off")) button.setText("On");
    }
}
