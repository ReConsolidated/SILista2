package io.github.reconsolidated.playerHandlers;

import io.github.reconsolidated.algorithms.Algorithm;
import io.github.reconsolidated.algorithms.alphaBeta.AlphaBeta;
import io.github.reconsolidated.heuristic.NumberOfPiecesHeuristic;
import io.github.reconsolidated.reversi.Board;
import io.github.reconsolidated.reversi.BoardElement;
import io.github.reconsolidated.reversi.Move;
import io.github.reconsolidated.reversi.PlayerHandler;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MinMaxPlayerHandler implements PlayerHandler {
    private boolean showMessages;
    private int depth;

    @Override
    public Move getMove(Board board, BoardElement playerElement, List<Move> availableMoves) {
        Algorithm miniMax = new AlphaBeta(new NumberOfPiecesHeuristic(), depth);
        if (showMessages) {
            System.out.println("Calculating my move...");
        }
        Move move = miniMax.getBestMove(board, playerElement);
        if (showMessages) {
            System.out.println("My move is: " + move);
            System.out.println("New board state: ");
            System.out.println(move.getBoardAfterMove().toString());
        }
        return move;
    }
}
