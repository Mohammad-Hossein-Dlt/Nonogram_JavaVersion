package WindowsManager;


import Constants.Language.Language;
import GameData.DataManager;
import GameData.Reed.ReedData;
import History.HistoryList;
import Game.Game;
import Menu.Menu;
import Settings.Settings;
import SoundEffect.PlaySound;

import javax.swing.*;

public class MenuButtonsActionListener {
    public static void history(JFrame mainWindow){
        PlaySound.play("MenuButton.wav");
        MainWindow.reload(mainWindow,new HistoryList(mainWindow));
    }
    public static void continueGame(JFrame mainWindow){
        PlaySound.play("MenuButton.wav");
//      ------------------------------
        if(DataManager.ContinueGame()) {
            ReedData.Reed();
            MainWindow.reload(mainWindow, new Game(Integer.parseInt(ReedData.GameConfig.get(0)), Double.parseDouble(ReedData.GameConfig.get(1)), false, true));
        }else{
            PlaySound.play("Warning.wav");
            int newGame = JOptionPane.showConfirmDialog(mainWindow,Language.NewGameError.Get(), Language.NewGameErrorTitle.Get(),JOptionPane.CLOSED_OPTION);
            if(newGame == JOptionPane.YES_OPTION) PlaySound.play("YesClicked.wav");
        }
    }
    public static void start(JFrame mainWindow){
        PlaySound.play("MenuButton.wav");
//      ------------------------------
        DataManager.StartNewGame();
//      ------------------------------
        if (Menu.scale10.isSelected()) MainWindow.scale = 10;
        if (Menu.scale15.isSelected()) MainWindow.scale = 15;


        if (Menu.easy.isSelected()) MainWindow.hardship = 0.3;
        if (Menu.medium.isSelected()) MainWindow.hardship = 0.4;
        if (Menu.hard.isSelected()) MainWindow.hardship = 0.5;

        MainWindow.moreEasy = Menu.showFalseButtons.isSelected();
//      ------------------------------
        MainWindow.reload(mainWindow,new Game(MainWindow.scale, MainWindow.hardship, MainWindow.moreEasy, false));
//      ------------------------------
    }
    public static void setting(JFrame mainWindow){
        PlaySound.play("MenuButton.wav");
        MainWindow.reload(mainWindow,new Settings());
    }

}
