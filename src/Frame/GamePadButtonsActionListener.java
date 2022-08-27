package Frame;

import Game.Game;
import Game.Status;
import Game.GamePad;
import GameData.GamesFoldersManager;
import GameData.Read.ReadData;
import GameData.Save.SaveData;
import Menu.Menu;
import SettingsData.SettingsData;
import SoundEffect.BackgroundMusic;
import SoundEffect.PlaySound;

import javax.swing.*;

public class GamePadButtonsActionListener {
    public static void restart(JFrame mainWindow){
        PlaySound.play("Restart.wav");
        ReadData.read(); // To Have GameConfig, ReadData Called Before DataManager.restart(), Because DataManager.restart() Remove GameConfig Too
        GamesFoldersManager.restart();
        MainFrame.reload(mainWindow, new Game(Integer.parseInt(ReadData.GameConfig.get(0)), Double.parseDouble(ReadData.GameConfig.get(1)), MainFrame.moreEasy, false));
    }
    public static void tryAgain(JFrame mainWindow){
        PlaySound.play("Restart.wav");
        GamesFoldersManager.tryAgain();
        Status.mistakeNumber = Integer.parseInt(SettingsData.NumberOfChances);
        SaveData.SaveGameConfig();
        ReadData.read();
        MainFrame.reload(mainWindow, new Game(Integer.parseInt(ReadData.GameConfig.get(0)), Double.parseDouble(ReadData.GameConfig.get(1)), MainFrame.moreEasy, true));
        GamePad.tryAgain.setEnabled(false);
    }
    public static void menu(JFrame mainWindow){
        BackgroundMusic.stop();
        PlaySound.play("MenuButton.wav");
        MainFrame.reload(mainWindow, new Menu());
    }
}
