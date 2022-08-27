package Constants.Language;

import Constants.Language.En.En;
import Constants.Language.Fa.Fa;
import SettingsData.SettingsData;

public class Language {
//  -------------------------------------- Public
    public static LanguageManager Back = () -> get_(En.Back,Fa.Back);
//  -------------------------------------- Menu
    public static LanguageManager ScaleTitle = () -> get_(En.ScaleTitle,Fa.ScaleTitle);
    public static LanguageManager Scale_10x10 = () -> get_(En.Scale_10x10,Fa.Scale_10x10);
    public static LanguageManager Scale_15x15 = () -> get_(En.Scale_15x15,Fa.Scale_15x15);
    public static LanguageManager HardshipTitle = () -> get_(En.HardshipTitle,Fa.HardshipTitle);
    public static LanguageManager Easy = () -> get_(En.Easy,Fa.Easy);
    public static LanguageManager Medium = () -> get_(En.Medium,Fa.Medium);
    public static LanguageManager Hard = () -> get_(En.Hard,Fa.Hard);
    public static LanguageManager MoreEasyTitle = () -> get_(En.MoreEasyTitle,Fa.MoreEasyTitle);
    public static LanguageManager ShowFalseButtonsTitle = () -> get_(En.ShowFalseButtonsTitle,Fa.ShowFalseButtonsTitle);
    public static LanguageManager HistoryTitle = () -> get_(En.HistoryTitle,Fa.HistoryTitle);
    public static LanguageManager ContinueTitle = () -> get_(En.ContinueTitle,Fa.ContinueTitle);
    public static LanguageManager StartTitle =  () -> get_(En.StartTitle,Fa.StartTitle);
    public static LanguageManager SettingTitle =  () -> get_(En.SettingTitle,Fa.SettingTitle);
//  -------------------------------------- History
    public static LanguageManager View = () -> get_(En.View,Fa.View) ;
    public static LanguageManager Remove = () -> get_(En.Remove,Fa.Remove) ;
    public static LanguageManager RemoveAll = () -> get_(En.RemoveAll,Fa.RemoveAll) ;
    public static LanguageManager  Win = () -> get_(En.Win,Fa.Win) ;
    public static LanguageManager  Lose = () -> get_(En.Lose,Fa.Lose) ;
    public static LanguageManager  Unfinished = () -> get_(En.Unfinished,Fa.Unfinished) ;
//  -------------------------------------- Settings
    public static LanguageManager NumberOfChancesTitle = () -> get_(En.NumberOfChancesTitle,Fa.NumberOfChancesTitle);
    public static LanguageManager ThemeTitle = () -> get_(En.ThemeTitle,Fa.ThemeTitle);
    public static LanguageManager Light = () -> get_(En.Light,Fa.Light);
    public static LanguageManager Dark = () -> get_(En.Dark,Fa.Dark);
    public static LanguageManager LanguageTitle = () -> get_(En.LanguageTitle,Fa.LanguageTitle);
    public static LanguageManager English = () -> get_(En.English,Fa.English);
    public static LanguageManager Persian = () -> get_(En.Persian,Fa.Persian);
    public static LanguageManager Music = () -> get_(En.Music,Fa.Music);
    public static LanguageManager Sounds = () -> get_(En.Sounds,Fa.Sounds);
    public static LanguageManager Save = () -> get_(En.Save,Fa.Save);
//  -------------------------------------- Game
    public static LanguageManager Restart = () -> get_(En.Restart,Fa.Restart);
    public static LanguageManager TryAgain = () -> get_(En.TryAgain,Fa.TryAgain);
    public static LanguageManager Menu = () -> get_(En.Menu,Fa.Menu);
    public static LanguageManager ChanceText = () -> get_(En.ChanceText,Fa.ChanceText);
    public static LanguageManager NoMoreChanceText =  () -> get_(En.NoMoreChanceText,Fa.NoMoreChanceText);
    public static LanguageManager WinGame = () -> get_(En.WinGame,Fa.WinGame);
    public static LanguageManager LoseGame = () -> get_(En.LoseGame,Fa.LoseGame);
//  -------------------------------------- Errors
    public static LanguageManager ExitErrorTitle = () -> get_(En.ExitTitle,Fa.ExitTitle);;
    public static LanguageManager ExitError = () -> get_(En.ExitError,Fa.ExitError);


    public static LanguageManager NewGameErrorTitle = () -> get_(En.NewGameTitle,Fa.NewGameTitle);
    public static LanguageManager NewGameError = () -> get_(En.NewGameError,Fa.NewGameError);

    public static LanguageManager RemoveErrorTitle = () -> get_(En.RemoveTitle,Fa.RemoveTitle);
    public static LanguageManager RemoveError = () -> get_(En.RemoveError,Fa.RemoveError);

    public static LanguageManager RemoveAllErrorTitle = () -> get_(En.RemoveAllTitle,Fa.RemoveAllTitle);
    public static LanguageManager RemoveAllError = () -> get_(En.RemoveAllError,Fa.RemoveAllError);
    public static String get_(String En, String Fa){
        return SettingsData.Language.equals("En") ? En : Fa;
    }
}
