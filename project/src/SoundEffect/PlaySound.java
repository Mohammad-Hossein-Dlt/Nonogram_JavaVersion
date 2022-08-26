package SoundEffect;
import SettingsData.SettingsData;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PlaySound {
    private static final ArrayList<String> music = new ArrayList<>(List.of(new String[]{"Beginning.wav", "ExitConfirm.wav", "Exit.wav", "CancelExit.wav", "Win.wav", "Lose.wav", "Restart.wav"}));
    private static final ArrayList<String> sounds = new ArrayList<>(List.of(new String[]{"CorrectButton.wav", "FalseButton.wav", "Complete.wav", "MenuButton.wav", "Warning.wav", "YesClicked.wav", "Cancel.wav"}));
    public static void play(String name) {
        if ( ( music.contains(name) && SettingsData.Music.equals("On") ) || ( sounds.contains(name) && SettingsData.Sounds.equals("On") )
        ) {
            try {
                URL path = PlaySound.class.getClassLoader().getResource("audio/" + name);
                assert path != null;
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(path);
                Clip c = AudioSystem.getClip();
                c.open(inputStream);
                c.start();
            } catch (Exception ignored) {}
        }
    }
}
