package GameData;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class PathManager {
    private static final String prefix = "/Game ";
    public static final File GameDataFolder = new File("GameData") ;
    public static File GameHistory;
    public static File GameConfig;
    public static File FalsePoints;
    public static File ShowingFalseButtons;
    public static File WrongClicked;
    public static File CorrectClicked;
    public static ArrayList<File> folderList = (Files.exists(GameDataFolder.toPath()) && GameDataFolder.list().length != 0 )? sortFolders() : new ArrayList<>();// A List To Sort Folders By Name
    public static void createNew(){
//      Create New GameData
        if (Files.notExists(GameDataFolder.toPath())) {
            GameDataFolder.mkdirs();
        }
        if(GameDataFolder.listFiles().length == 0 ) {
            GameHistory = new File(GameDataFolder.getPath() + prefix + 1);
        }
        if (GameDataFolder.listFiles().length > 0) {
                GameHistory = new File(GameDataFolder.getPath()+prefix+( Integer.parseInt(folderList.get(folderList.size()-1).getName().split(" ")[1]) + 1 ));
        }
        if(PathManager.load(GameHistory)) {
            try {
                GameHistory.mkdirs();
                GameConfig.createNewFile();
                FalsePoints.createNewFile();
                ShowingFalseButtons.createNewFile();
                WrongClicked.createNewFile();
                CorrectClicked.createNewFile();
            } catch (IOException ignored) {
            }
            folderList.add(GameHistory);
        }
    }
    public static boolean lastPath() {
        if((Files.notExists(GameDataFolder.toPath()) || GameHistory == null) || isFinished(GameHistory) ) GameHistory = lastUnfinished();
        PathManager.load(GameHistory);
        return GameHistory != null;
    }
    public static boolean load(File folder){
        if(folder != null) {
            GameHistory = folder;
            GameConfig = new File(GameHistory.getPath() + "/GameConfig.txt");
            FalsePoints = new File(GameHistory.getPath() + "/FalsePoints.txt");
            ShowingFalseButtons = new File(GameHistory.getPath() + "/ShowingFalseButtons.txt");
            WrongClicked = new File(GameHistory.getPath() + "/WrongClicked.txt");
            CorrectClicked = new File(GameHistory.getPath() + "/UserCorrect.txt");
        }
        return GameHistory != null;
    }
    private static ArrayList<File> sortFolders(){
        ArrayList<Integer> indexList = new ArrayList<>();
        for (String dirName : GameDataFolder.list()) indexList.add(Integer.parseInt(dirName.split(" ")[1]));
        Collections.sort(indexList);
        ArrayList<File> list = new ArrayList<>();
        for (int index: indexList) list.add(new File(GameDataFolder.getPath()+prefix+index));
        return list;
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

}
