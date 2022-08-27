package Frame;

import Menu.Menu;
import SoundEffect.PlaySound;

import javax.swing.*;

public class PublicActionListener {
    public static void menu(JFrame mainWindow){
        PlaySound.play("MenuButton.wav");
        MainFrame.reload(mainWindow, new Menu());
    }

}
