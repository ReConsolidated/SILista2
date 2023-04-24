package io.github.reconsolidated.heuristic;

import io.github.reconsolidated.reversi.Board;
import io.github.reconsolidated.reversi.BoardElement;

public class NumberOfPiecesHeuristic implements Heuristic{
    @Override
    public double score(Board board, BoardElement element) {
        int myCount = 0;
        int opponentCount = 0;
        BoardElement opponentElement = element.getOpposite();
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                if (board.getBoard()[i][j] == element) {
                    myCount++;
                } else if (board.getBoard()[i][j] == opponentElement) {
                    opponentCount++;
                }
            }
        }
        return (0.0 + myCount - opponentCount)/(myCount + opponentCount);
    }
}
