package io.github.reconsolidated.heuristic;

import io.github.reconsolidated.reversi.Board;
import io.github.reconsolidated.reversi.BoardElement;

public interface Heuristic {
    double score(Board board, BoardElement element);
}
