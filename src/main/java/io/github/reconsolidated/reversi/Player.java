package io.github.reconsolidated.reversi;

import java.util.List;

public class Player {
    private PlayerHandler playerHandler;
    private BoardElement boardElement;

    public Player(BoardElement boardElement, PlayerHandler playerHandler) {
        this.playerHandler = playerHandler;
        this.boardElement = boardElement;
    }

    public Move getMove(Board currentBoard, List<Move> availableMoves) {
        return playerHandler.getMove(currentBoard, boardElement, availableMoves);
    }
}
