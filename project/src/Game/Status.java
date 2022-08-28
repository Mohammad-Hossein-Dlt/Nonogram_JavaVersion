package Game;

import javax.swing.*;
import java.awt.*;

import GameCore.GameCore;
import Constants.Language.Language;
import Constants.Theme.ThemeData;

import GameData.Read.ReadData;
import SettingsData.SettingsData;
import SoundEffect.BackgroundMusic;
import SoundEffect.PlaySound;

public class Status extends JPanel {
    public static int mistakeNumber;
    private static JLabel resultLabel;
    private static JLabel chancesLabel;
    public Status(boolean continueGame){
        this.setLayout(new GridBagLayout());
//      ------------------------------- Defining Panels
        JPanel chancesPanel = new JPanel();
        JPanel resultPanel = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
//      -------------------------------
        mistakeNumber = continueGame ? Integer.parseInt(ReadData.GameConfig.get(2)) : Integer.parseInt(SettingsData.NumberOfChances);
        chancesLabel = new JLabel( mistakeNumber >= 0 ? Language.ChanceText.Get() : Language.NoMoreChanceText.Get());
        resultLabel = new JLabel(mistakeNumber >= 0 ? (continueGame && GameCore.truepoints.isEmpty() ?  Language.WinGame.Get() : "Programed By Mh_Dlt" ) : Language.LoseGame.Get());
//      ------------------------------- Chances
//      ChancesLabel Config
        chancesLabel.setForeground(ThemeData.Text.Get());
        chancesLabel.setHorizontalAlignment(SwingConstants.LEFT);
        chancesLabel.setFont(new Font("",Font.BOLD,18));
        if(mistakeNumber != 0) {
            for (int i = 0; i < mistakeNumber; i++) chancesLabel.setText(chancesLabel.getText() + " " + "💣" + " ");
        }else chancesLabel.setText(Language.NoMoreChanceText.Get());
//      Add To ChancesPanel
        chancesPanel.setBackground(ThemeData.ChancePanelColor.Get());
        chancesPanel.add(chancesLabel);
//      ------------------------------- Result
//      ResultLabel Config
        resultLabel.setForeground(ThemeData.Text.Get());
        resultLabel.setFont(new Font("",Font.BOLD,18));
//      Add to ResultPanel
        resultPanel.setBackground(ThemeData.ResultPanelColor.Get());
        resultPanel.add(resultLabel);
//      -------------------------------
        gbc.fill = GridBagConstraints.BOTH;
//      -------------------------------
        gbc.weightx = 3;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(chancesPanel,gbc);
//      -------------------------------
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(resultPanel,gbc);
    }
    public static void correct(){
        if (GameCore.truepoints.size() == 0) {
            BackgroundMusic.stop();
            PlaySound.play("Win.wav");
            Status.resultLabel.setText(Language.WinGame.Get());
        }
    }
    public static void wrong(){
        if (mistakeNumber >= 0) {
            mistakeNumber--;
            if (mistakeNumber > 0) {
                chancesLabel.setText(Language.ChanceText.Get());
                for (int i = 0; i < Status.mistakeNumber; i++) chancesLabel.setText(chancesLabel.getText() + " " + "💣" + " ");
            } else if (mistakeNumber == 0) chancesLabel.setText(Language.NoMoreChanceText.Get());
        }
        if (Status.mistakeNumber == -1) {
            BackgroundMusic.stop();
            Status.resultLabel.setText(Language.LoseGame.Get());
        }
    }
    public static boolean isFinished(){
        return mistakeNumber == -1;
    }
}
