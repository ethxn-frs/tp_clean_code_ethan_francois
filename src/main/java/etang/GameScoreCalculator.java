package etang;

import java.util.List;

public class GameScoreCalculator {

    public static int calculateScore(List<Integer> diceRoll) {

        if (diceRoll.stream().distinct().count() == 1) return 50;
        
        return 0;
    }
}
