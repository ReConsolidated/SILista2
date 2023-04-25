package io.github.reconsolidated.heuristic;

import io.github.reconsolidated.reversi.Board;
import io.github.reconsolidated.reversi.BoardElement;

public class PiecesOnEdgeHeuristic implements Heuristic{
    @Override
    public double score(Board board, BoardElement element) {
        int myCount = 0;
        int opponentCount = 0;
        BoardElement opponentElement = element.getOpposite();
        for (int i = 0; i < board.getBoard().length; i++) {
            if (board.getBoard()[i][7] == element) {
                myCount++;
            } else if (board.getBoard()[i][7] == opponentElement) {
                opponentCount++;
            }
        }
        for (int i = 0; i < board.getBoard().length; i++) {
            if (board.getBoard()[7][i] == element) {
                myCount++;
            } else if (board.getBoard()[7][i] == opponentElement) {
                opponentCount++;
            }
        }
        return (0.0 + myCount - opponentCount)/(myCount + opponentCount);
    }
}
