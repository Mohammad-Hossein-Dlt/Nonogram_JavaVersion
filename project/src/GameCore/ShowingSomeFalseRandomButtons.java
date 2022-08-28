package GameCore;

import java.util.ArrayList;
import java.util.Random;

import static GameCore.GameCore.falsepoints;

public class ShowingSomeFalseRandomButtons {
    public static ArrayList<ArrayList<Integer>> FalseRandomPointsList = new ArrayList<>();
    public static void randomGathering(boolean check){
        FalseRandomPointsList.clear();
        if(check) {
            Random generator = new Random();
            while (FalseRandomPointsList.size() < (int) falsepoints.size() * 0.4) {
                int index = generator.nextInt(falsepoints.size());
                if (!FalseRandomPointsList.contains(falsepoints.get(index))) {
                    FalseRandomPointsList.add(falsepoints.get(index));
                }
            }
        }
    }
}
