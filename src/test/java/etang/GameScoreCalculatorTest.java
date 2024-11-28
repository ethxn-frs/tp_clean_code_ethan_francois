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


}
