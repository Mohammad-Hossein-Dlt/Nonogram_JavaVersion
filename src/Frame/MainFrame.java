package Frame;


import Constants.Language.Language;
import Game.GamePad;
import History.HistoryList;
import Settings.Settings;
import SettingsData.SettingsManager;
import Menu.Menu;
import SoundEffect.BackgroundMusic;
import SoundEffect.PlaySound;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainFrame extends JFrame {
    public static int scale = 10;
    public static double hardship = 0.3;
    public static boolean moreEasy = false;
    public MainFrame(){
        this.setResizable(false);
//      ------------------------------
        SettingsManager.load();
        PlaySound.play("Beginning.wav");
        this.add(new Menu());
//      ------------------------------
//      Because The Following Game Control Button Maybe Reload The MainFrame And Take Data From Other Places,
//      The Behavior(Function) Of The Buttons Should Be Specified In Static Mode Of The Buttons
//      Because Normally We Can't Access The Information Outside The Class In Which The Buttons Are Defined And Defining The Buttons Behavior(Function)
        Menu.start.addActionListener(e -> MenuButtonsActionListener.start(this));
        Menu.settings.addActionListener(e -> MenuButtonsActionListener.setting(this));
        Menu.continueGame.addActionListener(e -> MenuButtonsActionListener.continueGame(this));
        Menu.gameHistory.addActionListener(e -> MenuButtonsActionListener.history(this));

        GamePad.restart.addActionListener(e -> GamePadButtonsActionListener.restart(this));
        GamePad.tryAgain.addActionListener(e -> GamePadButtonsActionListener.tryAgain(this));
        GamePad.menu.addActionListener(e -> GamePadButtonsActionListener.menu(this));

        HistoryList.removeAll.addActionListener(e -> HistoryButtonsActionListener.removeAll(this));
        HistoryList.back.addActionListener(e -> PublicActionListener.menu(this));

        Settings.back.addActionListener(e -> PublicActionListener.menu(this));
        Settings.save.addActionListener(e -> SettingsButtonsActionListener.saveData(this));
        Settings.musicOnOff.addActionListener(e -> SettingsButtonsActionListener.MusicSoundsControl(Settings.musicOnOff));
        Settings.soundsOnOff.addActionListener(e -> SettingsButtonsActionListener.MusicSoundsControl(Settings.soundsOnOff));

        this.pack();
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                PlaySound.play("ExitConfirm.wav");
                int exit = JOptionPane.showConfirmDialog(null , Language.ExitError.Get(),Language.ExitErrorTitle.Get(),JOptionPane.YES_NO_OPTION);
                if(exit == JOptionPane.YES_OPTION){
                    BackgroundMusic.stop();
                    PlaySound.play("Exit.wav");
                    dispose();
                }else {
                    PlaySound.play("CancelExit.wav");
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }
    public static void reload(JFrame frame, JPanel panel){
//      Following Methods Is Not Static And We Can't Use Them Without Instantiation Of MainFrame
//      So We Have To Pass The MainFrame To reload As Function Input 'frame'
        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.getContentPane().validate();
    }
}
