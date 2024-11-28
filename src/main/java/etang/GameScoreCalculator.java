package etang;

import java.util.List;
import java.util.stream.Collectors;

public class GameScoreCalculator {

    public static int calculateScore(List<Integer> diceRoll) {

        // Yams Case
        if (diceRoll.stream().distinct().count() == 1) return 50;

        // FourOfKind Case
        long maxCount = diceRoll.stream()
                .collect(Collectors.groupingBy(die -> die, Collectors.counting()))
                .values().stream()
                .max(Long::compareTo)
                .orElse(0L);

        if (maxCount == 4) {
            return 35;
        }

        return 0;
    }
}
