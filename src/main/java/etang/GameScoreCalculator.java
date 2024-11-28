package etang;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameScoreCalculator {

    public static int calculateScore(List<Integer> diceRoll) {

        Map<Integer, Long> counts = countDiceOccurrences(diceRoll);

        // YAMS Case
        if (counts.containsValue(5L)) return 50;

        // FourOfKind Case
        if (counts.containsValue(4L)) return 35;

        // Full Case
        if (isFullHouse(counts)) return 30;

        // Large Straight Case
        if (isLargeStraight(diceRoll)) return 40;

        return 0;
    }

    private static Map<Integer, Long> countDiceOccurrences(List<Integer> diceRoll) {
        return diceRoll.stream()
                .collect(Collectors.groupingBy(die -> die, Collectors.counting()));
    }

    private static boolean isFullHouse(Map<Integer, Long> counts) {
        return counts.containsValue(3L) && counts.containsValue(2L);
    }

    private static boolean isLargeStraight(List<Integer> diceRoll) {
        List<Integer> sortedRoll = diceRoll.stream().sorted().toList();
        return sortedRoll.equals(List.of(1, 2, 3, 4, 5)) || sortedRoll.equals(List.of(2, 3, 4, 5, 6));
    }
}
