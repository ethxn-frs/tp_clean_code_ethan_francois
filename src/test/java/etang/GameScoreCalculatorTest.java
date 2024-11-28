package etang;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameScoreCalculatorTest {

    @Test
    public void shouldReturnYamsScore() {

        // Given
        List<Integer> diceRoll = List.of(6, 6, 6, 6, 6);

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll);

        // Then
        assertEquals(50, score);
    }

    @Test
    public void shouldReturnFourOfAKindScore() {
        // Given
        List<Integer> diceRoll = List.of(4, 4, 4, 4, 2);

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll);

        // Then
        assertEquals(35, score);
    }

    @Test
    public void shouldReturnFullScore() {
        // Given
        List<Integer> diceRoll = List.of(4, 4, 4, 1, 1);

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll);

        // Then
        assertEquals(30, score);
    }

    @Test
    public void shouldReturnLargeStraightScoreForFirstSequence() {
        // Given
        List<Integer> diceRoll = List.of(1, 2, 3, 4, 5);

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll);

        // Then
        assertEquals(40, score);
    }

    @Test
    public void shouldReturnLargeStraightScoreForFirstSequenceMixed() {
        // Given
        List<Integer> diceRoll = List.of(1, 3, 2, 4, 5);

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll);

        // Then
        assertEquals(40, score);
    }

    @Test
    public void shouldReturnLargeStraightScoreForSecondSequenceMixed() {
        // Given
        List<Integer> diceRoll = List.of(2, 3, 5, 4, 6);

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll);

        // Then
        assertEquals(40, score);
    }

    @Test
    public void shouldReturnThreeOfAKindScore() {
        // Given
        List<Integer> diceRoll = List.of(3, 3, 3, 1, 2);

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll);

        // Then
        assertEquals(28, score);
    }

    @Test
    public void shouldReturnChanceScoreWhenNoOtherFigures() {
        // Given
        List<Integer> diceRoll = List.of(1, 2, 3, 4, 6);

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll);

        // Then
        assertEquals(16, score);
    }

    @Test
    public void shouldReturnErrorNotEnoughRollScore() {

        // Given
        List<Integer> diceRoll = List.of(1, 2, 4, 6);

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll);

        // Then
        assertEquals(0, score);
    }

    @Test
    public void shouldReturnErrorTooMuchRollScore() {
        // Given
        List<Integer> diceRoll = List.of(1, 2, 3, 3, 4, 6);

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll);

        // Then
        assertEquals(0, score);
    }

    @Test
    public void shouldPrioritizeFourOfAKindOverThreeOfAKind() {
        // Given
        List<Integer> diceRoll = List.of(4, 4, 4, 4, 2);

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll);

        // Then
        assertEquals(35, score);
    }

    @Test
    public void shouldPrioritizeFullHouseOverThreeOfAKind() {
        // Given
        List<Integer> diceRoll = List.of(3, 3, 3, 2, 2);

        // When
        int score = GameScoreCalculator.calculateScore(diceRoll);

        // Then
        assertEquals(30, score);
    }
}
