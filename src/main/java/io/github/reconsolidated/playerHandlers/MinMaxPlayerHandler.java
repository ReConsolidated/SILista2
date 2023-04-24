package io.github.reconsolidated.playerHandlers;

import io.github.reconsolidated.heuristic.NumberOfPiecesHeuristic;
import io.github.reconsolidated.minMax.MiniMax;
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
        MiniMax miniMax = new MiniMax(depth, new NumberOfPiecesHeuristic());
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
