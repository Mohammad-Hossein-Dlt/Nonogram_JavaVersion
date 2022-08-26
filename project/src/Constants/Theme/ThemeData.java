package Constants.Theme;

import Constants.Theme.Dark.DarkTheme;
import Constants.Theme.Light.LightTheme;
import SettingsData.SettingsData;

import java.awt.*;
public class ThemeData {
//  -------------------------------------- Public
    public static ThemeManager Background = () -> getColor(LightTheme.background,DarkTheme.background);
    public static ThemeManager Text = () -> getColor(LightTheme.text,DarkTheme.text);
    public static ThemeManager MenuButtonForeground = () -> getColor(LightTheme.menuButtonForeground,DarkTheme.menuButtonForeground);
    public static ThemeManager Back = () -> getColor(LightTheme.back,DarkTheme.back);
//  -------------------------------------- Menu
    public static ThemeManager History =() -> getColor(LightTheme.history,DarkTheme.history);
    public static ThemeManager ContinueButton =() -> getColor(LightTheme.continueButton,DarkTheme.continueButton);
    public static ThemeManager Start =() -> getColor(LightTheme.start,DarkTheme.start);
    public static ThemeManager Settings =() -> getColor(LightTheme.settings,DarkTheme.settings);
//  -------------------------------------- History
    public static ThemeManager Remove = () -> getColor(LightTheme.remove,DarkTheme.remove);
    public static  ThemeManager Win = () -> getColor(LightTheme.win,DarkTheme.win);
    public static  ThemeManager Lose = () -> getColor(LightTheme.lose,DarkTheme.lose);
    public static  ThemeManager Unfinished = () -> getColor(LightTheme.unfinished,DarkTheme.unfinished);
//  -------------------------------------- Settings
    public static ThemeManager Save = () -> getColor(LightTheme.save,DarkTheme.save);
//  -------------------------------------- Game
    public static ThemeManager Control = () -> getColor(LightTheme.controls,DarkTheme.controls);
    public static ThemeManager Restart = () -> getColor(LightTheme.restart,DarkTheme.restart);
    public static ThemeManager TryAgain = () -> getColor(LightTheme.tryAgain,DarkTheme.tryAgain);
    public static ThemeManager ButtonColor =() -> getColor(LightTheme.buttonColor,DarkTheme.buttonColor);
    public static ThemeManager Labels = () -> getColor(LightTheme.Labels,DarkTheme.Labels);

    public static ThemeManager ColumnColor = () -> getColor(LightTheme.columnColor,DarkTheme.columnColor);
    public static ThemeManager RowColor = () -> getColor(LightTheme.rowColor,DarkTheme.rowColor);

    public static  ThemeManager FalseButtonColor = () -> getColor(LightTheme.falseButtonColor,DarkTheme.falseButtonColor);
    public static ThemeManager TrueButtonColor = () -> getColor(LightTheme.trueButtonColor,DarkTheme.trueButtonColor);
    public static ThemeManager DisableButtonColor = () -> getColor(LightTheme.disableButtonColor,DarkTheme.disableButtonColor);

    public static  ThemeManager ChancePanelColor = () -> getColor(LightTheme.ChancePanelColor,DarkTheme.ChancePanelColor);
    public static  ThemeManager ResultPanelColor = () -> getColor(LightTheme.resultPanelColor,DarkTheme.resultPanelColor);

public static Color getColor(Color Light, Color Dark){
    return SettingsData.Theme.equals("Light") ? Light : Dark;
}
}
