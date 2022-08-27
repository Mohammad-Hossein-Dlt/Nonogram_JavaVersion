package Config;

import GameData.Read.ReadData;

import java.util.*;
public class config {
    public static int gamescale = 10;
    public static double hardshipFactor = 0.3;
    public static HashMap<ArrayList<Integer>, Boolean> allpoint_;
    public static ArrayList<ArrayList<Integer>> falsepoints;
    public static ArrayList<ArrayList<Integer>> truepoints;
    public static HashMap<String, ArrayList<Integer>> columnhints;
    public static HashMap<String, ArrayList<Integer>> rowhints;
    public static HashMap<String, HashMap<ArrayList<Integer>, Boolean > > columns;
    public static HashMap<String, HashMap<ArrayList<Integer>, Boolean > > rows;

    public static void create(int scale, double factor,boolean continueGame) {
        hardshipFactor = factor;
        gamescale = scale;
//        --------------------------------------------------------------- Initialization Variables
        allpoint_ = new HashMap<>();
        falsepoints = new ArrayList<>();
        truepoints = new ArrayList<>();
        columnhints = new HashMap<>();
        rowhints = new HashMap<>();
        columns = new HashMap<>();
        rows = new HashMap<>();
//        --------------------------------------------------------------- Create Initial List Of Points
        ArrayList<ArrayList<Integer>> allpoints = new ArrayList<>();
        for (int i = 1; i <= gamescale; i++){
            for (int j = 1; j <= gamescale; j++){
                ArrayList<Integer> newpoint = new ArrayList<>();
                newpoint.add(i);
                newpoint.add(j);
                allpoints.add(newpoint);
            }
        }
//        --------------------------------------------------------------- Create False Points
        if(continueGame) {
            falsepoints = ReadData.FalsePoints;
        }
        else {
            int falsepointslenght = 0;
            while (falsepointslenght != (int) (scale * scale * hardshipFactor)) {
                Random generator = new Random();
                int index = generator.nextInt(allpoints.size());
                ArrayList<Integer> choosenpoint = allpoints.get(index);
                if (!falsepoints.contains(choosenpoint)) {
                    falsepoints.add(choosenpoint);
                    falsepointslenght++;
                }
            }
        }
//        --------------------------------------------------------------- Create True Points
        for(int i = 0; i < gamescale*gamescale; i++){
            if (!falsepoints.contains(allpoints.get(i))) truepoints.add(allpoints.get(i));
        }
//        --------------------------------------------------------------- Create All Points
        for(int i = 0; i < gamescale*gamescale; i++){
            ArrayList<Integer> point = allpoints.get(i);
            if(falsepoints.contains(point)) allpoint_.put(point,false);
            if(truepoints.contains(point)) allpoint_.put(point,true);
        }
//        --------------------------------------------------------------- Create Row Hints
        for (int i = 1; i <= gamescale; i++) {
            ArrayList<Integer> newRow = new ArrayList<>();
            int counter = 0;
            for (ArrayList<Integer> point : allpoints) {
                boolean check = allpoint_.get(point);
                if (point.get(0) == i) {
                    if (check) counter++;
                    if ((!check && counter != 0) || (point.get(1) == gamescale && check && counter != 0)) {
                        newRow.add(counter);
                        counter = 0;
                    }
                }
            }
            rowhints.put("R"+i,newRow);
        }
//          --------------------------------------------------------------- Create Column Hints
        for (int i = 1; i <= gamescale; i++) {
            ArrayList<Integer> newColumn = new ArrayList<>();
            int counter = 0;
            for (ArrayList<Integer> point : allpoints) {
                boolean check = allpoint_.get(point);
                if (point.get(1) == i) {
                    if (check) counter++;
                    if ((!check && counter != 0) || (point.get(0) == gamescale && check && counter != 0)) {
                        newColumn.add(counter);
                        counter = 0;
                    }
                }
            }
            columnhints.put("C"+i,newColumn);
        }
//          --------------------------------------------------------------- Create Column And Row List
        for(int i = 1; i <= gamescale; i++ ){
            HashMap<ArrayList<Integer>, Boolean > newrow = new HashMap<>();
            HashMap<ArrayList<Integer>, Boolean > newcolumn = new HashMap<>();
            for(ArrayList<Integer> point: allpoints ){
                if(point.get(0) == i) newcolumn.put(point,allpoint_.get(point));
                if(point.get(1) == i) newrow.put(point,allpoint_.get(point));
            }
            rows.put("R"+i,newrow);
            columns.put("C"+i, newcolumn);
        }
    }
}
