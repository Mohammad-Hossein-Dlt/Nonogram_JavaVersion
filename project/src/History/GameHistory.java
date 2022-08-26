package History;

import Constants.Language.Language;
import Constants.Theme.ThemeData;
import Game.Game;
import GameData.DataManager;
import GameData.PathManager;
import GameData.Reed.ReedData;
import SoundEffect.PlaySound;
import WindowsManager.MainWindow;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;

public class GameHistory extends JPanel {
    JLabel name = new JLabel();
    JLabel result = new JLabel();
    JButton loadGame = new JButton();
    JButton remove = new JButton();
    public GameHistory(JFrame mainWindow,File folder, String gameResult){
        String gameName = folder.getName();
        this.setLayout(new GridBagLayout());
        this.setMaximumSize(new Dimension(450,50));
        this.setPreferredSize(new Dimension(450,50));
        this.setBackground(ThemeData.Background.Get());
        this.setBorder(LineBorder.createGrayLineBorder());
//      ------------------------------ Defining Panels Variables
        JPanel info = new JPanel();
        JPanel btns = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
//      ------------------------------ Name(JLabel), Result(JLabel) And Info(JPanel) Config And Add Name And Result To Info
//      Name
        name.setText(gameName);
        name.setForeground(ThemeData.Text.Get());
        name.setFont(new Font("",Font.BOLD,16));
//      Result
        result.setOpaque(true);
        result.setBackground(ThemeData.Background.Get());
        result.setFont(new Font("",Font.BOLD,14));
        if(gameResult.equals("Unfinished")){
            result.setText(Language.Unfinished.Get());
            result.setForeground(ThemeData.Unfinished.Get());
        }
        if(gameResult.equals("Lose")){
            result.setText(Language.Lose.Get());
            result.setForeground(ThemeData.Lose.Get());
        }
        if(gameResult.equals("Win")){
            result.setText(Language.Win.Get());
            result.setForeground(ThemeData.Win.Get());
        }
//      Info Config
        info.setLayout(new BoxLayout(info,BoxLayout.Y_AXIS));
        info.setBackground(ThemeData.Background.Get());
        info.setMinimumSize(new Dimension(120,40));
        info.setPreferredSize(new Dimension(120,40));
//      Add To Info
        info.add(name);
        info.add(result);
//      ------------------------------ continueGame(JButton), remove(JButton) And btns(JPanel) Config And Add continueGame And remove To btns
//      continueGame
        if(gameResult.equals("Lose") || gameResult.equals("Win")) loadGame.setText(Language.View.Get());
        else loadGame.setText(Language.ContinueTitle.Get());
        loadGame.addActionListener(e -> loadGame(mainWindow,folder));
        loadGame.setBackground(ThemeData.ContinueButton.Get());
        loadGame.setFont(new Font("",Font.BOLD,14));
//      Remove
        remove.setText(Language.Remove.Get());
        remove.addActionListener(e -> remove(mainWindow, folder));
        remove.setBackground(ThemeData.Remove.Get());
        remove.setFont(new Font("",Font.BOLD,14));
//      BtnPanel Config
        btns.setBackground(ThemeData.Background.Get());
        btns.setMinimumSize(new Dimension(200,40));
        btns.setPreferredSize(new Dimension(200,40));
//      Add To BtnPanel
        btns.add(loadGame);
        btns.add(remove);
//      ------------------------------ Add info And btns To GameHistory
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,20,0,50);
        this.add(info,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,20,0,50);
        this.add(btns,gbc);
    }
    public void loadGame(JFrame mainWindow,File folder){
        PlaySound.play("MenuButton.wav");
        PathManager.load(folder);
        ReedData.Reed();
        MainWindow.reload(mainWindow, new Game(Integer.parseInt(ReedData.GameConfig.get(0)), Double.parseDouble(ReedData.GameConfig.get(1)), false, true));
    }
    public void remove(JFrame mainWindow,File folder){
        PlaySound.play("Warning.wav");
        int removeCheck = JOptionPane.showConfirmDialog(this,Language.RemoveError.Get().replace("X", folder.getName()),Language.RemoveErrorTitle.Get().replace("X",folder.getName()),JOptionPane.YES_NO_OPTION);
        if(removeCheck == JOptionPane.YES_OPTION) {
            PlaySound.play("YesClicked.wav");
            DataManager.removeData(folder);
            MainWindow.reload(mainWindow, new HistoryList(mainWindow));
        }else PlaySound.play("Cancel.wav");
    }
}
