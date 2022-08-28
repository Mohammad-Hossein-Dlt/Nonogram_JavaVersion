package GameData.Save;

import java.util.ArrayList;

public class SaveData {
    public static void SaveUserClicked(ArrayList<Integer> point, boolean check) {
        new SaveUserClicked(point, check);
    }

    public static void SaveFalsePoints() {
        new SaveFalsePoints();
    }

    public static void SaveShowingFalseButtons() {
        new SaveShowingFalseButtons();
    }

    public static void SaveRestOfFalsePoints(ArrayList<Integer> point) {
        new SaveRestOfFalsePoints(point);
    }
    public static void SaveGameConfig() {
        new SaveGameConfig();
    }
}
