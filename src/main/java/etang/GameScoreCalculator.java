package etang;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameScoreCalculator {

    private static final int SCORE_YAMS = 50;
    private static final int SCORE_FOUR_OF_KIND = 35;
    private static final int SCORE_FULL_HOUSE = 30;
    private static final int SCORE_LARGE_STRAIGHT = 40;
    private static final int SCORE_THREE_OF_KIND = 28;

    public static int calculateScore(List<Integer> diceRoll) {

        if (diceRoll.size() != 5) return 0;

        Map<Integer, Long> counts = countDiceOccurrences(diceRoll);

        // YAMS Case
        if (isYams(counts)) return SCORE_YAMS;

        // FourOfKind Case
        if (isFourOfKind(counts)) return SCORE_FOUR_OF_KIND;

        // Full house Case
        if (isFullHouse(counts)) return SCORE_FULL_HOUSE;

        // Large Straight Case
        if (isLargeStraight(diceRoll)) return SCORE_LARGE_STRAIGHT;

        // ThreeOfKind Case
        if (isThreeOfKind(counts)) return SCORE_THREE_OF_KIND;

        // Chance Case ( default )
        return calculateChance(diceRoll);
    }

    private static Map<Integer, Long> countDiceOccurrences(List<Integer> diceRoll) {
        return diceRoll.stream().collect(Collectors.groupingBy(die -> die, Collectors.counting()));
    }

    private static boolean isYams(Map<Integer, Long> counts) {
        return counts.containsValue(5L);
    }

    private static boolean isFourOfKind(Map<Integer, Long> counts) {
        return counts.containsValue(4L);
    }

    private static boolean isFullHouse(Map<Integer, Long> counts) {
        return counts.containsValue(3L) && counts.containsValue(2L);
    }

    private static boolean isLargeStraight(List<Integer> diceRoll) {
        List<Integer> sortedRoll = diceRoll.stream().sorted().toList();
        return sortedRoll.equals(List.of(1, 2, 3, 4, 5)) || sortedRoll.equals(List.of(2, 3, 4, 5, 6));
    }

    private static boolean isThreeOfKind(Map<Integer, Long> counts) {
        return counts.containsValue(3L);
    }

    private static int calculateChance(List<Integer> diceRoll) {
        return diceRoll.stream().mapToInt(Integer::intValue).sum();
    }
}
