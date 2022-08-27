package Frame;

import Game.Game;
import Game.Status;
import Game.GamePad;
import GameData.DataManager;
import GameData.Reed.ReedData;
import GameData.Save.SaveData;
import Menu.Menu;
import SettingsData.SettingsData;
import SoundEffect.BackgroundMusic;
import SoundEffect.PlaySound;

import javax.swing.*;

public class GamePadButtonsActionListener {
    public static void restart(JFrame mainWindow){
        PlaySound.play("Restart.wav");
        ReedData.Reed(); // To Have GameConfig, ReedData Called Before DataManager.restart(), Because DataManager.restart() Remove GameConfig Too
        DataManager.restart();
        MainFrame.reload(mainWindow, new Game(Integer.parseInt(ReedData.GameConfig.get(0)), Double.parseDouble(ReedData.GameConfig.get(1)), MainFrame.moreEasy, false));
    }
    public static void tryAgain(JFrame mainWindow){
        PlaySound.play("Restart.wav");
        DataManager.tryAgain();
        Status.mistakeNumber = Integer.parseInt(SettingsData.NumberOfChances);
        SaveData.SaveGameConfig();
        ReedData.Reed();
        MainFrame.reload(mainWindow, new Game(Integer.parseInt(ReedData.GameConfig.get(0)), Double.parseDouble(ReedData.GameConfig.get(1)), MainFrame.moreEasy, true));
        GamePad.tryAgain.setEnabled(false);
    }
    public static void menu(JFrame mainWindow){
        BackgroundMusic.stop();
        PlaySound.play("MenuButton.wav");
        MainFrame.reload(mainWindow, new Menu());
    }
}
