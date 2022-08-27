package Settings;

import Constants.Language.Language;
import Constants.Theme.ThemeData;
import SettingsData.SettingsData;

import javax.swing.*;
import java.awt.*;

public class Settings extends JPanel {
    public static JSpinner number = new JSpinner(new SpinnerNumberModel(Integer.parseInt(SettingsData.NumberOfChances),0,10,1));
    public static JRadioButton light = new JRadioButton();
    public static JRadioButton dark = new JRadioButton();
    public static JRadioButton english = new JRadioButton();
    public static JRadioButton persian = new JRadioButton();
    public static JButton musicOnOff = new JButton();
    public static JButton soundsOnOff = new JButton();
    public static JButton save = new JButton();
    public static JButton back = new JButton();

    public Settings(){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(ThemeData.Background.Get());
//      ------------------------------- Defining And Initialization JLabels, JPanels And ButtonGroups
//      SetChances
        JPanel setChancesPanel = new JPanel();
        JLabel setChancesTitle = new JLabel(Language.NumberOfChancesTitle.Get());
//      Theme
        JPanel themePanel = new JPanel();
        JLabel theme = new JLabel(Language.ThemeTitle.Get());
        ButtonGroup themeGroup = new ButtonGroup();
//      Language
        JPanel languagePanel = new JPanel();
        JLabel language = new JLabel(Language.LanguageTitle.Get());
        ButtonGroup languageGroup = new ButtonGroup();
//      Music
        JPanel musicPanel = new JPanel();
        JLabel music = new JLabel();
//      Sounds
        JPanel soundsPanel = new JPanel();
        JLabel sounds = new JLabel();
//      Buttons
        JPanel buttonsPanel = new JPanel();
//      ------------------------------- Number Of Chances Setting
        setChancesTitle.setForeground(ThemeData.Text.Get());
//      Number
        number.setMaximumSize(new Dimension(35,50));
        number.setPreferredSize(new Dimension(35,50));
//      SetChancesPanel Config
        setChancesPanel.setLayout(new BoxLayout(setChancesPanel,BoxLayout.X_AXIS));
        setChancesPanel.setBackground(ThemeData.Background.Get());
//      Add To SetChancesPanel
        setChancesPanel.add(number);
        if(SettingsData.Language.equals("En")) setChancesPanel.add(setChancesTitle,0);
        if(SettingsData.Language.equals("Fa")) setChancesPanel.add(setChancesTitle);
//      ------------------------------- Theme Setting
        theme.setForeground(ThemeData.Text.Get());
//      Light Config
        light.setBackground(ThemeData.Background.Get());
        light.setForeground(ThemeData.Text.Get());
        light.setText(Language.Light.Get());
//      Dark Config
        dark.setBackground(ThemeData.Background.Get());
        dark.setForeground(ThemeData.Text.Get());
        dark.setText(Language.Dark.Get());
//      ThemePanel Config
        themePanel.setLayout(new BoxLayout(themePanel,BoxLayout.X_AXIS));
        themePanel.setBackground(ThemeData.Background.Get());
//      Add To ThemePanel
        themePanel.add(light);
        themePanel.add(dark);
        if(SettingsData.Language.equals("En")) themePanel.add(theme,0);
        if(SettingsData.Language.equals("Fa")) themePanel.add(theme);
        if(SettingsData.Theme.equals("Light")) light.setSelected(true);
        if(SettingsData.Theme.equals("Dark")) dark.setSelected(true);
//      Add To ThemeGroup
        themeGroup.add(light);
        themeGroup.add(dark);
//      ------------------------------- Language Setting
        language.setForeground(ThemeData.Text.Get());
//      English Config
        english.setBackground(ThemeData.Background.Get());
        english.setForeground(ThemeData.Text.Get());
        english.setText(Language.English.Get());
//      Persian Config
        persian.setBackground(ThemeData.Background.Get());
        persian.setForeground(ThemeData.Text.Get());
        persian.setText(Language.Persian.Get());
//      LanguagePanel Config
        languagePanel.setLayout(new BoxLayout(languagePanel,BoxLayout.X_AXIS));
        languagePanel.setBackground(ThemeData.Background.Get());
//      Add To LanguagePanel
        languagePanel.add(english);
        languagePanel.add(persian);
        if(SettingsData.Language.equals("En")) languagePanel.add(language,0);
        if(SettingsData.Language.equals("Fa")) languagePanel.add(language);
        if (SettingsData.Language.equals("En")) english.setSelected(true);
        if (SettingsData.Language.equals("Fa")) persian.setSelected(true);
//      Add To LanguageGroup
        languageGroup.add(english);
        languageGroup.add(persian);
//      ------------------------------- Music/Sounds On/Off
//      Music Config
        music.setBackground(ThemeData.Background.Get());
        music.setForeground(ThemeData.Text.Get());
        music.setText(Language.Music.Get());
        musicOnOff.setBackground(ThemeData.Background.Get());
        musicOnOff.setForeground(ThemeData.Text.Get());
        musicOnOff.setText(SettingsData.Music);
        musicPanel.setBackground(ThemeData.Background.Get());
        musicPanel.add(musicOnOff);
        if(SettingsData.Language.equals("En")) musicPanel.add(music,0);
        if(SettingsData.Language.equals("Fa")) musicPanel.add(music);
//      Sounds Config
        sounds.setBackground(ThemeData.Background.Get());
        sounds.setForeground(ThemeData.Text.Get());
        sounds.setText(Language.Sounds.Get());
        soundsOnOff.setBackground(ThemeData.Background.Get());
        soundsOnOff.setForeground(ThemeData.Text.Get());
        soundsOnOff.setText(SettingsData.Sounds);
        soundsPanel.setBackground(ThemeData.Background.Get());
        soundsPanel.add(soundsOnOff);
        if(SettingsData.Language.equals("En")) soundsPanel.add(sounds,0);
        if(SettingsData.Language.equals("Fa")) soundsPanel.add(sounds);
//      ------------------------------- Save And Back Buttons
//      Back Config
        back.setText(Language.Back.Get());
        back.setBackground(ThemeData.Back.Get());
        back.setForeground(Color.white);
        back.setFont(new Font("",Font.BOLD,14));
//      Save Config
        save.setText(Language.Save.Get());
        save.setBackground(ThemeData.Save.Get());
        save.setFont(new Font("",Font.BOLD,14));
//      Add To ButtonsPanel
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.X_AXIS));
        buttonsPanel.setBackground(ThemeData.Background.Get());
        buttonsPanel.add(save);
        buttonsPanel.add(back);
//      ------------------------------- Adding to Settings Panel
        this.add(setChancesPanel);
        this.add(themePanel);
        this.add(languagePanel);
        this.add(musicPanel);
        this.add(soundsPanel);
        this.add(buttonsPanel);
    }

}
