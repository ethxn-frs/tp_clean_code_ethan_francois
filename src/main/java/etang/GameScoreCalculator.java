package etang;

import java.util.*;
import java.util.stream.Collectors;

public class GameScoreCalculator {

    private static final int SCORE_YAMS = 50;
    private static final int SCORE_FOUR_OF_KIND = 35;
    private static final int SCORE_FULL_HOUSE = 30;
    private static final int SCORE_LARGE_STRAIGHT = 40;
    private static final int SCORE_THREE_OF_KIND = 28;

    public static int calculateScore(List<Integer> diceRoll, Set<Figure> usedFigures) {

        if (diceRoll.size() != 5) return 0;

        Map<Integer, Long> counts = countDiceOccurrences(diceRoll);

        if (!usedFigures.contains(Figure.YAMS) && isYams(counts)) {
            usedFigures.add(Figure.YAMS);
            return Figure.YAMS.getScore();
        }

        if (!usedFigures.contains(Figure.FOUR_OF_A_KIND) && isFourOfKind(counts)) {
            usedFigures.add(Figure.FOUR_OF_A_KIND);
            return Figure.FOUR_OF_A_KIND.getScore();
        }

        if (!usedFigures.contains(Figure.FULL_HOUSE) && isFullHouse(counts)) {
            usedFigures.add(Figure.FULL_HOUSE);
            return Figure.FULL_HOUSE.getScore();
        }

        if (!usedFigures.contains(Figure.LARGE_STRAIGHT) && isLargeStraight(diceRoll)) {
            usedFigures.add(Figure.LARGE_STRAIGHT);
            return Figure.LARGE_STRAIGHT.getScore();
        }

        if (!usedFigures.contains(Figure.THREE_OF_A_KIND) && isThreeOfKind(counts)) {
            usedFigures.add(Figure.THREE_OF_A_KIND);
            return Figure.THREE_OF_A_KIND.getScore();
        }

        usedFigures.add(Figure.CHANCE);
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

    public static List<Integer> calculateGameScores(List<List<Integer>> diceRolls) {
        Set<Figure> usedFigures = new HashSet<>();
        List<Integer> scores = new ArrayList<>();

        for (List<Integer> roll : diceRolls) {
            scores.add(calculateScore(roll, usedFigures));
        }

        return scores;
    }

}
