package Frame;

import Constants.Language.Language;
import GameData.GamesFoldersManager;
import History.HistoryList;
import SoundEffect.PlaySound;

import javax.swing.*;

public class HistoryButtonsActionListener {
    public static void removeAll(JFrame mainWindow){
        PlaySound.play("Warning.wav");
        int removeCheck = JOptionPane.showConfirmDialog(mainWindow, Language.RemoveAllError.Get() ,Language.RemoveAllErrorTitle.Get(),JOptionPane.YES_NO_OPTION);
        if(removeCheck == JOptionPane.YES_OPTION) {
            PlaySound.play("YesClicked.wav");
            GamesFoldersManager.removeAllGamesData();
            MainFrame.reload(mainWindow, new HistoryList(mainWindow));
        }else PlaySound.play("Cancel.wav");
    }
}
