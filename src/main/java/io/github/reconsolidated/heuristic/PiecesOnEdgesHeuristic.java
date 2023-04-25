package io.github.reconsolidated.heuristic;

import io.github.reconsolidated.reversi.Board;
import io.github.reconsolidated.reversi.BoardElement;

import java.util.ArrayList;
import java.util.List;

public class PiecesOnEdgesHeuristic implements Heuristic{
    @Override
    public double score(Board board, BoardElement element) {
        int myCount = 0;
        int opponentCount = 0;
        BoardElement opponentElement = element.getOpposite();

        List<Position> eligiblePositions = new ArrayList<>();

        eligiblePositions.add(new Position(0, 0));
        eligiblePositions.add(new Position(0, 7));
        eligiblePositions.add(new Position(7, 0));
        eligiblePositions.add(new Position(7, 7));

        for (Position position : eligiblePositions) {
            if (board.getBoard()[position.x()][position.y()] == element) {
                myCount++;
            } else if (board.getBoard()[position.x()][position.y()] == opponentElement) {
                opponentCount++;
            }
        }
        return (0.0 + myCount - opponentCount)/(myCount + opponentCount);
    }
}
