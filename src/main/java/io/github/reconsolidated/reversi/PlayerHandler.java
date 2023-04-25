package io.github.reconsolidated.reversi;

import io.github.reconsolidated.algorithms.Algorithm;

import java.util.List;

public interface PlayerHandler {
    Move getMove(Board board, BoardElement playerElement, List<Move> availableMoves);
}
