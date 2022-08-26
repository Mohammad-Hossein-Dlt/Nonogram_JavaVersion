package GameData.Reed;

import GameData.PathManager;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class ReedData {
    public static ArrayList<String> GameConfig = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FalsePoints = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> ShowingFalsePoints = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> CorrectClicked = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> WrongClicked = new ArrayList<>();

    public static void Reed(){
        GameConfig = reedConfig(PathManager.GameConfig);
        FalsePoints = reedPoints(PathManager.FalsePoints);
        ShowingFalsePoints = reedPoints(PathManager.ShowingFalseButtons);
        CorrectClicked = reedPoints(PathManager.CorrectClicked);
        WrongClicked = reedPoints(PathManager.WrongClicked);
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
