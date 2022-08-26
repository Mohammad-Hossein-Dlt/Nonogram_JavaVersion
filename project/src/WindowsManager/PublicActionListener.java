package WindowsManager;

import Menu.Menu;
import SoundEffect.PlaySound;

import javax.swing.*;

public class PublicActionListener {
    public static void menu(JFrame mainWindow){
        PlaySound.play("MenuButton.wav");
        MainWindow.reload(mainWindow, new Menu());
    }

}
