package SoundEffect;

import GameData.Read.ReadData;
import SettingsData.SettingsData;

import javax.sound.sampled.*;
import java.net.URL;

public class BackgroundMusic {
    private static final URL path = BackgroundMusic.class.getClassLoader().getResource("audio/"+"Background.wav");
    private static Clip clip;
    static {
        try {
            clip = AudioSystem.getClip();
        } catch(Exception ignored){}
    }
    public static void play(boolean continueGame) {
//        The Order Of Conditions Is Essential
//        Because When Start Button Clicked No Data Is Read And ReadData.GameConfig.get(3) Gives Error
//        But When It Placed After || Only continueGame Is Checked
        if (SettingsData.Music.equals("On") && ( !continueGame || ReadData.GameConfig.get(3).equals("Unfinished") ) ) {
            try {
                assert path != null;
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(path);
                if (!clip.isRunning() || !clip.isActive() || !clip.isOpen()) {
                    clip.flush();
                    clip.open(inputStream);
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                    FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    control.setValue(0.1f);
                    clip.start();
                }
            } catch (Exception ignored) {}
        }
    }
    public static void stop(){
        clip.close();
    }
}
