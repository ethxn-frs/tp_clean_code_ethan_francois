package etang;


public enum Figure {
    YAMS(50),
    FOUR_OF_A_KIND(35),
    FULL_HOUSE(30),
    LARGE_STRAIGHT(40),
    THREE_OF_A_KIND(28),
    CHANCE(0);

    private final int score;

    Figure(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
