package GameData.Save;

import Config.config;
import Game.Status;
import GameData.GamesFoldersManager;

import java.io.*;
import java.nio.file.Files;

public class SaveGameConfig {
    public SaveGameConfig() {
        File path = GamesFoldersManager.GameConfig;
        try {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(path.toPath()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            writer.write("Scale: "+config.gamescale);
            writer.newLine();
            writer.write("HardShip: "+config.hardshipFactor);
            writer.newLine();
            writer.write("Chances: "+ Status.mistakeNumber);
            writer.newLine();
            if(config.truepoints.size() == 0) writer.write("Result: Win");
            else if(Status.mistakeNumber < 0) writer.write("Result: Lose");
            else writer.write("Result: Unfinished");
            writer.newLine();

            writer.flush();
            writer.close();
        } catch (IOException ignored) {}
    }
}
