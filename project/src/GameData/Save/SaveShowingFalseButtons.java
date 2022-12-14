package GameData.Save;

import GameData.GamesFoldersManager;

import java.io.*;
import java.nio.file.Files;

import static GameCore.ShowingSomeFalseRandomButtons.FalseRandomPointsList;

public class SaveShowingFalseButtons {
    public SaveShowingFalseButtons() {
        File path = GamesFoldersManager.ShowingFalseButtons;
        try {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(path.toPath()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

            FalseRandomPointsList.forEach(e -> {
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