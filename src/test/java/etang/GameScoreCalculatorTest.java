package etang;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class GameScoreCalculatorTest {

    @Test
    public void shouldReturnYamsScore() {
        // Given
        List<Integer> diceRoll = List.of(6, 6, 6, 6, 6);
        Set<Figure> usedFigures = new HashSet<>();

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll, usedFigures);

        // Then
        assertEquals(50, score);
    }


    @Test
    public void shouldReturnFourOfAKindScore() {
        // Given
        List<Integer> diceRoll = List.of(4, 4, 4, 4, 2);
        Set<Figure> usedFigures = new HashSet<>();

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll, usedFigures);

        // Then
        assertEquals(35, score);
    }

    @Test
    public void shouldReturnFullScore() {
        // Given
        List<Integer> diceRoll = List.of(4, 4, 4, 1, 1);
        Set<Figure> usedFigures = new HashSet<>();

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll, usedFigures);

        // Then
        assertEquals(30, score);
    }

    @Test
    public void shouldReturnLargeStraightScoreForFirstSequence() {
        // Given
        List<Integer> diceRoll = List.of(1, 2, 3, 4, 5);
        Set<Figure> usedFigures = new HashSet<>();

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll, usedFigures);

        // Then
        assertEquals(40, score);
    }

    @Test
    public void shouldReturnLargeStraightScoreForMixedSequence() {
        // Given
        List<Integer> diceRoll = List.of(1, 3, 2, 4, 5);
        Set<Figure> usedFigures = new HashSet<>();

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll, usedFigures);

        // Then
        assertEquals(40, score);
    }

    @Test
    public void shouldReturnThreeOfAKindScore() {
        // Given
        List<Integer> diceRoll = List.of(3, 3, 3, 1, 2);
        Set<Figure> usedFigures = new HashSet<>();

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll, usedFigures);

        // Then
        assertEquals(28, score);
    }

    @Test
    public void shouldReturnChanceScoreWhenNoOtherFigures() {
        // Given
        List<Integer> diceRoll = List.of(1, 2, 3, 4, 6);
        Set<Figure> usedFigures = new HashSet<>();

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll, usedFigures);

        // Then
        assertEquals(16, score);
    }

    @Test
    public void shouldUseEachFigureOnlyOnce() {
        // Given
        List<List<Integer>> diceRolls = List.of(
                List.of(6, 6, 6, 6, 6),
                List.of(6, 6, 6, 6, 2),
                List.of(3, 3, 3, 2, 2),
                List.of(1, 2, 3, 4, 5)
        );
        Set<Figure> usedFigures = new HashSet<>();

        // When
        int scoreYams = GameScoreCalculator.calculateScore(diceRolls.get(0), usedFigures);
        int scoreFourOfKind = GameScoreCalculator.calculateScore(diceRolls.get(1), usedFigures);
        int scoreFullHouse = GameScoreCalculator.calculateScore(diceRolls.get(2), usedFigures);
        int scoreLargeStraight = GameScoreCalculator.calculateScore(diceRolls.get(3), usedFigures);

        // Then
        assertEquals(50, scoreYams);
        assertEquals(35, scoreFourOfKind);
        assertEquals(30, scoreFullHouse);
        assertEquals(40, scoreLargeStraight);
    }

}