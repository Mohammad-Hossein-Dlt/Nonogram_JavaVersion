package Menu;


import Constants.Language.Language;
import Constants.Theme.ThemeData;
import SettingsData.SettingsData;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Menu extends JPanel {
   public static JRadioButton scale10 = new JRadioButton();
   public static JRadioButton scale15 = new JRadioButton();
    public static JRadioButton easy = new JRadioButton();
    public static JRadioButton medium = new JRadioButton();
    public static JRadioButton hard = new JRadioButton();
    public static JCheckBox showFalseButtons = new JCheckBox();
    public static JButton start = new JButton();
    public static JButton settings = new JButton();
    public static JButton continueGame = new JButton();
    public static JButton gameHistory = new JButton();
    public Menu(){
        this.setBackground(ThemeData.Background.Get());
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
//      ------------------------------- Defining And Initialization JLabels, JPanels And ButtonGroups
//      Scale
        JLabel setScale = new JLabel(Language.ScaleTitle.Get());
        JPanel scalePanel = new JPanel();
        ButtonGroup scaleGroup = new ButtonGroup();
//      Hardship
        JLabel hardship = new JLabel(Language.HardshipTitle.Get());
        JPanel hardshipPanel = new JPanel();
        ButtonGroup hardshipGroup = new ButtonGroup();
//      MoreEasy
        JPanel moreEasyPanel = new JPanel();
        JLabel moreEasy = new JLabel(Language.MoreEasyTitle.Get());
//      Buttons
        JPanel buttonsPanel = new JPanel();
//      ------------------------------- Titles
//      SetScale
        setScale.setFont(new Font("",Font.BOLD,20));
        setScale.setForeground(ThemeData.Text.Get());
//      Hardship
        hardship.setFont(new Font("",Font.BOLD,20));
        hardship.setForeground(ThemeData.Text.Get());
//      MoreEasy
        moreEasy.setFont(new Font("",Font.BOLD,20));
        moreEasy.setForeground(ThemeData.Text.Get());
//      ------------------------------- Scales
//      Scale 10
        scale10.setText(Language.Scale_10x10.Get());
        scale10.setBackground(ThemeData.Background.Get());
        scale10.setForeground(ThemeData.Text.Get());
//      Scale 15
        scale15.setText(Language.Scale_15x15.Get());
        scale15.setBackground(ThemeData.Background.Get());
        scale15.setForeground(ThemeData.Text.Get());
//      Set ScalePanel Config
        scalePanel.setLayout(new BoxLayout(scalePanel,BoxLayout.X_AXIS));
        scalePanel.setBackground(ThemeData.Background.Get());
//      Add To ScalePanel
        scalePanel.add(scale10);
        scalePanel.add(scale15);
        if(SettingsData.Language.equals("En")) scalePanel.add(setScale,0);
        if(SettingsData.Language.equals("Fa")) scalePanel.add(setScale);
//      Add To ScaleGroup
        scaleGroup.add(scale10);
        scaleGroup.add(scale15);
//      ------------------------------- Hardship Config
//      Easy
        easy.setText(Language.Easy.Get());
        easy.setBackground(ThemeData.Background.Get());
        easy.setForeground(ThemeData.Text.Get());
//      Medium
        medium.setText(Language.Medium.Get());
        medium.setBackground(ThemeData.Background.Get());
        medium.setForeground(ThemeData.Text.Get());
//      Hard
        hard.setText(Language.Hard.Get());
        hard.setBackground(ThemeData.Background.Get());
        hard.setForeground(ThemeData.Text.Get());
//      HardshipPanel Config
        hardshipPanel.setLayout(new BoxLayout(hardshipPanel,BoxLayout.X_AXIS));
        hardshipPanel.setBackground(ThemeData.Background.Get());
        hardshipPanel.setBorder(LineBorder.createGrayLineBorder());
//      Add To HardshipPanel
        hardshipPanel.add(easy);
        hardshipPanel.add(medium);
        hardshipPanel.add(hard);
        if(SettingsData.Language.equals("En")) hardshipPanel.add(hardship,0);
        if(SettingsData.Language.equals("Fa")) hardshipPanel.add(hardship);
//      Add To HardshipGroup
        hardshipGroup.add(easy);
        hardshipGroup.add(medium);
        hardshipGroup.add(hard);
//      ------------------------------- More Easy Config
        showFalseButtons.setText(Language.ShowFalseButtonsTitle.Get());
        showFalseButtons.setBackground(ThemeData.Background.Get());
        showFalseButtons.setForeground(ThemeData.Text.Get());
        moreEasyPanel.setLayout(new BoxLayout(moreEasyPanel,BoxLayout.X_AXIS));
        moreEasyPanel.setBackground(ThemeData.Background.Get());
        moreEasyPanel.add(showFalseButtons);
        moreEasyPanel.add(moreEasy);
        if(SettingsData.Language.equals("En")) moreEasyPanel.add(moreEasy,0);
        if(SettingsData.Language.equals("Fa")) moreEasyPanel.add(moreEasy);
//      ------------------------------- ContinueGame,GameHistory, Start And Settings Config
//      ContinueGame
        continueGame.setText(Language.ContinueTitle.Get());
        continueGame.setBackground(ThemeData.ContinueButton.Get());
        continueGame.setForeground(ThemeData.MenuButtonForeground.Get());
        continueGame.setFont(new Font("",Font.BOLD,14));
//      GameHistory
        gameHistory.setText(Language.HistoryTitle.Get());
        gameHistory.setBackground(ThemeData.History.Get());
        gameHistory.setForeground(ThemeData.MenuButtonForeground.Get());
        gameHistory.setFont(new Font("",Font.BOLD,14));
//      Start
        start.setText(Language.StartTitle.Get());
        start.setBackground(ThemeData.Start.Get());
        start.setForeground(ThemeData.MenuButtonForeground.Get());
        start.setFont(new Font("",Font.BOLD,14));
//      Setting
        settings.setText(Language.SettingTitle.Get());
        settings.setBackground(ThemeData.Settings.Get());
        settings.setForeground(ThemeData.MenuButtonForeground.Get());
        settings.setFont(new Font("",Font.BOLD,14));
//      Add To ButtonsPanel
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.X_AXIS));
        buttonsPanel.setBackground(ThemeData.Background.Get());
        buttonsPanel.add(gameHistory);
        buttonsPanel.add(continueGame);
        buttonsPanel.add(start);
        buttonsPanel.add(settings);
//      ------------------------------- Adding To Menu Panel
        this.add(scalePanel);
        this.add(hardshipPanel);
        this.add(moreEasyPanel);
        this.add(buttonsPanel);
    }
}
