package GameData.Read;

import GameData.GamesFoldersManager;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class ReadData {
    public static ArrayList<String> GameConfig = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FalsePoints = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> ShowingFalsePoints = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> CorrectClicked = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> WrongClicked = new ArrayList<>();

    public static void read(){
        GameConfig = reedConfig(GamesFoldersManager.GameConfig);
        FalsePoints = reedPoints(GamesFoldersManager.FalsePoints);
        ShowingFalsePoints = reedPoints(GamesFoldersManager.ShowingFalseButtons);
        CorrectClicked = reedPoints(GamesFoldersManager.Correct);
        WrongClicked = reedPoints(GamesFoldersManager.Wrong);
    }
    private static ArrayList<ArrayList<Integer>> reedPoints(File path){
        ArrayList<ArrayList<Integer>> Data = new ArrayList<>();
        try {
            InputStream input = new BufferedInputStream(Files.newInputStream(path.toPath()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            String[] temp;
            while ((line = reader.readLine()) != null ){
                temp = line.split(" ");
                ArrayList<Integer> point = new ArrayList<>();
                point.add(Integer.parseInt(temp[0]));
                point.add(Integer.parseInt(temp[1]));
                Data.add(point);
            }
        } catch (IOException ignored) {}
        return Data;
    }
    private static ArrayList<String> reedConfig(File path){
        ArrayList<String> Data = new ArrayList<>();
        try {
            InputStream input = new BufferedInputStream(Files.newInputStream(path.toPath()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            String[] temp;
            while ((line = reader.readLine()) != null ){
                temp = line.split(" ");
                Data.add(temp[1]);
            }
        } catch (IOException ignored) {}
        return Data;
    }

}
