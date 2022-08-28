package Game;
import GameCore.ShowingSomeFalseRandomButtons;
import GameCore.GameCore;
import GameData.Save.SaveData;
import SoundEffect.BackgroundMusic;

import javax.swing.*;
import java.awt.*;


public class Game extends JPanel {
    public Game(int scale, double hardship, boolean moreEasy, boolean continueGame){
        this.setLayout(new GridBagLayout());
//      -------------------------------
        GameCore.create(scale, hardship, continueGame);
        if(!continueGame) ShowingSomeFalseRandomButtons.randomGathering(moreEasy);
//      -------------------------------
        BackgroundMusic.play(continueGame);
//      -------------------------------
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
//      -------------------------------
        gbc.weightx = 4;
        gbc.weighty = 4;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(new GamePad(scale, continueGame), gbc);
//      -------------------------------
        gbc.weightx = 4;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(new Status(continueGame), gbc);
//      -------------------------------
        if(!continueGame) {
            SaveData.SaveFalsePoints();
            SaveData.SaveShowingFalseButtons();
            SaveData.SaveGameConfig();
        }
    }
}
