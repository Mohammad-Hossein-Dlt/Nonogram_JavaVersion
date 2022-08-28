package GameData.Save;

import GameCore.GameCore;
import GameData.GamesFoldersManager;

import java.io.*;
import java.nio.file.Files;

public class SaveFalsePoints {
    public SaveFalsePoints() {
        File path = GamesFoldersManager.FalsePoints;
        try {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(path.toPath()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

            GameCore.falsepoints.forEach(e -> {
                try {
                    writer.write(e.get(0) + " " + e.get(1));
                    writer.newLine();
                } catch (IOException ignored) {}
            });
            writer.flush();
            writer.close();
        } catch (IOException ignored) {}
    }
}
