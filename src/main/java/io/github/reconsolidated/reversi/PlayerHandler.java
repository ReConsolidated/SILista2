package io.github.reconsolidated.reversi;

import java.util.List;

public interface PlayerHandler {
    Move getMove(Board board, BoardElement playerElement, List<Move> availableMoves);
}
