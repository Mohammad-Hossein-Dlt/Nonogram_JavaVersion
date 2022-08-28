package Frame;


import Constants.Language.Language;
import GameData.GamesFoldersManager;
import GameData.Read.ReadData;
import History.HistoryList;
import Game.Game;
import Menu.Menu;
import Settings.Settings;
import SoundEffect.PlaySound;

import javax.swing.*;

public class MenuButtonsActionListener {
    public static void history(JFrame mainWindow){
        PlaySound.play("MenuButton.wav");
        MainFrame.reload(mainWindow,new HistoryList(mainWindow));
    }
    public static void continueGame(JFrame mainWindow){
        PlaySound.play("MenuButton.wav");
//      ------------------------------
        if(GamesFoldersManager.lastPath()) {
            ReadData.read();
            MainFrame.reload(mainWindow, new Game(Integer.parseInt(ReadData.GameConfig.get(0)), Double.parseDouble(ReadData.GameConfig.get(1)), false, true));
        }else{
            PlaySound.play("Warning.wav");
            int newGame = JOptionPane.showConfirmDialog(mainWindow,Language.NewGameError.Get(), Language.NewGameErrorTitle.Get(),JOptionPane.CLOSED_OPTION);
            if(newGame == JOptionPane.YES_OPTION) PlaySound.play("YesClicked.wav");
        }
    }
    public static void start(JFrame mainWindow){
        PlaySound.play("MenuButton.wav");
//      ------------------------------
        GamesFoldersManager.createNew();
//      ------------------------------
        if (Menu.scale10.isSelected()) MainFrame.scale = 10;
        if (Menu.scale15.isSelected()) MainFrame.scale = 15;


        if (Menu.easy.isSelected()) MainFrame.hardship = 0.3;
        if (Menu.medium.isSelected()) MainFrame.hardship = 0.4;
        if (Menu.hard.isSelected()) MainFrame.hardship = 0.5;

        MainFrame.moreEasy = Menu.showFalseButtons.isSelected();
//      ------------------------------
        MainFrame.reload(mainWindow,new Game(MainFrame.scale, MainFrame.hardship, MainFrame.moreEasy, false));
//      ------------------------------
    }
    public static void setting(JFrame mainWindow){
        PlaySound.play("MenuButton.wav");
        MainFrame.reload(mainWindow,new Settings());
    }

}
