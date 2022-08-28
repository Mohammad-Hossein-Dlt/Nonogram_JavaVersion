package GameData.Save;

import GameData.GamesFoldersManager;

import java.io.*;
import java.util.ArrayList;

public class SaveRestOfFalsePoints {
    public SaveRestOfFalsePoints(ArrayList<Integer> point) {
        File path = GamesFoldersManager.Wrong;
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(String.valueOf(point.get(0))).append(" ").append(String.valueOf(point.get(1)));
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException ignored) {
        }
    }
}