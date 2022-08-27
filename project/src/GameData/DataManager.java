package GameData;

import java.io.*;
import static GameData.PathManager.*;

public class DataManager {
    public static void StartNewGame(){
        PathManager.createNew();
    }
    public static boolean ContinueGame(){
        return PathManager.lastPath();
    }
    public static void restart(){
        GameConfig.delete();
        FalsePoints.delete();
        ShowingFalseButtons.delete();
        WrongClicked.delete();
        CorrectClicked.delete();
        try {
            GameConfig.createNewFile();
            FalsePoints.createNewFile();
            ShowingFalseButtons.createNewFile();
            WrongClicked.createNewFile();
            CorrectClicked.createNewFile();
        } catch (IOException ignored){}
    }
    public static void tryAgain(){
        WrongClicked.delete();
        CorrectClicked.delete();
        try {
            WrongClicked.createNewFile();
            CorrectClicked.createNewFile();
        } catch (IOException ignored){}
    }
    public static void removeData(File folder){
//      First All Files Inside The Folder Are Deleted
        for(File file: folder.listFiles()) file.delete();
//      Then The Folder Is Deleted
        folder.delete();
//      Then The Folder Will Be Removed From folderList
        folderList.remove(folder);
    }
    public static void removeAllData(){
        for(File folder: GameDataFolder.listFiles())
            removeData(folder);
    }
}
