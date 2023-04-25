package io.github.reconsolidated.algorithms;

import io.github.reconsolidated.reversi.Board;
import io.github.reconsolidated.reversi.BoardElement;
import io.github.reconsolidated.reversi.Move;

public interface Algorithm {
    Move getBestMove(Board board, BoardElement playerElement);
}
