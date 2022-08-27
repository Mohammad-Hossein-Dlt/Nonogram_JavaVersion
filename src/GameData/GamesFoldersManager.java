package GameData;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class GamesFoldersManager {
    private static final String prefix = "/Game ";
    public static final File GamesDataFolder = new File("GameData") ;
    public static File GameFolder;
    public static File GameConfig;
    public static File FalsePoints;
    public static File ShowingFalseButtons;
    public static File Wrong;
    public static File Correct;
    public static ArrayList<File> folderList = (Files.exists(GamesDataFolder.toPath()) && GamesDataFolder.list().length != 0 )? sortFolders() : new ArrayList<>();// A List To Sort Folders By Name
//  Create And load Methods
    public static void createNew(){
//      Create New GameData
        if (Files.notExists(GamesDataFolder.toPath())) {
            GamesDataFolder.mkdirs();
        }
        if(GamesDataFolder.listFiles().length == 0 ) {
            GameFolder = new File(GamesDataFolder.getPath() + prefix + 1);
        }
        if (GamesDataFolder.listFiles().length > 0) {
                GameFolder = new File(GamesDataFolder.getPath()+prefix+( Integer.parseInt(folderList.get(folderList.size()-1).getName().split(" ")[1]) + 1 ));
        }
        if(GamesFoldersManager.load(GameFolder)) {
            try {
                GameFolder.mkdirs();
                GameConfig.createNewFile();
                FalsePoints.createNewFile();
                ShowingFalseButtons.createNewFile();
                Wrong.createNewFile();
                Correct.createNewFile();
            } catch (IOException ignored) {
            }
            folderList.add(GameFolder);
        }
    }
    public static boolean lastPath() {
        if(( GameFolder == null) || isFinished(GameFolder) ) GameFolder = lastUnfinished();
        GamesFoldersManager.load(GameFolder);
        return GameFolder != null;
    }
    public static boolean load(File folder){
        if(folder != null) {
            GameFolder = folder;
            GameConfig = new File(GameFolder.getPath() + "/GameConfig.txt");
            FalsePoints = new File(GameFolder.getPath() + "/FalsePoints.txt");
            ShowingFalseButtons = new File(GameFolder.getPath() + "/ShowingFalseButtons.txt");
            Wrong = new File(GameFolder.getPath() + "/WrongClicked.txt");
            Correct = new File(GameFolder.getPath() + "/CorrectClicked.txt");
        }
        return GameFolder != null;
    }
    private static File lastUnfinished(){
        File lastUnfinished = null;
        for (File folder : folderList)
            if (!isFinished(folder)) lastUnfinished = folder;
        return lastUnfinished;
    }
    private static boolean isFinished(File folder){
        boolean finished;
        String result = "";
        try {
            InputStream input = new BufferedInputStream(Files.newInputStream(new File(folder.getPath() + "/GameConfig.txt").toPath()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String temp;
            while ((temp = reader.readLine()) != null) result = temp;
        } catch (IOException ignored) {}
        finished = !result.equals("Result: Unfinished");
        return finished;
    }
// Sorting Method
    private static ArrayList<File> sortFolders(){
        ArrayList<Integer> indexList = new ArrayList<>();
        for (String dirName : GamesDataFolder.list()) indexList.add(Integer.parseInt(dirName.split(" ")[1]));
        Collections.sort(indexList);
        ArrayList<File> list = new ArrayList<>();
        for (int index: indexList) list.add(new File(GamesDataFolder.getPath()+prefix+index));
        return list;
    }
//  Restart And Try-again Methods
    public static void restart() {
        GameConfig.delete();
        FalsePoints.delete();
        ShowingFalseButtons.delete();
        Wrong.delete();
        Correct.delete();
        try {
            GameConfig.createNewFile();
            FalsePoints.createNewFile();
            ShowingFalseButtons.createNewFile();
            Wrong.createNewFile();
            Correct.createNewFile();
        } catch (IOException ignored) {
        }
    }
    public static void tryAgain(){
        Wrong.delete();
        Correct.delete();
        try {
            Wrong.createNewFile();
            Correct.createNewFile();
        } catch (IOException ignored){}
    }
//    Removes Methods
    public static void removeGameData(File folder) {
//      First All Files Inside The Folder Are Deleted
        for (File file : folder.listFiles()) file.delete();
//      Then The Folder Is Deleted
        folder.delete();
//      Then The Folder Will Be Removed From folderList
        folderList.remove(folder);
    }
    public static void removeAllGamesData(){
        for(File folder: GamesDataFolder.listFiles()) removeGameData(folder);
    }
}
