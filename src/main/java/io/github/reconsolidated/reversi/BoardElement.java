package io.github.reconsolidated.reversi;

public enum BoardElement {
    EMPTY, PLAYER1, PLAYER2;

    public String get() {
        return switch (this) {
            case EMPTY -> "0";
            case PLAYER1 -> "1";
            case PLAYER2 -> "2";
        };
    }
}
