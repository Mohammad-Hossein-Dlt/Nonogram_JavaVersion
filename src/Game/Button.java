package Game;


import Config.ShowingSomeFalseRandomButtons;
import Config.config;
import Constants.Theme.ThemeData;
import GameData.Read.ReadData;
import GameData.Save.SaveData;
import SoundEffect.PlaySound;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Button extends JButton {
    private static final HashMap<ArrayList<Integer>, JButton> buttons = new HashMap<>();
    int column;
    int row;
    ArrayList<Integer> point = new ArrayList<>();

    public Button(int c, int r, boolean  continueGame) {
        this.column = c;
        this.row = r;
        point.add(c);
        point.add(r);
        buttons.put(point, this);
        this.setBackground(ThemeData.ButtonColor.Get());
        this.addActionListener(e -> click());
        this.setMinimumSize(new Dimension(40, 40));
        this.setPreferredSize(new Dimension(40, 40));
        this.setMaximumSize(new Dimension(40, 40));
        if(continueGame) {
            if (Integer.parseInt(ReadData.GameConfig.get(2)) < 0) {
                this.setEnabled(false);
                this.setBackground(ThemeData.DisableButtonColor.Get());
            }
            if ( (ReadData.ShowingFalsePoints.contains(point) || ReadData.WrongClicked.contains(point)) ) {
                this.setEnabled(false);
                this.setBackground(ThemeData.FalseButtonColor.Get());
            }
            if (ReadData.CorrectClicked.contains(point)) {
                this.setEnabled(false);
                this.setBackground(ThemeData.TrueButtonColor.Get());
                config.columns.get("C" + this.column).remove(point);
                config.rows.get("R" + this.row).remove(point);
                config.truepoints.remove(point);
            }
        } else {
            if( ShowingSomeFalseRandomButtons.FalseRandomPointsList.contains(point) ){
                this.setEnabled(false);
                this.setBackground(ThemeData.FalseButtonColor.Get());
            }
        }
    }

    public void click() {
        GamePad.restart.setEnabled(false);
        GamePad.tryAgain.setEnabled(true);
        this.setEnabled(false);
        boolean check = config.allpoint_.get(point);
        SaveData.SaveUserClicked(point, check);
        if (check) {
            PlaySound.play("CorrectButton.wav");
            this.setBackground(ThemeData.TrueButtonColor.Get());
            config.columns.get("C" + this.column).remove(point);
            config.rows.get("R" + this.row).remove(point);
            config.truepoints.remove(point);
            Status.correct();
        } else {
            PlaySound.play("FalseButton.wav");
            this.setBackground(ThemeData.FalseButtonColor.Get());
            Status.wrong();
            if(Status.isFinished()){
                PlaySound.play("Lose.wav");
                buttons.values().forEach(button -> {
                    if (button.isEnabled()) {
                        button.setEnabled(false);
                        button.setBackground(ThemeData.DisableButtonColor.Get());
                    }
                });
            }
        }
        SaveData.SaveGameConfig();
        if (!config.columns.get("C" + this.column).containsValue(true)) {
            PlaySound.play("Complete.wav");
            for (ArrayList<Integer> point : config.columns.get("C" + this.column).keySet()) {
                buttons.get(point).setBackground(ThemeData.FalseButtonColor.Get());
                buttons.get(point).setEnabled(false);
                SaveData.SaveRestOfFalsePoints(point);
            }
        }
        if (!config.rows.get("R" + this.row).containsValue(true)) {
            PlaySound.play("Complete.wav");
            for (ArrayList<Integer> point : config.rows.get("R" + this.row).keySet()) {
                buttons.get(point).setBackground(ThemeData.FalseButtonColor.Get());
                buttons.get(point).setEnabled(false);
                SaveData.SaveRestOfFalsePoints(point);
            }
        }
    }
}
